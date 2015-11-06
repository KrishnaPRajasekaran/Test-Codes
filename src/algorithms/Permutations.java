package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
	
static void permute(String prefix,String input,int n){
	if(prefix.length()==n){
		System.out.println(prefix);
		return;
	}
	for(int i=0;i<input.length();i++){
		//permute(prefix+input.charAt(i),input.substring(0,i)+input.substring(i+1),n);
		permute(prefix+input.charAt(i),input,n);
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String input="abc";
/*permute("",input,3);
	input="";
	int a[]={1,1,3};
	for(int i=0;i<a.length;i++)
	{
		input=input+String.valueOf(a[i]);
	}
	permute("",input,3);*/
	//char test[]=input.toCharArray();
	//System.out.println(Arrays.toString(test));
int a[]={1,1,3};
//Permutations p=new Permutations();
System.out.println(permute1(a));
	}
	
	static ArrayList<ArrayList<Integer>> permute1(int a[]){
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		for(int i=0;i<a.length;i++){
			ArrayList<ArrayList<Integer>> current=new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> l:result){
				for(int j=0;j<=l.size();j++){
					l.add(j,a[i]);
					if(!result.contains(l))
					current.add(new ArrayList<Integer>(l));
					l.remove(j);
				}
			}
			result=new ArrayList<ArrayList<Integer>>(current);
		}
		return result;
	}
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permute(num, 0, result);
		return result;
	}
	 
	void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
	 
		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
			return;
		}
	 
		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
		}
	}
	 
	private ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
