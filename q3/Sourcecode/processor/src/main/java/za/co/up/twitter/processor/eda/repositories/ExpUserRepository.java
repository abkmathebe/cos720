package za.co.up.twitter.processor.eda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import za.co.up.twitter.model.ex.ExpUsers;

import java.util.List;

public interface ExpUserRepository extends CrudRepository<ExpUsers, String> {
    @Query(nativeQuery=true, value="SELECT * FROM EXP_USERS WHERE DESCRIPTION regexp ?1 OR LOCATION regexp ?1")
    List<ExpUsers> findByDescriptionOrLocation(String regex);
}
