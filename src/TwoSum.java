	import java.util.HashMap;

/*
Write a function that, given a list and a target sum, returns zero-based indices of any two distinct elements whose sum is equal to the target sum. If there are no such elements, the function should return null.

For example, findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12) should return any of the following tuples of indices:

1, 4 (3 + 9 = 12)
2, 3 (5 + 7 = 12)
3, 2 (7 + 5 = 12)
4, 1 (9 + 3 = 12)

*/
public class TwoSum {
    public static int[] findTwoSum(int[] numbers, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] result = new int[2];
  
   
     
    	for (int i = 0; i < numbers.length; i++) {
    		if (map.containsKey(numbers[i])) {
    			int index = map.get(numbers[i]);
    			result[0] = index ;
    			result[1] = i;
    			break;
    		} else {
    			map.put(target - numbers[i], i);
    		}
    	}
     if(result[1]==0)
    	 return null;
    	return result;
        
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 9, 2, 7, 1, 5 }, 12);
        for(int i=0;i<indices.length;i=i+2)
        {
        //if(indices[i]!=indices[i+1])
        	System.out.println(indices[i] + ", " + indices[i+1]);
 
        }
        }
}

/*

Example case: java.lang.UnsupportedOperationException at TwoSum.findTwoSum(TwoSum.java:3) 
One solution: java.lang.UnsupportedOperationException at TwoSum.findTwoSum(TwoSum.java:3) 
No solution: java.lang.UnsupportedOperationException at TwoSum.findTwoSum(TwoSum.java:3) 
Performance test with a large number of elements: java.lang.UnsupportedOperationException at TwoSum.findTwoSum(TwoSum.java:3) 
*/