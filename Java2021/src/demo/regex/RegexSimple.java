package demo.regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSimple {
  public static void main(String args[]) {
    Pattern p = Pattern.compile("t(est)");
    String candidateString = "This is a test. This is another test.";
    Matcher matcher = p.matcher(candidateString);
    // Find group number 0 of the first find
    matcher.find();
    String group_0 = matcher.group(0);
    String group_1 = matcher.group(1);
    System.out.println("Group 0 " + group_0);
    System.out.println("Group 1 " + group_1);
    
    //
    while (matcher.find()) {
    	candidateString = candidateString.replaceAll(matcher.group(), matcher.group(1));
    }
    //
    System.out.println(candidateString);

  }
}