package algorithms;



public class EvaluateDeluxe {
static String Evaluate(String input){
String temp[]=input.split("[^0-9]");
return temp[0]+temp[1];
}
public static void main(String args[])
{
	System.out.println(Evaluate("3*5+1/4"));
}
}
