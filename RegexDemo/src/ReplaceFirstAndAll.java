import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class ReplaceFirstAndAll {

    public static void main(String[] args) {
        String REGEX = "dog";
        String INPUT1 = "The dog says meow. All dogs say meow.";
        String INPUT2 = "The dog says meow. All dogs say meow.";
        String REPLACE = "cat";

        Pattern p = Pattern.compile(REGEX);
        Matcher m1 = p.matcher(INPUT1);
        Matcher m2 = p.matcher(INPUT2);

        INPUT1 = m1.replaceFirst(REPLACE);
        System.out.println("replaceFirst: " + INPUT1);

        INPUT2 = m2.replaceAll(REPLACE);
        System.out.println("replaceAll: " + INPUT2);
   }
}