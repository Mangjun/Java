package stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student1> student1Stream = Stream.of(
                new Student1("가", 3, 300),
                new Student1("나", 1, 200),
                new Student1("다", 2, 100),
                new Student1("라", 2, 150),
                new Student1("마", 1, 200),
                new Student1("바", 3, 290),
                new Student1("사", 3, 180)
        );

        student1Stream.sorted(Comparator.comparing(Student1::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

    }
}

class Student1 implements Comparable<Student1> {
    String name; // 학생 이름
    int ban; // 학생 반
    int totalScore; // 총 점수

    public Student1(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public int compareTo(Student1 s) {
        return s.totalScore - this.totalScore;
    }
}