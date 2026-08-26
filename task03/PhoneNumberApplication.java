package org.example.basic.practice.practice99.task03;

import java.util.Scanner;

public class PhoneNumberApplication {

  private final Scanner scanner;

  public PhoneNumberApplication() {
    this.scanner = new Scanner(System.in);
  }

  public void run() {
    System.out.print("携帯電話番号を入力してください: ");
    String phoneNumber = scanner.next();

    if (isValidPhoneNumber(phoneNumber)) {
      System.out.printf("%s は有効な携帯電話番号です。%n", phoneNumber);
    } else {
      System.out.printf("%s は無効な携帯電話番号です。%n", phoneNumber);
    }
  }

  private boolean isValidPhoneNumber(String phoneNumber) {
    return phoneNumber.matches("0[789]0-\\d{4}-\\d{4}");
  }
}
