package dateFormat;

import javafx.scene.input.DataFormat;
import sun.util.resources.cldr.fo.CalendarData_fo_FO;

import java.io.DataInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * SimpleDateFormat 的API测试程序
 *
 * @author skywang
 * @email kuiwu-wang@163.com
 */
public class SimpleDateFormatTest {
    
    public static void main(String[] args) {

        // 通过SimpleDateFormat 获取日期/时间：有多种格式
        testSimpleDateFormats() ;

        // 通过DateFormat 获取日期/时间
        superTest() ;
    }

    /**
     * 通过SimpleDateFormat 获取日期/时间。有多种格式可以选择
     */
    private static void testSimpleDateFormats() {
        String[] formats = new String[] {
            "HH:mm",                                // 14:22
            "h:mm a",                               // 2:22 下午
            "HH:mm z",                              // 14:22 CST
            "HH:mm Z",                              // 14:22 +0800
            "HH:mm zzzz",                           // 14:22 中国标准时间
            "HH:mm:ss",                             // 14:22:30
            "yyyy-MM-dd",                           // 2013-09-19
            "yyyy-MM-dd HH:mm",                     // 2013-09-19 14:22
            "yyyy-MM-dd HH:mm:ss",                  // 2013-09-19 14:22:30
            "yyyy-MM-dd HH:mm:ss zzzz",             // 2013-09-19 14:22:30 中国标准时间
            "EEEE yyyy-MM-dd HH:mm:ss zzzz",        // 星期四 2013-09-19 14:22:30 中国标准时间
            "yyyy-MM-dd HH:mm:ss.SSSZ",             // 2013-09-19 14:22:30.000+0800
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ",           // 2013-09-19T14:22:30.000+0800
            "yyyy.MM.dd G 'at' HH:mm:ss z",         // 2013.09.19 公元 at 14:22:30 CST
            "K:mm a",                               // 2:22 下午, CST
            "EEE, MMM d, ''yy",                     // 星期四, 九月 19, '13
            "hh 'o''clock' a, zzzz",                // 02 o'clock 下午, 中国标准时间
            "yyyyy.MMMMM.dd GGG hh:mm aaa",         // 02013.九月.19 公元 02:22 下午
            "EEE, d MMM yyyy HH:mm:ss Z",           // 星期四, 19 九月 2013 14:22:30 +0800
            "yyMMddHHmmssZ",                        // 130919142230+0800
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ",           // 2013-09-19T14:22:30.000+0800
            "EEEE 'DATE('yyyy-MM-dd')' 'TIME('HH:mm:ss')' zzzz",        // 星期四 2013-09-19 14:22:30 中国标准时间
        };

        Date date = (new Date(0));                    // date为1970-01-01 07:00:00
        //Date date = Calendar.getInstance().getTime(); // date为当前时间
        //Date date = new Date(113, 8, 19, 14, 22, 30);   // date为2013-09-19 14:22:30
        for (String format : formats) {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.SIMPLIFIED_CHINESE);
            //SimpleDateFormat sdf = new SimpleDateFormat(format);
            System.out.format("%30s    %s\n", format, sdf.format(date));
         }
    }

    /**
     * 通过DateFormat 获取日期/时间
     */
    private static void superTest() {
        // 新建date对象，时间是2013-09-19 14:22:30
        // (01) 年=“‘目标年’ - 1900”，
        // (02) 月。 0是一月，1是二月，依次类推。
        // (03) 日。 1-31之间的数
        Date mDate = new Date(113, 8, 19, 14, 22, 30);
        Locale locale = new Locale("zh", "CN"); 

        // 14:22:30
        //String time = DateFormat.getTimeInstance( DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE).format(mDate);
        String time = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale).format(mDate);

        // 2013-09-19
        //String date = DateFormat.getDateInstance( DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE).format(mDate);
        String date = DateFormat.getDateInstance( DateFormat.MEDIUM, locale).format(mDate);

        // 2013-09-19 14:22:30
        //String datetime = DateFormat.getDateTimeInstance( DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE).format(mDate);
        String datetime = DateFormat.getDateTimeInstance( DateFormat.MEDIUM, DateFormat.MEDIUM, locale).format(mDate);

        System.out.printf("\ntime=%s\ndate=%s\ndatetime=%s\n",time,date,datetime); 
    }
}