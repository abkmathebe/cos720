package za.co.up.twitter.processor.eda.processors;

import com.linkedin.urls.Url;
import com.linkedin.urls.detection.UrlDetector;
import com.linkedin.urls.detection.UrlDetectorOptions;
import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetectorME;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.up.twitter.model.Threat;
import za.co.up.twitter.model.enhance.UrlInfo;
import za.co.up.twitter.model.enhance.UrlInfoKey;
import za.co.up.twitter.model.ex.ExpTweetsDetails;
import za.co.up.twitter.model.ex.ExpUsers;
import za.co.up.twitter.processor.RestClient;
import za.co.up.twitter.processor.eda.repositories.ExpUserRepository;
import za.co.up.twitter.processor.eda.repositories.UrlInfoRepository;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpTweetsProcessor implements ItemProcessor<ExpTweetsDetails, ExpTweetsDetails> {

    @Autowired
    private UrlInfoRepository urlInfoRepository;

    @Autowired
    private ExpUserRepository expUserRepository;

    @Autowired
    private LanguageDetectorME languageDetector;

    @Autowired
    private RestClient restClient;

    @Autowired
    private Map<String, Locale> languageConverter;

    private static final Logger log = LoggerFactory.getLogger(ExpTweetsProcessor.class);
    private static final String REGEX = "\\b((https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])";
    private final String EMOJI_REGEX = "\\([\\u20a0-\\u32ff\\ud83c\\udc00-\\ud83d\\udeff\\udbb9\\udce5-\\udbb9\\udcee]\\)";

    @Override
    public ExpTweetsDetails process(ExpTweetsDetails expTweetsDetails) throws Exception {

        Optional<ExpUsers> linkedUser = expUserRepository.findById(String.valueOf(expTweetsDetails.getUserId()));
        //Find url
        expTweetsDetails.setHasUrl(false);
        expTweetsDetails.setPossiblePhishing(false);
        expTweetsDetails.setHasEmoticon(false);
        expTweetsDetails.setMatchesUserLanguage(true);
        processUrls(expTweetsDetails);
        //Has emoji
        expTweetsDetails.setHasEmoticon(containsEmoji(expTweetsDetails.getContent()));
        //Detect language, only detect > 10 charaters, more errors when short
        if ((linkedUser.isPresent() && expTweetsDetails.getContent().length() > 15)) {
            String detectedLangCode = detectedLanguageCode(expTweetsDetails);
            if(detectedLangCode != null) {
                expTweetsDetails.setDetectedLanguage(detectedLangCode);
                expTweetsDetails.setMatchesUserLanguage(detectedLangCode.equalsIgnoreCase(linkedUser.get().getLanguage()));
            }
        }

        return expTweetsDetails;
    }

    private void processUrls(ExpTweetsDetails expTweetsDetails) {

        UrlDetector parser = new UrlDetector(expTweetsDetails.getContent(), UrlDetectorOptions.Default);
        List<Url> found = parser.detect();

        List<UrlInfo> urlInfos = new ArrayList<>();
        for(Url url :found){
            urlInfos.add(new UrlInfo(new UrlInfoKey(url.getFullUrl(), expTweetsDetails.getId()), false));
        }

//        List<String> urls = pullLinks(expTweetsDetails.getContent());
//
//        if (!urls.isEmpty()) {
//            for (String url : urls) {
//                if (!expTweetsDetails.getHasUrl() && UrlValidator.getInstance().isValid(url)) {
//                    expTweetsDetails.setHasUrl(true);
//                }
//                //Is possible phising?
//                Boolean possiblePhishing = false;
//                urlInfos.add(new UrlInfo(new UrlInfoKey(url, expTweetsDetails.getId()), possiblePhishing));
//                if (possiblePhising(url)) {
//                    expTweetsDetails.setPossiblePhishing(true);
//                }
//            }
            urlInfoRepository.saveAll(urlInfos);
//        }
    }

    public String detectedLanguageCode(ExpTweetsDetails expTweetsDetails) {
        Language language = languageDetector.predictLanguage(expTweetsDetails.getContent());
        //Algorithm returns is0 639-1(three letter), convert to 2 letter
        return languageConverter.get(language.getLang()) != null ? languageConverter.get(language.getLang()).getLanguage(): null;

    }

    private Boolean containsEmoji(String text) {
        Pattern pattern = Pattern.compile("[\uD83C-\uDBFF\uDC00-\uDFFF]+");
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    private Boolean possiblePhising(String text){
        Threat[] threats =  restClient.getDetectedThreat(text).getMatches();
        log.info("Threat {}", threats);
        return threats!= null && threats.length > 0;
    }

    private ArrayList pullLinks(String text) {
        ArrayList links = new ArrayList();
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(text);
        while (m.find()) {
            String urlStr = m.group();
            if (urlStr.startsWith("(") && urlStr.endsWith(")")) {
                urlStr = urlStr.substring(1, urlStr.length() - 1);
            }
            links.add(urlStr);
        }
        return links;
    }
}
