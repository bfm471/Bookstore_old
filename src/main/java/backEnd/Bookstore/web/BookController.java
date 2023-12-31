package backEnd.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import backEnd.Bookstore.domain.Book;
import backEnd.Bookstore.domain.BookRepository;
import backEnd.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	@Autowired CategoryRepository catrepository;
	
	@GetMapping("/*")
	public String goTo() {
		return("redirect:/booklist");
	}
	
	@GetMapping("/index")
	public String getStarted() {
		return("index");
	}

	@GetMapping("/booklist")
	public String listBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return("booklist");
	}
	
	@GetMapping("/delete/{id}") 
	public String deleteBook(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return("redirect:/booklist");
	}
	
	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catrepository.findAll());
		return("addbook");
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book",repository.findById(id));
		model.addAttribute("categories", catrepository.findAll());
		return("editbook");
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return("redirect:/booklist");
	}
	
}