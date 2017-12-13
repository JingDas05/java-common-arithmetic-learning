package top.treegrowth.common.p9;

public class P9_2 {
	static int[] ga=new int[100],gb=new int[100];				//�������ӵ�����

	static int friendnum(int a)				//���������㷨
	{
			int i,b1,b2,count;
			for(i=0;i<100;i++) 		//������� 
			{
				ga[i]=gb[i]=0;
			}
			count=0;				//�����±� 
			b1=0;				//�ۼӺ� 
			for(i=1;i<a/2+1;i++)		//����a������ 
			{
				if(a%i==0)			//a�ܱ�i���� 
				{
					ga[count++]=i; 	//�������ӵ����飬������� 
					b1+=i;		//�ۼ�����֮�� 
				}
			}
			count=0;
			b2=0;
			for(i=1;i<b1/2+1;i++) 	//����a����֮���ٽ������ӷֽ� 
			{
				if(b1%i==0) 		//b1�ܱ�i���� 
				{
					gb[count++]=i; //�������ӵ����� 
					b2=b2+i;	  	//�ۼ�����֮�� 
				}
			}
			if(b2==a && a<b1) 		//�ж�A��B���������	
			{
				return b1;
			}
			else
			{
				return 0;
			}
	}
	public static void main(String[] args) {
		int i,b,fanwei,count;

		fanwei=5000;				//��ʼ��
		System.out.printf("�о�1~%d֮���������������!\n",fanwei);
		for(i=1;i<fanwei;i++)
		{
			b=friendnum(i);
			if(b!=0)
			{
	            System.out.printf("\n%d--%d����������ʾ�����£�",i,b); //��������� 
	            System.out.printf("\n%d�ĸ�������֮��Ϊ:1",i);
	            count=1;
	            while(ga[count]>0)	//���һ���������� 
	            {
	                System.out.printf("+%d",ga[count]);
	                count++;
	            }
				System.out.printf("=%d\n",b);
	            System.out.printf("%d�ĸ�������֮��Ϊ:1",b);
	            count=1;
	            while(gb[count]>0)	//�����һ���������� 
	            {
	                System.out.printf("+%d",gb[count]);
	                count++;
	            }
				System.out.printf("=%d\n",i);
			}
		}

	}

}
