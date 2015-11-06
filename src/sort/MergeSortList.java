package sort;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;
public class MergeSortList<E> implements Comparator<E>{
public int compare(Object o1,Object o2)
{
	if(o1 instanceof String)
		return ((String)o1).compareToIgnoreCase((String)o2);
	else if(o1 instanceof Double)
		return ((Double)o1).compareTo((Double)o2);
	else if(o1 instanceof Integer)
		return ((Integer)o1).compareTo((Integer)o2);
	else
		return 0;
	
}
	 List<E> sort(List<E> list, int low, int high){
	if(high-low<0)
		return Collections.emptyList();
	if(high-low==0){
		List<E> result= new ArrayList<E>();
		result.add(list.get(low));
	return result;
	}
	int middle=low+(high-low)/2;
	
	return merge(sort(list,low,middle),sort(list,middle+1,high));
	
	
}
 List<E> merge(List<E> left,List<E> right){
	List<E> result=new ArrayList<E>();
	while(!left.isEmpty() && !right.isEmpty())
	{
		//compare(left.get(0))
	if(compare(left.get(0), right.get(0))<=0){
		//if(left.get(0)<=right.get(0)){
			result.add(left.get(0));
			left.remove(0);
		}
		else{
			result.add(right.get(0));
			right.remove(0);
		}
	}
	
while(!left.isEmpty()){
	result.add(left.get(0));
left.remove(0);
}
while(!right.isEmpty()){
	result.add(right.get(0));
	right.remove(0);
}
return result;
}
public static void main(String args[])
{
List<Integer> list=new ArrayList<Integer>();
MergeSortList ms=new MergeSortList();

Random r=new Random();
for(int i=0;i<10;i++){
	list.add(r.nextInt(50));
//System.out.println(list.get(i));
}
System.out.println(list);

List<Integer> result=ms.sort(list,0,list.size()-1);
System.out.println(result);

List<String> list1=new ArrayList<String>();
for(int i=0;i<10;i++)
{
	StringBuffer sb=new StringBuffer();
	for(int j=0;j<1+r.nextInt(10);j++)
		sb.append((char)(65+r.nextInt(26)));
list1.add(sb.toString());
}
list1.add("123");
list1.add("23$");
System.out.println(list1);
List<String> result1=ms.sort(list1,0,list1.size()-1);

System.out.println(result1);
List<Object> emptytest=Collections.emptyList();
System.out.println(emptytest.size());
System.out.println(ms.sort(emptytest,emptytest.size(),emptytest.size()-1));
}
}
