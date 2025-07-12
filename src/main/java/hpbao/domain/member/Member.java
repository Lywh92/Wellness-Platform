package hpbao.domain.member;

import hpbao.domain.caloriekit.CalorieKit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String userName;
  private String userId;
  private String password;
  private String userEmail;



  public Member(){

  }

  public Member(String userName, String userId, String password, String userEmail) {
    this.userName = userName;
    this.userId = userId;
    this.password = password;
    this.userEmail = userEmail;
  }
}

