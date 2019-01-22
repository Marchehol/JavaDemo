import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    matches, lookingAt 和 find 方法都用来尝试匹配一个输入序列模式。
    它们的不同是 matches 要求整个序列都匹配，而lookingAt 不要求，
    lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配.
    find()对字符串进行匹配,匹配到的字符串可以在任何位置.
 */
public class matches_lookingAt_find {

    private static final String REGEX = "foo";
    private static final String INPUT1 = "fooooooooooooooooo";
    private static final String INPUT2 = "ooooofoooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher1;
    private static Matcher matcher2;

    public static void main( String args[] ){

        pattern = Pattern.compile(REGEX);
        matcher1 = pattern.matcher(INPUT1);
        matcher2 = pattern.matcher(INPUT2);

        System.out.println("Current regex is: "+REGEX);
        System.out.println("Current Input1 is: "+INPUT1);
        System.out.println("Current Input2 is: "+INPUT2);
        System.out.println();


        System.out.println("Input1 matches(): " + matcher1.matches());
        System.out.println("Input1 lookingAt(): " + matcher1.lookingAt());
        System.out.println("Input1 find(): " + matcher1.find());
        System.out.println("Input2 matches(): " + matcher2.matches());
        System.out.println("Input2 lookingAt(): " + matcher2.lookingAt());
        System.out.println("Input2 find(): " + matcher2.find());
        System.out.println();

        /*
            Matcher.matches()/ Matcher.lookingAt()/ Matcher.find()
            Matcher类提供三个匹配操作方法,三个方法均返回boolean类型,当匹配到时返回true,没匹配到则返回false
        */

        //matches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true
        System.out.println("1. Matcher.matches(): ");
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("22bb23");
        System.out.println(m.matches());//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
        Matcher m2 = p.matcher("2223");
        System.out.println(m2.matches());//返回true,因为\d+匹配到了整个字符串

        //lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
        System.out.println("2. Matcher.lookingAt(): ");
        p = Pattern.compile("\\d+");
        m = p.matcher("22bb23");
        System.out.println(m.lookingAt());//返回true,因为\d+匹配到了前面的22
        m2 = p.matcher("aa2223");
        System.out.println(m2.lookingAt());//返回false,因为\d+不能匹配前面的aa

        //find()对字符串进行匹配,匹配到的字符串可以在任何位置.
        System.out.println("3. Matcher.find(): ");
        p = Pattern.compile("\\d+");
        m = p.matcher("22bb23");
        System.out.println(m.find());//返回true
        m2 = p.matcher("aa2223");
        System.out.println(m2.find());//返回true
        Matcher m3 = p.matcher("aa2223bb");
        System.out.println(m3.find());//返回true
        Matcher m4 = p.matcher("aabb");
        System.out.println(m4.find());//返回false
    }
}
