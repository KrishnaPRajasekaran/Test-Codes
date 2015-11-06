package algorithms;
public class AnagramTest {
    public static boolean areAnagrams(String a, String b) {
    	
        if(a.length()!=b.length())
        return false;
		char[] t1=a.toCharArray();   
    	char t2[]=b.toCharArray();
         int s1[]=new int[a.length()];
        int s2[]=new int[a.length()];
        for(int i=0;i<a.length();i++)
            {
            s1[i]=1;
            s2[i]=1;
        }
         for(int i=0;i<t1.length;i++)
            for(int j=0;j<t2.length;j++)
            {
            	if(s2[j]==0)
            		continue;
             if(t1[i]==t2[j])
                 {
                 s1[i]=0;
                 s2[j]=0; 
                 
                 System.out.println(t1[i]+":"+t2[j]+" "+i+":"+j);
                 break;
             }
         }
    for(int i=0;i<a.length();i++)
        {
        if(s1[i]!=0){
         System.out.println(i);
        	return false;
        }
    }
    return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("abccdef", "fddcbae"));
     
    }
}