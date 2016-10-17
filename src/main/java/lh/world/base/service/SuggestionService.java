package lh.world.base.service;

import lh.world.base.domain.Suggestion;
import lh.world.base.query.support.Query;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by lh on 2016/9/14.
 */
public interface SuggestionService {
    Suggestion save(Suggestion suggestion);

    Optional<Suggestion> findById(Long id);

    Page<Suggestion> listAll(Query query);

    void remove(Long id);
}
