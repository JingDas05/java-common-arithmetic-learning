package top.treegrowth.common.p9;

public class P9_3 {
	static void NarcissusNum(int n)					//�ж�ˮ�ɻ����㷨
	{
		long i,start,end,temp,num,sum;
		int j;

		start=(long)Math.pow(10,n-1);				//��ʼ����
		end=(long)Math.pow(10,n)-1;				//��ֹ����
		for(i=start;i<=end;i++)				//����ж�
		{
			temp=0;
			num=i;
			sum=0;
			for(j=0;j<n;j++)					//�ֽ��λ
			{
				temp=num%10;
				sum=sum+(long)Math.pow(temp,n);	//n�����ۼ�
				num=(num-temp)/10;
			}
			if(sum==i)
			{
				System.out.printf("%d\n",i);				//���ˮ�ɻ���
			}
		}
	}
	public static void main(String[] args) {
		int n;

		n=3;								//��ʼ��λ��
		System.out.printf("�о�%dλ��ˮ�ɻ�����\n",n);
		NarcissusNum(n);					//�о�����ˮ�ɻ���
		System.out.printf("\n");
		n=4;								//��ʼ��λ��
		System.out.printf("�о�%dλ��ˮ�ɻ�����\n",n);
		NarcissusNum(n);					//�о�����ˮ�ɻ���
		System.out.printf("\n");

	}

}
