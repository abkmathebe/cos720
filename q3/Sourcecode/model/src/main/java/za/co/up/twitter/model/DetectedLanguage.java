package za.co.up.twitter.model;

import lombok.Data;

@Data
public class DetectedLanguage {
    private String languageCode;
    private Long confidence;
    private Boolean isReliable;
}
