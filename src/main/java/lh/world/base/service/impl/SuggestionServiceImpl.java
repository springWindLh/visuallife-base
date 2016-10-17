package lh.world.base.service.impl;

import lh.world.base.domain.Suggestion;
import lh.world.base.query.support.Query;
import lh.world.base.repository.SuggestionRepository;
import lh.world.base.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by lh on 2016/9/14.
 */
@Service
public class SuggestionServiceImpl implements SuggestionService {
    @Autowired
    private SuggestionRepository suggestionRepository;

    @Override
    public Suggestion save(Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    @Override
    public Optional<Suggestion> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(suggestionRepository.findOne(id));
        }
    }

    @Override
    public Page<Suggestion> listAll(Query query) {
        return suggestionRepository.findAll(query.getPageable());
    }

    @Override
    public void remove(Long id) {
        if (id != null) {
            Optional<Suggestion> suggestionOptional = this.findById(id);
            if (suggestionOptional.isPresent()) {
                Suggestion suggestion = suggestionOptional.get();
                suggestion.setDel(true);
                this.save(suggestion);
            }
        }
    }
}
