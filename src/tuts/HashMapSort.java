package tuts;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSort {
public static void main(String arg[]){
	Integer ij=10;
	System.out.println(ij.intValue());
	
	
	HashMap<Integer,String> hm=new HashMap<Integer,String>();
	hm.put(10,"A");
	hm.put(5, "B");
	hm.put(15,"J");
	hm.put(12,"Z");
	
Set<Map.Entry<Integer, String>> s=hm.entrySet();
Iterator<Entry<Integer, String>> i=s.iterator();
while(i.hasNext())
{
	Map.Entry<Integer,String> m=(Map.Entry<Integer, String>)i.next();
	System.out.println(m.getKey()+":"+m.getValue());
	
}
sortHashMap(hm);
Enumeration<Entry<Integer, String>> e=Collections.enumeration(hm.entrySet());
while(e.hasMoreElements()){
Entry<Integer, String> m=(Map.Entry<Integer, String>)e.nextElement();
System.out.println(m.getKey()+":"+m.getValue());
}
}

@SuppressWarnings("unchecked")
static HashMap sortHashMap(HashMap<Integer, String> m){
	List<Entry<Integer, String>> list=new LinkedList<Map.Entry<Integer,String>>(m.entrySet());
	
	Collections.sort(list,new Comparator(){
	
		public int compare(Object o1,Object o2){
			//System.out.println(((Map.Entry<Integer, String>)o1).getValue());
			return ((Map.Entry<Integer, String>)o1).getValue().compareToIgnoreCase(((Map.Entry<Integer,String>)o2).getValue());
		}
		
	});
	
	HashMap sortedHashMap=new LinkedHashMap();
	for(Iterator it=list.iterator();it.hasNext();)
	{
		Map.Entry m1=(Map.Entry)it.next();
		sortedHashMap.put(m1.getKey(), m1.getValue());
		
	}
	return sortedHashMap;
}
}

