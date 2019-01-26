import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Pattern_Matcher_2 类：
    pattern 对象是一个正则表达式的编译表示。Pattern_Matcher_2 类没有公共构造方法。
    要创建一个 Pattern_Matcher_2 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern_Matcher_2 对象。该方法接受一个正则表达式作为它的第一个参数。

    Matcher 类：
    Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。
    你需要调用 Pattern_Matcher_2 对象的 matcher 方法来获得一个 Matcher 对象。

    捕获组:
    可以通过调用 matcher 对象的 groupCount 方法来查看表达式有多少个分组。groupCount 方法返回一个 int 值，表示matcher对象当前有多个捕获组。
    还有一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。
 */
public class Pattern_Matcher_1
{
    public static void main( String args[] ){

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)?";

        // 创建 Pattern_Matcher_2 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);

        //查看表达式有多少个分组
        int count = m.groupCount();
        System.out.println("Found rows: " + count);

        //m.find()找到下一个子序列
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }

    }
}

.*(.).*\\1.*