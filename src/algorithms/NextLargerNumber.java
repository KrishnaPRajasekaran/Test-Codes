package algorithms;

import java.util.Arrays;

public class NextLargerNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n=127354;



int nd=String.valueOf(n).length();
int a[]=new int[nd];
int d=-1;
int min=Integer.MAX_VALUE;
int pos=-1;

for(int i=nd-1;i>=1;i--)
{
	a[i]=Integer.parseInt(String.valueOf(n).substring(i,i+1));
	
	if(Integer.parseInt(String.valueOf(n).substring(i,i+1))>Integer.parseInt(String.valueOf(n).substring(i-1, i)))
	{
		a[i-1]=Integer.parseInt(String.valueOf(n).substring(i-1,i));
		d=i-1;
		break;
	}
}

if(d>=0){
	System.out.println(a[d]);
int temp=0;	
	for(int i=d+1;i<nd;i++)
	{
		temp=a[i]-a[d];
		if(temp>0 && min>temp)
		{
			min=temp;
			pos=i;
		}
	}
temp=a[d];
a[d]=a[pos];
a[pos]=temp;
String result=String.valueOf(n).substring(0, d);
Arrays.sort(a,d+1,nd);
for(int i=d;i<nd;i++)
	result=result+a[i];
System.out.println(result);
}

	}

}
