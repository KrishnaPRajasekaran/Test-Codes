package tuts;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

class Stack<E extends Object> implements Iterable<E> {

private int sizeconstraint=0;
private int counter=-1;

private E a[];
Stack(){
	
	a=(E[])new Object[2];
	
}
Stack(int n)
{
	sizeconstraint=n;
}
public boolean push(E e)
{
	if(counter<a.length-1)
	a[++counter]=e;
	else
	return false;
	return true;	
	
}
public E pop()
{
	if(counter>-1 && counter<a.length)
	return a[counter--];
	throw new NullPointerException();
//return null;
}

public List<E> toList()
{
	return Arrays.asList(a);
}

public Iterator<E> iterator(){
	return new myiterator();
}
class myiterator implements Iterator<E>
{
	private int it=-1;
@Override
public boolean hasNext() {
	// TODO Auto-generated method stub
if(it+1<a.length)
	return true;
return false;
}
@Override
public E next() {
	// TODO Auto-generated method stub
	return a[++it];
}
@Override
public void remove()
{
	
	
	throw new UnsupportedOperationException();


}
}
}
