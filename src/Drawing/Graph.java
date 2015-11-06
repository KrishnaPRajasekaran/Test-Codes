package Drawing;

import java.io.FileReader;
import java.util.Queue;
import java.util.ArrayDeque;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Deque;

class Graph
{
int V;
ArrayList<Integer> adj[];
int edgeTo[];
int id;
int count;
boolean visited[];
Queue<Integer> pre;
Queue<Integer> post;
Deque<Integer> topo;
boolean recursionstack[];
@SuppressWarnings("unchecked")
Graph(File f) throws Exception
{
BufferedReader br=new BufferedReader(new FileReader(f));
V=Integer.parseInt(br.readLine());
adj=(ArrayList<Integer>[])new ArrayList[V];
edgeTo=new int[V];
visited=new boolean[V];
recursionstack=new boolean[V];
String temp;
pre=new ArrayDeque<Integer>();
post=new ArrayDeque<Integer>();
topo=new ArrayDeque<Integer>();

for(int i=0;i<V;i++)
{
temp=br.readLine();
adj[i]=new ArrayList<Integer>();
if(!temp.trim().equals(""))
for(String s:temp.split(" ")){
adj[i].add(Integer.parseInt(s));
System.out.print(s+" ");
}
System.out.println();
}
br.close();
bfs(0,2);
dfs();
}

void bfs(int source,int destination){
System.out.println("Started bfs");
Queue<Integer> q=new ArrayDeque<Integer>();
q.add(source);
boolean visited[]=new boolean[V];
System.out.println(visited[source]);
visited[source]=true;
while(!q.isEmpty()){
int v=q.remove();
System.out.print(v+" ");
for(int w:adj[v]){
if(v!=w && visited[w]==false)
{
q.add(w);
visited[w]=true;
edgeTo[w]=v;
}
}
}
}

void dfs(){
count=0;
System.out.println();
for(int v=0;v<V;v++)
{
if(!visited[v]){
dfs(v);
count++;
}
}
System.out.println("Number of components: "+count);
}
void dfs(int source)
{
	
recursionstack[source]=true;
visited[source]=true;
pre.add(source);
System.out.print(source+" ");
for(int w:adj[source]){
if(!visited[w]){
edgeTo[w]=source;

dfs(w);

}else if(recursionstack[w]){
	System.out.println("Cycle detected");
System.out.print(w+" ");
for(int i=source;(i!=w) ;i=edgeTo[i])
System.out.print(i+" ");
System.out.print(w);
System.out.println();
}}
post.add(source);
topo.push(source);
recursionstack[source]=false;
}
public static void main(String arg[]) throws Exception
{
File f=new File("C:/Users/9rajas7/workspace/Test Codes/src/graphbase/mytest.txt");
Graph g=new Graph(f);
System.out.print("PRE:");
for(int w:g.pre)
System.out.print(w+" ");
System.out.println();
System.out.print("POST:");
for(Integer w:g.post)
System.out.print(w+" ");
System.out.println();
System.out.print("TOPO:");
for(int w:g.topo)
System.out.print(w+" ");

System.out.println();
}
}
