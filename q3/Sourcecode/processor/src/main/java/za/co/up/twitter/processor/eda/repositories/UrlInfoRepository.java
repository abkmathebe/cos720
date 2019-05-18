package za.co.up.twitter.processor.eda.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.up.twitter.model.enhance.UrlInfo;
import za.co.up.twitter.model.enhance.UrlInfoKey;

public interface UrlInfoRepository extends CrudRepository<UrlInfo, UrlInfoKey> {
}
