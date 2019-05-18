package za.co.twitter;

import com.linkedin.urls.Url;
import com.linkedin.urls.detection.UrlDetector;
import com.linkedin.urls.detection.UrlDetectorOptions;
import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class RestTest {
    @Test
//    @Ignore
    public void test() throws Exception{
        File modelFile = new File(RestTest.class.getClassLoader().getResource("langdetect-183.bin").getFile());
        LanguageDetectorModel languageDetectorModel = new LanguageDetectorModel(modelFile);
        LanguageDetectorME languageDetectorME = new LanguageDetectorME(languageDetectorModel);

        Language language = languageDetectorME.predictLanguage("Wat");

        //011408032082780382
        System.out.println(language.getLang() + ": " + language.getConfidence());

        UrlDetector parser = new UrlDetector("grundverordnung-aktualisierung-datenschutz.top", UrlDetectorOptions.Default);
        List<Url> found = parser.detect();

        System.out.println(language.getLang() + ": " + language.getConfidence());

//        RestClient restClient = new RestClient();
//        System.err.println(restClient.getDetectedThreat("grundverordnung-aktualisierung-datenschutz.top"));
    }
}
