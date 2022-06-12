package com.diplomSpring.diplomSp.Controllers;


import com.diplomSpring.diplomSp.Service.ArticleService;
import com.diplomSpring.diplomSp.models.Article;
import com.diplomSpring.diplomSp.models.ArticleEntity;
import com.diplomSpring.diplomSp.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    private ArticleService articleService;

    public MainController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(value = "/")
    public String index(@RequestParam(name = "error", defaultValue = "", required = false) String error, Model model) {
        if (error.equals("title")) {
            model.addAttribute("error", "Error");
        }
        List<Article> article = articleService.getArticle();
        model.addAttribute("articles", article);
        return "index";
    }

    @PostMapping(value = "/")
    public String store(@RequestParam String title, @RequestParam String info) {
        if (articleService.getArticleByTitle(title).isPresent()) {
            return "redirect:";
        } else if(!info.isEmpty() && !title.isEmpty())
        articleService.saveArticle(title, info);
        return "redirect:/";
    }
}
