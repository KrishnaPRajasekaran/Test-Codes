


	import java.util.ArrayList;
import java.util.Arrays;
	class RemoveDupl
	{
	public static void main(String args[])
	{
	int a[]={1,1,1,1,2,2,3,4,5,6,6,7,8,8,8,9,10,11};
	//int a[]={1,1,1};
	System.out.println(Arrays.toString(a));
	/*boolean flag=false;
	int pre=1;
	int count=0;
	for(int i=1;i<a.length;i++)
	{
	if(a[i]==a[i-1]){ 
	if(flag==false){

	a[pre++]=a[i];
	flag=true;
	}else
	count++;
	}else{

	a[pre++]=a[i];
	flag=false;
	}



	}
	System.out.println(Arrays.toString(a));
	System.out.println(a.length);
	a=Arrays.copyOf(a,pre);
	System.out.println(Arrays.toString(a));
	System.out.println(count);
	*/
	System.out.println(removeDuplicates(a));
	System.out.println(Arrays.toString(a));
	}
	public static int removeDuplicates(int[] A) {
			if (A.length <= 2)
				return A.length;
	 
			int prev = 1; // point to previous
			int curr = 2; // point to current
	 
			while (curr < A.length) {
				if (A[curr] == A[prev] && A[prev] == A[prev - 1]) {
					curr++;
				} else {
					prev++;
					A[prev] = A[curr];
					curr++;
				}
			}
	 
			return prev + 1;
		}

	}

	// 1 1 2 3 4  prev=2 1 1 3 