package graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;


class Cell {
	int x;
	int y;
	String id;
	Cell(int x, int y) {
		this.x = x;
		this.y = y;
		id="Cell"+x+"_"+y;
	}
	@Override
	public boolean equals(Object c1)
	{
		if(c1==null)
			return false;
	//	System.out.println("equals"+((Cell)c1).x);
	if(this==c1)
			return true;
	
		if(((Cell)c1).x==x && ((Cell)c1).y==y)
			return true;
		return false;
		
	}
	@Override
	public int hashCode()
	{
		//System.out.println("hascode");
		return id.hashCode()+31;
		
	}
}

public class Maze extends JFrame {
	int N; // maze is a square
	boolean north[][];
	boolean south[][];
	boolean east[][];
	boolean west[][];
	boolean visited[][];
	Map<Cell,Cell> path=new LinkedHashMap<Cell,Cell>();
	Map<Cell,Cell> testpath=new LinkedHashMap<Cell,Cell>();
	List<Cell> visitedpath=new ArrayList<Cell>();
	/*
	 * N+2 because one layer of cell is required to cover the maze so that north
	 * and south dont throw errors for border cell. All border cell will be
	 * marked as visited so that those cells aren't touched.
	 */
	Random r = new Random();

	public Maze(int N) {
		super("Maze");
		this.N = N;
		init();
		System.out.println(0);
		
		generate(1, 1);
		clear();
		solve(1,1,N,N);
		setVisible(true);
		setSize(900, 900);
		setDefaultCloseOperation(3);
		
System.out.println(1);
	}

	void init() {
		north = new boolean[N + 2][N + 2]; // north of cell i,j has wall or not
		south = new boolean[N + 2][N + 2];
		east = new boolean[N + 2][N + 2];
		west = new boolean[N + 2][N + 2];
		visited = new boolean[N + 2][N + 2];

		// all border cells are marked as visited
		for (int x = 0; x < N + 2; x++) {

			visited[x][0] = true;
			visited[0][x] = true;
			visited[N + 1][x] = true;
			visited[x][N + 1] = true;
		}
		for (int x = 0; x < N + 2; x++)
			for (int y = 0; y < N + 2; y++) {
				north[x][y] = true;
				south[x][y] = true;
				east[x][y] = true;
				west[x][y] = true;
			}

	}

	void generate(int x, int y) {
		visited[x][y] = true;
System.out.println(x+":"+y);
		while (visited[x + 1][y] == false || visited[x][y + 1] == false
				|| visited[x - 1][y] == false || visited[x][y - 1] == false) {
			while (true) {
				
				int t = r.nextInt(4);
				if (t == 0 && !visited[x - 1][y]) {
					north[x][y] = false;
					south[x - 1][y] = false;
					generate(x - 1, y);
					break;

				}
				if (t == 1 && !visited[x + 1][y]) {
					south[x][y] = false;
					north[x + 1][y] = false;
					generate(x + 1, y);
					break;
				}
				if (t == 2 && !visited[x][y + 1]) {
					east[x][y] = false;
					west[x][y + 1] = false;
					generate(x, y + 1);
					break;
				}
				if (t == 3 && !visited[x][y - 1]) {
					west[x][y] = false;
					east[x][y - 1] = false;
					generate(x, y - 1);
					break;
				}
				
			}


		}

	}
	/* public void paint(Graphics g) {
	        super.paint(g);  // fixes the immediate problem.
	        Graphics2D g2 = (Graphics2D) g;
	        Line2D lin = new Line2D.Float(100, 100, 250, 260);
	        Rectangle2D rect=new Rectangle2D.Float(10, 10,100, 100);
	        g2.draw(lin);
	        g2.draw(rect);
	    }
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gr = (Graphics2D) g;
	
		int e=50;
		
		for (int x = 1; x <= N; x++)
			for (int y = 1; y <=N; y++) {
				int x1=x*e;
				int y1=y*e;
				if (north[x][y]){
					
					gr.draw(new Line2D.Float(y1, x1,y1+50,x1 ));}
				if (south[x][y]){
					gr.draw(new Line2D.Float(y1, x1+50,y1+50,x1+50 ));
					
				}
				if (west[x][y]){
					gr.draw(new Line2D.Float(y1 , x1, y1,x1+50));}
				if (east[x][y]){
					gr.draw(new Line2D.Float(y1+50, x1, y1 + 50,
							x1 + 50));
				}
			}
	/*	Iterator<Cell> it1=visitedpath.iterator();
		
		Cell temp1=new Cell(1,1);
		if(it1.hasNext())
			temp1=it1.next();
		while(it1.hasNext()){
			Cell c=it1.next();
			gr.setColor(Color.RED);
			if(temp1.y != c.y || temp1.x!=c.x)
			gr.draw(new Line2D.Float(temp1.y*50+25,temp1.x*50+25,c.y*50+25,c.x*50+25));
			temp1=c;
		}	*/
	
