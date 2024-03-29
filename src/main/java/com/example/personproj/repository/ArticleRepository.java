package com.example.personproj.repository;

import com.example.personproj.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {

    @Query("SELECT a FROM Article a WHERE a.author.name = :author")
    List<Article> findAllByAuthor(@Param("author") String author);

    @Query(value = "SELECT * FROM article_tags a WHERE article_id = :articleId", nativeQuery = true)
    String findAllTagsByTitle(@Param("articleId") Long articleId);

    @Query("SELECT a FROM Article a WHERE a.author.name = :author or a.title = :title")
    List<Article> findAllByAuthorOrTitle(@Param("author") String author, @Param("title") String title);

    @Query("SELECT  a.author FROM Article a WHERE a.title = :title")
    List<String> findAllAuthorsByTitle(@Param("title") String title);

    @Query("SELECT a FROM Article a WHERE :tag MEMBER OF a.tags")
    List<Article> findAllByTag(@Param("tag") String tag);

    @Query("SELECT a FROM Article a WHERE a.title = :title")
    Article findByTitle(@Param("title") String title);

 /*   @Query("SELECT a FROM Article a WHERE LOWER(a.title) LIKE CONCAT('%', LOWER(:titlePart), '%')")
    List<Article> findAllByTitleContainingIgnoreCase(@Param("titlePart") String titlePart);
*/
}