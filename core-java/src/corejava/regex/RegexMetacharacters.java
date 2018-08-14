package corejava.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMetacharacters {

	public static void main(String[] args) {
		Pattern p=Pattern.compile("Java \\d");
		String candidate="Java 4";
		Matcher m=p.matcher(candidate);
		if(m!=null){
			System.out.println(m.find());
		}
		
		String regex="\\w+";
		Pattern p1=Pattern.compile(regex);
		String candidate1 = "asdf Java";
		Matcher matcher=p1.matcher(candidate1);
		if(matcher.find()){
			System.out.println("GROUP 0:" + matcher.group(0));
		}

	}

}
