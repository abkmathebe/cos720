package za.co.up.twitter.model.zz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.up.twitter.model.TwitterItem;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ZZ_USERS_ENRICH")
public class ZzUsersEnrich extends TwitterItem {

    @EmbeddedId
    private ZzUsersEnrichKey zzUsersEnrichKey;
    @Column(name = "SENTIMENT")
    private String sentiment;
    @Column(name = "EMOTION")
    private String emotion;
    @Column(name = "DISTANCE_LOCATION")
    private BigDecimal distanceLocation;
    @Column(name = "DISTANCE_TZ")
    private BigDecimal distanceTz;
    @Column(name = "CONTINENT")
    private String continent;
    @Column(name = "SUB_REGION")
    private String subRegion;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "AVG_TWEET_TIME")
    private BigDecimal avgTweetTime;
    @Column(name = "NO_OF_DEVICES")
    private Integer noOfDevices;
    @Column(name = "LEVENSHTEIN")
    private BigDecimal levenshtein;
    @Column(name = "HAMMING")
    private BigDecimal hamming;
    @Column(name = "VALID_NAME")
    private String validName;
    @Column(name = "IMAGE_GENDER")
    private String imageGender;
    @Column(name = "IMAGE_AGE")
    private BigDecimal imageAge;
    @Column(name = "NO_OF_FACES")
    private Integer noOfFaces;
    @Column(name = "LAST_TWEET_TIME")
    private String lastTweetTime;
    @Column(name = "IS_BOT")
    private Integer isBot;
    @Column(name = "IS_SUSPENDED")
    private Integer isSuspended;
    @Column(name = "FF_RATIO")
    private String ffRation;
    @Column(name = "USERNAME_LENGTH")
    private String usernameLength;
    @Column(name = "PROFILE_HAS_URL")
    private Integer profileHasUrl;
    @Column(name = "ACCOUNT_AGE_IN_MONTHS")
    private String accountAgeInMonths;
    @Column(name = "HAS_NAME")
    private Integer hasName;
    @Column(name = "HAS_IMAGE")
    private Integer hasImage;
    @Column(name = "DUP_PROFILE")
    private Integer dupProfile;
    @Column(name = "HAS_PROFILE")
    private Integer hasProfile;
}
