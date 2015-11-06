package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;



class Node
{
	
	private String id;
	Node(String name){
		
		this.id=name;
	}

	String getId(){
		return id;
	}
	
	boolean equals(Node d){
		if(d.getId()!=this.id)
		return false;
		return true;
	
	}
	@Override
	public int hashCode(){
		return this.id.hashCode()*31;
	}

	
}
class Edge
{
	String id;
	Node source;
	Node destination;
	int pathdistance;
Edge(String id,Node source,Node destination,int pathdistance){
	this.id=id;
	this.source=source;
	this.destination=destination;
	this.pathdistance=pathdistance;
}
}
class Graph
{
	List<Node> nodes;
	List<Edge> edges;
	HashMap<Node,Integer> distance;
	HashMap<Node,Node> predecessor;
	Set<Node> unsettlednodes;
	Set<Node> settlednodes;
	void initialize(){
		distance=new HashMap<Node,Integer>();	
		predecessor=new HashMap<Node,Node>();
		unsettlednodes=new HashSet<Node>();
		settlednodes=new HashSet<Node>();		
	}
	void shortestdistancetodestination(Node finaldest){
	initialize();
	Node source=nodes.get(0);

	distance.put(source, 0);
	unsettlednodes.add(source);
	while(unsettlednodes.size()>0){
		Node min=getMin(unsettlednodes);
		settlednodes.add(min);
		unsettlednodes.remove(min);
		updateDistanceNeighbours(min);
	
	}
	System.out.println(getShortestDistance(finaldest));
	Node temp=finaldest;
	System.out.format("%4s <-",finaldest.getId());
	while(predecessor.get(temp)!=null){
		System.out.format("%4s <-",predecessor.get(temp).getId());
	temp=predecessor.get(temp);
	}
System.out.println();
	}
	
	void shortestdistancetodestination(Node source,Node finaldest){
		initialize();
		//Node source=nodes.get(0);

		distance.put(source, 0);
		unsettlednodes.add(source);
		while(unsettlednodes.size()>0){
			Node min=getMin(unsettlednodes);
			settlednodes.add(min);
			unsettlednodes.remove(min);
			updateDistanceNeighbours(min);
		
		}
		System.out.println(getShortestDistance(finaldest));
		Node temp=finaldest;
		System.out.format("%4s <-",finaldest.getId());
		while(predecessor.get(temp)!=null){
			System.out.format("%4s <-",predecessor.get(temp).getId());
		temp=predecessor.get(temp);
		}
	System.out.println();
		}
	
	
void updateDistanceNeighbours(Node source){
	Set<Node> neighbours=findNeighbourNodes(source);
	
	for(Node n:neighbours){
		if(getShortestDistance(n)>(getDistance(source,n)+getShortestDistance(source))){
			distance.put(n,(getDistance(source,n)+getShortestDistance(source)));
		unsettlednodes.add(n);
		predecessor.put(n, source);
	}
	}
}
Node getMin(Set<Node> nodes){
	Node min=null;
	for(Node n:nodes){
	if(min==null)
	min=n;
	else
		if(getShortestDistance(min)>getShortestDistance(n))
			min=n;
	}
	return min;
}
int getShortestDistance(Node n){
	
	if(distance.get(n)==null)
		return Integer.MAX_VALUE;
	return distance.get(n);
}
Set<Node> findNeighbourNodes(Node source)
{
	Set<Node> n=new HashSet<Node>();
	for(Edge e:edges){
		if(e.source.getId().equals(source.getId()) && !settlednodes.contains(e.destination)){
			n.add(e.destination);
		}
	}
return n;
}
int getDistance(Node source,Node target){
	for(Edge e:edges){
		if((e.source.getId().equals(source.getId())) && (e.destination.getId().equals(target.getId())))
			return e.pathdistance;
		
	}
	return Integer.MAX_VALUE;
}

}

class Djikstra
{
	public static void main(String args[]){
		Graph g=new Graph();
		g.edges=new ArrayList<Edge>();
		g.nodes=new ArrayList<Node>();
		for(int i=1;i<10;i++)
			g.nodes.add(new Node(i+""));
		g.edges.add(new Edge("1,2",g.nodes.get(0),g.nodes.get(1),5));
		g.edges.add(new Edge("1,3",g.nodes.get(0),g.nodes.get(2),4));
		g.edges.add(new Edge("3,4",g.nodes.get(2),g.nodes.get(3),1));
		g.edges.add(new Edge("2,5",g.nodes.get(1),g.nodes.get(4),5));
		g.edges.add(new Edge("2,6",g.nodes.get(1),g.nodes.get(5),-3));
		g.edges.add(new Edge("3,6",g.nodes.get(2),g.nodes.get(5),5));
		g.edges.add(new Edge("3,7",g.nodes.get(2),g.nodes.get(6),2));
		g.edges.add(new Edge("5,8",g.nodes.get(4),g.nodes.get(7),4));
		g.edges.add(new Edge("6,8",g.nodes.get(5),g.nodes.get(7),4));
		g.edges.add(new Edge("6,9",g.nodes.get(5),g.nodes.get(8),3));
		g.edges.add(new Edge("7,9",g.nodes.get(6),g.nodes.get(8),2));
		System.out.println("Node:"+g.nodes.get(5).getId());
		g.shortestdistancetodestination(g.nodes.get(5));
		g.shortestdistancetodestination(g.nodes.get(1),g.nodes.get(8));
		String a="abcdea";
	
	}
}