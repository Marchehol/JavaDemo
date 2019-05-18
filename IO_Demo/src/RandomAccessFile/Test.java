package RandomAccessFile;

import java.io.File;
import java.io.RandomAccessFile;

public class Test {
    public static void main(String[] args) throws Exception {

        long len;
        File file = new File("src/file.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        byte b[] = {0x61, 0x62, 0x63, 0x64, 0x65};
        raf.write(b);
        len = raf.length();
        System.out.println(len);

        char c = 'F';
        raf.writeChar(c);
        len = raf.length();
        System.out.println(len);

        int d = 103;
        raf.write(d);

        String str = "hijkl";
        raf.writeChars(str);

        len = raf.length();
        raf.writeBoolean(true);

        raf.seek(0);

        byte b1[] = new byte[1024];
        raf.read(b1, 0, (int)len-1);
        System.out.println(new String(b1));
        raf.seek(len-1);
        boolean boo = raf.readBoolean();
        System.out.println(boo);

    }
}

