package BufferedIORWTest;

import java.io.*;

public class TestBufferedInputStream {
    public static void main(String args[]) {
        FileInputStream fis;
        FileOutputStream fos;
        try {
            fis = new FileInputStream("src/BufferedIORWTest/TestBufferedInputStream.java");
            // 在FileInputStream节点流的外面套接一层处理流BufferedInputStream
            BufferedInputStream bis = new BufferedInputStream(fis);

            fos = new FileOutputStream("txt/TestBufferedInputStream");
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            int b;
            while( (b=bis.read())!=-1 ){
                bos.write(b);
            }
            bos.flush();

            fis = new FileInputStream("txt/TestBufferedInputStream");
            bis = new BufferedInputStream(fis);
            int c;
            System.out.println((char) bis.read());
            System.out.println((char) bis.read());
            bis.mark(100);// 在此处做一个标记
            for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
                System.out.print((char) c);
            }
            System.out.println();
            bis.reset();// 重新回到原来标记的地方
            for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
                System.out.print((char) c);
            }
            bis.close();
            fis.close();
            bos.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}