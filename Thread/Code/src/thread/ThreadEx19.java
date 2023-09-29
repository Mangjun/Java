package thread;

public class ThreadEx19 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx19_1 t1 = new ThreadEx19_1();
        ThreadEx19_1 t2 = new ThreadEx19_1();

        t1.start();
        t2.start();
        startTime = System.currentTimeMillis();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}

        System.out.println("소요 시간: "+(System.currentTimeMillis() - ThreadEx19.startTime));
    }
}

class ThreadEx19_1 extends Thread {
    @Override
    public void run() {
        for(int i=0; i<300; i++) {
            System.out.print("-");
        }
    }
}

class ThreadEx19_2 extends Thread {
    @Override
    public void run() {
        for(int i=0; i<300; i++) {
            System.out.print("|");
        }
    }
}