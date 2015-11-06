import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.ListIterator;

import org.junit.rules.ErrorCollector;
import org.junit.rules.Verifier;
class TestCollections
{
	public static void main(String args[]){
		Integer arr[]={1,2,3,4,5,2};
		for(Integer num:arr)
			System.out.println(num);
	ArrayList<Integer> a=new ArrayList<Integer>(Arrays.asList(arr));
	System.out.println(a);
	Enumeration<Integer> e=Collections.enumeration(a);
	while(e.hasMoreElements())
	System.out.println(e.nextElement());
	arr[0].intValue();
	ListIterator<Integer> l=a.listIterator();
	
	l.nextIndex();
	
	l.next();
	l.previousIndex();
	ArrayList<Integer> aa=new ArrayList<Integer>(Collections.nCopies(5, 10));
	ArrayList<Object> b=new ArrayList<Object>();
	b.addAll(aa);
	//LinkedList<Integer> kk=new LinkedList<Integer>();
	int ta[]={1,2,3,4,5,2};
	Collections.synchronizedCollection(a);
	synchronized(a){
		System.out.println(a);
	}
	System.out.println(Collections.binarySearch(a, new Integer(2)));
	System.out.println(Arrays.binarySearch(ta, 5));
	//a.remove(Integer.valueOf(2));
	a.removeAll(Arrays.asList(new Integer(2)));
	System.out.println(a);
	//int t=a.toArray();
	
	
	
	}
}