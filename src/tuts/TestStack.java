package tuts;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestStack
{
	static Stack<Object> s;

@BeforeClass
public static void setUp()
{
	s=new Stack<Object>();

}

@Rule
public ExpectedException e=ExpectedException.none();
@Test
public void testItempushpopMethod()
{

assertTrue(s.push(null));
assertThat("HAS ADDED Item",s.toList(),hasItem(nullValue()));

assertThat("Removed value",s.pop(),is(nullValue()));
assertThat(s.push("abc"),is(true));
assertThat(s.push(1),is(true));
assertThat("Unable to remove value",s.pop(),is(1));
e.expect(NullPointerException.class);

s.pop();
e.expect(NullPointerException.class);

s.pop();
}

@Test
public void testExcpetionRule()
{
     NullPointerException expectedCause = new NullPointerException();
	    e.expectCause(is(expectedCause));
	     throw new IllegalArgumentException("What happened?",expectedCause);
}

@Rule
public ErrorCollector err=new ErrorCollector();
@Test

public void testErrorCollector()
{
	err.checkThat(1, equalTo(2));
	int a=5;
	err.checkThat(2, equalTo(3));
	err.addError(new NullPointerException());
//	System.out.println(err.toString());
}
}
