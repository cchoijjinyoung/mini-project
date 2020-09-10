package mini.project;

import mini.project.handler.BookHandler;
import mini.project.handler.LibrarianHandler;
import mini.project.handler.LibraryHandler;
import mini.project.handler.MemberHandler;
import mini.project.util.Prompt;

// 메인

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

          // 회원 전용
          case "/member/add": memberHandler.add(); break; // 회원 가입
          case "/member/list": memberHandler.list(); break; // 회원 목록
          case "/member/detail": memberHandler.detail(); break; // 회원 상세
          case "/member/update": memberHandler.update(); break; // 회원 수정
          case "/member/delete": memberHandler.delete(); break; // 회원 탈퇴
          case "/member/login": memberHandler.login(); break;// 로그인
          case "/book/list": bookHandler.list(); break; // 도서 리스트
          case "/book/detail": bookHandler.detail(); break; // 도서 상세
          case "/library/info": libraryHandler.libraryInfo(); break; // 이용정보
          case "/book/rent": libraryHandler.rent(); break;
          case "/rent/info": libraryHandler.rentInfo(); break;

          // 관리자(사서)용
          case "/master/add": librarianHandler.master(); break;
          case "/master/list": librarianHandler.list(); break;
          case "/book/delete": bookHandler.delete(); break;
          case "/book/update": bookHandler.update(); break;

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
