package thread;

import javax.swing.*;

public class ThreadEx13 {
    public static void main(String[] args) throws Exception {
        ThreadEx13_1 t1 = new ThreadEx13_1();
        t1.start();
        
        String s = JOptionPane.showInputDialog("입력");
        System.out.println(s);
        t1.interrupt();
    }
}

class ThreadEx13_1 extends Thread {
    @Override
    public void run() {
        int i=10;

        while (i!=0 && !isInterrupted()) {
            System.out.println(i--);
            for(long x=0; x<2500000000L; x++);
        }
        System.out.println("종료");
    }
}