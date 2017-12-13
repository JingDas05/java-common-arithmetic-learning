package top.treegrowth.common.p11;

import java.util.Scanner;


public class P11_4 {
	
	static final int ROWLEN=10; 						//��ά�ռ����� 
	static final int COLLEN=10; 						//��ά�ռ����� 
	static final int DEAD=0; 							//��ϸ�� 
	static final int ALIVE=1; 							//��ϸ�� 
	static int[][] cell=new int[ROWLEN][COLLEN]; 					//��ǰ����ϸ����״̬
	static int[][] celltemp=new int[ROWLEN][COLLEN]; 				//�����жϵ�ǰ��ϸ������һ��״̬
	
	static void initcell() 								//��ʼ��ϸ���ֲ�
	{
	   int row, col;
	   Scanner input=new Scanner(System.in);
	   for (row = 0; row < ROWLEN; row++) //��ȫ����ʼ��Ϊ��״̬ 
	   {
		  for (col = 0; col < COLLEN; col++)
		  {
			 cell[row][col] = DEAD;
		  }
	   }
	   System.out.printf("��������һ���ϸ��������λ�ã�����(-1 -1)����:\n");
	   while (true)
	   {
		  System.out.printf("������һ����ϸ��������λ�ã�");
		  row=input.nextInt();
		  col=input.nextInt(); 			//�����ϸ������ 
		  if (0 <= row && row < ROWLEN && 0 <= col && col < COLLEN)
		  {
			 cell[row][col] = ALIVE; 				//�����ϸ�� 
		  }
		  else if (row == -1 || col == -1)
		  {
			 break;
		  }
		  else
		  {
			 System.out.printf("�������곬����Χ��\n"); 
		  }
	   }
	}
	
	static int LinSum(int row, int col) 					//ͳ������ϸ������ 
	{
	   int count = 0, c, r;

	   for (r = row - 1; r <= row + 1; r++)
	   {
		  for (c = col - 1; c <= col + 1; c++)
		  {
			 if (r < 0 || r >= ROWLEN || c < 0 || c >= COLLEN) 
			 {
				continue; 						//������һ����Ԫ�� 
			 }
			 if (cell[r][c] == ALIVE)				//���Ϊ��ϸ��
			 {
				count++; 						//���ӻ�ϸ�������� 
			 }
		  }
		  
	   }
	   if (cell[row][col] == ALIVE) 					//��ǰ��Ԫ��Ϊ��ϸ�� 
	   {
		  count--; 
	   }
	   return count; 							//�������ܻ�ϸ������ 
	}
	
	static void OutCell() 								//�����ʾϸ��״̬ 
	{
	   int row, col;

	   System.out.printf("\nϸ��״̬\n");
	   System.out.printf("��");	 
	   for (col = 0; col < COLLEN -1; col++)			//���һ��
	   {
		   System.out.printf("����");
	   }
	   System.out.printf("����\n");
	   for (row = 0; row < ROWLEN; row++)
	   {
		   System.out.printf("��");	
		  for (col = 0; col < COLLEN; col++)			//�������Ԫ����ϸ��������״̬ 
		  {
			  switch(cell[row][col])
			  {
			  case ALIVE:
				  System.out.printf("��");					//������ϸ��
				  break;
			  case DEAD:
				  System.out.printf("��");					//�������ϸ�� 
				  break;
			  default:
				  ;
			  }
		  }
		  System.out.printf("\n");

		  if (row < ROWLEN - 1)
		  {
			  System.out.printf("��");	
			 for (col = 0; col < COLLEN - 1; col++)	//���һ�� 
			 {
				 System.out.printf("����");
			 }
			 System.out.printf("����\n");
		  }
	   }
	   System.out.printf("��");
	   for (col = 0; col < COLLEN - 1; col++)			//���һ�еĺ��� 
	   {
		   System.out.printf("����");
	   }
	   System.out.printf("����\n");   
	}
	
	static void cellfun()								//������Ϸ�㷨
	{
	   int row, col,sum;
	   int count=0;

		for (row = 0; row < ROWLEN; row++)
		  {
			 for (col = 0; col < COLLEN; col++)
			 {
				switch (LinSum(row, col)) 		//���ܻ�ϸ������ 
				{
				case 2:
				   celltemp[row][col] = cell[row][col]; //����ϸ��ԭ�� 
				   break;
				case 3:
				   celltemp[row][col] = ALIVE; 		//���� 
				   break;
				default:
				   celltemp[row][col] = DEAD; 		//��ȥ 
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
			     if(cell[row][col] == ALIVE) 	//���ǻ�ϸ�� 
				 {
	                 count++; 				//�ۼӻ�ϸ������ 
				 }
			  }
		  }
		  sum=count;

	      OutCell(); 						//�����ʾ��ǰϸ��״̬ 
	      System.out.printf("��ǰ״̬�£�����%d����ϸ����\n",sum); 
	}
	
	public static void main(String[] args) {
		String go;
		Scanner input=new Scanner(System.in);
		System.out.printf("������Ϸ��\n");
		   initcell(); 							//��ʼ��
		   OutCell();   						//�����ʼϸ��״̬ 
//		   printf("���������ʼ��Ϸ,����ϸ��ת����\n");
//		   getch(); 
		   do{
	       cellfun();						//��ʼ��Ϸ 
	       
	       System.out.print("\n����������һ��ϸ����״̬(y/n)?");
	       go=input.next();
		   }while(go.equalsIgnoreCase("y"));
		   System.out.println("��Ϸ������");

	}

}
