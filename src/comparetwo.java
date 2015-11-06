import java.util.HashMap;
import java.util.Arrays;


public class comparetwo {

public static void main(String args[])
{
	int a[]={1,2,3,3};
	int b[]={1,2,2,3};
	HashMap<Integer,Integer> ab=new HashMap<Integer,Integer>();
	HashMap<Integer,Integer> bb=new HashMap<Integer,Integer>();
	for(int i=0;i<a.length;i++)
	{
		if(ab.containsKey(a[i]))
			ab.put(a[i],ab.get(a[i]));
		else
			ab.put(a[i],1);
		if(bb.containsKey(b[i]))
			bb.put(b[i],bb.get(b[i]));
		else
			bb.put(b[i],1);
	}
	
	System.out.println(Integer.MIN_VALUE);
	
}
}
