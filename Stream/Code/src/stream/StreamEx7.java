package stream;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;


public class StreamEx7 {
    public static void main(String[] args) {
        Student7[] stuArr = {
                new Student7("가", true, 1, 1, 300),
                new Student7("나", false, 1, 1, 250),
                new Student7("다", true, 1, 1, 200),
                new Student7("라", false, 1, 2, 150),
                new Student7("마", true, 1, 2, 100),
                new Student7("바", false, 1, 2, 50),
                new Student7("사", false, 1, 3, 100),
                new Student7("아", false, 1, 3, 150),
                new Student7("자", true, 1, 3, 200),
                
                new Student7("기", true, 2, 1, 300),
                new Student7("니", false, 2, 1, 250),
                new Student7("디", true, 2, 1, 200),
                new Student7("리", false, 2, 2, 150),
                new Student7("미", true, 2, 2, 100),
                new Student7("비", false, 2, 2, 50),
                new Student7("시", false, 2, 3, 100),
                new Student7("이", false, 2, 3, 150),
                new Student7("지", true, 2, 3, 200),
        };

        System.out.printf("1. 단순 분할(성별로 분할)\n");
        Map<Boolean, List<Student7>> stuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student7::isMale));

        List<Student7> maleStudent = stuBySex.get(true);
        List<Student7> femaleStudent = stuBySex.get(false);

        for(Student7 s : maleStudent) {
            System.out.println(s);
        }

        for(Student7 s : femaleStudent) {
            System.out.println(s);
        }

        System.out.printf("\n2. 단순 분할 + 통계(성별 학생수)\n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student7::isMale, counting()));

        System.out.println("남학생 수: "+stuNumBySex.get(true));
        System.out.println("여학생 수: "+stuNumBySex.get(false));

        System.out.printf("\n3. 단순 분할 + 통계(성별 1등)\n");
        Map<Boolean, Optional<Student7>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student7::isMale, maxBy(Comparator.comparingInt(Student7::getScore))));
        System.out.println("남학생 1등: "+topScoreBySex.get(true));
        System.out.println("여학생 1등: "+topScoreBySex.get(false));

        Map<Boolean, Student7> toScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(Student7::isMale,
                        collectingAndThen(maxBy(Comparator.comparingInt(Student7::getScore)), Optional::get)));
        System.out.println("남학생 1등: "+toScoreBySex2.get(true));
        System.out.println("여학생 1등: "+toScoreBySex2.get(false));

        System.out.printf("\n4. 다중 분할(성격 불합격자, 100점 이하)\n");

        Map<Boolean, Map<Boolean, List<Student7>>> failedStuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student7::isMale,
                        partitioningBy(s -> s.getScore()<=100)));
        List<Student7> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student7> failedFemaleStu = failedStuBySex.get(false).get(false);

        for(Student7 s : failedMaleStu) {
            System.out.println(s);
        }

        for(Student7 s : failedFemaleStu) {
            System.out.println(s);
        }
    }
}

class Student7 {
    String name; // 이름
    boolean isMale; // 성별
    int hak; // 학년
    int ban; // 반
    int score; // 점수

    public Student7(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    enum Level {HIGH, MID, LOW}
}