package za.co.up.twitter.processor.eda;

import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.up.twitter.model.enhance.LanguageStatistics;
import za.co.up.twitter.model.ex.ExpTweetsDetails;
import za.co.up.twitter.model.sm.SmpLanguage;
import za.co.up.twitter.processor.RestClient;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    private File modelFile = new File(BatchConfiguration.class.getClassLoader().getResource("langdetect-183.bin").getFile());

    @Bean
    public Step languageEda(ItemProcessor<SmpLanguage, LanguageStatistics> languageStatisticsItemProcessor,
                            ItemReader<SmpLanguage> languageReader, ItemWriter<LanguageStatistics> languageStatisticsItemWriter) {
        return stepBuilderFactory.get("importLanguageStats")
                .<SmpLanguage, LanguageStatistics>chunk(100)
                .reader(languageReader)
                .processor(languageStatisticsItemProcessor)
                .writer(languageStatisticsItemWriter)
                .build();
    }

    @Bean
    public Step expTweetsEda(ItemProcessor<ExpTweetsDetails, ExpTweetsDetails> expTweetsProcessor,
                            ItemReader<ExpTweetsDetails> expTweetsReader, ItemWriter<ExpTweetsDetails> expTweetsWriter) {
        return stepBuilderFactory.get("importTweetsDetails")
                .<ExpTweetsDetails, ExpTweetsDetails>chunk(100)
                .reader(expTweetsReader)
                .processor(expTweetsProcessor)
                .writer(expTweetsWriter)
                .build();
    }

    @Bean
    public LanguageDetectorME languageDetector() throws Exception{
        // load the trained Language Detector Model file
        LanguageDetectorModel languageDetectorModel = new LanguageDetectorModel(modelFile);
        return new LanguageDetectorME(languageDetectorModel);
    }

    @Bean
    public RestClient restClient() throws Exception{
        return new RestClient();
    }

    @Bean
    public Map<String, Locale> languageConverter(){
        String[] languages = Locale.getISOLanguages();
        Map<String, Locale> localeMap = new HashMap<String, Locale>(languages.length);
        for (String language : languages) {
            Locale locale = new Locale(language);
            localeMap.put(locale.getISO3Language(), locale);
        }

        return localeMap;
    }
}
