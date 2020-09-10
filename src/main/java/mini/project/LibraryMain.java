package mini.project;

import mini.project.handler.BookHandler;
import mini.project.handler.LibrarianHandler;
import mini.project.handler.LibraryHandler;
import mini.project.handler.MemberHandler;
import mini.project.util.Prompt;

// 메인.

public class LibraryMain {

  public static void main(String[] args) {


    MemberHandler memberHandler = new MemberHandler();
    LibrarianHandler librarianHandler = new LibrarianHandler();

    LibraryHandler libraryHandler = new LibraryHandler(memberHandler);

    BookHandler bookHandler = new BookHandler(librarianHandler);

    loop:
      while (true) {
        String command = Prompt.inputString("명령> ");

        switch (command) {

          // 사용자
          case "/member/add": memberHandler.add(); break;
          case "/member/list": memberHandler.list(); break;
          case "/member/detail": memberHandler.detail(); break;
          case "/member/update": memberHandler.update(); break;
          case "/member/delete": memberHandler.delete(); break;
          case "/member/login": memberHandler.login(); break;

          case "/book/add": bookHandler.add(); break;
          case "/book/list": bookHandler.list(); break;
          case "/book/detail": bookHandler.detail(); break;

          // 사서용
          case "/member/master": librarianHandler.master(); break;
          case "/book/delete": bookHandler.delete(); break;
          case "/book/update": bookHandler.update(); break;

          case "/library/info": libraryHandler.libraryInfo(); break;
          case "/book/info": libraryHandler.bookInfo(); break;
          case "/book/rent": libraryHandler.rent(); break;
          //          case "/book/check": libraryHandler.checkBook(); break;





          case "quit":
          case "exit":
            System.out.println("종료됩니다!");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }
        System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
      }
    Prompt.close();
  }
}
