package demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String names = "Subrata Sunita Sumit Su Ayan Rohit Saurabh";
		//Search for name starting with s
		String pattern = "(?i)\\bs[a-z]{4,}\\b";
		Pattern checkRegex = Pattern.compile(pattern);
		Matcher regexMatcher = checkRegex.matcher(names);
		while(regexMatcher.find()) {
			System.out.println(regexMatcher.start() + " : " + regexMatcher.group());
		}

	}

}
