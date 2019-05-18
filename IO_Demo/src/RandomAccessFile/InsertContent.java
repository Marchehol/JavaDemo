package RandomAccessFile;

import java.io.*;

public class InsertContent {
 
    public static void main(String[] args) {
        String file = "txt/file.txt";
        String str = "Hello World!";

        FileInputStream fis = null;
        FileOutputStream fos = null;
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            File tmp = File.createTempFile("tmp", null);
            tmp.deleteOnExit();
            fis = new FileInputStream(tmp);
            fos = new FileOutputStream(tmp);
            raf.seek(0);
            byte[] bbuf = new byte[64];
            int hasRead;
            while ((hasRead = raf.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);
            }
            raf.seek(raf.length());
            raf.write("\n插入内容:\n".getBytes());
            raf.write((str + "\n").getBytes());
            while ((hasRead = fis.read(bbuf)) > 0) {
                raf.write(bbuf, 0, hasRead);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
 
}