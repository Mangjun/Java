package file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class FileEx5 {
    public static void main(String[] args) {
        if(args.length != 1 || args[0].length() != 1 || "tTlLnN".indexOf(args[0]) == -1) {
            System.out.println("usage: java FileEx5 sort_option");
            System.out.println("sort option");
            System.out.println("t: Time asc");
            System.out.println("T: Time desc");
            System.out.println("l: Length asc");
            System.out.println("L: Length desc");
            System.out.println("n: Name asc");
            System.out.println("N: Name desc");
            System.exit(0);
        }

        final char option = args[0].charAt(0);

        String currDir = System.getProperty("user.dir");
        File dir = new File(currDir);
        File[] files = dir.listFiles();

        Comparator comp = new Comparator() {
            public int compare(Object o1, Object o2) {
                long time1 = ((File)o1).lastModified();
                long time2 = ((File)o2).lastModified();

                long len1 = ((File)o1).length();
                long len2 = ((File)o2).length();

                String name1 = ((File)o1).getName().toLowerCase();
                String name2 = ((File)o2).getName().toLowerCase();

                int result = 0;

                switch (option) {
                    case 't':
                        if(time1 - time2 > 0) result = 1;
                        else if(time1 - time2 == 0) result = 0;
                        else if(time1 - time2 < 0) result = -1;
                        break;
                    case 'T':
                        if(time1 - time2 > 0) result = -1;
                        else if(time1 - time2 == 0) result = 0;
                        else if(time1 - time2 < 0) result = 1;
                        break;
                    case 'l':
                        if(len1 - len2 > 0) result = 1;
                        else if(len1 - len2 == 0) result = 0;
                        else if(len1 - len2 < 0) result = -1;
                        break;
                    case 'L':
                        if(len1 - len2 > 0) result = -1;
                        else if(len1 - len2 == 0) result = 0;
                        else if(len1 - len2 < 0) result = 1;
                        break;
                    case 'n':
                        result = name1.compareTo(name2);
                        break;
                    case 'N':
                        result = name2.compareTo(name1);
                        break;
                }

                return result;
            }

            public boolean equals(Object o) {return false;}
        };

        Arrays.sort(files, comp);

        for(int i=0; i< files.length; i++) {
            File f = files[i];
            String name = f.getName();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String attribute = "";
            String size = "";

            if(files[i].isDirectory()) {
                attribute = "DIR";
            } else {
                size = f.length()+"";
                attribute = f.canRead() ? "R" : " ";
                attribute += f.canWrite() ? "W" : " ";
                attribute += f.isHidden() ? "H" : " ";
            }

            System.out.printf("%s %3s %6s %s\n", df.format(new Date(f.lastModified())), attribute, size, name);
        }
    }
}
