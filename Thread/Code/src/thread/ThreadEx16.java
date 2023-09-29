package thread;

public class ThreadEx16 {
    public static void main(String[] args) {
        RunImplEx16 r1 = new RunImplEx16();
        RunImplEx16 r2 = new RunImplEx16();
        RunImplEx16 r3 = new RunImplEx16();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000);
            r1.suspend();
            Thread.sleep(2000);
            r2.suspend();
            Thread.sleep(3000);
            r1.resume();
            Thread.sleep(3000);
            r1.stop();
            r2.stop();
            Thread.sleep(2000);
            r3.stop();
        } catch (InterruptedException e) {}
    }
}

class RunImplEx16 implements Runnable {
    volatile boolean suspended = false;
    volatile boolean stopped = false;

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
        System.out.println(Thread.currentThread().getName()+"- 종료");
    }

    public void suspend() {suspended = true;}
    public void resume() {suspended = false;}
    public void stop() {stopped = true;}
}