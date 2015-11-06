package algorithms;


public class Find2DMin {
static int findMin(int a[][],int startrow,int endrow,int startcol,int endcol)
{
	
	int midrow=startrow+(endrow-startrow)/2;
	if(midrow==startrow || midrow==endrow)
		return a[midrow][findminRow(a,midrow,startcol,endcol)];

	
	int minelem=findminRow(a,midrow,startcol,endcol);
	if(a[midrow][minelem]<a[midrow+1][minelem] && a[midrow-1][minelem]>a[midrow][minelem])
		return a[midrow][minelem];
	if(a[midrow][minelem]>a[midrow+1][minelem])
	{
		int mincol=findminCol(a,minelem,midrow,endrow);
		if(mincol<startcol+1 && mincol>endcol-1)
			return -1;
		if(a[mincol][minelem]>a[mincol+1][minelem])
			return findMin(a,midrow,endrow,minelem,endcol);
		else
			return findMin(a,midrow,endrow,startcol,minelem);
				
	}else{
		int mincol=findminCol(a,minelem,startrow,midrow);
	
		if(a[mincol][minelem]>a[mincol+1][minelem])
			return findMin(a,startrow,midrow,minelem,endcol);
		else
			return findMin(a,startrow,midrow,startcol,minelem);
	}

}
static int findminRow(int a[][],int row,int start,int end)
{
	int min=start;
	for(int i=start;i<=end;i++)
	{
		if(a[row][i]<a[row][min]){
			min=i;
		}
	}
	return min;
}
static int findminCol(int a[][],int col,int start,int end)
{
	int min=start;
	for(int i=start;i<=end;i++)
	{
		if(a[i][col]<a[min][col]){
			min=i;
		}
	}
	return min;
}
public static void main(String args[])
{
	int a[][]={
			{7,2,3,4,20},
			{45,6,16,8,21},
			{46,11,12,13,22},
			{14,15,1,17,23},
			{24,25,-3,-4,29}
	};

	System.out.println(findMin(a,0,a.length-1,0,a.length-1));
}
}
