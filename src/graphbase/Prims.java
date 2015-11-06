package graphbase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
class Prims {
	double a[][];
	int V;
	boolean visited[];
List<Edge> ls;
	Prims() throws Exception {
		BufferedReader br = new BufferedReader(
				new FileReader(new File("C:/Users/9rajas7/workspace/Test Codes/src/graphbase/mintree.txt")));
		V = Integer.parseInt(br.readLine());
		a = new double[V][V];
ls=new ArrayList<Edge>();		
visited = new boolean[V];
		String temp;
		while ((temp = br.readLine()) != null) {
			// System.out.println(temp);
			int i = Integer.parseInt(temp.split(" ")[0]);
			int j = Integer.parseInt(temp.split(" ")[1]);
			a[i][j] = Integer.parseInt(temp.split(" ")[2]);
			a[j][i]=a[i][j];
			// System.out.println(i+" "+j+" "+a[i][j]);
			ls.add(new Edge(i,j,a[i][j]));
			
		}
		br.close();
		Collections.sort(ls,new Comparator<Edge>(){
@Override
public int compare(Edge e1,Edge e2){
return (int)e1.weight-(int)e2.weight;
}});
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				if (a[i][j] == 0)
					a[i][j] = Double.POSITIVE_INFINITY;
		prims();
kruskal();
djikstra(5);
bellman(5);
bipartite();
	}

	void prims() {
		double total = 0;
		double min;
		visited[0]=true;
		for (int counter = 0; counter < V - 1; counter++) {
			
			int u = 0, v = 0;
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < V; i++) {
				if (visited[i]) {
					for (int j = 0; j < V; j++) {
						if (!visited[j] && a[i][j] != Double.POSITIVE_INFINITY) {
							if (a[i][j] < min) {
								min = a[i][j];
								u = i;
								v = j;
							}
						}

					}
				}
			}
			total=total+min;
			System.out.println(u+" "+v+" "+a[u][v]);
			visited[v]=true;


		}
		System.out.println(total);
	}
	
	void kruskal(){
System.out.println("Kruskal algorithm");
	int u=0,v=0,count=0;
double total=0;
//LinkedList<Edge> span=new LinkedList<Edge>();
	int parent[]=new int[V];
for(int i=0;i<V;i++)
parent[i]=-1;
	for(Edge e:ls){


		u=e.u;
		v=e.v;
		while(parent[u]!=-1)
		u=parent[u];
		while(parent[v]!=-1)
		v=parent[v];
		
		if(u!=v)
		{
		System.out.println(e.u+" "+e.v+" "+e.weight);
total=total+e.weight;
//parent[v]=u;
parent[u]=v;
count++;
//if(count==V-1)
//break;

		}else{
			System.out.println(e.u+" "+e.v+"Rejected");
		}
		
		
	   }		
	System.out.println(total);	
	}

class Edge{
int u;
int v;
double weight;
Edge(int u,int v,double weight)
{
this.u=u;
this.v=v;
this.weight=weight;
}
@Override
public boolean equals(Object b){
if(b==null)
return false;
if(b instanceof Edge){
Edge e=(Edge)b;
if(e.u!=u)
return false;
if(e.v!=v)
return false;
if(e.weight!=weight)
return false;
return true;
}
return false;
}
}
void djikstra(int target){
	double dist[]=new double[V];
	int prev[]=new int[V];
	boolean visited[]=new boolean[V];
	PriorityQueue<Integer> pq=new PriorityQueue<Integer>(V,new Comparator<Integer>(){

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			
			return (int)dist[arg0]-(int)dist[arg1];
			
		}
		
	});
	for(int v=0;v<V;v++)
	{
		dist[v]=Double.POSITIVE_INFINITY;
		prev[v]=-1;
		pq.add(v);
	}
	dist[0]=0;
	int v=0;
	while(!pq.isEmpty()){
		v=pq.poll();
		visited[v]=true;
		if(v==target)
		break;
		for(int j=0;j<V;j++){
			if(a[v][j]!=Double.POSITIVE_INFINITY && !visited[j]){
				double s1=dist[v]+a[v][j];
				if(s1<dist[j]){
					pq.remove(j);
					dist[j]=s1;
				prev[j]	=v;
				
				pq.add(j);
				}
			}
		}
	}
	System.out.println(dist[target]);
	for(int x=target;x!=0;x=prev[x])
		System.out.print(x+ " ");
	System.out.print(0);
	System.out.println();
}

void bellman(int target){
	double dist[]=new double[V];
	int prev[]=new int[V];
	for(int i=0;i<V;i++){
	dist[i]=Double.POSITIVE_INFINITY;
	prev[i]=-1;
	}
	dist[0]=0;
	for(int i=0;i<V-1;i++)
	for(int v=0;v<V;v++){
		for(int j=0;j<V;j++){
			if(a[v][j]!=Double.POSITIVE_INFINITY){
				double s1=dist[v]+a[v][j];
				if(s1<dist[j]){
					dist[j]=s1;
					prev[j]=v;
				}
			}
		}
	}
	System.out.println(dist[target]);
	for(int x=target;x!=0;x=prev[x])
		System.out.print(x+ " ");
	System.out.print(0);
	System.out.println();
}
void bipartite(){
	int color[]=new int[V];
	boolean visited[]=new boolean[V];
for(int i=0;i<V;i++)
	color[i]=-1;
Deque<Integer> s=new ArrayDeque<Integer>();

for(int v=0;v<V;v++)
{
	if(color[v]==-1)
	{
		s.push(v);
		color[v]=1;
		while(!s.isEmpty()){
			int n=s.pop();
			for(int j=0;j<V;j++){
				if(a[n][j]!=Double.POSITIVE_INFINITY && color[j]==-1 && j!=n)
				{
					color[j]=color[v]==1?0:1;
				}else if(a[n][j]!=Double.POSITIVE_INFINITY && color[j]!=-1 && j!=n){
					if(color[j]==color[v])
						System.out.println("Graph is no bipartite "+v+" "+j);
				}
			}
		}
	}
}


}

	public static void main(String args[]) throws Exception{
		Prims p=new Prims();
		System.out.println(Double.POSITIVE_INFINITY);

	}
}
