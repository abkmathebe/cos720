package za.co.up.twitter.model.zz;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZzTweetsKey implements Serializable {
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERID")
    private Long userId;
    @Column(name = "USERNAME")
    private String userName;
}
