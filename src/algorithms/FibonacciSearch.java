package algorithms;

import java.util.Arrays;

public class FibonacciSearch {
static	int fib[];
static int p=-1,q=-1;
static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3,4,5,6,7,8,9,10,11,12,13,31,42,44};
		int b[]={5,4,6,1,3,4,5,7,8,9,0,334,54};
		fib=new int[10];
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<10;i++)
		{
			fib[i]=fib[i-1]+fib[i-2];
		}
		System.out.println(a.length);
		System.out.println(rank(1,a,0,a.length-1));
	// 0 1 1 2 3 5 8 13 21 	
		System.out.println(count);
		int result[]=min(b);
		System.out.println(result[0]+":"+result[1]);
	}
	
	  public static int rank(final int key, final int[] a,int start,int end) {
		  count++;
	  int k=0,p=1,q=1;
		  while(fib[k++]<(end-start+1))
			  ;
		 if(end-start<0)
			 return -1;
		  // p=fib[k];
		  q=fib[k-2];
		  
		  if(a[start+q]==key)
			  return start+q;
		  else if(a[start+q]<key)
			  return rank(key,a,start+q+1,end);
		  else
			  return rank(key,a,start,start+q-1);
	    }
	  
	  public static int[] min(int a[])
	  {
		  int result[]={-1,-1};
		result[0]=Math.min(a[0], a[1]);
		result[1]=result[0]==a[0]?a[1]:a[0];
		  for(int i=2;i<a.length;i++)
		  {
			  if(a[i]<result[1])
				  if(a[i]<result[0]){
					  result[1]=result[0];
					  result[0]=a[i];
					  
				  }
				  else
					  result[1]=a[i];
		  }
		 return result; 
	  }
}
	

