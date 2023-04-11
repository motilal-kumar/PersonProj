package com.example.personproj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Author author;

    @Column(unique = true)
    private String title;

    private String content;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String>  tags = new ArrayList<>();

    public Article(Author author, String title) {
        this.author = author;
        this.title = title;
    }

    public Article() {

    }

    public Long getId() {
        return id;
    }


    public String getContent() {
        return content;
    }
    public void addTag(String tag) {
        tags.add(tag);
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }


    /* private String author;

    private String tag;*/

   // @ManyToOne(fetch = FetchType.LAZY)
   // private Author author;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "article_tags",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;*/

    // getters and setters
}
