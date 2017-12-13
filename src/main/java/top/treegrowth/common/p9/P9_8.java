package top.treegrowth.common.p9;

public class P9_8 {
	static int isPrime(int a)			//�����㷨
	{  
	    int i;
	    for(i=2;i<a;i++)
		{
			if(a % i == 0)
			{
				return 0;      //�������� 
			}
		}
	    return 1;      			//������ 
	}

	static int huiwen(int n)			//���������㷨
	{
		int temp,m,k,t,num,sum;
		int count,i;

		k=1;
		count=0;
		while(k>0)				//�ж�λ��
		{
			k=n-(int)Math.pow(10,count);
			count++;
		}
		m=count-1;			//λ��

		sum=0;
		num=n;
		for(i=0;i<m;i++)			//��λ���������ߵ�λ
		{
			temp=num%10;
			sum=sum+temp*((int)Math.pow(10,m-1-i));
			num=(num-temp)/10;
		}
		t=sum;
		if(t==n)
		{
			if(isPrime(n)==1)
			{
				return 1;		//�ǻ�������
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
	}
	public static void main(String[] args) {
		int i,count;

		count=0;
		System.out.printf("�о�0~50000֮��Ļ�������\n");
		for(i=10;i<50000;i++)		//�оٻ�������
		{
			if(huiwen(i)==1)
			{
				System.out.printf("%7d",i);
				count++;
				if(count%10==0)//10��Ϊһ��
				{
					System.out.printf("\n");
				}
			}
		}
		System.out.printf("\n");

	}

}
