package com.example.personproj.service;


import com.example.personproj.entity.Article;
import com.example.personproj.entity.Person;

import java.util.List;

public interface IArticleService {

    public List<Article> findAllByAuthor(String author);
    public Article findByTitle(String title);

    public String findAllTagsByTitle(String title);

    public List<Article> getAllByAuthorOrTitle(String author, String title);
}
