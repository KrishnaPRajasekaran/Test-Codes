package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Stringsort {
public static void main(String args[])
{
	String input="google";
	String ord="dog";
	System.out.println(sort(input,ord));
}
static String sort(String input,String order)
{
	HashMap<String,Integer> hmorder=new HashMap<String,Integer>();
	String ordarr[]=order.split("");
	String inputarr[]=input.split("");
	for(String single:ordarr)
	{
		if(hmorder.get(single)==null)
			hmorder.put(single,hmorder.size());
	}
	//loaded order string
	//LinkedHashMap<String,Integer> hmreq=new LinkedHashMap<String,Integer>();
	SortedMap<String,Integer> hmreq=new TreeMap<String, Integer>(new Comparator<String>(){

		@Override
		public int compare(String arg0, String arg1) {
		
			// TODO Auto-generated method stub
			if(hmorder.get(arg0)>hmorder.get(arg1))
				return 1;
			else if(hmorder.get(arg0)<hmorder.get(arg1))
				return -1;
			else
				return 0;
		}
		
	});
	ArrayList<String> al=new ArrayList<String>();
	String remaining="";
	for(String single:inputarr)
	{
	
		if(hmorder.get(single)!=null){
			al.add(single);
			if(hmreq.get(single)==null){
				hmreq.put(single, 1);
				
			}else
				hmreq.put(single,hmreq.get(single)+1);
			
			
		}else{
			remaining=remaining+single;
		}
			
	}
	Collections.sort(al,new Comparator<String>(){

		@Override
		public int compare(String arg0, String arg1) {
		
			// TODO Auto-generated method stub
			if(hmorder.get(arg0)>hmorder.get(arg1))
				return 1;
			else if(hmorder.get(arg0)<hmorder.get(arg1))
				return -1;
			else
				return 0;
		}
		
	});
	String actual="";
	Set<Entry<String, Integer>> res=hmreq.entrySet();
	for(Entry<String,Integer> em:res){
		for(int i=0;i<em.getValue();i++)
			actual=actual+em.getKey();
	}
	String temp="";
	for(String single:al)
		temp=temp+single;
	System.out.println(temp+remaining);
	return actual+remaining;
}
}
