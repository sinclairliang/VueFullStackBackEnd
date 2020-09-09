package com.evan.wj.dao;

import com.evan.wj.entity.Book;
import com.evan.wj.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
