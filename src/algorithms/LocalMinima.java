package algorithms;

public class LocalMinima
{
	static int count=0;
 public static void main(String[] args)
 {
  //int[] arr = {64, 14, 52, 27, 71, 19, 63, 1, 16, 57};
int[] arr={ 9,7,7,2,1,3,3,5,4,7,3,3,4,8,6,9};
  //int[] arr={10, 2, 3, 4, 5, 8, 6, 9};
 System.out.println(findLocalMinima(arr,0,arr.length-1));
 System.out.println(count);
 for(int i=1;i<arr.length-1;i++)
	 if(arr[i]<arr[i-1] && arr[i]<arr[i+1]){
		 System.out.println(arr[i]);
	 }
 }

 

 private static int findLocalMinima(int[] a, int start, int end)
 {
	 count++;
 int mid=start+(end-start)/2;
 if(mid<=start || mid >=end)
	 return -1;
 if(a[mid]<=a[mid+1] && a[mid]<=a[mid-1])
	 return a[mid];
 if(a[mid]>=a[mid+1])
	 return findLocalMinima(a,mid,end);
 else
	 return findLocalMinima(a,start,mid);
 }

}
   
