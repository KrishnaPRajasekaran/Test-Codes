package Stringfunc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regextest {
public static void main(String args[]){
	
	 Pattern p = Pattern.compile("a*?b");
	 Matcher m = p.matcher("aaaaab");
	 boolean b = m.matches();
	 System.out.println(b);
m = p.matcher("abb");
b = m.matches();
	 System.out.println(b);
System.out.println("\u0007");
}
}
