package file;

import java.io.File;
import java.io.IOException;

public class FileEx1 {
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\Git_Repository\\Java\\IO\\Code\\src\\file\\FileEx1.java");
        String fileName = f.getName();
        int pos = fileName.lastIndexOf(".");

        System.out.println("경로 제외 파일 이름: "+fileName);
        System.out.println("확장자 제외 파일 이름: "+fileName.substring(0, pos));
        System.out.println("확장자: "+fileName.substring(pos+1));
        System.out.println("경로 포함 파일 이름: "+f.getPath());
        System.out.println("절대 경로: "+f.getAbsolutePath());
        System.out.println("정규 경로: "+f.getCanonicalPath());
        System.out.println("파일이 속해 있는 디렉터리: "+f.getParent());
        System.out.println();
        System.out.println("경로 구분자: "+File.separator);
        System.out.println("경로 구분자: "+File.separatorChar);
        System.out.println();
        System.out.println("user.dir: "+System.getProperty("user.dir"));
        System.out.println("sun.boot.class.path: "+System.getProperty("sun.boot.class.path"));
    }
}
