package lh.world.base.service;

import lh.world.base.domain.Comment;
import lh.world.base.query.support.Query;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by lh on 2016/9/14.
 */
public interface CommentService {
    Comment save(Comment comment);

    Optional<Comment> findById(Long id);

    Page<Comment> listByTargetTypeAndTargetId(Comment.TargetType targetType, Long targetId, Boolean isDeleted, Query query);

    void remove(Long id);
}
