package StringBuffer; 
import java.util.HashMap;
/**
 * StringBuffer 演示程序
 *
 * @author skywang
 */
public class StringBufferTest {

    public static void main(String[] args) {
        testInsertAPIs() ;
        testAppendAPIs() ;
        testReplaceAPIs() ;
        testDeleteAPIs() ;
        testIndexAPIs() ;
        testOtherAPIs() ;
    }

    /**
     * StringBuffer 的其它API示例
     */
    private static void testOtherAPIs() {

        System.out.println("-------------------------------- testOtherAPIs --------------------------------");

        StringBuffer sbuffer = new StringBuffer("0123456789");

        int cap = sbuffer.capacity();
        System.out.printf("cap=%d\n", cap);

        char c = sbuffer.charAt(6);
        System.out.printf("c=%c\n", c);

        char[] carr = new char[4];
        sbuffer.getChars(3, 7, carr, 0);
        for (int i=0; i<carr.length; i++)
            System.out.printf("carr[%d]=%c ", i, carr[i]);
        System.out.println();

        System.out.println();
    }

    /**
     * StringBuffer 中index相关API演示
     */
    private static void testIndexAPIs() {
        System.out.println("-------------------------------- testIndexAPIs --------------------------------");

        StringBuffer sbuffer = new StringBuffer("abcAbcABCabCaBcAbCaBCabc");
        System.out.printf("sbuffer=%s\n", sbuffer);

        // 1. 从前往后，找出"bc"第一次出现的位置
        System.out.printf("%-30s = %d\n", "sbuffer.indexOf(\"bc\")", sbuffer.indexOf("bc"));

        // 2. 从位置5开始，从前往后，找出"bc"第一次出现的位置
        System.out.printf("%-30s = %d\n", "sbuffer.indexOf(\"bc\", 5)", sbuffer.indexOf("bc", 5));

        // 3. 从后往前，找出"bc"第一次出现的位置
        System.out.printf("%-30s = %d\n", "sbuffer.lastIndexOf(\"bc\")", sbuffer.lastIndexOf("bc"));

        // 4. 从位置4开始，从后往前，找出"bc"第一次出现的位置
        System.out.printf("%-30s = %d\n", "sbuffer.lastIndexOf(\"bc\", 4)", sbuffer.lastIndexOf("bc", 4));

        System.out.println();
    }

    /**
     * StringBuffer 的replace()示例
     */
    private static void testReplaceAPIs() {

        System.out.println("-------------------------------- testReplaceAPIs ------------------------------");

        StringBuffer sbuffer;

        sbuffer = new StringBuffer("0123456789");
        sbuffer.replace(0, 3, "ABCDE");
        System.out.printf("sbuffer=%s\n", sbuffer);

        sbuffer = new StringBuffer("0123456789");
        sbuffer.reverse();
        System.out.printf("sbuffer=%s\n", sbuffer);

        sbuffer = new StringBuffer("0123456789");
        sbuffer.setCharAt(0, 'M');
        System.out.printf("sbuffer=%s\n", sbuffer);

        System.out.println();
    }

    /**
     * StringBuffer 的delete()示例
     */
    private static void testDeleteAPIs() {

        System.out.println("-------------------------------- testDeleteAPIs -------------------------------");

        StringBuffer sbuffer = new StringBuffer("0123456789");
        
        // 删除位置0的字符，剩余字符是“123456789”。
        sbuffer.deleteCharAt(0);
        // 删除位置3(包括)到位置6(不包括)之间的字符，剩余字符是“123789”。
        sbuffer.delete(3,6);

        // 获取sb中从位置1开始的字符串
        String str1 = sbuffer.substring(1);
        // 获取sb中从位置3(包括)到位置5(不包括)之间的字符串
        String str2 = sbuffer.substring(3, 5);
        // 获取sb中从位置3(包括)到位置5(不包括)之间的字符串，获取的对象是CharSequence对象，此处转型为String
        String str3 = (String)sbuffer.subSequence(3, 5);

        System.out.printf("sbuffer=%s\nstr1=%s\nstr2=%s\nstr3=%s\n", 
                sbuffer, str1, str2, str3);

        System.out.println();
    }

