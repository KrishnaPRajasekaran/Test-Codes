package tuts;

import javax.naming.spi.DirStateFactory.Result;

public class Calculate {
public static String calc(String a)
{
	try{
		Integer.parseInt(a);
		return a;
	}catch(NumberFormatException e)
	{
		
	}
	String temp="";
	
	int first=a.lastIndexOf("(");
	int last=a.indexOf(")",first);
	if(first==last && first==-1)
	{
		while(a.indexOf("/")>0)
		{
			int c=a.indexOf("/");
			int firstoperandpos=c;
			int secondoperandpos=c;
			while(firstoperandpos>0 && (Character.isDigit(a.charAt(--firstoperandpos))|| a.charAt(firstoperandpos)=='-'))
					{}
			if(firstoperandpos!=0)
			firstoperandpos++;
			while(secondoperandpos<a.length()-1 && (Character.isDigit(a.charAt(++secondoperandpos))|| a.charAt(secondoperandpos)=='-'))
			{}
			if(secondoperandpos==a.length()-1)
				secondoperandpos++;
				int result=Integer.parseInt(a.substring(firstoperandpos, c))/Integer.parseInt(a.substring(c+1,secondoperandpos));
	a=a.replace(a.substring(firstoperandpos, secondoperandpos),result+"");
	
		}
		while(a.indexOf("*")>0)
		{
			int c=a.indexOf("*");
			int firstoperandpos=c;
			int secondoperandpos=c;
			while(firstoperandpos>0 && (Character.isDigit(a.charAt(--firstoperandpos))|| a.charAt(firstoperandpos)=='-'))
					{}
			if(firstoperandpos!=0)
			firstoperandpos++;
			while(secondoperandpos<a.length()-1 && (Character.isDigit(a.charAt(++secondoperandpos)) || a.charAt(secondoperandpos)=='-'))
			{}
			if(secondoperandpos==a.length()-1)
				secondoperandpos++;
				int result=Integer.parseInt(a.substring(firstoperandpos, c))*Integer.parseInt(a.substring(c+1,secondoperandpos));
	a=a.replace(a.substring(firstoperandpos, secondoperandpos),result+"");
	
		}
		while(a.indexOf("+")>0)
		{
			int c=a.indexOf("+");
			int firstoperandpos=c;
			int secondoperandpos=c;
			while(firstoperandpos>0 && (Character.isDigit(a.charAt(--firstoperandpos))|| a.charAt(secondoperandpos)=='-'))
					{}
			if(firstoperandpos!=0)
			firstoperandpos++;
			while(secondoperandpos<a.length()-1 && (Character.isDigit(a.charAt(++secondoperandpos))|| a.charAt(secondoperandpos)=='-'))
			{}
			if(secondoperandpos==a.length()-1)
				secondoperandpos++;
				int result=Integer.parseInt(a.substring(firstoperandpos, c))+Integer.parseInt(a.substring(c+1,secondoperandpos));
	a=a.replace(a.substring(firstoperandpos, secondoperandpos),result+"");
	
		}
		while(a.indexOf("-")>0)
		{
			int c=a.indexOf("-");
			int firstoperandpos=c;
			int secondoperandpos=c;
			while(firstoperandpos>0 && (Character.isDigit(a.charAt(--firstoperandpos))|| a.charAt(secondoperandpos)=='-'))
					{}
			if(firstoperandpos!=0)
			firstoperandpos++;
			while(secondoperandpos<a.length()-1 && (Character.isDigit(a.charAt(++secondoperandpos))|| a.charAt(secondoperandpos)=='-'))
			{}
			if(secondoperandpos==a.length()-1)
				secondoperandpos++;
				int result=Integer.parseInt(a.substring(firstoperandpos, c))-Integer.parseInt(a.substring(c+1,secondoperandpos));
	a=a.replace(a.substring(firstoperandpos, secondoperandpos),result+"");
	
		}
	
	return a;	
	}else{
		
	temp=a.substring(0,first)+calc(a.substring(first+1, last));
	if(last!=a.length()-1)
	temp=temp+	a.substring(last+1, a.length());
	
	return calc(temp);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(calc("(5+5)*(5-15)/(5+5)"));
System.out.println(calc("-15+5"));
System.out.println(calc("-5*-5"));
System.out.println(calc("5*5+2+(4/2-1)"));

	}

}
