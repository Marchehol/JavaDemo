package StringBuilder;

/**
 * StringBuilder 的replace()示例
 *
 * @author skywang
 */
public class StringBuilderReplaceTest {

    public static void main(String[] args) {
        testReplaceAPIs() ;
    }

    /**
     * StringBuilder 的replace()示例
     */
    private static void testReplaceAPIs() {

        System.out.println("-------------------------------- testReplaceAPIs ------------------------------");

        StringBuilder sbuilder;

        sbuilder = new StringBuilder("0123456789");
        System.out.printf("sbuilder=%s\n", sbuilder);

        sbuilder.replace(0, 3, "ABCDE");
        System.out.printf("sbuilder=%s\n", sbuilder);

        sbuilder = new StringBuilder("0123456789");
        sbuilder.reverse();
        System.out.printf("sbuilder=%s\n", sbuilder);

        sbuilder = new StringBuilder("0123456789");
        sbuilder.setCharAt(0, 'M');
        System.out.printf("sbuilder=%s\n", sbuilder);

        System.out.println();
    }
}