package mini.project.domain;

import java.sql.Date;

public class Member {

  // 회원 데이터
  private int no;
  private String id;
  private String name;
  private String email;
  private String password;
  private String tel;
  private Date registeredDate;


  public int getNo() {
    return no;
  }
  public String getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getEmail() {
    return email;
  }
  public String getPassword() {
    return password;
  }
  public String getTel() {
    return tel;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
}

