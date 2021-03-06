package lh.world.base.repository;

import lh.world.base.domain.Article;
import lh.world.base.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lh on 2016/8/10.
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
    Page<Article> queryByDelAndTitleLike(boolean isDeleted, String title, Pageable pageable);
    Page<Article> queryByDelAndUser(boolean isDeleted, User user, Pageable pageable);
}
