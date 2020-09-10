package mini.project.domain;

import java.sql.Date;

public class Librarian {

  // 사서
  private String id;
  private String name;
  private String password;
  private Date registeredDate;

  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  public String getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getPassword() {
    return password;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
