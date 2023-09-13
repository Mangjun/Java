package stackqueue;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {
    // Stack에 요소를 저장
    public Object push(Object item) {
        addElement(item);
        return item;
    }

    // 마지막 요소를 꺼내기
    public Object pop() {
        Object obj = peek();
        removeElement(size() - 1);
        return obj;
    }

    // 마지막 요소를 읽기
    public Object peek() {
        int len = size();

        if(len == 0) {
            throw new EmptyStackException();
        }

        return elementAt(len -1);
    }

    // Stack이 비어있는 지 확인
    public boolean empty() {
        return size() == 0;
    }

    // 객체를 찾아 index를 반환, 못 찾으면 -1을 반환
    public int search(Object o) {
        int i = lastIndexOf(o);

        if(i >= 0) {
            return size() - i;
        }

        return -1;
    }
}
