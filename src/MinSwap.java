import java.util.Arrays;
import java.util.Hashtable;
public class MinSwap {
	static int numswaps=0;
	
	static void swap(int arr[],int ind1,int ind2)
	{
		int temp=arr[ind1];
		arr[ind1]=arr[ind2];
		arr[ind2]=temp;
	}
static int findminswap(int arr[],Hashtable<Integer,Integer> ht,int index){
	if(index>=arr.length)
		return 0;
	int findpairindex=findindex(arr,ht.get(arr[index]));
		if(findpairindex==index+1)
			return findminswap(arr,ht,index+2);
		
		swap(arr,findpairindex,index+1);
		//return 1+findminswap(arr,ht,index+2);
		int onechange=findminswap(arr,ht,index+2);
		swap(arr,findpairindex,index+1);
		int findpairindex2=findindex(arr,ht.get(arr[index+1]));
		swap(arr,findpairindex2,index);
		int twochange=findminswap(arr,ht,index+2);
		swap(arr,findpairindex2,index); 
		if(onechange<=twochange)
		{
		System.out.println("onechange:"+(index+1)+":"+findpairindex+";"+onechange);
		//swap(arr,findpairindex,index+1);
		return 1+onechange;
		}
		else{
			System.out.println("twochange:"+index+":"+findpairindex2+";"+twochange);
			//swap(arr,findpairindex2,index);	
			return 1+twochange;
		}
			
	}
	static int findindex(int arr[],int key){
		int index=0;
		for(;index<arr.length;index++)
			if(arr[index]==key)
				return index;
		return -1;
	}
	public static void main(String[] args) {
		int pairs[]={1,3,2,6,4,5};
		int arr[]={3,5,6,4,1,2};
		Hashtable<Integer,Integer> ht=new Hashtable<Integer,Integer>();
		for(int i=0;i<pairs.length;i=i+2)
		{
			ht.put(pairs[i],pairs[i+1]);
			ht.put(pairs[i+1], pairs[i]);
		}
		
		System.out.println("Minimum number of swaps:"+findminswap(arr,ht,0));
		System.out.println(Arrays.toString(arr));

	}

}
