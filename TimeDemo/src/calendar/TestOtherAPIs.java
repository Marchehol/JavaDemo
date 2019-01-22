package calendar;

import java.util.Calendar;

/**
 * 测试Calendar的clone()，getFirstDayOfWeek()等接口
 *
 * @author skywang (kuiwu-wang@163.com)
 */
public class TestOtherAPIs {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        // 克隆cal
        Calendar clone = (Calendar)cal.clone();

        // 设置 为 2013-01-10。
        // 注：2013-01-01 为“星期二”，2013-01-06为“星期天”，
        clone.set(Calendar.YEAR, 2013);
        clone.set(Calendar.MONTH, 0);
        clone.set(Calendar.DATE, 10);
        // 设置“本年的第一个星期最少包含1天”。
        // 则2013-01-10属于第2个星期
        clone.setMinimalDaysInFirstWeek(1);
        int m1 = clone.getMinimalDaysInFirstWeek();
        int index1 = clone.get(Calendar.WEEK_OF_YEAR);

        // 设置“本年的第一个星期最少包含7天”。
        // 则2013-01-10属于第1个星期
        clone.setMinimalDaysInFirstWeek(7);
        int m2 = clone.getMinimalDaysInFirstWeek();
        int index2 = clone.get(Calendar.WEEK_OF_YEAR);

        // 设置“每周的第一天是星期几”。
        clone.setFirstDayOfWeek(Calendar.WEDNESDAY);
        // 获取“每周的第一天是星期几”。
        int firstDayOfWeek = clone.getFirstDayOfWeek();

        System.out.printf("\ntestOtherAPIs: firstDayOfWeek=%s, [minimalDay, WeekOfYear]={(%s, %s), (%s, %s)} %s\n",
                firstDayOfWeek, m1, index1, m2, index2, clone.getTime());
    }
}
