package top.treegrowth.common.p9;

public class P9_1 {
	static void Perfectnum(long fanwei)		//������ȫ���㷨
	{
	    long[] p=new long[300]; 				//����ֽ������ 
		long i,j,sum,num;
		int k,count;

		for(i=1;i<fanwei;i++)			//ѭ������ÿ1����
		{
			count=0;
			num=i;
			sum=num;
			for(j=1;j<num;j++)		//ѭ������ÿ1����
			{
				if(num % j==0)
				{
					p[count++]=j;	//�������ӣ�������count����1
					sum=sum-j;	//��ȥһ������
				}
			}
			if(sum==0)
			{
	            System.out.printf("%4d��һ����ȫ��,������",num);
	            System.out.printf("%d=%d",num,p[0]); 	//�������
	            for(k=1;k<count;k++) 		//�������
				{
	                System.out.printf("+%d",p[k]);
				}
	            System.out.printf("\n");
			}
		}
	}
	public static void main(String[] args) {
		long fanwei;

		fanwei=10000;					//��ʼ����Χ
		System.out.printf("����%d֮�ڵ���ȫ����\n",fanwei);
		Perfectnum(fanwei);				//������ȫ��

	}

}
