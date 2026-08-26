package org.example.basic.practice.practice99.task02;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

  private final List<Student> students = new ArrayList<>();

  public void addStudent(String name, int score) {
    Student student = new Student(name, score);
    students.add(student);
  }

  public void deleteStudent(String name) {
    students.removeIf(student -> student.getName().equals(name));
  }

  public void updateScore(String name, int score) {
    students.stream()
        .filter(student -> student.getName().equals(name))
        .findFirst()
        .ifPresent(student -> student.setScore(score));
  }

  public double calculateAverage() {
    return students.stream()
        .mapToInt(Student::getScore)
        .average()
        .orElse(0.0);
  }

  public List<Student> getStudents() {
    return List.copyOf(students);
  }
}
