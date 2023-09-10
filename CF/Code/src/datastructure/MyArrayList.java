package datastructure;

import java.util.Arrays;
import java.util.Collection;

/**
 * 간단하게 ArrayList를 구현해보기
 */
public class MyArrayList {
    private Object[] data = null; // 객체를 저장할 객체 배열
    private int capacity = 0; // 용량
    private int size = 0; // 크기

    // 용량이 0인 MyArrayList를 생성하는 기본 생성자
    public MyArrayList() {
        data = new Object[0];
    }

    // 주어진 Collection이 저장된 MyArrayList를 생성하는 생성자
    public MyArrayList(Collection c) {
        data = Arrays.copyOf(c.toArray(), c.size());
        setCapacity(c.size());
        setSize(c.size());
    }

    // 지정된 용량을 갖는 MyArrayList를 생성하는 생성자
    public MyArrayList(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("유효하지 않는 값입니다. :" + capacity);
        }
        setCapacity(capacity);
        data = new Object[this.capacity];
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // 마지막에 객체를 추가하는 메서드
    public boolean add(Object o) {
        if(capacity == size) {
            setCapacity(capacity++);
            setSize(size++);
            Object[] tmp = Arrays.copyOf(data, capacity);
            data = tmp;
            data[size] = o;
        } else {
            setSize(size++);
            data[size] = o;
        }
        return true;
    }
    
    // 지정된 위치에 객체를 추가하는 메서드
    public boolean add(int index, Object o) {
        if(capacity == size) {
            setCapacity(capacity++);
            setSize(size++);
            Object[] tmp = Arrays.copyOf(data, capacity);
            data = tmp;
            for(int i = capacity; i > index; i--) {
                Object temp = data[i];
                data[i] = data[i-1];
                data[i-1] = temp;
            }
            data[index] = o;
        } else {
            setSize(size++);
            for(int i = capacity; i > index; i--) {
                Object temp = data[i];
                data[i] = data[i-1];
                data[i-1] = temp;
            }
            data[index] = o;
        }
        return true;
    }

    // 지정된 객체를 삭제하는 메서드
    public boolean remove(Object o) {

        return true;
    }

    // 크기를 반환하는 메서드
    public int size() {
        return this.size;
    }
    
    // 객체를 반환하는 메서드
    public Object get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }
        return data[index];
    }
    
    // MyArrayList를 비우는 메서드
    public void clear() {
        
    }
    
    // MyArrayList를 복제하는 메서드
    public Object clone() {
        Object[] tmp;
        tmp = Arrays.copyOf(data, data.length);
        return tmp;
    }
}