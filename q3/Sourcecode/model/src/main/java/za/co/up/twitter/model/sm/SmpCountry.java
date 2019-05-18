package za.co.up.twitter.model.sm;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.up.twitter.model.TwitterItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SMP_COUNTRY")
public class SmpCountry extends TwitterItem {

    @Id
    @Column(name = "COUNTRY_EN")
    private String countryEn;
    @Column(name = "COUNTRY_DE")
    private String countryDe;
    @Column(name = "COUNTRY_LOCAL")
    private String countryLocal;
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    @Column(name = "CONTINENT")
    private String continent;
    @Column(name = "CAPITAL")
    private String capital;
    @Column(name = "POPULATION")
    private Integer population;
    @Column(name = "AREA")
    private Integer area;
    @Column(name = "COASTLINE")
    private Integer coastline;
    @Column(name = "GOVERNMENT_FORM")
    private String governmentForm;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;
    @Column(name = "DIALING_PREFIX")
    private String dialingPrefix;
    @Column(name = "BIRTHRATE")
    private BigDecimal birthRate;
    @Column(name = "DEATHRATE")
    private BigDecimal deathRate;
    @Column(name = "LIFE_EXPECTANCY")
    private BigDecimal lifeExpectancy;
    @Column(name = "URL")
    private String url;
}
