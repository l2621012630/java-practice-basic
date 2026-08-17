package org.example;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Practice7 {

  // Java 16 で正式に標準機能となった record の方がスマート
  // public record Employee(String name, int age, String department, int salary) {}

  public static class Employee {

    private final String name;
    private final int age;
    private final String department;
    private final int salary;

    public Employee(String name, int age, String department, int salary) {
      this.name = name;
      this.age = age;
      this.department = department;
      this.salary = salary;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    public String getDepartment() {
      return department;
    }

    public int getSalary() {
      return salary;
    }
  }

  public static void main(String[] args) {
    System.out.println("--- 課題1 ---");
    runTask1();

    System.out.println();
    System.out.println("--- 課題2 ---");
    runTask2();

    System.out.println();
    System.out.println("--- 課題3 ---");
    runTask3();
  }

  /**
   * 課題1: 文字列のリストから文字数が2以上のものを抽出し、カンマ区切りで結合して出力する
   */
  public static void runTask1() {
    List<String> words = List.of(
        "A", "Java", "Go", "C", "Python",
        "JS", "Ruby", "R", "Kotlin", "PHP"
    );

    String result = words.stream()
        .filter(v -> v.length() >= 2)
        .collect(Collectors.joining(", "));

    System.out.println(result);
  }

  /**
   * 課題2: 数値のリストから奇数を抽出し、その平均値を出力する
   */
  public static void runTask2() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    OptionalDouble average = numbers.stream()
        .filter(v -> v % 2 == 1)
        .mapToInt(Integer::intValue)
        .average();

    if (average.isPresent()) {
      System.out.println("奇数の平均値: " + average.getAsDouble());
    } else {
      System.out.println("奇数が存在しません。");
    }
  }

  /**
   * 課題3: 生成AIで作成した従業員データに関するStream APIの活用課題
   */
  public static void runTask3() {
    List<Employee> employees = List.of(
        new Employee("佐藤", 25, "開発部", 400000),
        new Employee("鈴木", 30, "営業部", 450000),
        new Employee("高橋", 35, "開発部", 550000),
        new Employee("田中", 28, "人事部", 380000),
        new Employee("渡辺", 40, "営業部", 520000),
        new Employee("伊藤", 26, "開発部", 420000)
    );

    // 1. 開発部の社員の名前を出力
    System.out.print("開発部の社員: ");
    employees.stream()
        .filter(v -> "開発部".equals(v.getDepartment()))
        .map(Employee::getName)
        .forEach(name -> System.out.print(name + " "));
    System.out.println();

    // 2. 給与が50万以上の社員がいるかどうか
    boolean hasHighEarner = employees.stream()
        .anyMatch(v -> v.getSalary() >= 500000);
    System.out.println("給与50万円以上の社員がいるか: " + hasHighEarner);

    // 3. 営業部の総給与を計算
    int salesDepartmentSalarySum = employees.stream()
        .filter(v -> "営業部".equals(v.getDepartment()))
        .mapToInt(Employee::getSalary)
        .sum();
    System.out.println("営業部の総給与: " + salesDepartmentSalarySum);
  }
}
