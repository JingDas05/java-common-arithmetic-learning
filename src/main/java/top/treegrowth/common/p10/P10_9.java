package top.treegrowth.common.p10;

public class P10_9 {
	static int iCount = 0;						//ȫ�ֱ���
	static int[] WeiZhi=new int[8];						//ȫ������

	static void Output()						//�����
	{
	   int i,j,flag=1;
	   System.out.printf("��%2d�ַ���(���ʾ�ʺ�):\n", ++iCount);//�����š� 
	   System.out.printf("  ");
	   for(i=1;i<=8;i++)
	   {
	       System.out.printf("�x");
	   }
	   System.out.printf("\n");
	   for (i = 0; i < 8; i++)
	   {
	       System.out.printf("��");
	       for (j = 0; j < 8; j++)
	       {
	           if(WeiZhi[i]-1 == j)
			   {
	               System.out.printf("��");			//�ʺ��λ��
			   }
	           else
	           {
	               if (flag<0)
				   {
	                   System.out.printf("     ");		//���
				   }
	               else
				   {
	                   System.out.printf("��");    		//���            
				   }
	           }
	           flag=-1*flag;
	       }
	       System.out.printf("��\n");
	       flag=-1*flag;
	   }
	   System.out.printf("  ");
	   for(i=1;i<=8;i++)
	   {
	       System.out.printf("��");
	   }
	   System.out.printf("\n");  
	}

	static void EightQueen(int n)				// �㷨
	{
	   int i,j;
	   int ct;							//�����ж��Ƿ��ͻ
	   if (n == 8)						//��8���ʺ��ѷ������
	   {
		  Output(); 					//������Ľ��
		  return;
	   }
	   for (i = 1; i <= 8; i++)				//��̽
	   { 
		  WeiZhi[n] = i;					//�ڸ��еĵ�i���Ϸ���
		  //�ϵ�n���ʺ��Ƿ���ǰ��ʺ��γɹ���
		  ct=1;
		for (j = 0; j < n; j++) 
		{
	 	  if (WeiZhi[j] == WeiZhi[n])		// �γɹ���
		  {
			 ct=0;
		  }
	 	  else if (Math.abs(WeiZhi[j] - WeiZhi[n]) == (n - j))// �γɹ���
		  {
			 ct=0;
		  }
		  else
		  {
		  }
		}

		  if (ct==1)					//û�г�ͻ���Ϳ�ʼ��һ�е���̽
			 EightQueen(n + 1); 		//�ݹ����
	   }
	}
	public static void main(String[] args) 
	{
		 System.out.printf("�˻ʺ�������⣡\n"); 
		   System.out.printf("�˻ʺ����з���:\n"); 
		   EightQueen(0);					//���

	}

}
