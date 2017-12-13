package top.treegrowth.common.p10;

public class P10_12 {
	static int count;								//�Ե�����
	static char color[] = "rwbwwbrbwr".toCharArray();				//��ɫ�������е����� 
	static int Blue, Write, Red;
	 
	static void swap(char[] c,int x, int y)				//�Ե�����ʾ
	{
		int i;
	   char temp;

	   temp= c[x];							//�Ե�����
	   c[x] = c[y];
	   c[y] = temp;
	   count++;							//�ۼӶԵ����� 

	   System.out.printf("��%d�ζԵ���",count);
	   for (i = 0; i < color.length; i++)		//����ƶ����Ч�� 
	   {
		  System.out.printf(" %c", color[i]);
	   }
	   System.out.printf("\n");
	}

	static void threeflags()						//��ɫ���㷨
	{
	   while (color[Write] == 'b')				//���� 
	   {
		  Blue++;							//����ƶ�����
		  Write++;						//����ƶ�����
	   }
	   while (color[Red] == 'r')				//���� 
	   {
		  Red--;							//��ǰ�ƶ����� 
		}
	   while (Write <= Red)			
	   {
		  if (color[Write] == 'r')				//���� 
		  {
			 swap(color,Write, Red);	//�Ե�����Ͱ��� 
			 Red--;	  
			 while (color[Red] == 'r')			//���Ǻ��� 
			 {
				Red--;					//��ǰ�ƶ�����
			 }
		  }
		  while (color[Write] == 'w')			//����
		  {
			 Write++;	
		  }
		  if (color[Write] == 'b')				//���� 
		  {
			 swap(color,Write, Blue);	//�Ե�
			 Blue++;	
			 Write++;	
		  }
	   }
	}
	public static void main(String[] args) {
		 int i;

		   Blue=0;							//��ʼ��
		   Write=0;
		   Red=color.length - 1;
		   count=0;

		   System.out.printf("��ɫ���������!\n");
		   System.out.printf("��ɫ���������Ч��:\n");
		   System.out.printf("             ");
		   for (i = 0; i <= Red; i++)				//���������������� 
		   {
			   System.out.printf(" %c", color[i]);
		   }
		   System.out.printf("\n");
		   threeflags();							//���
		   System.out.printf("ͨ��%d����ɶԵ�,���ս������:\n", count);
		   for (i = 0; i < color.length; i++)		//����ƶ����Ч�� 
		   {
			   System.out.printf(" %c", color[i]);
		   }
		   System.out.printf("\n");

	}

}
