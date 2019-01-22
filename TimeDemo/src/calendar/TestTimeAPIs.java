package calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 测试Calendar的Date、TimeZone、MilliSecond等相关函数
 *
 * @author skywang (kuiwu-wang@163.com)
 */
public class TestTimeAPIs {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();

        // 设置cal的时区为“GMT+8”
        cal.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 获取当前的cal时区
        TimeZone timezone = cal.getTimeZone();

        // 设置 milliseconds
        cal.setTimeInMillis(1279419645742L);
        // 获取 milliseconds
        long millis = cal.getTimeInMillis();
        // 设置 milliseconds之后，时间也改变了。
        // 获取cal对应的日期
        Date date = cal.getTime();
        System.out.printf("\ntestTimeAPIs:\n\tdate = %s\n\ttimezone = %s\n\tmillis = %s\n",
                date, timezone, millis);

        // 设置时间为“1988-08-08”
        cal.set(1988, Calendar.AUGUST, 8);
        // 设置时间为“1999-09-09 09:09”
        cal.set(1999, Calendar.OCTOBER, 9, 9, 9);
        // 设置时间为“2000-10-10 10:10:10”
        cal.set(2000, Calendar.NOVEMBER, 10, 10, 10, 10);
        System.out.println(cal.toString());


    }
}
