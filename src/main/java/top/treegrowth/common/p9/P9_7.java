package top.treegrowth.common.p9;

public class P9_7 {
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
	    return 1;       			//������ 
	}
	public static void main(String[] args) {
		int i,n,count;

		n=1000;				//��Χ
		count=0;
		System.out.printf("�о�1~1000֮�����е�������\n");
		for(i=1;i<1000;i++)
		{
			if(isPrime(i)==1)	//���������
			{
				System.out.printf("%7d",i);
				count++;
				if(count%10==0)//10��һ��
				{
					System.out.printf("\n");
				}
			}
		}
		System.out.printf("\n");

	}

}
