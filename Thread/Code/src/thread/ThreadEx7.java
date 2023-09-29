package thread;

import javax.swing.*;

public class ThreadEx7 {

    public static void main(String[] args) throws Exception {
        ThreadEx7_1 t1 = new ThreadEx7_1();
        t1.start();

        String input = JOptionPane.showInputDialog("입력");
        System.out.println("입력: "+input);
    }

}

class ThreadEx7_1 extends Thread {

    @Override
    public void run() {
        for(int i=10; i>0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (Exception e) {}
        }
    }
}