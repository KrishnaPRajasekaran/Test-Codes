package dp;

public class EditDistance {
static int finddis(String inp1,String inp2){
	int dp[][]=new int[inp1.length()+1][inp2.length()+1];
	
	for(int i=0;i<=inp1.length();i++)
		dp[i][0]=i;
	for(int i=0;i<=inp2.length();i++)
		dp[0][i]=i;
	for(int i=0;i<inp1.length();i++){
	char c1=inp1.charAt(i);
		for(int j=0;j<inp2.length();j++)
		{
			char c2=inp2.charAt(j);
			if(c1==c2)
				dp[i+1][j+1]=dp[i][j];
			else
			{
				int insert=dp[i][j+1]+1;
				int delete=dp[i+1][j]+1;
				int replace=dp[i][j]+1;
				dp[i+1][j+1]=Math.min(Math.min(insert, delete),replace);
			}
		}
	}
	return dp[inp1.length()][inp2.length()];
}
	
	public static void main(String args[]){
		String input1="dec";
		String input2="ad";
		System.out.println(finddis(input1,input2));
	}
}
