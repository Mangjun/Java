package thread;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx11 {
    public static void main(String[] args) {
        ThreadEx11_1 t1 = new ThreadEx11_1("t1");
        ThreadEx11_2 t2 = new ThreadEx11_2("t2");
        t1.start();
        t2.start();
    }
}

class ThreadEx11_1 extends Thread {
    ThreadEx11_1(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            sleep(5 * 1000);
        } catch (InterruptedException e) {}
    }
}

class ThreadEx11_2 extends Thread {
    ThreadEx11_2(String name) {
        super(name);
    }

    @Override
    public void run() {
        Map map = getAllStackTraces();
        Iterator it = map.keySet().iterator();

        int x=0;
        while (it.hasNext()) {
            Object obj = it.next();
            Thread t = (Thread) obj;
            StackTraceElement[] ste = (StackTraceElement[]) (map.get(obj));
            System.out.println(++x + t.getName() + t.getThreadGroup().getName() + t.isDaemon());
            for(int i=0; i<ste.length; i++) {
                System.out.println(ste[i]);
            }
            System.out.println();
        }
    }
}