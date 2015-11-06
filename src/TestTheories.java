import junit.framework.Assert;

import org.junit.Assume;
import org.junit.runner.RunWith;
import org.junit.experimental.theories.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
@RunWith(Theories.class)
public class TestTheories
{
	@DataPoints
	public static int a[]={1,2,3};
	@DataPoint
	public static int b=3;
	
	@Theory
	public void testTheories(int c,int b)
	{
		System.out.println(c+":"+b);
		Assume.assumeTrue(c>0);
		assertTrue(b>0);
	}
	
}