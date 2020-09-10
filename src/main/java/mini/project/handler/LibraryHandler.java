package mini.project.handler;

import java.sql.Date;
import java.util.LinkedList;
import mini.project.domain.Book;
import mini.project.domain.Library;
import mini.project.util.PromptTest;

public class LibraryHandler {

  private int Viewcount = 1;
  LinkedList<Library> libraryList = new LinkedList();
  LinkedList<Book> bookList = new LinkedList();

  public void libraryInfo() {
    System.out.println("[도서관 입장 정보]");

    Library library = new Library();

    Date todayDate = new Date(System.currentTimeMillis());
    System.out.printf("오늘의 날짜: %s\n", todayDate);
    System.out.printf("입장 횟수: %d\n", Viewcount++);
  }

  public void rent() {
    System.out.println("[대여 도서 입력]");

    Library library = new Library();
    library.setTitle(PromptTest.inputString("책 이름? "));
    library.setNo(PromptTest.inputInt("코드? "));
    library.setAuthor(PromptTest.inputString("저자? "));
    library.setPublisher(PromptTest.inputString("출판사? "));
    library.setStartrent(PromptTest.inputDate("대여 시작일? "));
    library.setEndrent(PromptTest.inputDate("대여 완료일? "));
    library.setState(PromptTest.inputInt("상태?\n1: 대여 중\n2: 대여 가능\n> "));

    libraryList.add(library);
  }


  //  public void checkBook() {
  //    while (true) {
  //      System.out.println("[해당 도서의 재고 유무를 확인합니다.]");
  //      String temp = PromptTest.inputString("해당 도서명? ");
  //      int count = 0;
  //      for (int i = 0; i < libraryList.size(); i++) {
  //        if (temp.equals(libraryList.get(i).getTitle())) {
  //          count++;
  //          boolean bStatus = libraryList.get(i).isbAvailable();
  //
  //          if (bStatus) {
  //            bStatus = false;
  //            System.out.println("도서가 대여되었습니다.");
  //          } else {
  //            bStatus = true;
  //            System.out.println("도서가 반납되었습니다.");
  //          }
  //          libraryList.get(i).setbAvailable(bStatus);
  //          break;
  //        }
  //      }
  //      if (count == 0) {
  //        System.out.println("해당 도서가 존재하지 않습니다. 도서명을 다시 입력하세요.");
  //      } else {
  //        break;
  //      }
  //    }
  //
  //  }

  public void bookInfo() {
    System.out.println("[해당 도서의 상세를 조회합니다.]");
    String title = PromptTest.inputString("도서명? ");
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
