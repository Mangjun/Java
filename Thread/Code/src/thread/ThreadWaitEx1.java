package thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaitEx1 {
    public static void main(String[] args) throws Exception {
        Table table = new Table();

        new Thread(new Cook(table), "cook1").start();
        new Thread(new Customer(table, "donut"), "cust1").start();
        new Thread(new Customer(table, "burger"), "cust2").start();

        Thread.sleep(2000);
        System.exit(0);
    }
}

class Customer implements Runnable {
    private Table table;
    private String food;

    public Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " eat " + food);
        }
    }

}

class Cook implements Runnable {
    private Table table;

    public Cook(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }
}

class Table {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;

    private ArrayList<String> dishes = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCust = lock.newCondition();

    public void add(String dish) {
        lock.lock();

        try {
            while(dishes.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name +" wait");
                try {
                    forCook.await();
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
            dishes.add(dish);
            forCook.signal();
            System.out.println("dish: "+dishes.toString());
        } finally {
            lock.unlock();
        }
    }

    public void remove(String dishName) {
        lock.lock();
        String name = Thread.currentThread().getName();

        try {
            while (dishes.size() == 0) {
                System.out.println(name+" wait");
                try {
                    forCust.await();
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }

            while (true) {
                for(int i=0; i<dishes.size(); i++) {
                    if(dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        forCook.signal();
                        return;
                    }
                }

                try {
                    System.out.println(name +" wait");
                    forCust.await();
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        } finally {
            lock.unlock();
        }

    }

    public int dishNum() {return dishNames.length;}
}