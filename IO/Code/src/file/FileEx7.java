package file;

import java.io.File;
import java.io.FilenameFilter;

public class FileEx7 {
    public static void main(String[] args) throws Exception {
        if(args.length != 1) {
            System.out.println("usage: java FileEx7 pattern");
            System.exit(0);
        }

        String currDir = System.getProperty("user.dir");

        File dir = new File(currDir);
        final String pattern = args[0];

        String[] files = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.indexOf(pattern) != -1;
            }
        });

        for(int i=0; i< files.length; i++) {
            System.out.println(files[i]);
        }
    }
}
