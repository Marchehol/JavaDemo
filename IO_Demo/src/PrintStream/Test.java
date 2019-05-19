package PrintStream;

import java.io.PrintStream;

public class Test {
    public static void main(String[] args) throws Exception {

        byte []b1 = {0x61, 0x62, 0x63, 0x64, 0x65};   //a,b,c,d,e
        byte []b2 = {0x41, 0x42, 0x43, 0x44, 0x45};   //A,B,C,D,E

        PrintStream ps = new PrintStream("txt/file.txt");

        //public void write(byte b[])
        ps.write(b1);
        ps.write(b2);
        //public void write(int b)
        ps.write(0x66);
        ps.write(0x46);
        //此时test.txt内容：abcdeABCDEfF

        //public void print(int i)
        ps.print(0x61);         //等价于 ps.write(String.valueOf(0x61)); 写入字符串“97"
        ps.println(0x41);       //等价于 ps.write(String.valueOf(0x41));newLine(); 写入字符串“65”
        /*  此时test.txt内容：
            abcdeABCDEfF9765
        */

        //public void print(char c)
        ps.print('B');          //等价于 ps.write(String.valueOf('B')); 写入字符‘B’
        ps.println('b');        //等价于 ps.write(String.valueOf('b'));newLine(); 写入字符‘b’
        /*  此时test.txt内容：
            abcdeABCDEfF9765
            Bb
        */

        //public void print(double d)
        ps.print(2.12);        //等价于 ps.write(String.valueOf(2.12)); 写入字符串“2.12”
        ps.println(4.24);      //等价于 ps.write(String.valueOf(4.24));newLine(); 写入字符串“4.24”
        /*  此时test.txt内容：
            abcdeABCDEfF9765
            Bb
            2.124.24
        */
        ps.close();

    }
}

