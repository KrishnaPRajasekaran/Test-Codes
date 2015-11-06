package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ar1[]={1,4,7,9,10,23};
		int ar2[]={2,7,45,78,100};
		
		int ar3[]={-1,0,0,1};
		int[] ar4=new int[0];
		int m[][]=new int[][]{ar1,ar2,ar3};
	PriorityQueue<ArrayContainer> q=new PriorityQueue<ArrayContainer>();
	int total=0;
	for(int i=0;i<m.length;i++)
	{
		q.add(new ArrayContainer(m[i],0));
		total=total+m[i].length;
	}
	int result[]=new int[total];
	int cnt=0;
	while(!q.isEmpty()){
	ArrayContainer ac=q.poll();
	result[cnt++]=ac.arr[ac.index];
	if(ac.index<ac.arr.length-1)
		q.add(new ArrayContainer(ac.arr,ac.index+1));
	}
	
	System.out.println(Arrays.toString(result));
	}

}
class ArrayContainer implements Comparable<ArrayContainer>
{
	int arr[];
	int index;
	ArrayContainer(int arr[],int index){
		this.arr=arr;
		this.index=index;
	}
	@Override
	public int compareTo(ArrayContainer arg0) {
		// TODO Auto-generated method stub
		if(this.arr[this.index]<arg0.arr[arg0.index])
			return -1;
		if(this.arr[this.index]>arg0.arr[arg0.index])
			return 1;
		return 0;
	}
	
}
