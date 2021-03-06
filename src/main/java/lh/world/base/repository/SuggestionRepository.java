package lh.world.base.repository;

import lh.world.base.domain.Suggestion;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lh on 2016/9/14.
 */
public interface SuggestionRepository extends PagingAndSortingRepository<Suggestion, Long> {
}
