package dp;

import java.util.ArrayList;
import java.util.List;

public class Palindromelist {
static void getPalindrome(String s,ArrayList<String> result){
	int dp[][]=new int[s.length()][s.length()];
	int cut[]=new int[s.length()+1];
	for(int l=1;l<=s.length();l++)
	{
		cut[l]=l-1;//maximum cuts
		for(int i=0;i<=s.length()-l;i++){
			int j=i+l-1;
			if(s.charAt(i)==s.charAt(j))
			{
				if(l==1 || l==2){
					dp[i][j]=1;
					
				}else{
					dp[i][j]=dp[i+1][j-1];
				}
				
				if(dp[i][j]==1){
					result.add(s.substring(i,j+1));
				cut[l]=0;
				
				}
			}else{
				dp[i][j]=0;
		cut[l]=Math.min(cut[l], cut[l-1]+1);
			}
		}
	}
	System.out.println("number of cuts"+cut[s.length()]);
	for(int i=0;i<s.length();i++){
	System.out.println();
		for(int j=0;j<s.length();j++)
			System.out.print(dp[i][j]+" ");
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<String> result=new ArrayList<String>();
String input="cabbad";
getPalindrome(input,result);
System.out.println(result.toString());
System.out.println(getList(input).toString());
System.out.println(minCut(input));
System.out.println(numDistincts("arabbbit","rb"));
	}

	static ArrayList<ArrayList<String>> getList(String s)
	{
		ArrayList<String> partition=new ArrayList<String>();
		ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		getpartition(s,0,partition,result);
		return result;
	}
	static void getpartition(String s,int start,ArrayList<String> partition,ArrayList<ArrayList<String>> result){
		if(start==s.length())
		{
			ArrayList<String> temp=new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
		for(int i=start+1;i<=s.length();i++){
			if(isPalindrome(s.substring(start, i))){
				partition.add(s.substring(start,i));
				getpartition(s,i,partition,result);
				partition.remove(partition.size()-1);
			}
		}
		
	}
	
	static boolean isPalindrome(String s){
		int i=0;
		int j=s.length()-1;
		while(i<j && s.charAt(i)==s.charAt(j))
		{
			i++;j--;
		}
		if(i<j)
			return false;
		return true;
	}
	public static int minCut(String s) {
	    int n = s.length();
	 
		int dp[][] = new int[n][n];
		int cut[] = new int[n];
	 
		for (int j = 0; j < n; j++) {
			cut[j] = j; //set maximum # of cut
			for (int i = 0; i <= j; i++) {
				if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i+1][j-1]==1)) {
					dp[i][j] = 1;
	 
					// if need to cut, add 1 to the previous cut[i-1]
					if (i > 0){
						cut[j] = Math.min(cut[j], cut[i-1] + 1);
					}else{
					// if [0...j] is palindrome, no need to cut    
						cut[j] = 0; 
					}	
				}
			}
		}
	 for(int i=0;i<n;i++){
		 for(int j=0;j<n;j++)
			 System.out.print(dp[i][j]+" ");
		 System.out.println();
	 }	 
		return cut[n-1];
	}
	public static int numDistincts(String S, String T) {
		int[][] table = new int[S.length() + 1][T.length() + 1];
	 
		for (int i = 0; i <= S.length(); i++)
			table[i][0] = 1;
	 
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					table[i][j] = table[i - 1][j] + table[i - 1][j - 1];
				} else {
					table[i][j] = table[i - 1][j];
				}
			}
		}
	 for(int i=0;i<=S.length();i++){
		 System.out.println();
		 for(int j=0;j<=T.length();j++)
			 System.out.print(table[i][j]+" ");
	 }
		return table[S.length()][T.length()];
	}
}
