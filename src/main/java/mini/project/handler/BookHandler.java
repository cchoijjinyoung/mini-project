package mini.project.handler;

import java.util.LinkedList;
import mini.project.domain.Book;
import mini.project.util.PromptTest;

public class BookHandler {

  LinkedList<Book> booklist = new LinkedList();


  // 도서 등록
  public void add() {
    System.out.println("[도서 등록]");

    Book book = new Book();
    book.setTitle(PromptTest.inputString("도서명? "));
    book.setNo(PromptTest.inputInt("도서 번호? "));
    book.setAuthor(PromptTest.inputString("작가명? "));
    book.setGanre(PromptTest.inputString("장르? "));
    book.setPublisher(PromptTest.inputString("출판사? "));

    System.out.println("도서를 등록했습니다.");

    booklist.add(book);
  }

  // 도서 목록
  public void list() {
    System.out.println("[도서 목록]");

    for (int i = 0; i < booklist.size(); i++) {
      Book book = booklist.get(i);
      System.out.printf("%d, %s, %s, %s\n",
          book.getNo(),
          book.getTitle(),
          book.getAuthor(),
          book.getGanre());
    }
  }

  // 도서 조회
  public void detail() {
    System.out.println("[도서 조회]");
    int no = PromptTest.inputInt("번호? ");
    Book book = findByNo(no);

    if (book == null) {
      System.out.println("해당 도서가 존재하지 않습니다.");
      return;
    }

    System.out.printf("번호: %s\n", book.getNo());
    System.out.printf("도서제목: %s\n",  book.getTitle());
    System.out.printf("지은이: %s\n",  book.getAuthor());
    System.out.printf("장르: %s\n", book.getGanre());
  }

  // 도서 정보 수정
  public void update() {
    System.out.println("[도서 수정]");
    int no = PromptTest.inputInt("번호? ");
    Book book = findByNo(no);

    if (book == null) {
      System.out.println("해당 번호의 도서가 없습니다.");
      return;
    }

    String title = PromptTest.inputString(
        String.format("도서제목(%s)? ",book.getTitle()));
    String author = PromptTest.inputString(
        String.format("지은이(%s)? ", book.getAuthor()));
    String ganre = PromptTest.inputString(
        String.format("장르(%s)? ", book.getGanre()));

    String response = PromptTest.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("도서 수정을 취소하였습니다.");
      return;
    }

    book.setTitle(title);
    book.setAuthor(author);
    book.setGanre(ganre);

    System.out.println("도서를 수정하였습니다.");
  }

  // 도서 삭제
  public void delete() {
    System.out.println("[도서 삭제]");
    int no = PromptTest.inputInt("번호? ");
    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 도서가 없습니다.");
      return;
    }

    String response = PromptTest.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("도서 삭제를 취소하였습니다.");
      return;
    }

    booklist.remove(index);
    System.out.println("도서가 삭제되었습니다.");
  }

  // 도서 번호
  private Book findByNo(int no) {
    for (int i = 0; i < booklist.size(); i++) {
      Book book = booklist.get(i);
      if (book.getNo() == no) {
        return book;
      }
    }
    return null;
  }

  // 도서 삭제
  private int indexOf(int no) {
    for (int i = 0; i < booklist.size(); i++) {
      Book book = booklist.get(i);
      if (book.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


