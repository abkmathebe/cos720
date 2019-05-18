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
public class UrlInfoKey implements Serializable {
    @Column(name = "URL")
    private String url;
    @Column(name = "TWEET")
    private String tweet;
}
