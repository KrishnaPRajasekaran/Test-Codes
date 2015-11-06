package sort;

public class MergeSort {
public static void splitsort(int a[],int low,int high,int[] b){
	
	if(high-low==0)
		return;
	int imiddle=low+(high-low)/2;

	splitsort(a,low,imiddle,b);
	splitsort(a,imiddle+1,high,b);

	merge(a,low,imiddle,high,b);
	
}
static void copyArray(int[] a,int b[],int low,int high)
{
	for(int i=low;i<=high;i++)
		a[i]=b[i];
}

public static void merge(int a[],int low,int imiddle,int high,int[] b)
{
	int i=low,j=imiddle+1;
	
	for(int k=low;k<=high;k++)
	{
		
		if(i<=imiddle &&(j>high || (a[i]<a[j])))
	{
		b[k]=a[i];
		i=i+1;
	}else
	{
		b[k]=a[j];
		j++;

	}
	}
	//System.out.println("b");
	copyArray(a,b,low,high);
}
public static void main(String args[]){
	int a[]={5,4,6,2,7,4,9,1,0,-3};
	int b[]=new int[a.length];
	
	splitsort(a,0,a.length-1,b);
	for(int i=0;i<a.length;i++)
		System.out.print(a[i]);
}
}
