package za.co.up.twitter.model.enhance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LANG_STATS")
public class LanguageStatistics {
    @EmbeddedId
    private LanguageStatsKey languageStatsKey;
    @Column(name = "USERS")
    private Integer users;
    @Column(name = "TWEETS")
    private Integer tweets;
}
