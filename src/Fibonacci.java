import java.util.ArrayList;


public class Fibonacci {
	ArrayList<Integer> al=new ArrayList<Integer>();
static int fibo(int n){
	if(n==0||n==1)
		return n;
	else
		return fibo(n-1)+fibo(n-2);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(fibo(2));
	}

}
