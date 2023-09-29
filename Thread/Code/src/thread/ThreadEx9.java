package thread;

public class ThreadEx9 {
    public static void main(String[] args) throws Exception {
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup g1 = new ThreadGroup("g1");
        ThreadGroup g2 = new ThreadGroup("g2");

        ThreadGroup sg1 = new ThreadGroup(g1, "sg1");
        g1.setMaxPriority(3);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        };

        new Thread(g1, r, "t1").start();
        new Thread(sg1, r, "t2").start();
        new Thread(g2, r, "t2").start();

        System.out.println(main.getName()+" "+main.activeGroupCount()+" "+main.activeCount());

        main.list();
    }
}
