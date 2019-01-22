import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    public int start() : 返回以前匹配的初始索引
    public int end(): 返回最后匹配字符之后的偏移量
 */
public class start_end_group
{
    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT = "cat cat cat cattie cat";
 
    public static void main( String args[] ) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while (m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }


        /*
            当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以下三个方法得到更详细的信息.
            start()返回匹配到的子字符串在字符串中的索引位置.
            end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
            group()返回匹配到的子字符串
         */
        System.out.println("\n1. find:");
        p = Pattern.compile("\\d+");
        m = p.matcher("aaa2223bb");
        System.out.println(m.find());//匹配2223
        System.out.println(m.start());//返回3
        System.out.println(m.end());//返回7,返回的是2223后的索引号
        System.out.println(m.group());//返回2223

        System.out.println("\n2. lookingAt:");
        Matcher m2 = p.matcher("2223bb");
        System.out.println(m2.lookingAt());   //匹配2223
        System.out.println(m2.start());   //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
        System.out.println(m2.end());   //返回4
        System.out.println(m2.group());   //返回2223

        System.out.println("\n3. find:");
        Matcher m3 = p.matcher("222344");
        System.out.println(m3.matches());   //匹配整个字符串
        System.out.println(m3.start());   //返回0,原因相信大家也清楚了
        System.out.println(m3.end());   //返回6,原因相信大家也清楚了,因为matches()需要匹配所有字符串
        System.out.println(m3.group());   //返回222344

        System.out.println("\ngroup test:");
        p = Pattern.compile("([a-z]+)(\\d+)");
        m = p.matcher("aaa2223bb");
        System.out.println(m.find());   //匹配aaa2223
        System.out.println(m.groupCount());   //返回2,因为有2组
        System.out.println(m.start(1));   //返回0 返回第一组匹配到的子字符串在字符串中的索引号
        System.out.println(m.start(2));   //返回3
        System.out.println(m.end(1));   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
        System.out.println(m.end(2));   //返回7
        System.out.println(m.group(1));   //返回aaa,返回第一组匹配到的子字符串
        System.out.println(m.group(2));   //返回2223,返回第二组匹配到的子字符串
    }
}
