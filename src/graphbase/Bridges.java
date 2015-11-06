package graphbase;

import java.util.Arrays;
import java.util.Collections;

public class Bridges {
	private boolean marked[];
	private int low[];
	private int pre[];
	private int count=0;
	Bridges(Graph g){
		low=new int[g.V];
		pre=new int[g.V];
	}
void dfs(Graph g,int u, int v){
	int children=0;
pre[v]=count++;
//System.out.println(v+"= "+(count-1));
low[v]=pre[v];
	for(int w:g.adj[v]){
		if(pre[w]==-1){
			children++;
			dfs(g,v,w);
		low[v]=Math.min(low[v],low[w]);
		if(low[w]==pre[w]);
			//System.out.println(v+":"+w+" is a bridge");
		if(low[w]>=pre[v] && u!=v)
			System.out.println(v+"articulation");
			
		
		}else if(w!=u)
		low[v]=Math.min(low[v],pre[w]);
	}
	if(children>1 && u==v)
		System.out.println(u+"articulation");
}
void dfs(Graph g){
	pre=new int[g.V];
	low=new int[g.V];
	for(int i=0;i<g.V;i++){
		pre[i]=-1;
		low[i]=-1;
				
	}
	for(int v=0;v<g.V;v++)
	{
		if(pre[v]==-1)
			dfs(g,v,v);
		
	}
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
Graph g=new Graph();
Bridges b=new Bridges(g);
b.dfs(g);




	}

}
