package za.co.up.twitter.model.enhance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "URLS")
public class UrlInfo {
    @EmbeddedId
    private UrlInfoKey urlInfoKey;
    @Column(name = "POSSIBLE_PHISING")
    private Boolean possiblePhishing;
}
