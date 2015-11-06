package Drawing;
public class PrintSpiral
{
	 public static void main(String[] args)
	 {
	  int[] arr =
	  { 44, 3, -48, 0, 6, -8, 12, 3, -9, 2, 5, 8, -3, 4, 8, 0, 3, -3, -5, -9,
	    4, 2 };
	  maxSumSubArray(arr);
	 }

	 private static void maxSumSubArray(int[] arr)
	 {
	  int currentStart = 0;
	  int currentEnd = 0;
	  int currentSum = 0;
	  int maxStart = 0;
	  int maxEnd = 0;
	  int maxSum = 0;
	  while (currentEnd != arr.length)
	  {
	   currentSum += arr[currentEnd];
	   if (currentSum > maxSum)
	   {
	    maxSum = currentSum;
	    maxStart = currentStart;
	    maxEnd = currentEnd;
	   }
	   if (currentSum <= 0)
	   {
	    currentStart = currentEnd + 1;
	    currentSum=0;
	   }
	   currentEnd++;
	  }
	  System.out.println("Maximum sum = " + maxSum);
	  System.out.println("Indexes (" + maxStart + "," + maxEnd + ")");
	 }
}