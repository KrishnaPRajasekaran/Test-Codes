package graphbase;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class DirectedDFS {
	int pre[];
	int post[];
	Queue<Integer> preorder;
	Queue<Integer> postorder;
	Stack<Integer> topologicalorder;
	int precounter,postcounter;
	boolean marked[];
DirectedDFS(DGraph g){
	marked=new boolean[g.V];
	pre=new int[g.V];
	post=new int[g.V];
	preorder=new ArrayDeque<Integer>();
	postorder=new ArrayDeque<Integer>();
	topologicalorder=new Stack<Integer>();
	dfs(g,0);
}
void dfs(DGraph g,int v){
	marked[v]=true;
	pre[v]=precounter++;
	preorder.offer(v);
	for(int w:g.adj[v])
	{
		if(!marked[w])
			dfs(g,w);
	}
	post[v]=postcounter++;
	postorder.offer(v);
	
}
Iterable<Integer> reversepost(){
	
	//topologicalorder=new Stack<Integer>();	
	for(int w:postorder)
	{
		topologicalorder.push(w);
	}
	return topologicalorder;
	//	return topologicalorder.iterator();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
DGraph g=new DGraph();
DirectedDFS d=new DirectedDFS(g);
for(Iterator<Integer> i=d.preorder.iterator();i.hasNext();)
{
	System.out.print(i.next()+" ");
}
System.out.println();
for(Iterator<Integer> i=d.postorder.iterator();i.hasNext();)
{
	System.out.print(i.next()+" ");
}
System.out.println();

/*for(Iterator i=d.topologicalorder.iterator();i.hasNext();)
{
	System.out.print(i.next()+" ");
}
System.out.println();*/


	for(int w:d.reversepost())
		System.out.print(w+" ");
	//System.out.println(d.topologicalorder.pop());
	}

}
