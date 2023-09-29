package thread;

import javax.swing.*;

public class ThreadEx14 {
    public static void main(String[] args) throws Exception {
        ThreadEx14_1 t1 = new ThreadEx14_1();
        t1.start();
        
        String s = JOptionPane.showInputDialog("입력");
        System.out.println(s);
        t1.interrupt();
    }
}

class ThreadEx14_1 extends Thread {
    @Override
    public void run() {
        int i=10;

        while (i!=0 && !isInterrupted()) {
            System.out.println(i--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
        System.out.println("종료");
    }
}