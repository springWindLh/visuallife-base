package lh.world.base.service;

import lh.world.base.domain.Reply;
import lh.world.base.query.support.Query;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by lh on 2016/9/16.
 */
public interface ReplyService {
    Reply save(Reply reply, Long commentId, Long accepterId);

    Reply save(Reply reply);

    Optional<Reply> findById(Long id);

    Page<Reply> listByCommentId(Long commentId, Boolean isDeleted, Query query);

    void remove(Long id);
}

