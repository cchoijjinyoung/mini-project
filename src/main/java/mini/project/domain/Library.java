package mini.project.domain;

import java.sql.Date;

public class Library {

  private int state;
  private String title;
  private String name;
  private String author;
  private String publisher;
  private int no;
  private Date startrent;
  private Date endrent;
  private int viewCount;
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
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String writer) {
    this.author = writer;
  }
  public String getPublisher() {
    return publisher;
  }
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int code) {
    this.no = code;
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
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int enterCount) {
    this.viewCount = enterCount;
  }

  public boolean isbAvailable() {
    return Available;
  }

  public void setbAvailable(boolean bAvailable) {
    this.Available = bAvailable;
  }





}

