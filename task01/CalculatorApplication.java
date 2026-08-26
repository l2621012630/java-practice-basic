package org.example.basic.practice.practice99.task01;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CalculatorApplication {

  private final Scanner scanner;

  public CalculatorApplication() {
    this.scanner = new Scanner(System.in);
  }

  public void run() {
    try {
      int firstNumber = inputNumber("1番目の数字を入力してください: ");
      String operator = inputOperator();
      int secondNumber = inputNumber("2番目の数字を入力してください: ");

      double result = calculate(firstNumber, operator, secondNumber);

      System.out.printf("計算結果: %d %s %d = %.1f%n", firstNumber, operator, secondNumber, result);
    } catch (NoSuchElementException ex) {
      System.out.println("正しい値を入力してください。");
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }
  }

  private int inputNumber(String message) {
    System.out.print(message);
    return scanner.nextInt();
  }

  private String inputOperator() {
    System.out.print("演算子を入力してください (+, -, *, /): ");
    return scanner.next();
  }

  private double calculate(int firstNumber, String operator, int secondNumber) {
    return switch (operator) {
      case "+" -> firstNumber + secondNumber;
      case "-" -> firstNumber - secondNumber;
      case "*" -> firstNumber * secondNumber;
      case "/" -> (double) firstNumber / secondNumber;
      default -> throw new IllegalArgumentException("無効な演算子です。");
    };
  }
}
