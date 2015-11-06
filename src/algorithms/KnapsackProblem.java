package algorithms;

public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int W=10;
        int N=val.length;
        int option1,option2;
        int bagval[][]=new int[N+1][W+1];
        boolean sol[][]=new boolean[N+1][W+1];
        for(int i=1;i<=N;i++)
        for(int j=1;j<=W;j++){
        	option1=bagval[i-1][j];
        	option2=Integer.MIN_VALUE;
        	if(wt[i-1]<=j)
        		option2=val[i-1]+bagval[i-1][j-wt[i-1]];
        	bagval[i][j]=Math.max(option1, option2);
        	sol[i][j]=option2>option1;
        	
        }
        boolean take[]=new boolean[N+1];
        System.out.println(bagval[N-1][W]);
        System.out.println(bagval[2][7]);
        for(int i=0;i<=N;i++)
        {
        	for(int j=0;j<=W;j++){
        		System.out.format("%4d",bagval[i][j]);
        	}
        	System.out.println();
        }
        for(int i=N,w=W;i>0 && w>0;i--)
        {
        	if(sol[i][w]){
        		take[i-1]=true;
        		w=w-wt[i-1];
        	
        	}
        	else
        		take[i-1]=false;
        }
        for(int i=0;i<N;i++)
        	System.out.println(take[i]);
        
        System.out.println(3 & 2 );
	}

}
