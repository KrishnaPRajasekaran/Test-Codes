package algorithms;

public class power {
static int powerfind(int a,int n)
{
	int temp;
	if(n==0)
		return 1;
	if(n%2==0){
		temp=powerfind(a,n/2);
	return temp*temp;}
	else{
		temp= powerfind(a,n/2);
		return temp*temp*a;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(powerfind(2,3));
	}

}
