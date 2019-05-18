package za.co.up.twitter.model.enhance;

import lombok.Data;

@Data
public class TwitterStats {
    private Long allAccounts;
    private Long allTweets;
    private Long tweetsWithUrls;
    private Long tweetsWithEmoticons;
    private Long tweetsWithPossiblePhishing;
    private Long detectedMatchesDeclaredLanguage;
    private Long mostFollowedAccount;
    private Long mostTweetsAccount;
    private Long avgFollowersPerAccount;
    private Long avgTweetsPerAccount;
    private Long medianTweetsPerAccount;
    private Long geoEnabledAccounts;
    private Long geoEnabledTweets;
    private Long celebrities;
}
