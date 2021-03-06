package lh.world.base.service.impl;

import lh.world.base.domain.Comment;
import lh.world.base.domain.Reply;
import lh.world.base.domain.User;
import lh.world.base.query.support.Query;
import lh.world.base.repository.ReplyRepository;
import lh.world.base.service.CommentService;
import lh.world.base.service.ReplyService;
import lh.world.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by lh on 2016/9/16.
 */
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    @Override
    public Reply save(Reply reply) {
        return replyRepository.save(reply);
    }

    @Override
    public Reply save(Reply reply, Long commentId, Long accepterId) {
        Optional<Comment> comment = commentService.findById(commentId);
        comment.ifPresent(reply::setComment);
        Optional<User> accepter = userService.findById(accepterId);
        accepter.ifPresent(reply::setAccepter);
        return replyRepository.save(reply);
    }

    @Override
    public Optional<Reply> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(replyRepository.findOne(id));
        }
    }

    @Override
    public Page<Reply> listByCommentId(Long commentId, Boolean isDeleted, Query query) {
        return replyRepository.queryByCommentIdAndDel(commentId, isDeleted, query.getPageable());
    }

    @Override
    public void remove(Long id) {
        if (id != null) {
            Optional<Reply> replyOptional = this.findById(id);
            if (replyOptional.isPresent()) {
                Reply reply = replyOptional.get();
                reply.setDel(true);
                this.save(reply);
            }
        }
    }
}
