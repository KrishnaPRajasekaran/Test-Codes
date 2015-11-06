import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
class Permutationofarray
{
	public static void main(String args[])
	{
	int a[]={1,2,3};
	System.out.println(permute(a));
	}
	static ArrayList<ArrayList<Integer>> permute(int num[])
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
	
		for(int i=0;i<num.length;i++){
			ArrayList<ArrayList<Integer>> current=new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> l:result){
			for(int j=0;j<=l.size();j++){
				l.add(j,num[i]);
				ArrayList<Integer> temp=new ArrayList<Integer>(l);
				current.add(temp);
				l.remove(j);
				
			}
		}
		result=new ArrayList<ArrayList<Integer>>(current);
	//	result=current;
		
		//result.addAll(current);
		}
		//return current;
		return result;
	}
}

