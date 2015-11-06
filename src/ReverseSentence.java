
public class ReverseSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*String str="Reverse words of a sentence";
String arr[]=str.split(" ");
for(int i=arr.length-1;i>=0;i--)
	System.out.print(arr[i]+ " ");
*/
		StringBuilder st;
	String str="forgeeksskeegfor";
	int maxlen=0;
	String maxstr="";
	for(int i=0;i<str.length();i++)
		for(int j=i+2;j<=str.length();j++){
			try{
			st=new StringBuilder(str.substring(i,j));
			st.reverse();
		//	System.out.println(st.toString());
			if(st.toString().equals(str.substring(i,j)) && str.substring(i,j).length()>maxlen)
			{
				maxstr=str.substring(i,j);
				maxlen=str.substring(i,j).length();
			}}
			catch(StringIndexOutOfBoundsException e)
			{
				System.out.println(i);
				System.out.println(j);
			}
		}
	
	System.out.println(maxstr);
}
}
