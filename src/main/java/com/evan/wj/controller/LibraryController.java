package com.evan.wj.controller;

import com.evan.wj.pojo.Book;
import com.evan.wj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @CrossOrigin
    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @CrossOrigin
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @CrossOrigin
    @GetMapping("/api/category/{cid}/books")
    public List<Book> listByCategory(@PathVariable int cid) throws Exception {
        if (cid != 0) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
        if ("".equals(keywords)) {
            // return all books if empty;
            return bookService.list();
        } else {
            return bookService.Search(keywords);
        }
    }

// TODO: Upload Covers;
//    @CrossOrigin
//    @PostMapping("/api/covers")
//    public String coversUpload(MultipartFile file) throws Exception {
//
//    }
}
