package graphbase;

import java.util.ArrayDeque;
import java.util.Deque;

public class DCycle {
	boolean marked[];
	int edgeto[];
	Deque<Integer> cycle;
	int count=-1;
	DCycle(DGraph g){
		marked=new boolean[g.V];
		edgeto=new int[g.V];
		
		dfs(g,-1,0);
		
	}
	void isSelfLoop(DGraph g){
		for(int v=0;v<g.V;v++){
			if(g.adj[v].contains(v))
				System.out.println(v+" is a self loop");
		}
	}
	void paralleledges(DGraph g){
		marked=new boolean[g.V];
		
		for(int v=0;v<g.V;v++){
			marked=new boolean[g.V];
			for(int w:g.adj[v])
				if(marked[w]){        
					cycle=new ArrayDeque<Integer>();
					cycle.push(v);
					cycle.push(w);
					cycle.push(v);
					return;
				}
		marked=null;
		}
	}
	void dfs(DGraph g,int u,int v){
		marked[v]=true;
		for(int w:g.adj[v])
		{
			
			if(!marked[w]){
				edgeto[w]=v;
				dfs(g,v,w);
				
			}
			else//w!=u eradicates back edges cuz v-w and w-v can form a cycle. and w!=v eradicates self loops
			{
				if(cycle!=null) 
						return;
				cycle=new ArrayDeque<Integer>();
				for(int x=v;x!=w;x=edgeto[x])
				cycle.push(x);
				cycle.push(w);
				cycle.push(v);
				System.out.println("found cycle");
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DGraph g=new DGraph();
		DCycle c=new DCycle(g);
		c.isSelfLoop(g);
		
		c.cycle.forEach(e->System.out.println(e+" "));
	}

}
