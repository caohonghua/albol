package org.caohh.albol.controller;

import org.caohh.albol.service.ArticleService;
import org.caohh.albol.vo.Article;
import org.caohh.albol.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/save")
    public Result save(@RequestBody Article article){
        return articleService.save(article);
    }

    @GetMapping("/search")
    public Result search(Article article){
        return articleService.search(article);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        return articleService.delete(id);
    }
}
