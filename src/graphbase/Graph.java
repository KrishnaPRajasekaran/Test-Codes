package graphbase;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
int V=0;
int E=0;
boolean marked[];
int pathTo[];
ArrayList<Integer> adj[];
Graph(){			
	//this.V=V;

loadData();
marked=new boolean[V];
pathTo=new int[V];

}
void loadData(){
	BufferedReader bf = null;
	try{
	bf=new BufferedReader(new FileReader(new File("C:\\Users\\9rajas7\\workspace\\Test Codes\\src\\graphbase\\tiny.txt")));
	this.V=Integer.parseInt(bf.readLine());
	this.E=Integer.parseInt(bf.readLine());
	adj=(ArrayList<Integer>[]) new ArrayList[V];
	for(int i=0;i<V;i++)
	{
		adj[i]=new ArrayList<Integer>();
		
		String input=bf.readLine();
		for(String single:input.split(" "))
			adj[i].add(Integer.parseInt(single));
			}
	}catch(IOException e){
		System.out.println(e);
	}finally{
		try{
	bf.close();
		}catch(Exception e){}
	}
	
}
int maxDegree()
{
	int max=0;
	for(int v=0;v<V;v++){
	if(adj[v].size()>max)
		max=adj[v].size();
	}
	return max;
}
int numberofselfloops(){
int count=0;
for(int v=0;v<V;v++)
	for(Integer w:adj[v])
		if(v==w){
			count++;
		System.out.println(v);
		}
return count;
}
void dfs(){

	for(int v=0;v<V;v++)
	if(!marked[v])
		dfs(v);
	System.out.println();
}
void dfs(int v)
{
	marked[v]=true;
	System.out.print(v+" ");
	for(Integer w:adj[v])
		if(!marked[w]){
		
			dfs(w);
		}
}
void dfsStack(int v){ //to get path or connected
	int next=-1;
	Deque<Integer> s=new ArrayDeque<Integer>();
	boolean marked[]=new boolean[V];
	//for(int v=0;v<V;v++){
		//if(!marked[v]){
			s.push(v);
			//if(v!=0)
				//System.out.println(v+" is not connected to source");
	while(!s.isEmpty()){
		
		int prev=next;
		next=s.pop();
		pathTo[next]=prev;
		if(!marked[next]){
		marked[next]=true;
		
		System.out.print(next+" ");}
		for(Integer w:adj[next])
			if(!marked[w])
				s.push(w);
	}
	//}}
	System.out.println();
}
void paralleledges(){
	
	for(int v=0;v<V;v++){
		boolean marked[]=new boolean[V];
		for(Integer w:adj[v])
		{			if(marked[w]){
				System.out.println(v+"->"+w);
			}
		marked[w]=true;
	}}
	
	
}
void printpath(int w){
	if(!marked[w]){
		System.out.println("Not connected");
	return;}
	int v=w;
	for(;v!=0;v=pathTo[v]){
		System.out.print(v+"<-");
	}
	System.out.println(v);
}

void bfs(int v){
	Queue<Integer> q=new ArrayDeque<Integer>();
	q.offer(v);
	pathTo=new int[V];
	marked=new boolean[V];
	marked[0]=true;
	pathTo[0]=-1;
	while(!q.isEmpty()){
		int next=q.poll();
		
		//marked[next]=true;
		System.out.print(next+" ");
		for(int w:adj[next])
		{
			if(!marked[w]){
				q.offer(w);
				pathTo[w]=next;
				marked[w]=true;
			}
		}
		
	}
	System.out.println();
}
public static void main(String args[]){
	Graph g=new Graph();
	System.out.println("max degree of vertex:"+g.maxDegree());
	System.out.println("Number of self loops:"+g.numberofselfloops());
	g.paralleledges();
	g.dfs();
	g.dfsStack(0);
	g.printpath(4);
	g.bfs(0);
	g.printpath(1);
}
}
