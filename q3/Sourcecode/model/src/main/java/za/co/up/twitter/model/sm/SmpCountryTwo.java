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
@Table(name = "SMP_COUNTRY_TWO")
public class SmpCountryTwo extends TwitterItem {

    @Id
    @Column(name = "NAME")
    private String name;
    @Column(name = "ALPHA2")
    private String alpha2;
    @Column(name = "ALPHA3")
    private String alpha3;
    @Column(name = "COUNTRYCODE")
    private Integer countryCode;
    @Column(name = "ISO_31662")
    private String iso31662;
    @Column(name = "REGION")
    private String region;
    @Column(name = "SUBREGION")
    private String subRegion;
    @Column(name = "REGIONCODE")
    private Integer regionCode;
    @Column(name = "SUBREGIONCODE")
    private Integer subRegionCode;
}
