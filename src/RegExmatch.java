import java.util.regex.Pattern;

public class RegExmatch {
static boolean match(String s, String p){
	if(p.indexOf("**")!=-1)
		return false;
	
	
	if(p.charAt(0)=='*' || p.charAt(0)=='?')
		return false;
	int i=0;
	int j=0;
	int startindex=-1;
	int iindex=-1;
	while(i<s.length()){
	if(j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'||p.charAt(j)=='.'))
	{
		i++;
		j++;
	}else if(j<p.length() && p.charAt(j)=='*'){
		startindex=j-1;
		iindex=i;
		j++;
	}
	else if(j<p.length()-1 && p.charAt(j+1)=='*')
	{
		startindex=j++;
	}else if(startindex!=-1){
		if(p.charAt(startindex)!=s.charAt(i) && p.charAt(startindex)!='.')
			return false;
		i=iindex++;
		j=startindex+1;
		
	}
	else{
		return false;
	}
	}
	
		while(j<p.length() && p.charAt(j)=='*' )
			j++;

	return j==p.length();
}


public static void main(String[] args) {
		// TODO Auto-generated method stub
String input="c";
String pattern=".*";
System.out.println(Pattern.matches(pattern,input));
System.out.println(match(input,pattern));


	}

}
