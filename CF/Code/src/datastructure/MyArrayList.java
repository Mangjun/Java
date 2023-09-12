package datastructure;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList implements List {
    private Object[] data = null;
    private int capacity = 0; // 용량
    private int size = 0; // 크기

    // 초기 용량을 설정을 안 하면 8
    public MyArrayList() {
        this.capacity = 8;
        data = new Object[this.capacity];
    }

    // 배열의 초기 용량을 설정
    public MyArrayList(int initcapacity) {
        capacity = initcapacity;
        data = new Object[capacity];
    }

    public int getCapacity() {
        return this.capacity;
    }

    // 배열이 꽉 찼을 때 배열의 용량을 2배로 늘림
    public void doubling() {
        this.capacity = this.capacity * 2;
        Object[] newData = new Object[this.capacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 저장된 데이터의 개수를 반환
    @Override
    public int size() {
        return size;
    }

    // 배열이 비어있는지 확인
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 데이터가 포함되어 있는지 확인
    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size; i++) {
            if(o.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    // 배열로 반환
    @Override
    public Object[] toArray() {
        Object[] newData = new Object[this.size];

        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        return newData;
    }

    // 마지막에 데이터를 추가
    @Override
    public boolean add(Object o) {
        if(this.size == this.capacity) {
            doubling();
        }
        data[size++] = o;
        return true;
    }

    // 데이터를 삭제
    @Override
    public boolean remove(Object o) {
        for(int i = 0; i < this.size; i++) {
            if(o.equals(data[i])) {
                data[i] = null;
                for(int j = i; j < this.size(); j++) {
                    Object tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
                this.size--;
                return true;
            }
        }
        return false;
    }

    // Collection에 있는 데이터를 모두 추가
    @Override
    public boolean addAll(Collection c) {
        Object[] tmp = c.toArray();
        int index = 0;

        if(this.size + c.size() > capacity) {
            doubling();
        }

        for(int i = this.size; i < this.size + c.size(); i++) {
            data[i] = tmp[index++];
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator c) {
        List.super.sort(c);
    }

    // 모든 데이터 삭제
    @Override
    public void clear() {
        for(int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    // 데이터 읽기
    @Override
    public Object get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("유효하지 않는 값입니다." + index);
        }
        return data[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    // 처음 위치부터 데이터를 찾아 index를 반환
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if(o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // 마지막 위치부터 데이터를 찾아 index를 반환
    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i > 0; i--) {
            if(o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator spliterator() {
        return List.super.spliterator();
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
