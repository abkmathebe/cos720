package za.co.up.twitter.model.sm;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.up.twitter.model.TwitterItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SMP_LANGUAGE")
public class SmpLanguage extends TwitterItem {

    @Id
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "FULL_CODE")
    private String fullCode;
    @Column(name = "LANGUAGE_CODE")
    private String languageCode;
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
}
