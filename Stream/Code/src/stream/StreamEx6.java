package stream;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class StreamEx6 {
    public static void main(String[] args) {
        Student6[] stuArr = {
                new Student6("가", 3, 300),
                new Student6("나", 1, 200),
                new Student6("다", 2, 100),
                new Student6("라", 2, 150),
                new Student6("마", 1, 200),
                new Student6("바", 3, 290),
                new Student6("사", 3, 180),
        };

        List<String> names = Stream.of(stuArr)
                .map(Student6::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        Student6[] stuArr2 = Stream.of(stuArr).toArray(Student6[]::new);

        for(Student6 s : stuArr2) {
            System.out.println(s);
        }

        Map<String, Student6> stuMap = Stream.of(stuArr)
                .collect(Collectors.toMap(s -> s.getName(), p -> p));

        for(String name : stuMap.keySet()) {
            System.out.println(name+"-"+stuMap.get(name));
        }

        long count = Stream.of(stuArr).collect(counting());
        long totalScore = Stream.of(stuArr)
                .collect(summingInt(Student6::getTotalScore));
        System.out.println("count: "+count);
        System.out.println("totalScore: "+totalScore);

        totalScore = Stream.of(stuArr)
                .collect(reducing(0, Student6::getTotalScore, Integer::sum));
        System.out.println("totalScore: "+totalScore);

        Optional<Student6> topStudent = Stream.of(stuArr)
                .collect(maxBy(Comparator.comparingInt(Student6::getTotalScore)));
        System.out.println("topStudent: "+topStudent);

        IntSummaryStatistics stat = Stream.of(stuArr)
                .collect(summarizingInt(Student6::getTotalScore));
        System.out.println(stat);

        String stuNames = Stream.of(stuArr)
                .map(Student6::getName)
                .collect(joining(",", "{", "}"));
        System.out.println(stuNames);
    }
}

class Student6 implements Comparable<Student6> {
    String name; // 학생 이름
    int ban; // 학생 반
    int totalScore; // 총 점수

    public Student6(String name, int ban, int totalScore) {
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
    public int compareTo(Student6 s) {
        return s.totalScore - this.totalScore;
    }
}