package mini.project;

import mini.project.handler.BookHandler;
import mini.project.handler.LibraryHandler;
import mini.project.handler.MemberHandler;
import mini.project.util.Prompt;

public class LibraryMain {

  public static void main(String[] args) {


    MemberHandler memberHandler = new MemberHandler();

    LibraryHandler libraryHandler = new LibraryHandler(memberHandler);

    BookHandler bookHandler = new BookHandler();

    loop:
      while (true) {
        String command = Prompt.inputString("명령> ");

        switch (command) {
          case "/member/add": memberHandler.add(); break;
          case "/member/list": memberHandler.list(); break;
          case "/member/detail": memberHandler.detail(); break;
          case "/member/update": memberHandler.update(); break;
          case "/member/delete": memberHandler.delete(); break;
          case "/member/login": memberHandler.login(); break;

          case "/library/login": libraryHandler.libraryInfo(); break;
          case "/book/check": libraryHandler.checkBook(); break;
          case "/book/bookInfo": libraryHandler.bookInfo(); break;

          case "/book/add": bookHandler.add(); break;
          case "/book/list": bookHandler.list(); break;
          case "/book/update": bookHandler.delete(); break;
          case "/book/delete": bookHandler.delete(); break;



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
