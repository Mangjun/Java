package file;

import java.io.File;

public class FileEx9 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("usage: java FileEx9 directory");
            System.exit(0);
        }

        File dir = new File(args[0]);
        
        if(!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉터리");
            System.exit(0);
        }

        File[] list = dir.listFiles();

        for(int i=0; i< list.length; i++) {
            String fileName = list[i].getName();
            String newFileName = "0000"+fileName;
            newFileName = newFileName.substring(newFileName.length() - 7);
            list[i].renameTo(new File(dir, newFileName));
        }
    }
}
