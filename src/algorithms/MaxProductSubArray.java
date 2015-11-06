package algorithms;

public class MaxProductSubArray
{
 public static void main(String[] args)
 {
  int[] arr =
  { 0,1, 2, -1, 4, 0, 5, -6, -5, -6, 2, 0, 3, -4, 3, -2, 4, -3,0,-15,1,-20 };
  int[] returnIndices = new int[2];
  long maxProduct = findMaxProduct(arr, returnIndices);
  System.out.println("Maximum product " + maxProduct);
  System.out.println("Indices " + returnIndices[0] + " - "
    + returnIndices[1]);
  System.out.println(ownproduct(arr));
  System.out.println(maxProduct(arr));
  System.out.println(maxProductdp(arr));
  System.out.println(genius(arr));
 }


 private static long findMaxProduct(int[] arr, int[] returnIndices)
 {
  int startIndex = 0;
  long maxProduct = 0;
  int[] indices = new int[2];
  for (int index = 0; index < arr.length; ++index)
  {
   if (arr[index] == 0 && index >= startIndex)
   {
    long product = findMaxProductWithoutZero(arr, startIndex,
      index - 1, indices);
    if (product > maxProduct)
    {
     maxProduct = product;
     returnIndices[0] = indices[0];
     returnIndices[1] = indices[1];
    }
    startIndex = index + 1;
   } else if (index == arr.length - 1)
   {
    long product = findMaxProductWithoutZero(arr, startIndex, index,
      indices);
    if (product > maxProduct)
    {
     maxProduct = product;
     returnIndices[0] = indices[0];
     returnIndices[1] = indices[1];
    }
   }
  }
  return maxProduct;
 }

 private static long findMaxProductWithoutZero(int[] arr, int startIndex,
   int endIndex, int[] returnIndices)
 {
  if (startIndex > endIndex || startIndex < 0 || endIndex >= arr.length)
   return 0;
  int negativeCount = 0;
  int firstNegativeIndex = -1;
  int lastNegativeIndex = -1;
  for (int index = startIndex; index <= endIndex; ++index)
  {
   if (arr[index] < 0)
   {
    negativeCount++;
    if (firstNegativeIndex == -1)
     firstNegativeIndex = index;
    lastNegativeIndex = index;
   }
  }
  if (negativeCount % 2 == 0)
   return findMaxProductWithoutNegative(arr, startIndex, endIndex,
     returnIndices);
  else
  {
   int[] indices = new int[2];
   long maxProduct = findMaxProductWithoutNegative(arr,
     firstNegativeIndex + 1, endIndex, indices);
   returnIndices[0] = indices[0];
   returnIndices[1] = indices[1];
   long maxProduct2 = findMaxProductWithoutNegative(arr, startIndex,
     lastNegativeIndex - 1, indices);
   if (maxProduct2 > maxProduct)
   {
    maxProduct = maxProduct2;
    returnIndices[0] = indices[0];
    returnIndices[1] = indices[1];
   }
   return maxProduct;
  }
 }

 private static long findMaxProductWithoutNegative(int[] arr,
   int startIndex, int endIndex, int[] indices)
 {
  if (startIndex > endIndex || startIndex < 0 || endIndex >= arr.length)
   return 0;
  long product = 1;
  for (int index = startIndex; index <= endIndex; ++index)
   product *= arr[index];
  indices[0] = startIndex;
  indices[1] = endIndex;
  return product;
 }
 
 
  static long ownproduct(int arr[])
 {
	  int currentProduct=1;
	  int maxproduct=1;
	  int result[]=new int[2];
	  int currentend=0;
	  int currentstart=0;
	while(currentend!=arr.length){
			currentProduct=currentProduct*arr[currentend];
			if(currentProduct>maxproduct){
				maxproduct=currentProduct;
				result[0]=currentstart;
				result[1]=currentend;
			}else if(currentProduct==0){
				currentstart=currentend+1;
				currentProduct=1;
			}
			currentend++;
	}
	System.out.println(result[0]+":"+result[1]);
	 return maxproduct;
 }
  public static int maxProduct(int[] A) {
	    int max = Integer.MIN_VALUE;
	 
	    for(int i=0; i<A.length; i++){
	        for(int l=0; l<A.length; l++){
	          //  if(i+l < A.length){
	                int product = calProduct(A, i, l);
	                max = Math.max(product, max);
	            //}
	 
	        }
	 
	    }
	    return max;
	}
	 
	public static int calProduct(int[] A, int i, int j){
	    int result = 1;
	    for(int m=i; m<=j; m++){
	        result = result * A[m];
	    }
	    return result;
	}
	
	public static int maxProductdp(int[] A) {
	    if(A==null || A.length==0)  
	        return 0;  
	 
	    int maxLocal = A[0];  
	    int minLocal = A[0];  
	    int global = A[0];  
	 
	/*    for(int i=1; i<A.length; i++){  
	        int temp = maxLocal;  
	     
	        maxLocal = Math.max(Math.max(A[i]*maxLocal, A[i]), A[i]*minLocal);  
	        minLocal = Math.min(Math.min(A[i]*temp, A[i]), A[i]*minLocal);  
	        global = Math.max(global, maxLocal);  
	    } */ 
	    
	    for(int i=1;i<A.length;i++){
	    	int temp=maxLocal;
	    	maxLocal=Math.max(A[i],Math.max(A[i]*maxLocal,A[i]*minLocal));
	    	minLocal=Math.min(Math.min(A[i], A[i]*minLocal),A[i]*temp);
	    	global=Math.max(maxLocal, global);
	    }
	    return global;
	}
	
	public static int genius(int A[]){
		if(A==null||A.length==0)
			return 0;
		int global=0;
		int maxlocal=0;
		int minlocal=0;
		for(int i=0;i<A.length;i++){
			if(A[i]==0)
			{
				minlocal=0;
				maxlocal=0;
				continue;
			}
			if(A[i]<0){
				if(minlocal==0){
					minlocal=A[i];
				}else{
					minlocal=minlocal*A[i];
					if(minlocal>0){
						maxlocal=maxlocal==0?minlocal:maxlocal*minlocal;
						minlocal=0;
					}
				}
			}else{
				maxlocal=maxlocal==0?A[i]:maxlocal*A[i];
			}
			
				global=Math.max(global, maxlocal);
		}
		return global;
		
	}
}