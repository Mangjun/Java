package stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        Student3[] student3s = {
                new Student3("가", 3, 300),
                new Student3("나", 1, 200),
                new Student3("다", 2, 100),
                new Student3("라", 2, 150),
                new Student3("마", 1, 200),
                new Student3("바", 3, 290),
                new Student3("사", 3, 180)
        };

        Stream<Student3> sStream = Stream.of(student3s);

        sStream.sorted(Comparator.comparing(Student3::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        sStream = Stream.of(student3s);
        IntStream sScoreStream = sStream.mapToInt(Student3::getTotalScore);

        IntSummaryStatistics stat = sScoreStream.summaryStatistics();

        System.out.println("count: "+stat.getCount());
        System.out.println("sum: "+stat.getSum());
        System.out.println("avg: "+stat.getAverage());
        System.out.println("min: "+stat.getMin());
        System.out.println("max: "+stat.getMax());
    }
}

class Student3 implements Comparable<Student3> {
    String name; // 학생 이름
    int ban; // 학생 반
    int totalScore; // 총 점수

    public Student3(String name, int ban, int totalScore) {
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
    public int compareTo(Student3 s) {
        return s.totalScore - this.totalScore;
    }
}