    /**
     * StringBuffer 的insert()示例
     */
    private static void testInsertAPIs() {

        System.out.println("-------------------------------- testInsertAPIs -------------------------------");

        StringBuffer sbuffer = new StringBuffer();

        // 在位置0处插入字符数组
        sbuffer.insert(0, new char[]{'a','b','c','d','e'});
        // 在位置0处插入字符数组。0表示字符数组起始位置，3表示长度
        sbuffer.insert(0, new char[]{'A','B','C','D','E'}, 0, 3);
        // 在位置0处插入float
        sbuffer.insert(0, 1.414f);
        // 在位置0处插入double
        sbuffer.insert(0, 3.14159d);
        // 在位置0处插入boolean
        sbuffer.insert(0, true);
        // 在位置0处插入char
        sbuffer.insert(0, '\n');
        // 在位置0处插入int
        sbuffer.insert(0, 100);
        // 在位置0处插入long
        sbuffer.insert(0, 12345L);
        // 在位置0处插入StringBuilder对象
        sbuffer.insert(0, new StringBuffer("StringBuilder"));
        // 在位置0处插入StringBuilder对象。6表示被在位置0处插入对象的起始位置(包括)，13是结束位置(不包括)
        sbuffer.insert(0, new StringBuffer("STRINGBUILDER"), 6, 13);
        // 在位置0处插入StringBuffer对象。
        sbuffer.insert(0, new StringBuffer("StringBuffer"));
        // 在位置0处插入StringBuffer对象。6表示被在位置0处插入对象的起始位置(包括)，12是结束位置(不包括)
        sbuffer.insert(0, new StringBuffer("STRINGBUFFER"), 6, 12);
        // 在位置0处插入String对象。
        sbuffer.insert(0, "String");
        // 在位置0处插入String对象。1表示被在位置0处插入对象的起始位置(包括)，6是结束位置(不包括)
        sbuffer.insert(0, "0123456789", 1, 6);
        sbuffer.insert(0, '\n');

        // 在位置0处插入Object对象。此处以HashMap为例
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        sbuffer.insert(0, map);

        System.out.printf("%s\n\n", sbuffer);
    }

    /**
     * StringBuffer 的append()示例
     */
    private static void testAppendAPIs() {

        System.out.println("-------------------------------- testAppendAPIs -------------------------------");

        StringBuffer sbuffer = new StringBuffer();

        // 追加字符数组
        sbuffer.append(new char[]{'a','b','c','d','e'});
        // 追加字符数组。0表示字符数组起始位置，3表示长度
        sbuffer.append(new char[]{'A','B','C','D','E'}, 0, 3);
        // 追加float
        sbuffer.append(1.414f);
        // 追加double
        sbuffer.append(3.14159d);
        // 追加boolean
        sbuffer.append(true);
        // 追加char
        sbuffer.append('\n');
        // 追加int
        sbuffer.append(100);
        // 追加long
        sbuffer.append(12345L);
        // 追加StringBuilder对象
        sbuffer.append(new StringBuffer("StringBuilder"));
        // 追加StringBuilder对象。6表示被追加对象的起始位置(包括)，13是结束位置(不包括)
        sbuffer.append(new StringBuffer("STRINGBUILDER"), 6, 13);
        // 追加StringBuffer对象。
        sbuffer.append(new StringBuffer("StringBuffer"));
        // 追加StringBuffer对象。6表示被追加对象的起始位置(包括)，12是结束位置(不包括)
        sbuffer.append(new StringBuffer("STRINGBUFFER"), 6, 12);
        // 追加String对象。
        sbuffer.append("String");
        // 追加String对象。1表示被追加对象的起始位置(包括)，6是结束位置(不包括)
        sbuffer.append("0123456789", 1, 6);
        sbuffer.append('\n');

        // 追加Object对象。此处以HashMap为例
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        sbuffer.append(map);
        sbuffer.append('\n');

        // 追加unicode编码
        sbuffer.appendCodePoint(0x5b57);    // 0x5b57是“字”的unicode编码
        sbuffer.appendCodePoint(0x7b26);    // 0x7b26是“符”的unicode编码
        sbuffer.appendCodePoint(0x7f16);    // 0x7f16是“编”的unicode编码
        sbuffer.appendCodePoint(0x7801);    // 0x7801是“码”的unicode编码

        System.out.printf("%s\n\n", sbuffer);
    }
}