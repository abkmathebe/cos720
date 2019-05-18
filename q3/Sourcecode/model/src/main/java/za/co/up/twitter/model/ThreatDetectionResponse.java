package za.co.up.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThreatDetectionResponse {
    private Threat[] matches;
}
