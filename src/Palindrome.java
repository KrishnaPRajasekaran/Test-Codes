



	public class Palindrome {
	    public static boolean isPalindrome(String str){
	    	System.out.println(str);
	   
	   //StringBuffer s1=new StringBuffer(str);
	  
	  String s1=str.replaceAll("[^a-zA-Z]","");
	  StringBuffer s=new StringBuffer(s1);
	  
		
		
	     if(s.reverse().toString().equalsIgnoreCase(s1))
	         return true;
	      else
	          return false;
	    }

	    public static void main(String[] args) {
	        System.out.println(isPalindrome("Noel sees Leon."));
	    }
	}
