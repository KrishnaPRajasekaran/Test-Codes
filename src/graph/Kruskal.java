package graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Kruskal {
int V=7;
int spanning[][]=new int[V][V];

	int adj[][]={{0,20,10,0,0,0,30},{0,0,0,10,0,50,0},{0,0,0,0,0,0},{0,0,0,0,10,0,0},{0,0,0,0,0,20,40},{0,0,0,0,0,0},{0,0,0,0,0,0}};
LinkedList<KEdge> edgelist=new LinkedList<KEdge>();
	void createEdges(int adj[][]){
		for(int i=0;i<adj.length;i++)
			for(int j=0;j<adj[i].length;j++){
				if(adj[i][j]!=0){
					edgelist.add(new KEdge(i,j,adj[i][j]));
					adj[j][i]=0;
				}
			}
	}
	
	void createspanningtree(){
		Collections.sort(edgelist,new Comparator<KEdge>(){
	
			@Override
			public int compare(KEdge arg0, KEdge arg1) {
				// TODO Auto-generated method stub
				if(arg0.weight>arg1.weight)
					return 1;
				else if(arg0.weight<arg1.weight)
					return -1;
				return 0;
			}
				});
		
		
			
	}
	
	void checkCycle(){
		
		
	}
	
	
	
	
}


class KEdge{
	int source;
	int destination;
	int weight;
	KEdge(int i,int j,int k){
		source=i;
		destination=j;
		weight=k;
	}
}