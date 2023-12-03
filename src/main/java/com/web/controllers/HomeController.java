package com.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.models.Book;
import com.web.models.User;
import com.web.services.BookService;
import com.web.services.UserService;
import com.web.utility.ImageUtil;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageUtil theImageUtil;
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/")
	public String home(Model model) {
		List<Book> bookList = bookService.getBookList();
		model.addAttribute("bookList", bookList);
        theImageUtil=new ImageUtil();
		model.addAttribute("image", theImageUtil);
		return "home";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/login")
	public String login(Model model, @ModelAttribute("USER") User user) {
		return "login";
	}
	
	@GetMapping("/register")
	public String addOrEdit(Model model) {
		User u = new User();
		model.addAttribute("USER", u);
		model.addAttribute("ACTION", "saveOrUpdate");
		return "register-user";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(Model model, @ModelAttribute("USER") User user) {
		user.setRole("USER"); 
		userService.save(user);
		return "login";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(Model model ,@RequestParam("username") String username, @RequestParam("password") String password) {
		User user = userService.findByUsername(username);
		if(user==null) {
			model.addAttribute("error", "Tài khoản hoặc mật khẩu không chính xác");
			return "login";
		}
			
		if(user.getPassword().equalsIgnoreCase(password)) {
			if(user.getRole().equalsIgnoreCase("ADMIN")) {
				return "admin";
			}else {
				
				return "redirect:/user/" + user.getId();
			}
		}
		model.addAttribute("error", "Tài khoản hoặc mật khẩu không chính xác");
		return "login";
	}
	
	@GetMapping("/book/{bookId}")
	public String Book(Model model, @PathVariable(name = "bookId") int bookId) {
		Book book = bookService.getBook(bookId);
		model.addAttribute("book", book);
		theImageUtil=new ImageUtil();
		model.addAttribute("image", theImageUtil);
		return "homeBook";
	}
	
}
