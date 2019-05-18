package za.co.up.twitter.model.sm;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.up.twitter.model.TwitterItem;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SMP_NAME_GENDER")
public class SmpNameGender extends TwitterItem {
    @EmbeddedId
    private NameGenderKey nameGenderKey;
    @Column(name = "NAME2")
    private String name2;
    @Column(name = "NAME3")
    private String name3;
    @Column(name = "NAME4")
    private String name4;
}
