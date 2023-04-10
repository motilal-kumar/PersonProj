package com.example.personproj.controller;

import com.example.personproj.entity.Article;
import com.example.personproj.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;;import java.util.List;

/*
*
*


 */

@RestController
@RequestMapping("/api/v2")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping(value = "/article", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Article>> getArticleByAuthor(@RequestParam(value = "author") String author) {

        List<Article> articleList = articleService.findAllByAuthor(author);

        System.out.println("personList: "+articleList);
            return new ResponseEntity<>(articleList, HttpStatus.OK);
        }

    @GetMapping(value = "/title", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> getArticleByTitle(@RequestParam(value = "title") String title) {

        Article article = articleService.findByTitle(title);

        System.out.println("article: "+article);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }


    @GetMapping(value = "/tagsandtitle", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getArticleByTagsAndTitle(@RequestParam(value = "title") String title) {

        String article = articleService.findAllTagsByTitle(title);

        System.out.println("article: "+article);
        return new ResponseEntity<>(article, HttpStatus.OK);

    }

    }
