package locale;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Locale 的测试程序
 *
 * @author skywang
 * @email kuiwu-wang@163.com
 */
public class LocaleTest {

    public static void main(String[] args) {
        // 2种不同的Locale的创建方法
        testDiffDateLocales();

        System.out.println();

        // 显示所有的Locales
        testAllLocales();
    }


    /**
     *  2种不同的Locale的创建方法
     */
    private static void testDiffDateLocales() {
        // date为2013-09-19 14:22:30
        Date date = new Date(113, 8, 19, 14, 22, 30);

        // 创建“简体中文”的Locale
        Locale localeCN = Locale.SIMPLIFIED_CHINESE;
       // Locale localeCN = new Locale("zh", "CH");
        // 创建“英文/美国”的Locale
        //Locale localeUS = Locale.US;
        Locale localeUS = new Locale("en", "US");

        // 获取“简体中文”对应的date字符串
        String cn = DateFormat.getDateInstance(DateFormat.FULL, localeCN).format(date);
        // 获取“英文/美国”对应的date字符串
        String us = DateFormat.getDateInstance(DateFormat.FULL, localeUS).format(date);

        System.out.printf("cn=%s\nus=%s\n", cn, us);
    }

    /**
     *  显示所有的Locales
     */
    private static void testAllLocales() {
        Locale[] ls = Locale.getAvailableLocales();

        System.out.print("All Locales: ");
        for (Locale locale:ls) {
            System.out.print(locale + ", ");
        }
        System.out.println();
    }
}