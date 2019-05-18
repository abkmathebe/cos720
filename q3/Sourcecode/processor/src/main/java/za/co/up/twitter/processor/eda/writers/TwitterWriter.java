package za.co.up.twitter.processor.eda.writers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import javax.persistence.EntityManager;
import java.util.List;

public class TwitterWriter<Object> implements ItemWriter<Object> {

    private EntityManager entityManager;

    private static final Logger log = LoggerFactory.getLogger(TwitterWriter.class);

    public TwitterWriter(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void write(List<? extends Object> list) throws Exception {
        for(Object obj :list){
            log.info("Writing stats for {}", obj);
            entityManager.merge(obj);
        }

    }
}
