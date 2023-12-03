package com.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.web.models.Book;
import com.web.models.Orders;
import com.web.models.User;
import com.web.services.BookService;
import com.web.services.CartService;
import com.web.services.OrdersService;
import com.web.services.UserService;
import com.web.utility.ImageUtil;

import jakarta.servlet.annotation.MultipartConfig;

@Controller
@RequestMapping("/admin")
@MultipartConfig
public class AdminController {
	
	@Autowired
	private ImageUtil theImageUtil;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	CartService cartService;
	
	@GetMapping("")
	public String admin(Model model) {
		return "admin";
	}
	
	@GetMapping("/statistics")
	public String statistics(Model model) {
		List<Orders> orders = ordersService.findAll();
		model.addAttribute("orders", orders);
		return "statistics";
	}
	
	@GetMapping("/statistics/{orderId}")
	public String getStatistic(Model model, @PathVariable(name = "orderId") int orderId) {	
		Orders order = ordersService.findById(orderId);
		model.addAttribute("order", order);
		List<String> orderNames = new ArrayList<String>(Arrays.asList(order.getOrderName().split(", ")));
		
		List<Book> books = bookService.findByBookNameIn(orderNames);
		model.addAttribute("books" , books);
		theImageUtil=new ImageUtil();
		model.addAttribute("image", theImageUtil);
		
		
		return "getStatistics";
	}
	
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("USER", userService.findAll());
		return "view-user";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(Model model, @PathVariable(name = "id") int id) {
		Optional<User> u = userService.findById(id);
		if(u.isPresent()) {
			model.addAttribute("USER", u.get());
		}else {
			model.addAttribute("USER", new User());
		}
		model.addAttribute("ACTION", "/admin/saveUser");
		return "edit-user";
	}
	
	@PostMapping("/saveUser")
	public String saveOrUpdate(Model model, @ModelAttribute("USER") User user) {
		userService.save(user);
		return "redirect:/admin/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(Model model, @PathVariable(name = "id") int id) {
		userService.deleteById(id);
		model.addAttribute("USER", userService.findAll());
		return "view-user";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(Model model, @PathVariable(name = "id") int id) {
		bookService.deleteById(id);
		return "redirect:/admin/getBookList";
	}
	
	@GetMapping("/addBook")
	public String addBook(Model model) {
		Book theBook=new Book();
		model.addAttribute("book", theBook);
		return "addBook";
	}
	
	@GetMapping("/editBook/{bookId}")
	public String editMyBook(Model model ,@PathVariable(name = "bookId") int bookId) {
		Book book = bookService.getBook(bookId);
		model.addAttribute("book", book);
		theImageUtil = new ImageUtil();
		model.addAttribute("image", theImageUtil.getImgData(book.getBookImage()));
		return "addBook";
	}
	
	@PostMapping("/saveBook")
	public String saveMyBook(@ModelAttribute("book") Book theBook, @RequestParam("Image") MultipartFile Image) {
		try {
			theBook.setBookImage(Image.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		bookService.saveBook(theBook);
		return "redirect:/admin/getBookList";
	}
	
	@GetMapping("/getBookList")
	public String getBookList(Model model) {
		List<Book> bookList = bookService.getBookList();
		model.addAttribute("bookList", bookList);
        theImageUtil=new ImageUtil();
		model.addAttribute("image", theImageUtil);
		return "listBooks";
	}
	
	
}
