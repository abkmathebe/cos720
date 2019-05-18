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
@Table(name = "SMP_LANGUAGE")
public class SmpLocation extends TwitterItem {

    @Id
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "LATITUDE")
    private BigDecimal latitude;
    @Column(name = "LONGITUDE")
    private BigDecimal longitude;
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "CONTINENT")
    private String continent;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "CLASS")
    private String clazz;
}
