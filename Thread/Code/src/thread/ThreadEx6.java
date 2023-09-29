package thread;

import javax.swing.*;

public class ThreadEx6 {

    public static void main(String[] args) throws Exception {
        String input = JOptionPane.showInputDialog("아무 값이나 입력");
        System.out.println("입력한 값: "+input);

        for(int i=10; i>0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }

}
