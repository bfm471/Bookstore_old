package backEnd.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import backEnd.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/index")
	public String getStarted() {
		return("index");
	}

	@GetMapping("/booklist")
	public String listBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return("booklist");
	}
	
}
