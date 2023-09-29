package thread;

public class ThreadEx18 {
    public static void main(String[] args) {
        ThreadEx18_1 t1 = new ThreadEx18_1("*");
        ThreadEx18_1 t2 = new ThreadEx18_1("**");
        ThreadEx18_1 t3 = new ThreadEx18_1("***");
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000);
            t1.suspend();
            Thread.sleep(2000);
            t2.suspend();
            Thread.sleep(3000);
            t1.resume();
            Thread.sleep(3000);
            t1.stop();
            t2.stop();
            Thread.sleep(2000);
            t3.stop();
        } catch (InterruptedException e) {}
    }
}

class ThreadEx18_1 implements Runnable {
    volatile boolean suspended = false;
    volatile boolean stopped = false;

    Thread t;

    public ThreadEx18_1(String name) {
        t = new Thread(this, name);
    }

    @Override
    public void run() {
        String name = t.getName();

        while (!stopped) {
            if (!suspended) {
                System.out.println(name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(name + " interrupt");
                }
            } else {
                Thread.yield();
            }
        }
        System.out.println(name + " stop");
    }

    public void suspend() {
        suspended = true;
        t.interrupt();
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        stopped = true;
        t.interrupt();
    }

    public void start() {
        t.start();
    }
}