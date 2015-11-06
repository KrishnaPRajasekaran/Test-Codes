package tuts;

import java.lang.reflect.Field;

public class Mutation {
final int testvariable=1;
	public static void main(String[] args) throws NoSuchFieldException, RuntimeException, IllegalAccessException {
		// TODO Auto-generated method stub
		Mutation m=new Mutation();
Field f=Mutation.class.getDeclaredField("testvariable");

f.setAccessible(true);
f.set(new Integer(3),2);
int a=0;
System.out.println(Mutation.class.getDeclaredField("testvariable"));

System.out.println(f.get(m));
System.out.println(m.testvariable);


	}

}
