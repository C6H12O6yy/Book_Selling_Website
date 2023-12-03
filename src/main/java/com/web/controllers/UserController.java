package com.web.controllers;

import java.time.LocalDate;
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

import com.web.models.Book;
import com.web.models.Cart;
import com.web.models.Orders;
import com.web.models.Suggest;
import com.web.models.User;
import com.web.services.BookService;
import com.web.services.CartService;
import com.web.services.OrdersService;
import com.web.services.SuggestService;
import com.web.services.UserService;
import com.web.utility.ImageUtil;

@Controller
@RequestMapping("/user/{userId}")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageUtil theImageUtil;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private SuggestService suggestService;
	
	@GetMapping("")
	public String home(Model model, @PathVariable(name = "userId") int userId) {
		Optional<User> user = userService.findById(userId);
		model.addAttribute("user", user.get());
		
		List<Book> bookList = bookService.getBookList();
		model.addAttribute("bookList", bookList);
        theImageUtil=new ImageUtil();
		model.addAttribute("image", theImageUtil);
		return "homeUser";
	}
	
	@GetMapping("/category/{id}")
	public String Category(Model model, @PathVariable(name = "userId") int userId, @PathVariable(name = "id") int id) {
		Optional<User> user = userService.findById(userId);
		model.addAttribute("user", user.get());
		
		String bookType = bookService.getBookType(id);
		List<Book> bookList = bookService.findByBookType(bookType);
		model.addAttribute("bookType", bookType);
		model.addAttribute("bookList", bookList);
        theImageUtil=new ImageUtil();
		model.addAttribute("image", theImageUtil);
		return "category";
	}
	
	@GetMapping("/book/{bookId}")
	public String Book(Model model, @PathVariable(name = "bookId") int bookId, @PathVariable(name = "userId") int userId) {
		Optional<User> user = userService.findById(userId);
		model.addAttribute("user", user.get());
		
		Book book = bookService.getBook(bookId);
		model.addAttribute("book", book);
		theImageUtil=new ImageUtil();
		model.addAttribute("image", theImageUtil);
		return "book";
	}
	
	@GetMapping("/addToCart/{bookId}")
	public String addToCart(Model model, @PathVariable(name = "userId") int userId, @PathVariable(name = "bookId") int bookId) {
		Suggest suggest = new Suggest(userId, bookService.getBook(bookId).getBookAuthor());
		suggestService.save(suggest);
		Cart cart = new Cart(userId,bookId,1);
		cartService.saveCart(cart);
		return "redirect:/user/{userId}";
	}
	@GetMapping("/cart")
	public String cart(Model model, @PathVariable(name = "userId") int userId) {
		Optional<User> user = userService.findById(userId);
		model.addAttribute("user", user.get());
		
		List<Integer> bookIdList = cartService.findAllBookId(userId, 1);
		List<Book> books = bookService.findAllById(bookIdList);
		model.addAttribute("books" , books);
		long sumPrice = books.stream().mapToLong(Book::getBookPrice).sum();
		model.addAttribute("sumPrice" , sumPrice);
		
		theImageUtil=new ImageUtil();
		model.addAttribute("image", theImageUtil);
		
		return "cart";
	}
	
	@GetMapping("/cart/delete/{bookId}")
	public String deleteCart(Model model, @PathVariable(name = "userId") int userId, @PathVariable(name = "bookId") int bookId) {
		cartService.deleteByBookId(bookId);
		return "redirect:/user/{userId}/cart";
	}
	
	@GetMapping("/payment")
	public String payment(Model model, @PathVariable(name = "userId") int userId) {
		Optional<User> user = userService.findById(userId);
		model.addAttribute("user", user.get());
		
		List<Integer> bookIdList = cartService.findAllBookId(userId, 1);
		List<Book> books = bookService.findAllById(bookIdList);
		model.addAttribute("books" , books);
		long sumPrice = books.stream().mapToLong(Book::getBookPrice).sum();
		model.addAttribute("sumPrice" , sumPrice);
		
		theImageUtil=new ImageUtil();
		model.addAttribute("image", theImageUtil);
		return "payment";
	}
	
	
	@PostMapping("/orderPay")
	public String orderPay(Model model, @ModelAttribute("user") User user, @PathVariable(name = "userId") int userId) {
		List<Integer> bookIdList = cartService.findAllBookId(userId, 1);
		cartService.updateFieldName(userId);
		List<Book> books = bookService.findAllById(bookIdList);
		long sumPrice = books.stream().mapToLong(Book::getBookPrice).sum();
		String bookNames = "";
		for (Book book : books) {
			bookNames += book.getBookName() +", ";
        }
		
		Orders orders = new Orders(userId, user.getFullname(), user.getPhone(), user.getAddress(), 0, bookNames,LocalDate.now(), sumPrice);
		ordersService.save(orders);
		return "redirect:/user/{userId}";
	}
	
	@GetMapping("/suggest")
	public String suggest(Model model, @PathVariable(name = "userId") int userId) {
		Optional<User> user = userService.findById(userId);
		model.addAttribute("user", user.get());
		
		List<String> sgList = suggestService.findAllSuggestName(userId);
		List<Book> bookList = bookService.findByBookAuthorIn(sgList);
		model.addAttribute("bookList", bookList);
		
        theImageUtil=new ImageUtil();
		model.addAttribute("image", theImageUtil);
		return "suggest";
	}
	
	
	
}
