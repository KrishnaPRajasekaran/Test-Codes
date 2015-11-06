package sort;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//int a[]={5,3,1,2,7,8,5,6,74};
int a[]={5,4,3,2,1};
int temp;
int count=0;
for(int i=0;i<a.length;i++){
	count++;
	for(int j=0;j<a.length-1-i;j++)
	{
		count++;
		if(a[j]>a[j+1])
		{
		temp=a[j+1];
		a[j+1]=a[j];
		a[j]=temp;
		}
	}}
for(int i=0;i<a.length;i++)
	System.out.print(a[i]+" ");
System.out.println(count);
	}

}
