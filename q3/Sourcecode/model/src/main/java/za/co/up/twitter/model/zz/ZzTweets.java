package za.co.up.twitter.model.zz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.up.twitter.model.TwitterItem;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ZZ_TWEETS")
public class ZzTweets extends TwitterItem {

    @EmbeddedId
    private ZzTweetsKey zzTweetsKey;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "CREATEDAT")
    private String createdAt;
    @Column(name = "RETWEET")
    private Integer retweet;
    @Column(name = "RTID")
    private Integer rtId;
    @Column(name = "RTUSERNAME")
    private String rtUserName;
    @Column(name = "SIZE")
    private Integer size;
    @Column(name = "LAST_UPDATED")
    private String lastUpdated;
    @Column(name = "SOURCE")
    private String source;
}
