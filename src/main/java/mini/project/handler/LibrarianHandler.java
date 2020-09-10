package mini.project.handler;

import java.sql.Date;
import java.util.LinkedList;
import mini.project.domain.Librarian;
import mini.project.util.Prompt;

public class LibrarianHandler {

  LinkedList<Librarian> librarianList = new LinkedList();
  MemberHandler memberHandler;

  // 사서 등록
  public void master() {
    System.out.println("[도서관 사서 등록]");

    Librarian librarian = new Librarian();
    librarian.setId(Prompt.inputString("아이디? "));
    librarian.setName(Prompt.inputString("이름? "));
    librarian.setPassword(Prompt.inputString("암호? "));
    librarian.setRegisteredDate(new Date(System.currentTimeMillis()));

    System.out.println(librarian.getId() + "님 마스터 계정으로 등록되었습니다.");

    librarianList.add(librarian);
  }

  // 사서 이름
  public Librarian findByMaster(String id) {
    for (int i = 0; i < librarianList.size(); i++) {
      Librarian librarian = librarianList.get(i);
      if (librarian.getId().equals(id)) {
        return librarian;
      }
    }
    return null;
  }
}
