package thread;

public class ThreadEx5 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx5_1 t1 = new ThreadEx5_1();
        t1.start();
        startTime = System.currentTimeMillis();

        for(int i=0; i<500; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.print("소요 시간1: "+(System.currentTimeMillis()-ThreadEx5.startTime));
    }

}

class ThreadEx5_1 extends Thread {

    @Override
    public void run() {
        for(int i=0; i<500; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.print("소요 시간2: "+(System.currentTimeMillis()-ThreadEx5.startTime));
    }
}