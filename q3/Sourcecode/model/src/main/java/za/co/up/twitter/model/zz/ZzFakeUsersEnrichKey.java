package za.co.up.twitter.model.zz;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZzFakeUsersEnrichKey implements Serializable {
    @Column(name = "ID")
    private String id;
    @Column(name = "SCREENNAME")
    private String screenName;
}
