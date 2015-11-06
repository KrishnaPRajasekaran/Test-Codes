import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
@RunWith(Parameterized.class)
public class ParameterTest {
@Parameters(name="Parameter Test Data: {index} : test[{0}]={1}")
public static Collection<Object[]> data(){
	//return Arrays.asList(new Object[][]{{1,2}});
	return Arrays.asList(new Object[][]{{1,2}});
}
@Parameter(1)
public int one;
@Parameter(0)
public int two;
@Rule
public TestName nm=new TestName();
	@Ignore
	@Test
	public void oneTest()
	{
		System.out.println(nm.getMethodName());
		assertTrue(one+1==two);
		
	}
	@Test
	public void Teststr(){
		String s="asdfaasdfasas";
		char ch='a';
		int result=0;
		int i=0;
		while((s.indexOf(ch, i))!=-1)
		{
			result++;
			i=s.indexOf(ch,i)+1;
			
		}
		System.out.println(result);
	}
	
}
