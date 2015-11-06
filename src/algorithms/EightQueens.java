package algorithms;

public class EightQueens {
static boolean solveeight(int a[][],int x)
{
	if(x>8)
		return true;	
	for(int i=1;i<=8;i++)//queen can be placed in 8 positions in the row
	{
		if(eval(a,x,i)){
			a[x][i]=1;
		if(solveeight(a,x+1))
			return true;
		a[x][i]=0;
		}
	}
	return false;
}
	private static boolean eval(int a[][],int x,int y) {
	// TODO Auto-generated method stub
	for(int i=1;i<=8;i++){
		if(a[x][i]==1)
			return false;
		if(a[i][y]==1)
			return false;
		
	}
	if(!diagonal1(a,x,y))
		return false;
	if(!diagonal2(a,x,y))
		return false;
	if(!diagonal3(a,x,y))
		return false;
	if(!diagonal4(a,x,y))
		return false;
	return true;
}
	static boolean diagonal1(int a[][],int x,int y)
	{
		if(x-1>=1 && y-1>=1)
			if(a[x-1][y-1]==1)
				return false;
			else
			return diagonal1(a,x-1,y-1);
		return true;
	}	
	static boolean diagonal2(int a[][],int x,int y){
		if(x-1>=1 && y+1<=8)
			if(a[x-1][y+1]==1)
				return false;
			else
				return diagonal2(a,x-1,y+1);
		return true;
	}
	
	static boolean diagonal3(int a[][],int x,int y){
		if(x+1<=8 && y+1<=8)
			if(a[x+1][y+1]==1)
				return false;
			else
				return diagonal3(a,x+1,y+1);
		return true;
	
	}
	
	static boolean diagonal4(int a[][],int x,int y){
		if(x+1<=8 && y-1>=1)
			if(a[x+1][y-1]==1)
				return false;
			else
				return diagonal4(a,x+1,y-1);
				
	return true;
	}
		
	
	static void solve(int a[][])
	{
		System.out.println(solveeight(a,2));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a[][]=new int[9][9];
a[1][2]=1;
solve(a);
for(int i=1;i<9;i++){
	for(int j=1;j<9;j++){
		System.out.print(a[i][j]+" ");
	}
	System.out.println();
}
	}

}
