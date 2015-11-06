package sort;

import java.util.Arrays;

public class HeapSort {
private static int n;
static void buildHeap(int a[],int n)
{
for(int i=n/2;i>=0;i--){

heapify(a,i);	


}
}
static void heapify(int a[],int index){

	
int left=2*index+1;
int right=2*index+2;
int largest=index;
int temp;
if(left<=n && a[left]>a[index])
	largest=left;
if(right<=n && a[right]>a[largest])
	largest=right;
if(largest!=index){
	temp=a[largest];
	a[largest]=a[index];
	a[index]=temp;
	heapify(a,largest);
}

}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a[]={5,8,3,0,12,45,3,7,6};
n=a.length-1;
buildHeap(a,a.length-1);
for(int j=0;j<a.length;j++)
	System.out.format("%3d",a[j]);
	System.out.println();

int temp;
for(int k=n;k>0;k--)
{
	temp=a[0];
	a[0]=a[k];
	a[k]=temp;
	n=n-1;
	for(int j=0;j<a.length;j++)
		System.out.format("%3d",a[j]);
		System.out.println();
	heapify(a,0);
	for(int j=0;j<a.length;j++)
		System.out.format("%3d",a[j]);
		System.out.println();

}
for(int j=0;j<a.length;j++)
	System.out.format("%3d",a[j]);
	System.out.println();
	
	


}
}
