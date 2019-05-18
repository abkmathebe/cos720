package za.co.up.twitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreatDetectionRequest {
    private final Client client = new Client();
    private ThreatInfo threatInfo;
}
