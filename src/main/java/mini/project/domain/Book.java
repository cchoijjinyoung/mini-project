package mini.project.domain;

public class Book {

  int no;
  String title;
  String author;
  String ganre;
  String publisher;
  private boolean Available;


  public String getPublisher() {
    return publisher;
  }
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
  public boolean isAvailable() {
    return Available;
  }
  public void setAvailable(boolean available) {
    Available = available;
  }



  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public String getGanre() {
    return ganre;
  }
  public void setGanre(String ganre) {
    this.ganre = ganre;
  }





}
