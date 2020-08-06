package com.evan.wj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;

import java.util.List;

public interface BookDAO extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
