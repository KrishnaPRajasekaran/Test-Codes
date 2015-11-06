import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class CommandPrompt {
public static void main(String a[]) throws Exception
{
	Process p = Runtime.getRuntime().exec("ping");
	System.out.println("1");
	 BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    String line = null;
	    while ((line = in.readLine()) != null) 
	       System.out.println(line);
	    in.close();
	   /* BufferedWriter out=new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
	    out.write("java");
	    out.flush();
		out.close();
		    while ((line = in.readLine()) != null) 
		       System.out.println(line);
	    */
	    p.destroy();

}
}
