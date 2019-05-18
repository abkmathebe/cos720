package za.co.up.twitter.model.zz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.up.twitter.model.TwitterItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ZZ_BOTS")
public class Bots extends TwitterItem {
    @Id
    @Column(name = "USERID")
    private String userId;
    @Column(name = "USERNAME")
    private String userName;
}
