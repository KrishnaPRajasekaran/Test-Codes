package ArrayFunc;

import java.util.Arrays;

public class ReverseArray {

public static void main(String args[]){
char ch[]={'a',97,'\u00ea','c','d'};
String stry=new String(ch);

System.out.println(stry);
int a[]={1,2,3,4,5,6,7,8};
rotateArray(a,3);
System.out.println(Arrays.toString(a));
System.out.println(Integer.MAX_VALUE);
System.out.println(Integer.MIN_VALUE-1);
String s="a1231";
s.indexOf(s, 2);
s.indexOf(4, 2);
System.out.println(s.lastIndexOf(98,1));

String str="abcb";
StringBuilder sb=new StringBuilder(str);
sb.setCharAt(1, 'k');
System.out.println(sb.toString());
long t=(long)Integer.MAX_VALUE+Integer.MAX_VALUE;
System.out.println(t);
}

static void validateinput(int a[],int k){


	if(k<0)
		throw new IllegalArgumentException();
	if(a==null || a.length<1)
		throw new IllegalArgumentException();
}
static void rotateArray(int a[], int k){
validateinput(a, k);
	k=k%a.length;
	reverse(a,0,a.length-1);	
	reverse(a,0,k-1);
	reverse(a,k,a.length-1);
	
}
static void reverse(int a[],int start,int end){

	while(start<end){
		int temp=a[start];
		a[start]=a[end];
		a[end]=temp;
		start++;
		end--;
	}
}

}
