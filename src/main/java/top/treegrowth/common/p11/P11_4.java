package top.treegrowth.common.p11;

import java.util.Scanner;


public class P11_4 {
	
	static final int ROWLEN=10; 						//二维空间行数 
	static final int COLLEN=10; 						//二维空间列数 
	static final int DEAD=0; 							//死细胞 
	static final int ALIVE=1; 							//活细胞 
	static int[][] cell=new int[ROWLEN][COLLEN]; 					//当前生命细胞的状态
	static int[][] celltemp=new int[ROWLEN][COLLEN]; 				//用于判断当前的细胞的下一个状态
	
	static void initcell() 								//初始化细胞分布
	{
	   int row, col;
	   Scanner input=new Scanner(System.in);
	   for (row = 0; row < ROWLEN; row++) //先全部初始化为死状态 
	   {
		  for (col = 0; col < COLLEN; col++)
		  {
			 cell[row][col] = DEAD;
		  }
	   }
	   System.out.printf("请先输入一组活细胞的坐标位置，输入(-1 -1)结束:\n");
	   while (true)
	   {
		  System.out.printf("请输入一个活细胞的坐标位置：");
		  row=input.nextInt();
		  col=input.nextInt(); 			//输入活细胞坐标 
		  if (0 <= row && row < ROWLEN && 0 <= col && col < COLLEN)
		  {
			 cell[row][col] = ALIVE; 				//保存活细胞 
		  }
		  else if (row == -1 || col == -1)
		  {
			 break;
		  }
		  else
		  {
			 System.out.printf("输入坐标超过范围。\n"); 
		  }
	   }
	}
	
	static int LinSum(int row, int col) 					//统计四周细胞数量 
	{
	   int count = 0, c, r;

	   for (r = row - 1; r <= row + 1; r++)
	   {
		  for (c = col - 1; c <= col + 1; c++)
		  {
			 if (r < 0 || r >= ROWLEN || c < 0 || c >= COLLEN) 
			 {
				continue; 						//处理下一个单元格 
			 }
			 if (cell[r][c] == ALIVE)				//如果为活细胞
			 {
				count++; 						//增加活细胞的数量 
			 }
		  }
		  
	   }
	   if (cell[row][col] == ALIVE) 					//当前单元格为活细胞 
	   {
		  count--; 
	   }
	   return count; 							//返回四周活细胞总数 
	}
	
	static void OutCell() 								//输出显示细胞状态 
	{
	   int row, col;

	   System.out.printf("\n细胞状态\n");
	   System.out.printf("┌");	 
	   for (col = 0; col < COLLEN -1; col++)			//输出一行
	   {
		   System.out.printf("─┬");
	   }
	   System.out.printf("─┐\n");
	   for (row = 0; row < ROWLEN; row++)
	   {
		   System.out.printf("│");	
		  for (col = 0; col < COLLEN; col++)			//输出各单元格中细胞的生存状态 
		  {
			  switch(cell[row][col])
			  {
			  case ALIVE:
				  System.out.printf("●│");					//●代表活细胞
				  break;
			  case DEAD:
				  System.out.printf("○│");					//○代表死细胞 
				  break;
			  default:
				  ;
			  }
		  }
		  System.out.printf("\n");

		  if (row < ROWLEN - 1)
		  {
			  System.out.printf("├");	
			 for (col = 0; col < COLLEN - 1; col++)	//输出一行 
			 {
				 System.out.printf("─┼");
			 }
			 System.out.printf("─┤\n");
		  }
	   }
	   System.out.printf("└");
	   for (col = 0; col < COLLEN - 1; col++)			//最后一行的横线 
	   {
		   System.out.printf("─┴");
	   }
	   System.out.printf("─┘\n");   
	}
	
	static void cellfun()								//生命游戏算法
	{
	   int row, col,sum;
	   int count=0;

		for (row = 0; row < ROWLEN; row++)
		  {
			 for (col = 0; col < COLLEN; col++)
			 {
				switch (LinSum(row, col)) 		//四周活细胞数量 
				{
				case 2:
				   celltemp[row][col] = cell[row][col]; //保持细胞原样 
				   break;
				case 3:
				   celltemp[row][col] = ALIVE; 		//复活 
				   break;
				default:
				   celltemp[row][col] = DEAD; 		//死去 
				}
			 }
		  }
	      for (row = 0; row < ROWLEN; row++) 
		  {
	    	  for (col = 0; col < COLLEN; col++)
			  {
	    		 cell[row][col] = celltemp[row][col];
			  }
		  }
		  for (row = 0; row < ROWLEN; row++)
		  {
		      for (col = 0; col < COLLEN; col++)
			  {
			     if(cell[row][col] == ALIVE) 	//若是活细胞 
				 {
	                 count++; 				//累加活细胞数量 
				 }
			  }
		  }
		  sum=count;

	      OutCell(); 						//输出显示当前细胞状态 
	      System.out.printf("当前状态下，共有%d个活细胞。\n",sum); 
	}
	
	public static void main(String[] args) {
		String go;
		Scanner input=new Scanner(System.in);
		System.out.printf("生命游戏！\n");
		   initcell(); 							//初始化
		   OutCell();   						//输出初始细胞状态 
//		   printf("按任意键开始游戏,进行细胞转换。\n");
//		   getch(); 
		   do{
	       cellfun();						//开始游戏 
	       
	       System.out.print("\n继续生成下一次细胞的状态(y/n)?");
	       go=input.next();
		   }while(go.equalsIgnoreCase("y"));
		   System.out.println("游戏结束！");

	}

}
