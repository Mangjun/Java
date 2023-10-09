package file;

import java.io.File;

public class FileEx8 {
    static int deleteFiles = 0;

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("usage: java FileEx8 extension");
            System.exit(0);
        }

        String currDir = System.getProperty("user.dir");

        File dir = new File(currDir);
        String ext = "."+args[0];

        delete(dir, ext);
        System.out.println(deleteFiles+"개의 파일 삭제");
    }

    public static void delete(File dir, String ext) {
        File[] files = dir.listFiles();

        for(int i=0; i<files.length; i++) {
            if(files[i].isDirectory()) {
                delete(files[i], ext);
            } else {
                String filename = files[i].getAbsolutePath();
                
                if(filename.endsWith(ext)) {
                    System.out.print(filename);
                    if(files[i].delete()) {
                        System.out.println(" 삭제 성공");
                        deleteFiles++;
                    } else {
                        System.out.println(" 삭제 실패");
                    }
                }
            }
        }
    }
}