		//System.out.println(path.size());
		//path..forEach((k,v)->System.out.println(k.x+":"+k.y+","+v.x+":"+v.y));
		//System.out.println(path.containsKey(new Cell(N,N)));
		List<Cell> s = new ArrayList<Cell>();
		Cell temp=new Cell(N,N);
		s.add(temp);
		
		//System.out.println(temp.x+":"+temp.y);	
		while((temp=testpath.get(temp))!=null)
		s.add(temp);
		Collections.reverse(s);
		
		Iterator<Cell> it=s.iterator();
		Set<Entry<Cell, Cell>> act=path.entrySet();
	for(Iterator<Entry<Cell, Cell>> i=act.iterator();i.hasNext();)
	{
		Entry<Cell, Cell> mm=i.next();
		Cell key=mm.getKey();
		Cell value=mm.getValue();
		gr.setColor(Color.RED);
	//	if(key!=null && value!=null)
		//gr.draw(new Line2D.Float(key.y*50+25,key.x*50+25,value.y*50+25,value.x*50+25));
	}
	if(it.hasNext())
		temp=it.next();
	System.out.println(temp.x+":"+temp.y);
	while(it.hasNext()){
		Cell c=it.next();
		gr.setColor(Color.CYAN);
		gr.draw(new Line2D.Float(temp.y*50+25,temp.x*50+25,c.y*50+25,c.x*50+25));
		temp=c;
	}
	

	
	
	}
	void clear(){
		visited=new boolean[N+2][N+2];
		for (int h = 0; h < N + 2; h++) {

			visited[h][0] = true;
			visited[0][h] = true;
			visited[N + 1][h] = true;
			visited[h][N + 1] = true;
		}
		System.out.println("clear");
	}
	void solve(int i,int j,int x, int y)
	{
	visited[i][j]=true;
		
			Deque<Cell> d=new ArrayDeque<Cell>();
	d.add(new Cell(i,j));
	Cell c,temp=null;
	while(!d.isEmpty())
	{
		
		c=d.pop();
	//	if(temp!=null)
		//System.out.println(temp.x+":"+temp.y+":"+x+":"+y);
	//	System.out.println(c.x+":"+c.y);
		//if(temp!=null)
		path.put(c,temp);
		//else
		//path.put(new Cell(c.x,c.y), null);
		visitedpath.add(c);
		temp=c;
		
		i=c.x;
		j=c.y;
		visited[i][j]=true;
		System.out.println("Visited Cell: "+i+":"+j);

		if(i==x && j==y)
		break;
		int flag=0;
			if(!visited[i-1][j] && !north[i][j]){
				d.push(new Cell(i-1,j));
				testpath.put(new Cell(i-1,j),c);
				flag=1;}
			if(!visited[i+1][j] && !south[i][j]){
				d.push(new Cell(i+1,j));
				testpath.put(new Cell(i+1,j),c);
				flag=1;
			}
			if(!visited[i][j-1] && !west[i][j]){
				d.push(new Cell(i,j-1));
				testpath.put(new Cell(i,j-1),c);
				flag=1;
			}
			if(!visited[i][j+1] && !east[i][j]){
				d.push(new Cell(i,j+1));
				testpath.put(new Cell(i,j+1),c);
				flag=1;
			}
		if(flag==0){
			Cell prevtemp=temp;
			while(temp!=null && ((visited[temp.x][temp.y-1] && west[temp.x][temp.y]) || (visited[temp.x][temp.y+1] && east[temp.x][temp.y]) || (visited[temp.x-1][temp.y] && north[temp.x][temp.y]) || (visited[temp.x+1][temp.y] && south[temp.x][temp.y])))
			{
				prevtemp=temp;
				temp=path.get(temp);
				
				if(temp!=null)
			System.out.println("Backtrack:"+temp.x+":"+temp.y);
				else
					System.out.println("null");
			}
			temp=prevtemp;
		}
		//visitedpath.add(new Cell(c.))
		//	visitedpath.add(c);
		}
		}	
		
	
	public static void main(String args[]) throws InterruptedException {
	//	for(int i=2;i<11;i++){
		Maze m = new Maze(10);
		//assert 1>2;
		//Thread.sleep(2000);
		//m.setVisible(false); //you can't see me!
	//if(i!=10)
		//m.dispose();
		//}
	//	m.repaint();
//m.setVisible(true);
		//m.paint(m.getContentPane().getGraphics());

	}

}
