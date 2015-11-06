import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;

import java.util.Iterator;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.HashMap;
public class Imagecache{
public List<Map.Entry<String, Integer>> topsites(String urls[]){
if(urls.length==0)
	return null;

ConcurrentHashMap<String,Integer> ht=new ConcurrentHashMap<String,Integer>();


for(String u:urls)
	{
		System.out.println(u);
		
		if(ht.containsKey(u)){
		System.out.println(1);
			ht.put(u, ht.get(u)+1);
		}
		else
			ht.put(u, 1);			
	}
	List<Entry<String, Integer>> list=new LinkedList<Entry<String, Integer>>(ht.entrySet());	
	Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
		@Override
		public int compare(Map.Entry<String, Integer> o1,Map.Entry<String,Integer> o2)
		{
			
		return ((Map.Entry<String,Integer>)o2).getValue().compareTo(((Map.Entry<String,Integer>)o1).getValue());	
		}
	} );
	
	Iterator<Map.Entry<String,Integer>> i=list.iterator();
	int j=0;
		while(i.hasNext()){
		Map.Entry<String, Integer> m=(Entry<String, Integer>) i.next();
		System.out.println("Site: "+m.getKey()+"was visited "+ m.getValue()+" times.");
		if(++j>=10)
			break;
		}
	
	while(i.hasNext())
		list.remove(i.next().getKey());
	return list;
}

}
