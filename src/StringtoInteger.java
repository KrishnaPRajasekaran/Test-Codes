
public class StringtoInteger {
public static void main(String args[]){
	Integer i=null;
	String s="111111111111111111111";
	try{
	 i=(int)Double.parseDouble(s);
	}catch(NumberFormatException e){
		
	}
	System.out.println(i);
}
}
