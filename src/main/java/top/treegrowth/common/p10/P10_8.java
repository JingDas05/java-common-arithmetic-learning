package top.treegrowth.common.p10;

import java.util.*;


class Coordinate
{
   int x;
   int y;
   
   public Coordinate(int a,int b){
	   x=a;
	   y=b;
   }
}						//棋盘上的坐标 


public class P10_8 {
	static int[][] chessboard=new int[8][8];	
	static int curstep;						//马跳的步骤序号
	 
	

	//马可走的八个方向
	static Coordinate[] fangxiang={new Coordinate(-2, 1), new Coordinate(-1, 2),
									new Coordinate(1, 2), new Coordinate(2, 1),
									new Coordinate(2, -1), new Coordinate(1, -2),
									new Coordinate(-1, -2),new Coordinate(-2, -1)};	

	static void Move(Coordinate curpos) 			//马踏棋盘算法
	{
		Coordinate next=new Coordinate(0,0);

	   int i,j;
	   if (curpos.x < 0 || curpos.x > 7 || curpos.y < 0 || curpos.y > 7)	//越界 
	   {
		  return;
	   }
	   if (chessboard[curpos.x][curpos.y]!=0)	//已走过 
	   {
		  return;	
	   }
	   chessboard[curpos.x][curpos.y] = curstep;	//保存步数 
	   curstep++;
	   if (curstep > 64)					//棋盘位置都走完了 
	   {
		   for (i = 0; i < 8; i++)			//输出走法
		   {
	           for (j = 0; j < 8; j++)
			   {
	        	   System.out.printf("%5d", chessboard[i][j]);
	        	   
			   }
		       System.out.print("\n");
		   }
		   System.exit(0);
	   } 
	   else
	   {
		  for (i = 0; i < 8; i++)			// 8个可能的方向
		  {
	
			 next.x = curpos.x + fangxiang[i].x;
			 next.y = curpos.y + fangxiang[i].y;
			 if (next.x < 0 || next.x > 7 || next.y < 0 || next.y > 7)
	           {
	           }
			 else
	           {
			     Move(next);
	           }
		  }
	   }

	   chessboard[curpos.x][curpos.y] = 0; 	//清除步数序号 
	   curstep--; 						//减少步数 
	}

	public static void main(String[] args) 
	{
		int i, j;
		   Coordinate start=new Coordinate(0,0);

		   System.out.print("马踏棋盘问题求解！\n");
		   System.out.print("请先输入马的一个起始位置(x,y):");
		   Scanner input=new Scanner(System.in);
		   start.x=input.nextInt();
		   start.y=input.nextInt();//起始位置

		   if (start.x < 1 || start.y < 1 || start.x > 8 || start.y > 8)	
		   {								//越界
			  System.out.print("起始位置输入错误，请重新输入！\n");
			  System.out.print("over!");
		   }

		   for(i=0;i<8;i++)					//初始化棋盘各单元格状态 
		   {
			   for(j=0;j<8;j++)
			   {
				   chessboard[i][j]=0;
			   }
		   }
		   
		   start.x--;
		   start.y--;
		   curstep = 1;						//第1步 

		   Move(start);						//求解


	}

}


