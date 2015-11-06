package algorithms;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StringSegment {
	static Set<String> s;
	static String SegmentString(String input, Set<String> dict) {
		  if (dict.contains(input)) return input;
		  int len = input.length();
		  for (int i = 1; i < len; i++) {
		    String prefix = input.substring(0, i);
		    if (dict.contains(prefix)) {
		      String suffix = input.substring(i);
		      
		      String segSuffix = SegmentString(suffix, dict);
		      if (segSuffix != null) {
		        return prefix + " " + segSuffix;
		      }
		    }
		  }
		  return null;
		}
	
	
	public static void main(String[] args) {
		String sd="\u00DC\u00DC\u00DC\u00DC";
		
	System.out.println(sd.replace('\u00DC', 'k'));
		// TODO Auto-generated method stub
s=new HashSet<String>();
s.add("Hi");
s.add("I");
s.add("you");
s.add("love");
s.add("much");
s.add("India");
s.add("so");

String input="HiIloveIndiasomuch";
int j=0;
String result="";
String lastword="";
int lastjvalue=0;
for(int i=1;i<=input.length();i++)
{
	String prefix=input.substring(j,i ); //i-1
	if(s.contains(prefix)){
		result=result+prefix+" ";
		
		j=i;
		lastword=prefix;
	}
	if(i==input.length() && result.replace(" ","").length()!=input.length())
	{
		if(lastjvalue==j)
			break;
	lastjvalue=j;	
		i=j+lastword.length(); // going back to where the miss happened j already has right value
		j=j-lastword.length();
		result=result.substring(0, result.length()-lastword.length()-1);
	}
		
}
System.out.println("Result is"+result);
	
	System.out.println(SegmentString(input, s));
	System.out.println(count("hihi",'i'));
	System.out.println(removevowels("remove"));
	}
static int count(String input,char ch){
	if(input==null)
		return 0;
	if(input.length()==0)
		return 0;
	if(input.charAt(0)==ch)
		return 1+count(input.substring(1),ch);
	else
		return count(input.substring(1),ch);
}
static String removevowels(String input){
	if(input==null)
		return null;
	if(input.length()==0)
		return "";
	if(input.charAt(0) == 'a' || input.charAt(0) == 'e'||input.charAt(0) == 'i'||input.charAt(0) == 'o'||input.charAt(0) == 'u')
		return removevowels(input.substring(1));
	else
		return input.charAt(0)+removevowels(input.substring(1));
}
}
