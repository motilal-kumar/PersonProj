package com.example.personproj.service;

import com.example.personproj.entity.Article;
import com.example.personproj.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService  implements IArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> findAllByAuthor(String author) {
        List<Article> articleList = articleRepository.findAllByAuthor(author);
        System.out.println("articleList: "+articleList);
        return articleList;
    }

    @Override
    public Article findByTitle(String title) {
       Article article = articleRepository.findByTitle(title);
        System.out.println("article: "+article);

        return article;
    }

    @Override
    public String findAllTagsByTitle(String title) {
        String article = articleRepository.findAllTagsByTitle(title);
        System.out.println("article: "+article);

        return article;
    }

}
