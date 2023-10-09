package charassiststream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {
    public static void main(String[] args) {
        String line = "";

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.println("OS enconding: "+isr.getEncoding());

            do {
                System.out.print("문장을 입력(q: 종료): ");
                line = br.readLine();
                System.out.println("입력한 문장: "+line);
            } while (!line.equalsIgnoreCase("q"));
            System.out.println("종료");
        } catch (IOException e) {

        }
    }
}
