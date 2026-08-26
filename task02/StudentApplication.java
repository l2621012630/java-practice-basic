package org.example.basic.practice.practice99.task02;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentApplication {

  private final StudentService studentService;
  private final Scanner scanner;

  public StudentApplication() {
    this.studentService = new StudentService();
    this.scanner = new Scanner(System.in);
  }

  public void run() {
    try {
      while (true) {
        int choice = readChoice();

        System.out.println();

        // ラベル付きbreakは避ける
        if (choice == 6) {
          break;
        }

        switch (choice) {
          case 1 -> addStudent();
          case 2 -> deleteStudent();
          case 3 -> updateScore();
          case 4 -> calculateAverage();
          case 5 -> showStudents();
          default -> System.out.println("不正な入力です。");
        }

        System.out.println();
      }

    } catch (NoSuchElementException ex) {
      System.out.println("入力を受け付けられませんでした。");
    }

    System.out.println("プログラムを終了します");
  }

  private int readChoice() {
    System.out.print("""
        1. 学生を追加
        2. 学生を削除
        3. 点数を更新
        4. 平均点を計算
        5. 全学生の情報を表示
        6. 終了
        """);
    System.out.print("選択してください: ");
    return scanner.nextInt();
  }

  private void addStudent() {
    System.out.print("学生の名前を入力してください: ");
    String name = scanner.next();

    System.out.printf("%sの点数を入力してください: ", name);
    int score = scanner.nextInt();

    studentService.addStudent(name, score);
  }

  private void deleteStudent() {
    System.out.print("学生の名前を入力してください: ");
    String name = scanner.next();

    studentService.deleteStudent(name);

    System.out.printf("%sを削除しました%n", name);
  }

  private void updateScore() {
    System.out.print("学生の名前を入力してください: ");
    String name = scanner.next();

    System.out.printf("%sの点数を入力してください: ", name);
    int score = scanner.nextInt();

    studentService.updateScore(name, score);
  }

  private void calculateAverage() {
    double average = studentService.calculateAverage();
    System.out.printf("平均点:%.1f点%n", average);
  }

  private void showStudents() {
    System.out.println("学生一覧:");

    List<Student> students = studentService.getStudents();
    for (Student student : students) {
      System.out.printf("%s:%d点%n", student.getName(), student.getScore());
    }
  }

}
