package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //The @Controller annotation tells the Spring Framework this class is to be added into the Spring Context as a controller.
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        
        model.addAttribute("books", bookRepository.findAll());
        
        return "books/list"; //Denetleyici metodlar nesneleri değil, görünüm (view) dosyalarının adlarını döndürür (thanks to @Controller).
    }
}
