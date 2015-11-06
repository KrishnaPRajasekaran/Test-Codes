package algorithms;

import java.util.Arrays;

public class lsb {
	public static void main(String[] args){
		int[] arr = new int[]{0,1,3,2,5,6,7,4,8,9,11,12,13,14,15};
//8 9 10 11
		System.out.println(findMissingIntegerInArray(arr,0,0,arr.length-1));
	//	for(int i=0;i<arr.length;i++)
		//	System.out.print(arr[i]+" ");
	}
/*	
	public static int findMissingIntegerInArray(int[] arr,int bit,int start,int end,int flag){
		int odd=(end-start)%2;
		int oddnum=0;
		int evennum=0;
		int counter=end;
		if(end-start==0)
			return arr[start]+1;
		if(end-start==1)
			return arr[end]-arr[start];
		
		for(int i=start;i<=counter;i++)
		{
			if(get(arr[i],bit)==flag)
			{
				oddnum++;
				swap(arr,i,counter--);
				i--;
			}else{
				evennum++;
			}
			
		}
		if(arr[counter]%2==1)
			counter--;
		
		System.out.println(counter);
		if(odd==1){
			if(oddnum>evennum){
				System.out.println("mising even number");
				//0 to counter
				findMissingIntegerInArray(arr,bit+1,start,counter,flag);
			}
			else{
				findMissingIntegerInArray(arr,bit+1,counter+1,end,flag);
				System.out.println("missing odd number");
			}
			}else
		{
			if(evennum-oddnum==2)
			{
			System.out.println("missing odd number");
			findMissingIntegerInArray(arr,bit+1,counter+1,end,flag);
			}else{
				System.out.println("missing even number");
				findMissingIntegerInArray(arr,bit+1,start,counter,flag);
			}
			
		}
		return 0;
	}
*/	static int get(int val,int bit)
	{
		int temp=(int)Math.pow(2, bit);
		if((val & temp)==temp)
			return 1;
		else
			return 0;
	}
	static void swap(int arr[],int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static int findMissingIntegerInArray(int[] arr,int bit,int start,int end){
		//int odd=(end-start)%2;
		int oddnum=0;
		int evennum=0;
		int counter=end;
		if(end-start==0)
			return (int) (arr[start]+Math.pow(2,bit));
		
		
		for(int i=start;i<=counter;i++)
		{
			if(get(arr[i],bit)==1)
			{
				oddnum++;
				swap(arr,i,counter--);
				i--;
			}else{
				evennum++;
			}
			
		}
		
		//System.out.println(counter);
		if(oddnum>evennum)
				return findMissingIntegerInArray(arr,bit+1,start,counter);
		else
			return findMissingIntegerInArray(arr,bit+1,counter+1,end);
			
		

	}

}
