package za.co.up.twitter.processor.eda.processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.up.twitter.model.enhance.LanguageStatistics;
import za.co.up.twitter.model.ex.ExpTweetsDetails;
import za.co.up.twitter.model.sm.SmpLanguage;
import za.co.up.twitter.processor.eda.processors.language.LanguageStatsProcessor;

import javax.persistence.EntityManager;

@Configuration
public class ProcessorConfiguration {

    @Autowired
    private EntityManager entityManager;

    @Bean
    public ItemProcessor<SmpLanguage, LanguageStatistics> languageStatisticsItemProcessor(){
        return new LanguageStatsProcessor(entityManager);
    }

    @Bean
    public ItemProcessor<ExpTweetsDetails, ExpTweetsDetails> expTweetsProcessor(){
        return new ExpTweetsProcessor();
    }
}
