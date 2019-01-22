package calendar;

import java.util.Calendar;

/**
 * 测试Calendar的“比较接口”
 *
 * @author skywang (kuiwu-wang@163.com)
 */
public class TestLenientAPIs {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();

        // 获取默认的“宽容度”。返回true
        boolean oriLenient = cal.isLenient();
        // MONTH值只能是“0-11”，这里越界。但是由于当前cal是宽容的，所以不会抛出异常
        System.out.println(cal.get(Calendar.MONTH));
        cal.set(Calendar.MONTH, 50);
        System.out.println(cal.get(Calendar.MONTH));

        // 设置“宽容度”为false。
        cal.setLenient(false);
        // 获取设置后的“宽容度”
        boolean curLenient = cal.isLenient();
        try {
            // MONTH值只能是“0-11”，这里越界。而且当前cal是不宽容的，所以会产生异常。
            // 但是，异常到下次计算日期时才会抛出。即，set()中不回抛出异常，而要等到get()中才会抛出异常
            cal.set(Calendar.MONTH, 50);
            // 此时，对cal进行读取。读取会导致重新计算cal的值，所以此时抛出异常！
            System.out.println(cal.get(Calendar.MONTH));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.out.printf("\ntestLenientAPIs: oriLenient=%s, curLenient=%s\n",
                oriLenient, curLenient);
    }
}
