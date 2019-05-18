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
@Table(name = "ZZ_USERS")
public class ZzUsers extends TwitterItem {
    @EmbeddedId
    private ZzUsersKey zzUsersKey;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CREATED")
    private String created;
    @Column(name = "ORIGINAL_PROFILE_IMAGE")
    private String originalProfileImage;
    @Column(name = "PROFILE_IMAGE")
    private String profileImage;
    @Column(name = "BACKGROUND_IMAGE")
    private String backgroundImage;
    @Column(name = "LAST_TWEET")
    private String lastTweet;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "LANGUAGE")
    private String language;
    @Column(name = "FRIENDS_COUNT")
    private Integer friendCount;
    @Column(name = "FOLLOWERS_COUNT")
    private Integer followersCount;
    @Column(name = "STATUS_COUNT")
    private Integer statusCount;
    @Column(name = "LISTED_COUNT")
    private Integer listedCount;
    @Column(name = "TIMEZONE")
    private String timezone;
    @Column(name = "UTC_OFFSET")
    private Integer utcOffset;
    @Column(name = "GEO_ENABLED")
    private Integer geoEnabled;
    @Column(name = "LATITUDE")
    private BigDecimal latitude;
    @Column(name = "LONGITUDE")
    private BigDecimal longitude;
    @Column(name = "IS_CELEBRITY")
    private Integer isCelebrity;
    @Column(name = "IS_DEFAULT_PROFILE")
    private Integer isDefaultProfile;
    @Column(name = "IS_DEFAULT_PROFILE_IMAGE")
    private Integer isDefaultProfileImage;
    @Column(name = "IS_BACKGROUND_IMAGE_USED")
    private Integer isBackgroundImageUsed;
    @Column(name = "PROFILE_TEXT_COLOR")
    private String profileTextColor;
    @Column(name = "PROFILE_BG_COLOR")
    private String profileBgColor;
    @Column(name = "SNAPSHOT_DATE")
    private String snapshotDate;
    @Column(name = "SNAPSHOT_END_DATE")
    private String snapshotEndDate;
}

