package za.co.up.twitter.processor.eda.readers;

import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.orm.JpaNativeQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.up.twitter.model.ex.ExpTweetsDetails;
import za.co.up.twitter.model.ex.ExpUsers;
import za.co.up.twitter.model.sm.SmpCountry;
import za.co.up.twitter.model.sm.SmpLanguage;

import javax.persistence.EntityManagerFactory;

@Configuration
public class ReaderConfiguration {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public JpaPagingItemReader<SmpCountry> reader() throws Exception {
        JpaPagingItemReader<SmpCountry> databaseReader = new JpaPagingItemReader<>();
        setupDatabaseReader(databaseReader, "SELECT * FROM SMP_COUNTRY", SmpCountry.class);
        return databaseReader;
    }

    @Bean
    public JpaPagingItemReader<SmpLanguage> languageReader() throws Exception {
        JpaPagingItemReader<SmpLanguage> databaseReader = new JpaPagingItemReader<>();
        setupDatabaseReader(databaseReader, "SELECT * FROM SMP_LANGUAGE", SmpLanguage.class);
        return databaseReader;
    }

    @Bean
    public JpaPagingItemReader<ExpUsers> usersReader() throws Exception {
        JpaPagingItemReader<ExpUsers> databaseReader = new JpaPagingItemReader<>();
        setupDatabaseReader(databaseReader, "SELECT * FROM EXP_USERS", ExpUsers.class);
        return databaseReader;
    }

    @Bean
    public JpaPagingItemReader<ExpTweetsDetails> expTweetsReader() throws Exception {
        JpaPagingItemReader<ExpTweetsDetails> databaseReader = new JpaPagingItemReader<>();
        setupDatabaseReader(databaseReader, "SELECT * FROM EXP_TWEETS_DETAIL", ExpTweetsDetails.class);
        return databaseReader;
    }

    private void setupDatabaseReader(JpaPagingItemReader databaseReader, String query, Class entityClazz) throws Exception{
        databaseReader.setEntityManagerFactory(entityManagerFactory);
        JpaNativeQueryProvider<SmpCountry> jpaQueryProvider = new JpaNativeQueryProvider<>();
        jpaQueryProvider.setSqlQuery(query);
        jpaQueryProvider.setEntityClass(entityClazz);
        databaseReader.setQueryProvider(jpaQueryProvider);
        databaseReader.setPageSize(1000);
        databaseReader.afterPropertiesSet();
    }


}
