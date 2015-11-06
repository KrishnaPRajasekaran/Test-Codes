package dp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
class lngsubstrkunq
{

public static void main(String args[])
{
String input="abcbbbbcccbdddadacbkkkkkkkkkkkkkkkkk";
int k=2;
int start=0;
String result="";
LinkedHashMap<Character,Integer> hm=new LinkedHashMap<Character,Integer>();
int max=0;
ArrayList<Character> al=new ArrayList<Character>();

for(int i=0;i<input.length();i++)
{
char ch=input.charAt(i);
if(hm.containsKey(ch)){
hm.put(ch,i);

}else
{
if(hm.size()==k){
System.out.println(input.substring(start,i));
if(input.substring(start,i).length()>result.length())
result=input.substring(start,i);
start=hm.get(al.get(0))+1;
hm.remove(al.get(0));
al.remove(0);

}
hm.put(ch,i);
al.add(ch);
}

}

System.out.println(result);
}

}