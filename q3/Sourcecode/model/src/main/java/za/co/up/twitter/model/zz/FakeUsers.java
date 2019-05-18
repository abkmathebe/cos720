package za.co.up.twitter.model.zz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.up.twitter.model.TwitterItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ZZ_FAKE_USERS")
public class FakeUsers extends TwitterItem {
    @Id
    @Column(name = "ID")
    Long id;
    @Column(name = "NAME")
    String name;
    @Column(name = "SCREENNAME")
    String screenName;
    @Column(name = "CREATED")
    String created;
    @Column(name = "ORIGINAL_PROFILE_IMAGE")
    String originalProfileImage;
    @Column(name = "PROFILE_IMAGE")
    String profileImage;
    @Column(name = "BACKGROUND_IMAGE")
    String backgroundImage;
    @Column(name = "LAST_TWEET")
    String lastTweet;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "LOCATION")
    String location;
    @Column(name = "LANG")
    String language;
    @Column(name = "FRIENDS_COUNT")
    Integer friendCount;
    @Column(name = "FOLLOWERS_COUNT")
    Integer followersCount;
    @Column(name = "STATUS_COUNT")
    Integer statusCount;
    @Column(name = "LISTED_COUNT")
    Integer listedCount;
    @Column(name = "TIMEZONE")
    String timezone;
    @Column(name = "UTC_OFFSET")
    Integer utcOffset;
    @Column(name = "GEO_ENABLED")
    Integer geoEnabled;
    @Column(name = "LATITUDE")
    Integer latitude;
    @Column(name = "LONGITUDE")
    Integer longitude;
    @Column(name = "IS_CELEBRITY")
    Integer isCelebrity;
    @Column(name = "IS_DEFAULT_PROFILE")
    Integer isDefaultProfile;
    @Column(name = "IS_DEFAULT_PROFILE_IMAGE")
    Integer isDefaultProfileImage;
    @Column(name = "IS_BACKGROUND_IMAGE_USED")
    Integer isBackgroundImageUsed;
    @Column(name = "PROFILE_TEXT_COLOR")
    String profileTextColor;
    @Column(name = "PROFILE_BG_COLOR")
    String profileBgColor;
    @Column(name = "SNAPSHOT_DATE")
    String snapshotDate;
    @Column(name = "SNAPSHOT_END_DATE")
    String snapshotEndDate;
}
