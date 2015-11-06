package graph;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sudoku {
	static int N=10;
	static int a[][]=new int[N][N];
	static Integer b[]={1,2,3,4,5,6,7,8,9};
static List<Integer> l=Arrays.asList(b);
static int count=0;	
static boolean generate(int tx,int ty)
{
	count++;

//int[] pos=findnextpos();
	//int tx=pos[0],ty=pos[1];
	//if(pos[0]==0)
		//return true;
	if(tx==N && ty==1)
		return true;
	for(int i=1;i<N;i++)
	{
		if(validate(l.get(i-1),tx,ty)){
		a[tx][ty]=l.get(i-1);
		if(ty==N-1){
			if(generate(tx+1,1))
				return true;}
		else{
			if(generate(tx,ty+1))
				return true;
		}
			/*
		if(generate())
			return true;*/
		a[tx][ty]=0;

		}
	}
	return false;
}
static int[] findnextpos()
{
int[] pos=new int[2];
lab:
	for(int i=1;i<N;i++)
		for(int j=1;j<N;j++)
			if(a[i][j]==0){
				pos[0]=i;
				pos[1]=j;
				break lab;
			}
	
return pos;
	
}
static boolean validate(int temp,int i, int j)
{
	for(int x=1;x<N;x++)
		if(a[i][x]==temp)
			return false;
	for(int x=1;x<N;x++)
		if(a[x][j]==temp)
			return false;
	int startx=i<=Math.sqrt(N-1)?1:i<=Math.sqrt(N-1)*2?(int)Math.sqrt(N-1)+1:7;
	int starty=j<=Math.sqrt(N-1)?1:j<=Math.sqrt(N-1)*2?(int)Math.sqrt(N-1)+1:7;
	
	for(int x=startx;x<startx+Math.sqrt(N-1);x++)
		for(int y=starty;y<starty+Math.sqrt(N-1);y++)
			if(a[x][y]==temp)
				return false;
	return true;
}
public static void main(String args[])
{
	
//	Collections.shuffle(l);	
generate(1,1);
for(int i=1;i<N;i++){
	for(int j=1;j<N;j++)
	{
		System.out.print(a[i][j]+" ");
	}
	System.out.println();
}


System.out.println(count);
}
}