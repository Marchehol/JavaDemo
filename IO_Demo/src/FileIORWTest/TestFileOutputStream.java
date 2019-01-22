package FileIORWTest;

import java.io.*;

public class TestFileOutputStream {
    public static void main(String args[]) {
        int b;
        FileInputStream in;
        FileOutputStream out;
        try {
            in = new FileInputStream("src/FileIORWTest/TestFileOutputStream.java");
            out = new FileOutputStream("txt/copy.txt");
            // 指明要写入数据的文件，如果指定的路径中不存在copy.txt这样的文件，则系统会自动创建一个
            while ((b = in.read()) != -1) {
                out.write(b);
                // 调用write(int c)方法把读取到的字符全部写入到指定文件中去
            }

            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件读取失败");
            System.exit(-1);// 非正常退出
        } catch (IOException e1) {
            System.out.println("文件复制失败！");
            System.exit(-1);
        }
        System.out
                .println("TestFileOutputStream.java文件里面的内容已经成功复制到文件copy.txt里面");
    }
}