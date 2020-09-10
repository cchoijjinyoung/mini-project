package mini.project;

import mini.project.handler.LibraryHandler;
import mini.project.handler.MemberHandler;
import mini.project.util.Prompt;

// Member - 회원 정보 필드
// MembrHandler - 회원 가입/목록/상세조회/수정/탈퇴/로그인
public class LibraryMain {

  public static void main(String[] args) {


    MemberHandler memberHandler = new MemberHandler();

    LibraryHandler libraryHandler = new LibraryHandler();

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

          case "/library/enter": libraryHandler.enter(); break;
          case "/book/check": libraryHandler.checkBook(); break;
          case "/book/info": libraryHandler.info(); break;
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
