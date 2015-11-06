package sort;

import java.util.Arrays;

public class QuickSort {
static void quicksort(int a[],int low, int high)
{
//	int pivot=a[low+(high-low)/2];

	int i=low;
	int j=high;
	/*Concept is keep swapping i and j to both sides of pivot such that all values less than pivot are left and greater are right.
	 * By the end i.e i==j i will b the final position of the pivot. Pivot is put in that position. 
	 * the remaining elements on both sides are sorted.
	 *  */
	// 4 6 3 1 7 5
	// 6 & 1   4 1 3 6 7 5
	if(i>=j)
		return;
	//if(j-i==1)
		//if(a[i]>a[j])
			//swap(a,i,j);
	int middle=low+(high-low)/2;
	int pivot=a[middle];
	while(i<j)
	{
		// 0 1  4 3
		while(a[i]<pivot && i<j)
		i++;
		while(a[j]>pivot && j>i)
		j--;
		
			
			swap(a,i,j);
			if(pivot==a[i] && pivot==a[j])
				i++;
	//		i++;
		//	j--;
			
	
		}
		for(int k=0;k<a.length;k++)
			System.out.format("%3d",a[k]);
		System.out.println();
	//	}
	//}
	//swap(a,i,middle);
	System.out.println("i"+i);
	System.out.println("j"+j);
	for(int k=0;k<a.length;k++)
		System.out.format("%3d",a[k]);
	System.out.println();
	quicksort(a,j+1,high);
	quicksort(a,low,j-1);
	}


static void swap(int a[],int i,int j)
{
	int temp;
	temp=a[i];
	a[i]=a[j];
	a[j]=temp;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={5,6,3,4,1,0,9,5,8,3};
		
	//int b[]={0, 6, 3, 4, 1, 5, 9, 8, 13,9};
		int b[]={9,8,4,1,5,3,6,7,8,99,22,33,44,55,100};
		for(int k=0;k<a.length;k++)
			System.out.format("%3d",a[k]);
		System.out.println();
		//Arrays.sort(b);
		
		//0 1 3 4 6
		quicksort(b,0,b.length-1);
		for(int i=0;i<b.length;i++)
			System.out.format("%3d",b[i]);
		System.out.println();
	
	}

}
