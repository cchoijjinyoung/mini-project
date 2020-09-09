package mini.project.util;

import java.sql.Date;
import java.util.Scanner;

public class PromptTest {
  static Scanner keyboardScan = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  public static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  // 프롬프트의 사용이 모두 끝났으면
  // 이 메서드를 호출하여 System.in 입력 스트림 자원을 해제하도록 한다.
  public static void close() {
    keyboardScan.close();
  }
}
