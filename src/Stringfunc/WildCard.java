package Stringfunc;

public class WildCard {
	private int aa;
	WildCard()
	{
		
	}
	public static void main(String args[]){
		WildCard w=new WildCard();
		System.out.println(w.aa);
		
		String s="abcab";
		String p="a*ab*";
		System.out.println(isMatchTest(s,p));
	}
	//* = 0 or more character
	//? = can be any character
	
	//algorithm for ? n same characters.. when you come across ? that char can be ignored. if pattern character and input character are same it can be ignored
	//algorithm for *. Eg *ab and aaaab. After * position ab should be present in the input or this to be true
	//Maintain iindex as counter to find where to start matching.. aaab *ab matching first aa is matched with ab, then second aa is matched with ab, then ab is matched with ab.
	public static boolean isMatchTest(String s,String p){
		int i=0;
		int j=0;
		int startindex=-1,iindex=0;
		while(i<s.length()){
			if(j<p.length() && s.charAt(i)==p.charAt(j))
			{
				i++;
				j++;
			}else if(j<p.length() && p.charAt(j)=='*')
			{
				startindex=j++;
				iindex=i;
			}else if(startindex!=-1){
				j=startindex+1;
				i=iindex++;
			}else{
				return false;
			}
			
		}
		
		while(j<p.length() && p.charAt(j)=='*')
		j++;
			return j==p.length();
	 
	}
	
	public static boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;
	 
		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;		
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				i = iIndex+1;
				iIndex++;
			} else {
				return false;
			}
		}
	 
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
	 
		return j == p.length();
	}
}
