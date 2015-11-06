package algorithms;

import java.util.Hashtable;


public class CompareArray {
public static void main(String a[])
	{
	int a1[]={1,5,9,34,56,78,2,3};
	int a2[]={5,66,77,88,99,0,1,2,34};
	int n;
	Hashtable<Integer,Integer> h1=new Hashtable<Integer,Integer>();
	Hashtable<Integer,Integer> h2=new Hashtable<Integer,Integer>();

	for(int i=0;i<a1.length;i++)
	{
		h1.put(a1[i], 0);
	}
	for(int i=0;i<a2.length;i++)
	{
		h2.put(a2[i], 0);
	}
	
	n=(a1.length>a2.length)?a1.length:a2.length;
	
	for(int i=0;i<a1.length;i++)
		for(int j=0;j<a2.length;j++)
		{
			if(a1[i]==a2[j])
			{
				h1.put(a1[i],1);
				h2.put(a2[j],1);
			}
		}
	
	System.out.println(h1.size());
	System.out.println(a1.length);
	System.out.println(h2.size());
	System.out.println(a2.length);
	System.out.print("Common numbers:");
	for(int i=0;i<n;i++){
		if(i<a1.length)
			if(h1.get(a1[i])==1)
				System.out.print(a1[i]+",");
			
	}
	
	
	System.out.print("Unique numbers:");
	for(int i=0;i<n;i++){
		if(i<a1.length)
			if(h1.get(a1[i])==0)
				System.out.print(a1[i]+",");
		if(i<a2.length)
			if(h2.get(a2[i])==0)
				System.out.print(a2[i]+",");	
	}
	}
}
