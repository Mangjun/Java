package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class CollectionsEx {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list);

        Collections.addAll(list, 1,2,3,4,5);
        System.out.println(list);

        Collections.rotate(list, 2); // 오른쪽으로 2칸씩 이동
        System.out.println(list);
        
        Collections.swap(list, 0, 2); // 바꾸기
        System.out.println(list);

        Collections.shuffle(list); // 섞기
        System.out.println(list);
        
        Collections.sort(list); // 정렬
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        int index = Collections.binarySearch(list, 3);
        System.out.println("index of 3: "+index);

        System.out.println("max: "+Collections.max(list));
        System.out.println("min: "+Collections.min(list));
        System.out.println("min: "+Collections.max(list, Collections.reverseOrder()));

        Collections.fill(list, 9);
        System.out.println("list: "+list);

        List newList = Collections.nCopies(list.size(), 2); // 같은 크기의 새로운 list를 생성하고 2로 채움, 결과는 변경불가
        System.out.println("newList: "+newList);

        System.out.println(Collections.disjoint(list, newList)); // 공통 요소가 없으면 true

        Collections.copy(list, newList);
        System.out.println("newList: "+newList);
        System.out.println("List: "+list);

        Collections.replaceAll(list, 2, 1);
        System.out.println("list: "+list);

        Enumeration e = Collections.enumeration(list);
        ArrayList list2 = Collections.list(e);

        System.out.println("list2: "+list2);
    }
}
