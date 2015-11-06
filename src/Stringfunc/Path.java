package Stringfunc;

import java.util.Arrays;
import java.util.ArrayList;
public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Path cd(String newPath) {
      
      //if(newPath.indexOf("..")!=0 || newPath.indexOf("..")!=-1)
        //return null;
      String pathsplit[]=path.split("/");
      String newpathsplit[]=newPath.split("/");
       ArrayList<String> pathls=new ArrayList<String>(Arrays.asList(pathsplit));
       ArrayList<String> newpathls=new ArrayList<String>(Arrays.asList(newpathsplit));
       while(newpathls.size()>0){
           if(newpathls.get(0).equals(".."))
               pathls.remove(pathls.size()-1);
    		else
                pathls.add(newpathls.get(0));
           newpathls.remove(0);
                
                     
       }
        String result="";
                 for(String s:pathls)
                     if(!s.equals(""))
                     result=result+"/"+s;
        return new Path(result);
    }
                                        
    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        System.out.println(path.cd("../x").cd("g/h").getPath());
    }
}
