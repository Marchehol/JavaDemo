import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern_Matcher_2 {
    public static void main(String[] args) {

        //Pattern类用于创建一个正则表达式,也可以说创建一个匹配模式,它的构造方法是私有的,不可以直接创建,
        // 但可以通过Pattern.complie(String regex)简单工厂方法创建一个正则表达式,
        Pattern p = Pattern.compile("\\w+");
        System.out.println(p);  //返回 \w+
        System.out.println(p.pattern());  //返回 \w+


        //Pattern有一个split(CharSequence input)方法,用于分隔字符串,并返回一个String[],
        p = Pattern.compile("\\d+");
        String[] str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        for (String aStr : str) {
            System.out.println(aStr);
        }


        //Pattern.matcher(String regex,CharSequence input)是一个静态方法,用于快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串.
        //返回true
        System.out.println(Pattern.matches("\\d+", "2233"));
        //返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到
        System.out.println(Pattern.matches("\\d+", "2233aa"));
        //返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到
        System.out.println(Pattern.matches("\\d+", "22bb33"));


        //Pattern.matcher(CharSequence input)  返回一个Matcher对象.
        //Matcher类的构造方法也是私有的,不能随意创建,只能通过Pattern.matcher(CharSequence input)方法得到该类的实例.
        //Pattern类只能做一些简单的匹配操作,要想得到更强更便捷的正则匹配操作,那就需要将Pattern与Matcher一起合作.
        //Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持.
        p=Pattern.compile("\\d+");
        Matcher m=p.matcher("22bb23");
        System.out.println(m.pattern());//返回p 也就是返回该Matcher对象是由哪个Pattern对象的创建的






    }
}
