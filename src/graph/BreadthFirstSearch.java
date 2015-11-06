package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
	Queue<Node> unsettlednodes=new LinkedList<Node>();
	HashMap<Node,Boolean> hm=new HashMap<Node,Boolean>();
	boolean marked[];
	List<Integer> distance=new ArrayList<Integer>();
	ArrayList<Node> path=new ArrayList<Node>();
	void bfs(Graph g, Node source){
		unsettlednodes.add(source);
		marked=new boolean[g.nodes.size()];
		
		while(!unsettlednodes.isEmpty()){
			source=unsettlednodes.poll();
		marked[g.nodes.indexOf(source)]=true;
			Set<Node> neighbours=getNeighbours(g,source);
		for(Iterator<Node> it=neighbours.iterator();it.hasNext();)
		{
			Node temp=it.next();
			if(!marked[g.nodes.indexOf(temp)]){
				path.set(g.nodes.indexOf(temp),source);
		//		System.out.println(g.nodes.indexOf(temp));
			System.out.println("visiting Node: "+temp.getId()+":"+source.getId());
			marked[g.nodes.indexOf(temp)]=true;
			unsettlednodes.offer(temp);		
			}
		}
		}
		
	}
	Set<Node> getNeighbours(Graph g,Node source)
	{
		Set<Node> result=new LinkedHashSet<Node>();
		for(int i=0;i<g.edges.size();i++)
		{
			if(g.edges.get(i).source.equals(source))
			{
				//marked[g.nodes.indexOf(g.edges.get(i).destination)]=true;
			//	System.out.println(g.edges.get(i).source.getId());
				result.add(g.edges.get(i).destination);
			}
			if(g.edges.get(i).destination.equals(source))
			{
				//marked[g.nodes.indexOf(g.edges.get(i).destination)]=true;
			//	System.out.println(g.edges.get(i).source.getId());
				result.add(g.edges.get(i).source);
			}
			
		}
		return result;
		
	}
	
	void dfs(Graph g, Node source){
		marked[g.nodes.indexOf(source)]=true;
			Set<Node> neighbours=getNeighbours(g,source);
		for(Iterator<Node> it=neighbours.iterator();it.hasNext();)
		{
			Node temp=it.next();
			if(!marked[g.nodes.indexOf(temp)]){
			System.out.println("visiting Node: "+temp.getId());
			path.set(g.nodes.indexOf(temp),source);
			dfs(g,temp);
			}
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g=new Graph();
		g.edges=new ArrayList<Edge>();
		g.nodes=new ArrayList<Node>();
		for(int i=1;i<10;i++)
			g.nodes.add(new Node(i+""));
		g.nodes.add(new Node("11"));
		g.edges.add(new Edge("1,2",g.nodes.get(0),g.nodes.get(1),5));
		g.edges.add(new Edge("1,3",g.nodes.get(0),g.nodes.get(2),4));
		g.edges.add(new Edge("3,4",g.nodes.get(2),g.nodes.get(3),1));
		g.edges.add(new Edge("2,5",g.nodes.get(1),g.nodes.get(4),5));
		g.edges.add(new Edge("2,6",g.nodes.get(1),g.nodes.get(5),3));
		g.edges.add(new Edge("3,6",g.nodes.get(2),g.nodes.get(5),5));
		g.edges.add(new Edge("3,7",g.nodes.get(2),g.nodes.get(6),2));
		g.edges.add(new Edge("5,8",g.nodes.get(4),g.nodes.get(7),4));
		g.edges.add(new Edge("6,8",g.nodes.get(5),g.nodes.get(7),4));
		g.edges.add(new Edge("6,9",g.nodes.get(5),g.nodes.get(8),3));
		g.edges.add(new Edge("7,9",g.nodes.get(6),g.nodes.get(8),2));
		BreadthFirstSearch bf=new BreadthFirstSearch();
		for(int k=0;k<g.nodes.size();k++)
			bf.path.add(null);
		Node source=g.nodes.get(0);
		bf.bfs(g,source);
		int flag=0;
		for(int i=0;i<bf.marked.length;i++){
		if(bf.marked[i]){
			
		}
		else{
			flag=1;
			System.out.println("Graph is not connected");
			break;
		}}
		if(flag==0)
			System.out.println("Graph is connected");
		for(int k=0;k<g.nodes.size();k++){
			if(!g.nodes.get(k).equals(source)){
			System.out.print("Path to Node "+g.nodes.get(k).getId()+":"+g.nodes.get(k).getId());
			Node temp1=g.nodes.get(k);
			while((temp1=bf.path.get(g.nodes.indexOf(temp1)))!=null){
				System.out.print("<-"+temp1.getId());
				
			}
			System.out.println();
			}
		}
		for(int k=0;k<g.nodes.size();k++)
			bf.path.set(k,null);
		bf.marked=new boolean[g.nodes.size()];
		source=g.nodes.get(2);
		bf.dfs(g, source);
		 flag=0;
			for(int i=0;i<bf.marked.length;i++){
			if(bf.marked[i]){
				
			}
			else{
				flag=1;
				System.out.println("Graph is not connected");	
			break;
			}}
			if(flag==0)
				System.out.println("Graph is connected");
			for(int k=0;k<g.nodes.size();k++){
				if(!g.nodes.get(k).equals(source)){
				System.out.print("Path to Node "+g.nodes.get(k).getId()+":"+g.nodes.get(k).getId());
				Node temp1=g.nodes.get(k);
				while((temp1=bf.path.get(g.nodes.indexOf(temp1)))!=null){
					System.out.print("<-"+temp1.getId());
					
				}
				System.out.println();
				}
			}	
	}

}
