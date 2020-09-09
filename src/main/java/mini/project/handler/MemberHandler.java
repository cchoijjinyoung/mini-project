package mini.project.handler;

import java.sql.Date;
import java.util.LinkedList;
import mini.project.domain.Member;
import mini.project.util.PromptTest;

public class MemberHandler {

  LinkedList<Member> memberList = new LinkedList();


  // 회원 등록
  public void add() {
    System.out.println("[도서관 회원 가입]");
    System.out.println("회원 가입 시 입력하신 번호는");
    System.out.println("1. 도서 시스템 이용 / 2. 회원 찾기 및 회원 변경 관련하여 이용되며 분실에 유의하시기 바랍니다.");

    Member member = new Member();
    member.setNo(PromptTest.inputInt("번호? "));
    member.setId(PromptTest.inputString("아이디? "));
    member.setName(PromptTest.inputString("이름? "));
    member.setEmail(PromptTest.inputString("이메일? "));
    member.setPassword(PromptTest.inputString("암호? "));
    member.setTel(PromptTest.inputString("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    System.out.println(member.getId() + "님 회원 등록을 축하드립니다. 감사합니다.");

    memberList.add(member);
  }

  // 회원 리스트
  public void list() {
    System.out.println("[회원 목록]");

    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      System.out.printf("%d, %s, %s, %s, %s\n",
          member.getNo(),
          member.getId(),
          member.getName(),
          member.getEmail(),
          member.getTel(),
          member.getRegisteredDate());
    }
  }

  // 회원 상세 정보 조회
  public void detail() {
    System.out.println("[회원 상세 조회]");
    int no = PromptTest.inputInt("번호? ");
    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("아이디: %s\n", member.getId());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("등록일: %s\n", member.getRegisteredDate());
  }

  // 회원 정보 수정
  public void update() {
    System.out.println("[회원정보 수정]");
    int no = PromptTest.inputInt("번호? ");
    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = PromptTest.inputString(
        String.format("이름(%s)? ", member.getName()));
    String id = PromptTest.inputString(
        String.format("아이디(%s)? ", member.getId()));
    String email = PromptTest.inputString(
        String.format("이메일(%s)? ", member.getEmail()));
    String password = PromptTest.inputString("암호? ");
    String tel = PromptTest.inputString(
        String.format("전화(%s)? ", member.getTel()));

    String response = PromptTest.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setName(name);
    member.setId(id);
    member.setEmail(email);
    member.setPassword(password);
    member.setTel(tel);

    System.out.println("회원을 변경하였습니다.");
  }

  // 회원 삭제
  public void delete() {
    System.out.println("[회원 탈퇴]");
    int no = PromptTest.inputInt("번호? ");
    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String response = PromptTest.inputString("정말 탈퇴하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 탈퇴를 취소하였습니다.");
      return;
    }

    memberList.remove(index);
    System.out.println("회원 탈퇴 되었습니다. 그동안 이용해 주셔서 감사합니다.");
  }

  // 로그인
  public void login() {
    String id = PromptTest.inputString("아이디? ");
    String pw = PromptTest.inputString("암호? ");

    Member member = findById(id);

    if (member == null) {
      System.out.println("등록되지 않은 ID 입니다.");
    } else if (member.getPassword().equals(pw)) {
      System.out.println("[" + member.getId() + " 님께서 로그인 하셨습니다.]");
    } else {
      System.out.println("비밀번호가 틀렸습니다.");
    }
  }



  // 회원 번호
  private Member findByNo(int no) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getNo() == no) {
        return member;
      }
    }
    return null;
  }

  // 회원 이름
  private Member findByName(String name) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getName().equals(name)) {
        return member;
      }
    }
    return null;
  }

  // 회원 아이디
  private Member findById(String id) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getId().equals(id)) {
        return member;
      }
    }
    return null;
  }

  // 로그인 아이디 조건문
  private boolean idCheck(String id) {
    boolean check = true;
    Member member = findById(id);
    if (member == null)
      check = false;
    return check;
  }

  // 회원 탈퇴
  private int indexOf(int no) {
    for (int i = 0; i < memberList.size(); i++) {
    	Member member = memberList.get(i);
      if (member.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


