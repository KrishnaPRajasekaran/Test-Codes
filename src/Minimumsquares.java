
public class Minimumsquares {
public static void main(String args[]){
	int sum=100;
System.out.println("Minimum number of squares:"+sq(sum));
}
static int sq(int sum){
	if(sum==0){
		//
		return 0;
	}
	if(sum==1){
		System.out.println(1);
		return 1;
	}
	System.out.print((int)Math.floor(Math.sqrt(sum))+",");
	return 1+sq(sum-(((int)Math.floor(Math.sqrt(sum)))*((int)Math.floor(Math.sqrt(sum)))));
 
}
}
