package com.evan.wj.controller;

import com.evan.wj.entity.Book;
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

//    @CrossOrigin
//    @GetMapping("/api/search")
//    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
//        if ("".equals(keywords)) {
//            // return all books if empty;
//            return bookService.list();
//        } else {
//            return bookService.Search(keywords);
//        }
//    }

//    @CrossOrigin
//    @PostMapping("/api/covers")
//    public String coversUpload(MultipartFile file) throws Exception {
//        String folder = "/Users/sinclairliang/Personal/workspaceImgs";
//        File imageFolder = new File(folder);
//        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
//                .substring(file.getOriginalFilename().length() - 4));
//        if (!f.getParentFile().exists()) {
//            f.getParentFile().mkdir();
//        }
//        try {
//            file.transferTo(f);
//            String imgURL = "http://localhost:8098/api/file/" + f.getName();
//            return imgURL;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
}
