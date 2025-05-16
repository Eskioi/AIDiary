package com.projetecam.diary.persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetecam.diary.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("""
       SELECT a
       FROM Article a
       WHERE (
           (:query IS NULL OR LOWER(a.headline) LIKE LOWER(CONCAT('%', :query, '%')))
           AND (:date IS NULL OR a.date = :date)
       )
       """)
        List<Article> search(@Param("query") String query,
                             @Param("date") LocalDate date);

    Optional<Article> findByIdAndCreatorUserId(long creatorUserId, Long id);
    List<Article> findByCreatorUserId(long creatorUserId);
}
