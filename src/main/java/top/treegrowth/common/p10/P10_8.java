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
}						//�����ϵ����� 


public class P10_8 {
	static int[][] chessboard=new int[8][8];	
	static int curstep;						//�����Ĳ������
	 
	

	//����ߵİ˸�����
	static Coordinate[] fangxiang={new Coordinate(-2, 1), new Coordinate(-1, 2),
									new Coordinate(1, 2), new Coordinate(2, 1),
									new Coordinate(2, -1), new Coordinate(1, -2),
									new Coordinate(-1, -2),new Coordinate(-2, -1)};	

	static void Move(Coordinate curpos) 			//��̤�����㷨
	{
		Coordinate next=new Coordinate(0,0);

	   int i,j;
	   if (curpos.x < 0 || curpos.x > 7 || curpos.y < 0 || curpos.y > 7)	//Խ�� 
	   {
		  return;
	   }
	   if (chessboard[curpos.x][curpos.y]!=0)	//���߹� 
	   {
		  return;	
	   }
	   chessboard[curpos.x][curpos.y] = curstep;	//���沽�� 
	   curstep++;
	   if (curstep > 64)					//����λ�ö������� 
	   {
		   for (i = 0; i < 8; i++)			//����߷�
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
		  for (i = 0; i < 8; i++)			// 8�����ܵķ���
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

	   chessboard[curpos.x][curpos.y] = 0; 	//���������� 
	   curstep--; 						//���ٲ��� 
	}

	public static void main(String[] args) 
	{
		int i, j;
		   Coordinate start=new Coordinate(0,0);

		   System.out.print("��̤����������⣡\n");
		   System.out.print("�����������һ����ʼλ��(x,y):");
		   Scanner input=new Scanner(System.in);
		   start.x=input.nextInt();
		   start.y=input.nextInt();//��ʼλ��

		   if (start.x < 1 || start.y < 1 || start.x > 8 || start.y > 8)	
		   {								//Խ��
			  System.out.print("��ʼλ������������������룡\n");
			  System.out.print("over!");
		   }

		   for(i=0;i<8;i++)					//��ʼ�����̸���Ԫ��״̬ 
		   {
			   for(j=0;j<8;j++)
			   {
				   chessboard[i][j]=0;
			   }
		   }
		   
		   start.x--;
		   start.y--;
		   curstep = 1;						//��1�� 

		   Move(start);						//���


	}

}


