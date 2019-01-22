package StringBuilder;

import java.util.HashMap;

/**
 * StringBuilder 的append()示例
 *
 * @author skywang
 */
public class StringBuilderAppendTest {

    public static void main(String[] args) {
        testAppendAPIs() ;
    }

    /**
     * StringBuilder 的append()示例
     */
    private static void testAppendAPIs() {

        System.out.println("-------------------------------- testAppendAPIs -------------------------------");

        StringBuilder sbuilder = new StringBuilder();

        // 追加字符数组
        sbuilder.append(new char[]{'a','b','c','d','e'});
        System.out.println("1. " + sbuilder);

        // 追加字符数组。0表示字符数组起始位置，3表示长度
        sbuilder.append(new char[]{'A','B','C','D','E'}, 0, 3);
        System.out.println("2. " + sbuilder);

        // 追加float
        sbuilder.append(1.414f);
        System.out.println("3. " + sbuilder);

        // 追加double
        sbuilder.append(3.14159d);
        System.out.println("4. " + sbuilder);

        // 追加boolean
        sbuilder.append(true);
        System.out.println("5. " + sbuilder);

        // 追加char
        sbuilder.append('\n');
        System.out.println("6. " + sbuilder);

        // 追加int
        sbuilder.append(100);
        System.out.println("7. " + sbuilder);

        // 追加long
        sbuilder.append(12345L);
        System.out.println("8. " + sbuilder);

        // 追加StringBuilder对象
        sbuilder.append(new StringBuilder("StringBuilder"));
        System.out.println("9. " + sbuilder);

        // 追加StringBuilder对象。6表示被追加对象的起始位置(包括)，13是结束位置(不包括)
        sbuilder.append(new StringBuilder("STRINGBUILDER"), 6, 13);
        System.out.println("10. " + sbuilder);

        // 追加StringBuffer对象。
        sbuilder.append(new StringBuffer("StringBuffer"));
        System.out.println("11. " + sbuilder);

        // 追加StringBuffer对象。6表示被追加对象的起始位置(包括)，12是结束位置(不包括)
        sbuilder.append(new StringBuffer("STRINGBUFFER"), 6, 12);
        System.out.println("12. " + sbuilder);

        // 追加String对象。
        sbuilder.append("String");
        System.out.println("13. " + sbuilder);

        // 追加String对象。1表示被追加对象的起始位置(包括)，6是结束位置(不包括)
        sbuilder.append("0123456789", 1, 6);
        System.out.println("14. " + sbuilder);

        sbuilder.append('\n');
        System.out.println("15. " + sbuilder);

        // 追加Object对象。此处以HashMap为例
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        sbuilder.append(map);
        sbuilder.append('\n');

        System.out.println("16. " + sbuilder);

        // 追加unicode编码
        sbuilder.appendCodePoint(0x5b57);    // 0x5b57是“字”的unicode编码
        sbuilder.appendCodePoint(0x7b26);    // 0x7b26是“符”的unicode编码
        sbuilder.appendCodePoint(0x7f16);    // 0x7f16是“编”的unicode编码
        sbuilder.appendCodePoint(0x7801);    // 0x7801是“码”的unicode编码

        System.out.printf("17. %s\n\n", sbuilder);
    }
}