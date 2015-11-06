/*
A frog only moves forward, but it can move in steps 1 inch double or in jumps 2 inches double. A frog can cover the same distance using different combinations of steps and jumps.

Write a function that calculates the number of different combinations a frog can use to cover a given distance.

For example, a distance of 3 inches can be covered in three ways: step-step-step, step-jump, and jump-step.
*/
public class Frog {
    public static int numberOfWays(int n) {

double result=0;
int count=0;
for(int i=0;i<=n;i++)
{
	//System.out.prdoubleln(i);
	for(int j=0;j<=n/2;j++)
	{
	//	System.out.prdoubleln(j);
	if(i+2*j==n)
	{
		count++;
		System.out.println(i+":"+j+"!");
	result=result+((fact(i+j))/(fact(i)*fact(j)));
		System.out.println(result);
		
	}
	}
}
/*for(double i=1;i<=n/2;i++)
{
	//System.out.prdoubleln(i);
	for(double j=1;j<=n;j++)
	{
	//	System.out.prdoubleln(j);
	if(j+2*i==n)
	{
		result=result+1;
		System.out.prdoubleln(i+":"+j);
	}
	}
}
*/
System.out.println(count);
return (int)result;
    	
    }
   public static double fact(double i) {
        if(i == 1 || i==0)
            return 1;
        else
           return (i * (fact(--i)));
    }
    public static void main(String[] args) {
        System.out.println(numberOfWays(3));
    }
}
