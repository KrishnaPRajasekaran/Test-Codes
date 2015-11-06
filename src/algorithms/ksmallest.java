package algorithms;

public class ksmallest {
	static int ksmallest(int a[],int alow,int alength,int b[],int blow,int blength,int k){
		if(alength==0)
			return b[blow+k];
		else if(blength==0)
			return a[alow+k];
		int i=(k-1)*alength/(alength+blength);
		int j=k-1-i;
	
		//i+j=k-1 i number of element and j number of elements are considered.  1 2 3  4 6  so to find 4th smallest we will consider 5 elements  1 2 3  4 6 if 3<4 1 2 3 is part of the soltuion  so we have just 4 and 6 to consider and 4 is the smallest element
		
		int ai1=i==0?Integer.MIN_VALUE:a[alow+i-1];
		int bj1=j==0?Integer.MIN_VALUE:b[blow+j-1];
		int ai=alow+i==a.length?Integer.MAX_VALUE:a[alow+i];
		int bj=blow+j==b.length?Integer.MAX_VALUE:b[blow+j];
		if(bj1<ai && ai<bj)
			return ai;
		if(ai1<bj && bj<ai)
			return bj;
		if(ai<bj1) //exclude alow to i  bj to bhigh
			return ksmallest(a,alow+i+1,alength-i-1,b,blow,bj,k-i-1);
		else//exclude alow+i+1 to alen blow to bj
			return ksmallest(a,alow,ai,b,blow+j+1,blength-j-1,k-j-1);
				
		
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a[]={1,2,3,4,5,6};
int b[]={0,3};
for(int i=1;i<=a.length+b.length;i++)
System.out.println(ksmallest(a,0,a.length,b,0,b.length,i));
	}

}
