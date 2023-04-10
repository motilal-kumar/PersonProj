package com.example.personproj.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    @Column(nullable = false)
    private String title;

   /* private String author;

    private String tag;*/

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "article_tags",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    // getters and setters
}
