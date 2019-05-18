package za.co.up.twitter.model.ex;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.up.twitter.model.TwitterItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Entity
@Table(name = "EXP_TWEETS_DETAIL")
public class ExpTweetsDetails extends TwitterItem {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "CREATEDAT")
    private String createdAt;
    @Column(name = "RETWEET")
    private String retweet;
    @Column(name = "RTID")
    private Long rtId;
    @Column(name = "RTUSERNAME")
    private String rtUsername;
    @Column(name = "OPEN_DATE")
    private String openDate;
    @Column(name = "USERID")
    private Long userId;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "FULLNAME")
    private String fullName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "GEO_ENABLED")
    private String geoEnabled;
    @Column(name = "LATITUDE")
    private String latitude;
    @Column(name = "LONGITUDE")
    private String longitude;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "TIMEZONE")
    private String timezone;
    @Column(name = "LANGUAGE")
    private String language;
    @Column(name = "FOLLOWERS")
    private String followers;
    @Column(name = "FRIENDS")
    private String friends;
    @Column(name = "RTFOLLOWERS")
    private String rtFollowers;
    @Column(name = "TRANSLATOR")
    private Boolean translator;
    @Column(name = "STATUS_COUNT")
    private String statusCount;
    @Column(name = "PROFILE_IMAGE")
    private String profileImage;
    @Column(name = "BACKGROUND_IMAGE")
    private String backgroundImage;
    @Column(name = "BANNER_IMAGE")
    private String bannerImage;
    @Column(name = "IS_FRIEND")
    private Boolean isFriend;
    @Column(name = "IS_FOLLOWER")
    private Boolean isFollower;
    @Column(name = "IS_DEFAULT_PROFILE")
    private Boolean isDefaultProfile;
    @Column(name = "SIZE")
    private String size;
    @Column(name = "LAST_UPDATED")
    private String lastUpdated;
    @Column(name = "INREPLYTO")
    private String inReplyTo;
    @Column(name = "SOURCE")
    private String source;
    @Column(name = "HAS_EMOTICON")
    private Boolean hasEmoticon;
    @Column(name = "DETECTED_LANGUAGE")
    private String detectedLanguage;
    @Column(name = "HAS_URLS")
    private Boolean hasUrl;
    @Column(name = "POSSIBLE_PHISING")
    private Boolean possiblePhishing;
    @Column(name = "MATCHES_USER_LANGUAGE")
    private Boolean matchesUserLanguage;

}
