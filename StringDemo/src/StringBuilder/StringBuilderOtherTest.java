package StringBuilder;

/**
 * StringBuilder 的其它API示例
 *
 * @author skywang
 */
public class StringBuilderOtherTest {

    public static void main(String[] args) {
        testOtherAPIs() ;
    }

    /**
     * StringBuilder 的其它API示例
     */
    private static void testOtherAPIs() {

        System.out.println("-------------------------------- testOtherAPIs --------------------------------");

        StringBuilder sbuilder = new StringBuilder("0123456789");

        int cap = sbuilder.capacity();
        System.out.printf("cap=%d\n", cap);

        sbuilder.append("0123456789");
        sbuilder.append("0123456789");
        System.out.printf("cap=%d\n", sbuilder.capacity());

        char c = sbuilder.charAt(6);
        System.out.printf("c=%c\n", c);

        char[] carr = new char[4];
        sbuilder.getChars(3, 7, carr, 0);
        for (int i=0; i<carr.length; i++)
            System.out.printf("carr[%d]=%c ", i, carr[i]);
        System.out.println();

        System.out.println();
    }
}