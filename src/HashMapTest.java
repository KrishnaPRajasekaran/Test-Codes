import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.ArrayList;

public class HashMapTest {
public static void main(String arg[]){
	HashMap<Integer,String> hm=new HashMap<Integer,String>();
	hm.put(1, "Krishna");
	hm.put(2, "Vasu");
	hm.put(3, "Kalyani");
	hm.put(null,null);
	hm.put(1,"Prashanth");
	
	Set<Entry<Integer, String>> s1=hm.entrySet();
	Iterator<Entry<Integer,String>> m=s1.iterator();
	while(m.hasNext()){
	Entry<Integer,String> e=m.next();
		System.out.println(e.getKey()+":"+e.getValue());
	}
	
	hm.remove(null);
	Hashtable<Integer,String> ht=new Hashtable<Integer,String>();
	ht.putAll(hm);
	s1=ht.entrySet();
		m=s1.iterator();
		while(m.hasNext()){
		Entry<Integer,String> e=m.next();
			System.out.println(e.getKey()+":"+e.getValue());
		}
	Set<Integer> s=hm.keySet();
for( Integer num:s)	
	System.out.println(num);
ArrayList<String> al=new ArrayList<String>(hm.values());
Enumeration<String> e=Collections.enumeration(al);
while(e.hasMoreElements())
{
System.out.println(e.nextElement());	
}
//@SuppressWarnings("unchecked")
@SuppressWarnings("unchecked")
HashMap<Integer,String> p=(HashMap<Integer, String>)hm.clone();
for(Entry<Integer,String> me:p.entrySet())
	System.out.println(me.getKey() +":" +me.getValue());


}



}
