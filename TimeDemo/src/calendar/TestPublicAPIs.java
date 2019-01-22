package calendar;

import java.util.Calendar;
import java.util.Random;

public class TestPublicAPIs {
    /**
     * 测试“Calendar的字段”
     *
     * @param cal   -- Calendar对象
     * @param field -- 要测试的“Calendar字段”。可以为以下值：
     *   Calendar.YEAR, Calendar.MONTH, Calendar.DATE, ... 等等
     * @param title -- 标题
     * @author skywang (kuiwu-wang@163.com)
     */
    private static void test(Calendar cal, int field, String title){
        final Random random = new Random();

        final int min = cal.getMinimum(field);    // 获取"字段最小值"
        final int max = cal.getMaximum(field);    // 获取“字段最大值”

        final int actualMin = cal.getActualMinimum(field);    // 获取"当前日期下，该字段最小值"
        final int actualMax = cal.getActualMaximum(field);    // 获取“当前日期下，该字段的最大值”

        // 获取“字段的当前值”
        final int ori = cal.get(field);

        // 设置“字段的当前值”, 并获取“设置之后的值”
        final int r1 = random.nextInt(max);
        cal.set(field, r1);
        final int set = cal.get(field);
        try {
            // 回滚“字段的当前值”：在“字段最小值”和“字段最大值”之间回滚。
            // “回滚值”可以为正，也可以为负。
            cal.roll(field, -max);
        } catch (IllegalArgumentException e) {
            // 当field == Calendar.ZONE_OFFSET时，会抛出该异常！
            e.printStackTrace();
        }
        final int roll = cal.get(field);

        // 获取一个随机值
        final int sign = ( random.nextInt(2) == 1) ? 1 : -1;
        final int r2 = sign * random.nextInt(max);
        try {
            // 增加“字段的当前值” ，并获取“新的当前字段值”
            // add的“参数值”可以为正，也可以为负。
            cal.add(field, r2);
        } catch (IllegalArgumentException e) {
            // 当field == Calendar.ZONE_OFFSET时，会抛出该异常！
            e.printStackTrace();
        }
        final int add = cal.get(field);



        // 打印字段信息
        System.out.printf("%s:\n\trange is [%d - %d] actualRange is [%d - %d].  original=%d, set(%d)=%d, roll(%d)=%d, add(%d)=%d\n",
                title, min, max, actualMin, actualMax, ori, r1, set, -max, roll, r2, add);
        
    }

    /**
     * 测试Calendar的“17个字段的公共函数接口”
     *
     * @author skywang (kuiwu-wang@163.com)
     */
    public static void main(String[] args){

        // 00. ERA 字段
        test(Calendar.getInstance(), Calendar.ERA, "Calendar.ERA");
        // 01. YEAR 字段
        test(Calendar.getInstance(), Calendar.YEAR, "Calendar.YEAR");
        // 02. MONTH 字段
        test(Calendar.getInstance(), Calendar.MONTH, "Calendar.MONTH");
        // 03. WEEK_OF_YEAR 字段
        test(Calendar.getInstance(), Calendar.WEEK_OF_YEAR, "Calendar.WEEK_OF_YEAR");
        // 04. WEEK_OF_MONTH 字段
        test(Calendar.getInstance(), Calendar.WEEK_OF_MONTH, "Calendar.WEEK_OF_MONTH");
        // 05. DATE 字段
        test(Calendar.getInstance(), Calendar.DATE, "Calendar.DATE");
        // 06. DAY_OF_MONTH 字段
        test(Calendar.getInstance(), Calendar.DAY_OF_MONTH, "Calendar.DAY_OF_MONTH");
        // 07. DAY_OF_YEAR 字段
        test(Calendar.getInstance(), Calendar.DAY_OF_YEAR, "Calendar.DAY_OF_YEAR");
        // 08. DAY_OF_WEEK 字段
        test(Calendar.getInstance(), Calendar.DAY_OF_WEEK, "Calendar.DAY_OF_WEEK");
        // 09. DAY_OF_WEEK_IN_MONTH 字段
        test(Calendar.getInstance(), Calendar.DAY_OF_WEEK_IN_MONTH, "Calendar.DAY_OF_WEEK_IN_MONTH");
        // 10. AM_PM 字段
        test(Calendar.getInstance(), Calendar.AM_PM, "Calendar.AM_PM");
        // 11. HOUR 字段
        test(Calendar.getInstance(), Calendar.HOUR, "Calendar.HOUR");
        // 12. HOUR_OF_DAY 字段
        test(Calendar.getInstance(), Calendar.HOUR_OF_DAY, "Calendar.HOUR_OF_DAY");
        // 13. MINUTE 字段
        test(Calendar.getInstance(), Calendar.MINUTE, "Calendar.MINUTE");
        // 14. SECOND 字段
        test(Calendar.getInstance(), Calendar.SECOND, "Calendar.SECOND");
        // 15. MILLISECOND 字段
        test(Calendar.getInstance(), Calendar.MILLISECOND, "Calendar.MILLISECOND");
        // 16. ZONE_OFFSET 字段
        test(Calendar.getInstance(), Calendar.ZONE_OFFSET, "Calendar.ZONE_OFFSET");
        
    }
}
