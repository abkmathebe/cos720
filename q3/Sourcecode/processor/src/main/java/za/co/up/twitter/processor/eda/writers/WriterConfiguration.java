package za.co.up.twitter.processor.eda.writers;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.up.twitter.model.enhance.LanguageStatistics;
import za.co.up.twitter.model.ex.ExpTweetsDetails;

import javax.persistence.EntityManager;

@Configuration
public class WriterConfiguration {

    @Autowired
    private EntityManager entityManager;

    @Bean
    public ItemWriter<LanguageStatistics> languageStatisticsItemWriter() {
        return new TwitterWriter(entityManager);
    }

    @Bean
    public ItemWriter<ExpTweetsDetails> expTweetsWriter() {
        return new TwitterWriter(entityManager);
    }

}
