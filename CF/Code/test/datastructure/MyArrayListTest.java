package datastructure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void doubling() {
        MyArrayList mal = new MyArrayList(5);
        mal.doubling();
        assertEquals(mal.getCapacity(), 10);
    }

    @Test
    void size() {
        MyArrayList mal = new MyArrayList();
        assertEquals(mal.size(), 0);
        mal.add(1);
        mal.add(2);
        assertEquals(mal.size(), 2);
    }

    @Test
    void isEmpty() {
        MyArrayList mal = new MyArrayList();
        assertEquals(mal.isEmpty(), true);
        mal.add(1);
        mal.add(2);
        assertEquals(mal.isEmpty(), false);
    }

    @Test
    void contains() {
        MyArrayList mal = new MyArrayList();
        mal.add(1);
        mal.add(2);
        assertEquals(mal.contains(1), true);
        assertEquals(mal.contains(3), false);
    }

    @Test
    void iterator() {
    }

    @Test
    void toArray() {
        MyArrayList mal = new MyArrayList();
        Object[] data = {1, 2};
        mal.add(1);
        mal.add(2);
        assertEquals(Arrays.toString(mal.toArray()), Arrays.toString(data));
    }

    @Test
    void add() {
        MyArrayList mal = new MyArrayList();
        mal.add(1);
        assertEquals(mal.size(), 1);
        assertEquals(mal.get(0), 1);
    }

    @Test
    void remove() {
    }

    @Test
    void addAll() {
    }

    @Test
    void testAddAll() {
    }

    @Test
    void replaceAll() {
    }

    @Test
    void sort() {
    }

    @Test
    void clear() {
        MyArrayList mal = new MyArrayList(5);
        mal.add("1");
        mal.clear();
        assertEquals(mal.get(0), null);
        assertEquals(mal.size(), 0);
    }

    @Test
    void get() {
        MyArrayList mal = new MyArrayList();
        mal.add(1);
        assertEquals(mal.get(0), 1);
    }

    @Test
    void set() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void listIterator() {
    }

    @Test
    void testListIterator() {
    }

    @Test
    void subList() {
    }

    @Test
    void spliterator() {
    }

    @Test
    void retainAll() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void containsAll() {
    }

    @Test
    void testToArray() {
    }
}