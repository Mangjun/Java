package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;

public class StreamEx8 {
    public static void main(String[] args) {
        Student8[] stuArr = {
                new Student8("가", true, 1, 1, 300),
                new Student8("나", false, 1, 1, 250),
                new Student8("다", true, 1, 1, 200),
                new Student8("라", false, 1, 2, 150),
                new Student8("마", true, 1, 2, 100),
                new Student8("바", false, 1, 2, 50),
                new Student8("사", false, 1, 3, 100),
                new Student8("아", false, 1, 3, 150),
                new Student8("자", true, 1, 3, 200),

                new Student8("기", true, 2, 1, 300),
                new Student8("니", false, 2, 1, 250),
                new Student8("디", true, 2, 1, 200),
                new Student8("리", false, 2, 2, 150),
                new Student8("미", true, 2, 2, 100),
                new Student8("비", false, 2, 2, 50),
                new Student8("시", false, 2, 3, 100),
                new Student8("이", false, 2, 3, 150),
                new Student8("지", true, 2, 3, 200),
        };

        System.out.printf("1. 단순 그룹화(반별로 그룹화)\n");
        Map<Integer, List<Student8>> stuByBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student8::getBan));

        for(List<Student8> ban : stuByBan.values()) {
            for(Student8 s: ban) {
                System.out.println(s);
            }
        }

        System.out.printf("\n2. 단순 그룹화(성적별로 그룹화)\n");
        Map<Student8.Level, List<Student8>> stuByLevel = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> {
                    if(s.getScore() >= 200)
                        return Student8.Level.HIGH;
                    else if(s.getScore() >= 100)
                        return Student8.Level.MID;
                    else
                        return Student8.Level.LOW;
                }));

        TreeSet<Student8.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for(Student8.Level key : keySet) {
            System.out.println("["+key+"]");

            for(Student8 s : stuByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.printf("\n3. 단순 그룹화 + 통계(성적별 학생수)\n");
        Map<Student8.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> {
                    if(s.getScore() >= 200)
                        return Student8.Level.HIGH;
                    else if(s.getScore() >= 100)
                        return Student8.Level.MID;
                    else
                        return Student8.Level.LOW;
                }, Collectors.counting()));
        for(Student8.Level key : stuCntByLevel.keySet()) {
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        }
        System.out.println();

        System.out.printf("\n4. 다중 그룹화(학년별, 반별)\n");
        Map<Integer, Map<Integer, List<Student8>>> stuByHakAndBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student8::getHak,
                        Collectors.groupingBy(Student8::getBan)));

        for(Map<Integer, List<Student8>> hak : stuByHakAndBan.values()) {
            for(List<Student8> ban : hak.values()) {
                System.out.println();
                for(Student8 s : ban) {
                    System.out.println(s);
                }
            }
        }

        System.out.printf("\n5. 다중 그룹화 + 통계(학년별, 반별 1등)\n");
        Map<Integer, Map<Integer, Student8>> topStuByHakAndBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student8::getHak,
                        Collectors.groupingBy(Student8::getBan,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(comparingInt(Student8::getScore)),
                                        Optional::get
                                ))));

        for(Map<Integer, Student8> ban : topStuByHakAndBan.values()) {
            for(Student8 s : ban.values()) {
                System.out.println(s);
            }
        }

        System.out.printf("\n6. 다중 그룹화 + 통계(학년별, 반별 성적 그룹)\n");
        Map<String, Set<Student8.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> s.getHak()+"-"+s.getBan(),
                        Collectors.mapping(s -> {
                            if (s.getScore() >= 200) return Student8.Level.HIGH;
                            else if (s.getScore() >= 100) return Student8.Level.MID;
                            else return Student8.Level.LOW;
                        }, Collectors.toSet())));

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for(String key : keySet2) {
            System.out.println("["+key+"]"+stuByScoreGroup.get(key));
        }
    }
}

class Student8 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public Student8(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
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
    
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }

    enum Level {HIGH, MID, LOW}
}