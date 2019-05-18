package za.co.up.twitter.processor;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import za.co.up.twitter.model.ThreatDetectionRequest;
import za.co.up.twitter.model.ThreatDetectionResponse;
import za.co.up.twitter.model.ThreatEntry;
import za.co.up.twitter.model.ThreatInfo;

public class RestClient {

    RestTemplate restTemplate = new RestTemplate();

    private static final String REST_URI = "https://safebrowsing.googleapis.com/v4/threatMatches:find";

    public ThreatDetectionResponse getDetectedThreat(String url) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(REST_URI)
                .queryParam("key", "");

        ThreatDetectionRequest threatDetectionRequest = new ThreatDetectionRequest();
        threatDetectionRequest.setThreatInfo(new ThreatInfo());
        threatDetectionRequest.getThreatInfo().getThreatTypes().add("SOCIAL_ENGINEERING");
        threatDetectionRequest.getThreatInfo().getThreatTypes().add("MALWARE");
        threatDetectionRequest.getThreatInfo().getThreatTypes().add("UNWANTED_SOFTWARE");
        threatDetectionRequest.getThreatInfo().getPlatformTypes().add("ANY_PLATFORM");
        threatDetectionRequest.getThreatInfo().getThreatEntries().add(new ThreatEntry(url));
        threatDetectionRequest.getThreatInfo().getThreatEntryTypes().add("URL");

        return restTemplate.postForObject(builder.toUriString(), threatDetectionRequest, ThreatDetectionResponse.class);
    }
}
