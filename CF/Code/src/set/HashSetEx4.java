package set;

import java.util.HashSet;
import java.util.Objects;

/**
 * 왜 논리적 오류가 날까?
 * hashCode()와 equals를 적절하게 오버라이딩을 했는데
 * 모르겠다
 */

public class HashSetEx4 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add(new String("abc"));
        set.add(new String("abc"));
        set.add(new Person2("David", 10));
        set.add(new Person2("David", 10));

        System.out.println(set);
    }
}

class Person2 {
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj) {
        if(obj instanceof Person2) {
            Person2 tmp = (Person2)obj;
            return name.equals(tmp.name) && age == tmp.age;
        }

        return false;
    }


    public int hasCode() {
        return Objects.hash(name, age);
    }

    public String toString() {
        return name + ":" + age;
    }
}