package tuts;

public class FibSearch {
public static void main(String args[]){
	int a[]={1,2,3,5,8,6,7,0,10,15,34,25,43,78,87};
	int fib[]=new int[a.length];
	fib[0]=0;
	fib[1]=1;
	for(int i=2;i<a.length;i++)
	{
		fib[i]=fib[i-1]+fib[i-2];
	}
	
}
}
