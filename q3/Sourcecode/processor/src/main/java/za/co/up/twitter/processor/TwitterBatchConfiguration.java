package za.co.up.twitter.processor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class TwitterBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job processTwitterDataJob(JobCompletionNotificationListener listener,
                                     Step languageEda, Step expTweetsEda) {
        return jobBuilderFactory.get("processTwitterDataJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(expTweetsEda)
                .next(languageEda)
                .end()
                .build();
    }
}
