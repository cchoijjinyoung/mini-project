package mini.project.domain;

import java.sql.Date;

public class Library {

  private int state;
  private String title;
  private String name;
  private String writer;
  private String publisher;
  private int code;
  private Date startrent;
  private Date endrent;
  private int enterCount;
  private boolean Available;


  public int getState() {
    return state;
  }
  public void setState(int state) {
    this.state = state;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public String getPublisher() {
    return publisher;
  }
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
  public int getCode() {
    return code;
  }
  public void setCode(int code) {
    this.code = code;
  }
  public Date getStartrent() {
    return startrent;
  }
  public void setStartrent(Date startrent) {
    this.startrent = startrent;
  }
  public Date getEndrent() {
    return endrent;
  }
  public void setEndrent(Date endrent) {
    this.endrent = endrent;
  }
  public int getEnterCount() {
    return enterCount;
  }
  public void setEnterCount(int enterCount) {
    this.enterCount = enterCount;
  }

  public boolean isbAvailable() {
    return Available;
  }

  public void setbAvailable(boolean bAvailable) {
    this.Available = bAvailable;
  }





}

