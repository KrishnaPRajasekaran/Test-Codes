import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
public class LongestSubSequence {
public static void main(String args[])
{
	//int arr[] = {1, 9, 3, 10, 4, 20, 2};
	int arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
	int resultarr[]=new int[arr.length];
	int temp[]=new int[arr.length];
	int result=0;
	HashSet<Integer> ht=new HashSet<Integer>();
	for(Integer num:arr)
	ht.add(num);
result=1;
	for(int i=0;i<arr.length;i++)
		{
int itresult=0;
int c=0;
		while(ht.contains(arr[i]+c)){
		itresult=itresult+1;
		//System.out.println(arr[i]+c);
		temp[c]=arr[i]+c;
		c++;
		}
	if(itresult>result){
		result=itresult;
		resultarr=Arrays.copyOf(temp, result);
	
	}
	
	
	
	}
	System.out.println("Result:"+result);
	System.out.println("Result Array:"+Arrays.toString(resultarr));
}
}
