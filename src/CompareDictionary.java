
public class CompareDictionary {
public static void main(String args[])
{
	String input[]={"caterer","base","basement","basepy","cs","areanet","12","child","are","care"};

	String dic[]={"are","area","base","cat","cater","children","basement"};
	
	for(String inp:input)
	System.out.println("Longest prefix is "+findprefix(dic,inp));
}
static String findprefix(String dic[],String input){
	String prefix="Empty";
	String temp1;
	int max=0;
	
	for(int i=0;i<dic.length;i++)
	{
		temp1="";
		if(input.length()>=dic[i].length())
		{
			temp1=input.substring(0,dic[i].length());
			
			if((temp1.replaceFirst(dic[i],"").length()==0) && dic[i].length()>max){
				max=dic[i].length();
				prefix=dic[i];
			}
			
		}
	}
	return prefix;

}
}
