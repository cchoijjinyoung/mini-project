package mini.project.handler;

import java.sql.Date;
import java.util.LinkedList;
import mini.project.domain.Library;
import mini.project.util.PromptTest;

public class LibraryHandler {

  LinkedList<Library> libraryList = new LinkedList();

  public void enter() {
    System.out.println("도서관 입장 정보");

    Library library = new Library();

    Date todayDate = new Date(System.currentTimeMillis());
    System.out.printf("오늘의 날짜: %s\n", todayDate);

    library.setEnterCount(library.getEnterCount() + 1);
    System.out.printf("입장 횟수: %s\n", library.getEnterCount());
  }

  public void checkBook() {
    while (true) {
      System.out.println("해당 도서명을 입력해주세요");
      String temp = PromptTest.inputString("해당 도서명? ");
      int count = 0;
      for (int i = 0; i < libraryList.size(); i++) {
        if (temp.equals(libraryList.get(i).getTitle())) {
          count++;
          boolean bStatus = libraryList.get(i).isbAvailable();

          if (bStatus) {
            bStatus = false;
            System.out.println("도서가 대여되었습니다.");
          } else {
            bStatus = true;
            System.out.println("도서가 반납되었습니다.");
          }
          libraryList.get(i).setbAvailable(bStatus);
          break;
        }
      }
      if (count == 0) {
        System.out.println("해당 도서가 존재하지 않습니다. 도서명을 다시 입력하세요.");
      } else {
        break;
      }
    }

  }

  public void info() {
    System.out.println("[도서 상세 조회]");
    System.out.println("조회할 책의 이름을 입력해주세요.");
    String title = PromptTest.inputString("도서명? ");
    Library library = findByName(title);

    if (library == null) {
      System.out.println("해당 이름의 도서가 없습니다.");
      return;
    }

    System.out.printf("도서명: %s\n", library.getTitle());
    System.out.printf("저자: %s\n", library.getWriter());
    System.out.printf("도서코드: %s\n", library.getCode());
    System.out.printf("출판사: %s\n", library.getPublisher());

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