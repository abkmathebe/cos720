package za.co.up.twitter.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ThreatInfo {
    List<String> threatTypes = new ArrayList<>();
    List<String> platformTypes = new ArrayList<>();
    List<String> threatEntryTypes = new ArrayList<>();
    List<ThreatEntry> threatEntries = new ArrayList<>();
}
