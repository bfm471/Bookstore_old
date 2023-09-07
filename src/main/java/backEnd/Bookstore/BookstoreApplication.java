package backEnd.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backEnd.Bookstore.domain.Book;
import backEnd.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		
		Book a = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 19.90);
		Book b = new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 14.95);
		Book c = new Book("To Shoot a Mockinbird", "Harper Lee", 1960, "951-864-028-9", 15.90);
	
		repository.save(a);
		repository.save(b);
		repository.save(c);
		
//		drepository.save(new Department("IT"));
//		drepository.save(new Department("Business"));
//		drepository.save(new Department("Law"));
//
//		
//		Student j = new Student("John", "Johnson", "jj@mail.com", drepository.findByName("IT").get(0));
//		Student m = new Student("Matt", "Matthews", "mm@mail.com", drepository.findByName("Business").get(0));
//		Student k = new Student("Kate", "Kateson", "kk@mail.com", drepository.findByName("Law").get(0));
//
//	 repository.save(j);
//	 repository.save(m);
//	 repository.save(k);

	};
	}

}
