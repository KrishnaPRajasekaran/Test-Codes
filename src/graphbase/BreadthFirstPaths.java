package graphbase;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths {
int pathto[];
int distto[];
int source;
boolean marked[];
	BreadthFirstPaths(Graph g){
	pathto=new int[g.V];
	marked=new boolean[g.V];
	distto=new int[g.V];
}
void bfs(Graph g,int source){
	Queue<Integer> q=new LinkedList<Integer>();
	q.offer(source);
	while(!q.isEmpty()){
		int v=q.poll();
		marked[v]=true;
		for(int w:g.adj[v]){
			if(!marked[w]){
				pathto[w]=v;
				
				q.offer(w);
				distto[w]=distto[v]+1;
			}
		}
	}
}
void printpath(int t){
	if(!marked[t])
		System.out.println("No path");
	else{
	for(int v=t;v!=source;v=pathto[v])
		System.out.print(v+"<-");
	System.out.println(source);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Graph g=new Graph();
BreadthFirstPaths b=new BreadthFirstPaths(g);
b.bfs(g, 0);
int target=9;
b.printpath(target);
System.out.println(b.distto[target]);
	}

}
