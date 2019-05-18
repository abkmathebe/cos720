package za.co.up.twitter.model.zz;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZzUsersEnrichKey implements Serializable {
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SCREENNAME")
    private String screenName;
}
