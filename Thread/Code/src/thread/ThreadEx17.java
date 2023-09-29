package thread;

public class ThreadEx17 {
    public static void main(String[] args) {
        ThreadEx17_1 t1 = new ThreadEx17_1("*");
        ThreadEx17_1 t2 = new ThreadEx17_1("**");
        ThreadEx17_1 t3 = new ThreadEx17_1("***");
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000);
            t1.suspend();
            Thread.sleep(2000);
            t2.suspend();
            Thread.sleep(2000);
            t1.resume();
            Thread.sleep(2000);
            t1.stop();
            t2.stop();
            Thread.sleep(2000);
            t3.stop();
        } catch (InterruptedException e) {}
    }
}

class ThreadEx17_1 implements Runnable {
    volatile boolean suspended = false;
    volatile boolean stopped = false;

    Thread t;

    public ThreadEx17_1(String name) {
        t = new Thread(this, name);
    }

    @Override
    public void run() {
        while (!stopped) {
            while (!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        }
        System.out.println(Thread.currentThread().getName()+"-종료");
    }

    public void suspend() {suspended=true;}
    public void resume() {suspended=false;}
    public void stop() {stopped=true;}
    public void start() {t.start();}
}