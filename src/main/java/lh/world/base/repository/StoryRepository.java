package lh.world.base.repository;

import lh.world.base.domain.User;
import lh.world.base.domain.Story;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lh on 2016/8/12.
 */
public interface StoryRepository extends PagingAndSortingRepository<Story, Long> {
    Page<Story> queryByDelAndUser(boolean isDeleted, User user, Pageable pageable);
}
