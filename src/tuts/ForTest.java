package tuts;
public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// file name: Main.java
		outer:
		     //label for outer loop
		    for (int i = 0; i < 10; i++) { 
		      for (int j = 0; j < 10; j++) {
		        if (j == 1)
		          break outer;
		        System.out.println(" value of j = " + j);
		      }
		    } //end of outer loop
		  
		    System.out.println("clear");
		    System.out.println(Integer.MAX_VALUE);
	}

}
