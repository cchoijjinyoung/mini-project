package mini.project.handler;

import java.sql.Date;
import java.util.LinkedList;
import mini.project.domain.Book;
import mini.project.domain.Library;
import mini.project.util.Prompt;

public class LibraryHandler {
  private int viewCount = 1;

  LinkedList<Library> libraryList = new LinkedList();
  LinkedList<Book> bookList = new LinkedList();
  MemberHandler memberHandler;

  public LibraryHandler(MemberHandler memberHandler) {
    this.memberHandler = memberHandler;
  }

  public void libraryInfo() {
    System.out.println("[도서관 입장 정보]");

    Library library = new Library();

    while (true) {
      String name = Prompt.inputString("회원 아이디?(취소: 빈 문자열) ");

      if (name.length() == 0) {
        System.out.println("도서관 입장을 취소합니다.");
        return;
      } else if (memberHandler.findByName(name) != null) {
        library.setMemberId(name);
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    Date todayDate = new Date(System.currentTimeMillis());
    System.out.printf("오늘의 날짜: %s\n", todayDate);
    System.out.printf("입장 횟수: %s\n", viewCount++);
  }

  public void rent() {

    Library library = new Library();

    while (true) {
      String name = Prompt.inputString("회원 아이디?(취소: 빈 문자열) ");

      if (name.length() == 0) {
        System.out.println("대여를 취소합니다.");
        return;
      } else if (memberHandler.findByName(name) != null) {
        library.setMemberId(name);
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
    System.out.println("[도서 대여 정보 입력]");

    while (true) {
      String title = Prompt.inputString("도서명?(취소: 빈 문자열) ");

      if (title.length() == 0) {
        System.out.println("정보 입력을 취소합니다.");
        return;
      } else {
        System.out.println("도서의 정보를 적어주세요.");

        library.setTitle(Prompt.inputString("도서명? "));
        library.setNo(Prompt.inputInt("코드? "));
        library.setAuthor(Prompt.inputString("저자? "));
        library.setPublisher(Prompt.inputString("출판사? "));
        library.setStartrent(Prompt.inputDate("대여 시작일? "));
        library.setEndrent(Prompt.inputDate("대여 완료일? "));
        library.setState(Prompt.inputInt("상태?\n1: 대여 실행\n2: 대여 취소\n> "));

        libraryList.add(library);
        break;

      }
    }
  }

  public void bookInfo() {
    System.out.println("[해당 도서의 상세를 조회합니다.]");
    String title = Prompt.inputString("도서명? ");
    Library library = findByName(title);

    if (library == null) {
      System.out.println("해당 이름의 도서가 없습니다.");
      return;
    }

    String stateLabel = null;
    switch (library.getState()) {
      case 1:
        stateLabel = "대여 중";
        break;
      case 2:
        stateLabel = "대여 가능";
        break;
      default:
        stateLabel = "분실";
    }
    System.out.printf("도서명: %s\n", library.getTitle());
    System.out.printf("저자: %s\n", library.getAuthor());
    System.out.printf("도서코드: %s\n", library.getNo());
    System.out.printf("출판사: %s\n", library.getPublisher());
    System.out.printf("대여 유무: %s\n", stateLabel);

  }


  private Library findByName(String title) {
    for (int i = 0; i < libraryList.size(); i++) {
      Library library = libraryList.get(i);
      if (library.getTitle().equals(title)) {
        return library;
      }
    }
    return null;
  }

}