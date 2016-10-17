package lh.world.base.service;

import lh.world.base.domain.Article;
import lh.world.base.domain.User;
import lh.world.base.query.support.Query;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by lh on 2016/8/10.
 */
public interface ArticleService {
    Article save(Article article);

    Optional<Article> findById(Long id);

    Page<Article> listByTitle(String title, Query query);

    Page<Article> listByUser(User user, Query query, boolean isDeleted);

    Page<Article> listAll(Query query);

    void remove(Long id);
}
