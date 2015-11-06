package algorithms;

public class TowerOfHanoi {
static void solve(int n,String A,String B ,String C){
	if(n==1)
		System.out.println(A+"->"+C);
	else{
		solve(n-1,A,C,B);
		System.out.println(A+"->"+C);
		solve(n-1,B,A,C);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
solve(3,"A","B","C");

	}

}
