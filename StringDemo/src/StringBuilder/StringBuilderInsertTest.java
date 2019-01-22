package StringBuilder;

import java.util.HashMap;

/**
 * StringBuilder 的insert()示例
 *
 * @author skywang
 */
public class StringBuilderInsertTest {

    public static void main(String[] args) {
        testInsertAPIs() ;
    }

    /**
     * StringBuilder 的insert()示例
     */
    private static void testInsertAPIs() {

        System.out.println("-------------------------------- testInsertAPIs -------------------------------");

        StringBuilder sbuilder = new StringBuilder();

        // 在位置0处插入字符数组
        sbuilder.insert(0, new char[]{'a','b','c','d','e'});
        System.out.println("1. " + sbuilder);

        // 在位置0处插入字符数组。0表示字符数组起始位置，3表示长度
        sbuilder.insert(0, new char[]{'A','B','C','D','E'}, 0, 3);
        System.out.println("2. " + sbuilder);

        // 在位置0处插入float
        sbuilder.insert(0, 1.414f);
        System.out.println("3. " + sbuilder);

        // 在位置0处插入double
        sbuilder.insert(0, 3.14159d);
        System.out.println("4. " + sbuilder);

        // 在位置0处插入boolean
        sbuilder.insert(0, true);
        System.out.println("5. " + sbuilder);

        // 在位置0处插入char
        sbuilder.insert(0, '\n');
        System.out.println("6. " + sbuilder);

        // 在位置0处插入int
        sbuilder.insert(0, 100);
        System.out.println("7. " + sbuilder);

        // 在位置0处插入long
        sbuilder.insert(0, 12345L);
        System.out.println("8. " + sbuilder);

        // 在位置0处插入StringBuilder对象
        sbuilder.insert(0, new StringBuilder("StringBuilder"));
        System.out.println("9. " + sbuilder);

        // 在位置0处插入StringBuilder对象。6表示被在位置0处插入对象的起始位置(包括)，13是结束位置(不包括)
        sbuilder.insert(0, new StringBuilder("STRINGBUILDER"), 6, 13);
        System.out.println("10. " + sbuilder);

        // 在位置0处插入StringBuffer对象。
        sbuilder.insert(0, new StringBuffer("StringBuffer"));
        System.out.println("11. " + sbuilder);

        // 在位置0处插入StringBuffer对象。6表示被在位置0处插入对象的起始位置(包括)，12是结束位置(不包括)
        sbuilder.insert(0, new StringBuffer("STRINGBUFFER"), 6, 12);
        System.out.println("12. " + sbuilder);

        // 在位置0处插入String对象。
        sbuilder.insert(0, "String");
        System.out.println("13. " + sbuilder);

        // 在位置0处插入String对象。1表示被在位置0处插入对象的起始位置(包括)，6是结束位置(不包括)
        sbuilder.insert(0, "0123456789", 1, 6);
        System.out.println("14. " + sbuilder);

        sbuilder.insert(0, '\n');
        System.out.println("15. " + sbuilder);

        // 在位置0处插入Object对象。此处以HashMap为例
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        sbuilder.insert(0, map);

        System.out.printf("16. %s\n\n", sbuilder);
    }
}