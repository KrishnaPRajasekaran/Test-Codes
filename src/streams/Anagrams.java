package streams;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagrams {
static boolean compare(String a,String b)
{
	if(a.length()!=b.length())
		return false;
	Map<Object,Long> m=Arrays.asList(a.split("")).stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
	Map<Object,Long> m1=Arrays.asList(b.split("")).stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
	if(m.equals(m1))
		return true;
	else
		return false;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String a="momanddad";
String b="dadandmom";
System.out.println(compare(a,b));
	}

}
