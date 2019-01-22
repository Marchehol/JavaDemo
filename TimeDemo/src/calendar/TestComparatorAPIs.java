package calendar;

import java.util.Calendar;

/**
 * 测试Calendar的“比较接口”
 *
 * @author skywang (kuiwu-wang@163.com)
 */
public class TestComparatorAPIs {

    public static void main(String[] args){
        // 新建cal1 ，且时间为1988年
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 1988);
        // 新建cal2 ，且时间为2000年
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.YEAR, 2000);
        // 新建cal3, 为cal1的克隆对象
        Calendar cal3 = (Calendar)cal1.clone();

        // equals 判断 cal1和cal2的“时间、时区等”内容是否相等
        boolean isEqual12 = cal1.equals(cal2);
        // equals 判断 cal1和cal3的“时间、时区等”内容是否相等
        boolean isEqual13 = cal1.equals(cal3);
        // cal1是否比cal2早
        boolean isBefore = cal1.before(cal2);
        // cal1是否比cal2晚
        boolean isAfter = cal1.after(cal2);
        // 比较cal1和cal2
        // (01) 若cal1 早于 cal2，返回-1
        // (02) 若cal1 等于 cal2，返回0
        // (03) 若cal1 晚于 cal2，返回1
        int icompare = cal1.compareTo(cal2);

        System.out.printf("\nTestComparatorAPIs:\n\t isEuqal12=%s, isEqual13=%s, isBefore=%s, isAfter=%s, icompare=%s\n",
                isEqual12, isEqual13, isBefore, isAfter, icompare);
    }
}
