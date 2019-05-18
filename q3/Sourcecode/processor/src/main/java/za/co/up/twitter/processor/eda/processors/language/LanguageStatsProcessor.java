package za.co.up.twitter.processor.eda.processors.language;

import org.springframework.batch.item.ItemProcessor;
import za.co.up.twitter.model.enhance.LanguageStatistics;
import za.co.up.twitter.model.enhance.LanguageStatsKey;
import za.co.up.twitter.model.sm.SmpLanguage;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LanguageStatsProcessor implements ItemProcessor<SmpLanguage, LanguageStatistics> {

    private EntityManager entityManager;

    public LanguageStatsProcessor(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public LanguageStatistics process(za.co.up.twitter.model.sm.SmpLanguage smpLanguage) throws Exception {

        Query userquery = entityManager.createNativeQuery("SELECT COUNT(*) FROM EXP_USERS WHERE `LANGUAGE` =:id");
        userquery.setParameter("id", smpLanguage.getLanguageCode());
        Integer users = ((Number) userquery.getSingleResult()).intValue();

        Query tweetquery = entityManager.createNativeQuery("SELECT COUNT(*) FROM EXP_TWEETS_DETAIL WHERE DETECTED_LANGUAGE =:id");
        tweetquery.setParameter("id", smpLanguage.getLanguageCode());
        Integer tweets = ((Number) tweetquery.getSingleResult()).intValue();


        return new LanguageStatistics(new LanguageStatsKey(smpLanguage.getLanguageCode(), smpLanguage.getDescription()), users, tweets);
    }
}
