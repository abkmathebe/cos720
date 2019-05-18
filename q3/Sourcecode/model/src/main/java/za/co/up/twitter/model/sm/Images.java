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
@Table(name = "IMAGES")
public class Images extends TwitterItem {

   @Id
   @Column(name = "IMAGE")
   private String image;
   @Column(name="RESULT")
   private String result;
   @Column(name="NO_OF_FACES")
   private String noOfFaces;
   @Column(name="GENDER")
   private String gender;
   @Column(name="AGE")
   private String age;
}
