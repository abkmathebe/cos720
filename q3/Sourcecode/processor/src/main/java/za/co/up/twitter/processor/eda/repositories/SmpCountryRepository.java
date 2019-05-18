package za.co.up.twitter.processor.eda.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.up.twitter.model.sm.SmpCountry;

public interface SmpCountryRepository extends CrudRepository<SmpCountry, String> {
}
