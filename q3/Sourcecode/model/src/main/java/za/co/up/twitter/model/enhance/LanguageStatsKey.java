package za.co.up.twitter.model.enhance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageStatsKey implements Serializable {
    @Column(name = "CODE")
    private String language;
    @Column(name = "DESCRIPTION")
    private String description;
}
