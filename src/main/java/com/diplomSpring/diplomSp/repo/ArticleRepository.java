package com.diplomSpring.diplomSp.repo;

import com.diplomSpring.diplomSp.models.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArticleRepository extends CrudRepository <ArticleEntity,Long>{
    Optional<ArticleEntity> findArticleEntitiesByTitle(String title);
}
