package lh.world.base.service;

import lh.world.base.domain.User;
import lh.world.base.domain.Story;
import lh.world.base.query.support.Query;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by lh on 2016/8/12.
 */
public interface StoryService {
    Story save(Story story);

    Optional<Story> findById(Long id);

    Page<Story> listAll(Query query);

    Page<Story> listByUser(User user, Query query, boolean isDeleted);

    void remove(Long id);

    void remove(Long[] ids);
}
