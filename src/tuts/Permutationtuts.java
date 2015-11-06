package tuts;

/*
 * Concept is first add 1 to empty, then add 2 to both sides of 1
 *  1 2
 *  2 1
 *  then add 3 around all elements of 1 2 3, 1 3 2, 3 1 2, 2 1 3, 2 3 1, 3 2 1
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutationtuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a[]={1,2,3};
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	result.add(new ArrayList<Integer>());
		for(int i=0;i<a.length;i++){
			ArrayList<ArrayList<Integer>> current=new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> l:result){
				for(int k=0;k<=l.size();k++){
					l.add(k,a[i]);
					current.add(new ArrayList<Integer>(l));//using new so that same object(reference) is not added
				 l.remove(k);
				}
			}
			result=new ArrayList<ArrayList<Integer>>(current);
		}
		Collections.reverse(result);
	result.forEach(e->System.out.println(e));	
	}

}
