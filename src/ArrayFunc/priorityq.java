package ArrayFunc;

import java.util.PriorityQueue;
import java.util.Random;

public class priorityq {
public static void main(String args[]){
	PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
	Random r=new Random();
	for(int i=0;i<10;i++)
		pq.offer(r.ints(0, 10).iterator().next());
	
	pq.stream().forEach(e->System.out.print(e+" "));
	pq.poll();
	System.out.println();
	pq.stream().forEach(e->System.out.print(e+" "));
	System.out.println();
	pq.poll();
	
	pq.stream().forEach(e->System.out.print(e+" "));
	System.out.println();
	pq.poll();
	
	pq.stream().forEach(e->System.out.print(e+" "));
}
}
