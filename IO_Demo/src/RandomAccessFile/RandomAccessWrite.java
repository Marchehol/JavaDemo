package RandomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessWrite {
 
    public static void main(String[] args) {
        String file = "txt/file.txt";
        RandomAccessFile raf = null;
        try {
            String[] arrays = new String[] { "Hello Hadoop", "Hello Spark", "Hello Hive" };
            raf = new RandomAccessFile(file, "rw");
            raf.seek(raf.length());
            raf.write("\n追加内容:\n".getBytes());
            for (String arr : arrays) {
                raf.write((arr + "\n").getBytes());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
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