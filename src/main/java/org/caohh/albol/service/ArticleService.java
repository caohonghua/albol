package org.caohh.albol.service;

import org.caohh.albol.vo.Article;
import org.caohh.albol.vo.Result;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {
    Result save(Article article);

    Result search(Article article);

    Result delete(Long id);
}
