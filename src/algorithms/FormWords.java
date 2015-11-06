package algorithms;
public class FormWords {
	static int count=1;
static void printwords(String prefix,String set[],int length){
	count++;
	if(prefix.length()==length)
		System.out.println(prefix);
	else{
	for(int i=0;i<set.length;i++){
		//System.out.println(prefix);
		printwords(prefix+set[i],set,length);
	}
	}
}
	public static void main(String[] args) {
		String set[]={"a","b","c"};
		int len=3;
		//for(int j=1;j<=len;j++)
		printwords("",set,len);
		System.out.println(count);
		count=1;
		String set1[]={"a","b","c","d"};
		int len1=1;
		printwords("",set1,len1);
		String set3[]={"0","1"};
		printwords("",set3,3);
	}

}
