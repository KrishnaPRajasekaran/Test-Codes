package dp;

public class HouseRobber {

	static long maxamount(int num[]){
		int dp[]=new int[num.length+1];

	dp[0]=0;
	
	dp[1]=num[0];
	dp[2]=Math.max(num[0],num[1]);

	for(int i=2;i<num.length;i++)
	dp[i+1]= Math.max(dp[i], dp[i-1]+num[i]);	


	return dp[num.length];
	}
	
	public static void main(String args[]){
		int num[]={50,1,1,50};
		System.out.println(maxamount(num));
	}
}
