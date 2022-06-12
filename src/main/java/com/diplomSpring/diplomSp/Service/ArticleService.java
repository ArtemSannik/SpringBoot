package com.diplomSpring.diplomSp.Service;

import com.diplomSpring.diplomSp.models.Article;
import com.diplomSpring.diplomSp.models.ArticleEntity;
import com.diplomSpring.diplomSp.repo.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    /**
     * Конструктор класса
     *
     * @param articleRepository - репозиторий для работы с данными
     */
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * Функция возвращает данные из бд
     *
     * @return массив данных
     */
    public List<Article> getArticle() {
        List<Article> article = new ArrayList<>();
        Iterable<ArticleEntity> all = articleRepository.findAll();
        all.forEach(el -> {
            article.add(new Article((el.getTitle()), el.getInfo()));
        });
        return article;
    }

    /**
     * Функция возвращающая данные об объекте по входным параметрам
     * @param title - сокращение ссылки
     * @return - объект или null
     */
    public Optional<Article> getArticleByTitle(String title) {
        if (title != null && !title.equals("")) {
            Optional<ArticleEntity> byTitle = articleRepository.findArticleEntitiesByTitle(title);
            if (byTitle.isPresent()) {
                return Optional.of(new Article((byTitle.get().getTitle()), byTitle.get().getInfo()));
            }
        }
        return Optional.empty();
    }

    /**
     * Функция сохраняет объект
     * @param title - сокращение
     * @param info - полная ссылка
     * @return - сохранённый объект
     */
    public Article saveArticle(String title, String info) {
        ArticleEntity save = articleRepository.save(new ArticleEntity(title, info));
        return new Article((save.getTitle()), save.getInfo());
    }
}
