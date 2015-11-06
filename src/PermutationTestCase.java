import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;









import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.hamcrest.core.CombinableMatcher;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Ignore;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Category(ParameterTest.class)
public class PermutationTestCase
{
@Ignore
	@Test
	public void assertPermutation()
	{
		int a[]={1,2,3};
		ArrayList<ArrayList<Integer>> expected=new ArrayList<ArrayList<Integer>>();
		
		expected.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		expected.add(new ArrayList<Integer>(Arrays.asList(1,3,2)));
		expected.add(new ArrayList<Integer>(Arrays.asList(2,1,3)));
		expected.add(new ArrayList<Integer>(Arrays.asList(2,3,1)));
		expected.add(new ArrayList<Integer>(Arrays.asList(3,1,2)));
		expected.add(new ArrayList<Integer>(Arrays.asList(3,2,1)));
		String c="123";
		
		//expected.toArray(b);
		//System.out.println(b);
ArrayList<ArrayList<Integer>> actual=Permutationofarray.permute(a);

	assertEquals(expected.size(),actual.size());
//for(ArrayList<Integer> b:expected)
	//(2+2,is(4));
	assertThat("4",is(equalTo("4")));
	assertEquals(4,4);
	//assertThat(7,not(CombinableMatcher<Integer>.either(equalTo(3)).or(equalTo(4))));
		//assertThat("Collection doesn't contain",actual,IsCollectionContaining.hasItems(expected.get(0),expected.get(1)));
		assertThat("Collection doesn't contain",actual,hasItem(expected.get(0)));
		//	ArrayList<ArrayList<Integer>> c=new ArrayList<ArrayList<Integer>>(expected);
	//	org.junit.Assert.assertThat("Validate two ArrayList", Permutationofarray.permute(a),expected );
	assertThat("Collection size mismatch",actual,is(hasItem(expected.get(0))));
assertTrue(actual.size()>1);

	
	try{
	assertThat("Collection match",actual,equalTo(expected));
	}catch(AssertionError e)
	{
		System.out.println("Verifying size");
		assertThat("Collection Size",actual.size(),equalTo(expected.size()));
	}
	}


@Test
@Ignore
public void testMatchers()
{
	Assert.assertEquals(1,1);
	Assert.assertArrayEquals(new int[]{1,2,3,4,5},new int[]{1,2,3,4,5});
	String s[]={"a1b","b2c"};
	
	assertThat(Arrays.asList(s),either(hasItem("a1b")).or(hasItem("b1")));
	assertThat(Arrays.asList(s),everyItem(containsString("b")));
	assertThat("abc",both(containsString("a")).and(containsString("b")));
	assertThat("abc",equalTo("abc"));
	assertThat(null,nullValue());
	assertThat(null,notNullValue());
	
}
@Ignore
	@Test(timeout=10000)
	public void TestImagecache()
	{
		int n=15;
		ArrayList<String> urllist=new ArrayList<String>();
		//urllist.add(null);
		//urllist.add("");
		for(int i=0;i<n;i++){
			
		for(int j=0;j<=i;j++)
			urllist.add("URL"+(i+1));
		}
		
		String s[]=new String[n/2 * (n+1)];
		s=urllist.toArray(s);
		System.out.println(s[0]);
		Imagecache im=new Imagecache();
		
		List<Map.Entry<String,Integer>> l=im.topsites(s);
		for(Map.Entry<String,Integer> c:l)
		{
			assertThat("Item mismatch:",c.getKey(),both(containsString("URL")).and(containsString((String.valueOf(n)))));
			n=n-1;
		}
		
		System.out.println(File.separatorChar);
	}
	@Rule
	public ExpectedException e=ExpectedException.none();
	@Rule
	public TemporaryFolder temp=new TemporaryFolder();
	@Rule
	public ErrorCollector collector=new ErrorCollector();
	@Test
	public void TestTempFolder() throws IOException
	{
		
		temp.newFolder("Test","Test1");
	//	e.expect(IOException.class);
		assertEquals(1,2);
		collector.checkThat("test", is(equalTo("1")));
		collector.checkThat(1,is(2));
	System.out.println(1);
	}
		
	}
	
