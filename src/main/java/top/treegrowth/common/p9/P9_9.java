package top.treegrowth.common.p9;

public class P9_9 {
	static int pingfanghuiwen(int a)				//�㷨
	{
		int temp,m,k,t,num,sum;
		int count,i,n;

		n=a*a;
		k=1;
		count=0;
		while(k>0)						//�ж�λ��
		{
			k=n-(int)Math.pow(10,count);
			count++;
		}
		m=count-1;					//λ��

		sum=0;
		num=n;
		for(i=0;i<m;i++)					//��λ���������ߵ�λ
		{
			temp=num%10;
			sum=sum+temp*((int)Math.pow(10,m-1-i));
			num=(num-temp)/10;
		}
		t=sum;
		if(t==n)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public static void main(String[] args) {
		int i;

		System.out.printf("�о�ƽ����������\n");
		for(i=10;i<1000;i++)
		{
			if(pingfanghuiwen(i)==1)		//�о�ƽ��������
			{
				System.out.printf("%d*%d=%d\n",i,i,i*i);
			}
		}

	}

}
