package algorithms;

public class SmallestElem {
	static final int MIN = Integer.MIN_VALUE;
	static final int MAX = Integer.MAX_VALUE;

	public static int kthSmallest(int[] A, int[] B, int k){
	    if (A == null || B == null || k > A.length + B.length)
			throw new IllegalArgumentException();
		return kthSmallest(A, 0, A.length, B, 0, B.length, k);
	}
	protected static int kthSmallest(int[] A, int aLow, int aLength, int[] B, int bLow, int bLength, int k){
		
		assert(aLow >= 0); assert(bLow >= 0);
		assert(aLength >= 0); assert (bLength >= 0); assert(aLength + bLength >= k);
		
		int i = (int)((double)((k-1)*aLength/(aLength+bLength)));
		int j = k - 1 - i;
		
		int Ai_1 = aLow + i == 0 ? 		MIN : A[aLow + i - 1];
		int Ai   = aLow + i == A.length ? 	MAX : A[aLow + i];
		
		int Bj_1 = bLow + j == 0 ? 		MIN : B[bLow + j - 1];
		int Bj   = bLow + j == B.length ? 	MAX : B[bLow + j];
		
		if (Bj_1 < Ai && Ai < Bj)
			return Ai;
		else if (Ai_1 < Bj && Bj < Ai)
			return Bj;
		
		assert(Ai < Bj-1 || Bj < Ai_1);
		
		if (Ai < Bj_1) // exclude A[aLow .. i] and A[j..bHigh], k was replaced by k - i - 1
			return kthSmallest(A, aLow + i + 1, aLength - i - 1, B, bLow, j, k - i - 1);
		else // exclude A[i, aHigh] and B[bLow .. j], k was replaced by k - j - 1
			return kthSmallest(A, aLow, i, B, bLow + j + 1, bLength - j - 1, k - j - 1);
	}
	public static void main(String args[])
	{
//	int a[]={3,4,7,9,12,45,87,98};
	//int b[]={0,2,5,99,100,343};
	int a[]={1,2,3,4,5,7};
	int b[]={0,3};
	int k=7;
	for(int i=1;i<a.length+b.length;i++){
	System.out.print(kthSmallest(a,b,i));
	//System.out.print(myownfindk(a,0,a.length-1,b,0,b.length-1,i));
	System.out.println();
	}
	}
	//4 6 9 13  // 1 2 3 3.5
	//ai=1 bi=2  4 bi 3 0
//	k==4
	static int myownfindk(int a[],int as,int ae,int b[],int bs,int be,int k)
	{
		int alen=ae-as+1;
		int blen=be-bs+1;
		//if(alen==0 && blen==0)
		if(k==0)
	if(alen<=0 && blen<=0)
		return Math.max(a[as-1], b[bs-1]);
		int amid=(k-1) *(alen/(alen+blen));
		int bmid=k-amid-1;
		// any given iteration look at only k elements
		int ai=as+amid;
		int bj=bs+bmid;
		
		if(bj>b.length || bj<0)
			return a[ai+k];
		else if(ai>a.length||ai<0)
			return b[bj+k];
	if(ai==0 && bj==0)
		return Math.min(a[ai], b[bj]);
		
		if(a[ai]>b[bj])
			return myownfindk(a,as,ai-1,b,bj+1,bs+k-bj-1,k-bj-1);
		else
			return myownfindk(a,ai+1,as+k-ai-1,b,bs,bj-1,k-ai-1);
			
		
			
		
		
		
	}
	
	
	
}
