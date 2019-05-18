package za.co.up.twitter.processor.eda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import za.co.up.twitter.model.ex.ExpTweetsDetails;

import java.util.List;

public interface ExpTweetsDetailRepository extends CrudRepository<ExpTweetsDetails, String> {
    @Query(nativeQuery=true, value="SELECT * FROM EXP_TWEETS_DETAIL WHERE CONTENT regexp ?1")
    List<ExpTweetsDetails> findByContent(String regex);
}
