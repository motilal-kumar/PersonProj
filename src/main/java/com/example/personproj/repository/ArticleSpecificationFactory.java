package com.example.personproj.repository;

import com.example.personproj.entity.Article;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ArticleSpecificationFactory {

    public Specification<Article> findByTag(String tag) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isMember(tag, root.get("tags"));
    }

    public Specification<Article> findByTitle(String title) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }

    public Specification<Article> findAllByTitleContainingIgnoreCase(String titlePart) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("title")),
                "%" + titlePart.toLowerCase() + "%"
        );
    }
}
