package za.co.up.twitter.model.sm;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class NameGenderKey implements Serializable {
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "NAME")
    private String name;
}
