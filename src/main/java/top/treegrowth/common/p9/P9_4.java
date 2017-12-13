package top.treegrowth.common.p9;

public class P9_4 {
	static int zishounum1(long n)				//�ж��������㷨1
	{
		long temp,m,k;
		int count;

		k=1;
		count=0;
		while(k>0)						//�ж�λ��
		{
			k=n-(long)Math.pow(10,count);
			count++;
		}
		m=count-1;					//λ��
		temp=(n*n)%((long)(Math.pow(10,m)));	
		if(temp==n)					//�ж��Ƿ�Ϊ������
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	static int zishounum2(long num) 			//�ж��������㷨2
	{
	    long faciend,mod,n_mod,p_mod; 	//mod��������ϵ����n_mod������ϵ��,p_mod���ֳ˻���ϵ�� 
	    long t,n;  						//��ʱ���� 

		faciend=num; 					//������ 
	    mod=1;
	    do
		{
	        mod*=10; 					//��������ϵ�� 
	        faciend/=10;
	    }while(faciend>0); 				//ѭ�������������ϵ�� 
	    p_mod=mod; 					//p_modΪ��ȡ���ֻ�ʱ��ϵ�� 
	    faciend=0; 					//�������Nλ 
	    n_mod=10; 					//��ȡ������Ӧλʱ��ϵ�� 
	    while(mod>0)
	    {
	       t=num % (mod*10); 			//��ȡ������ 
	       n=num%n_mod-num%(n_mod/10);//�ֽ��ÿһλ������Ϊ���� 
	       t=t*n; 						//��˵Ľ�� 
	       faciend=(faciend+t)%p_mod; 	//��ȡ�˻��ĺ��漸λ
	       mod/=10; 					//������������ϵ�� 
	       n_mod*=10; 				//����������ϵ�� 
	    }
	    if(num==faciend) 				//�ж���������������
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public static void main(String[] args) {
		long i;

		System.out.printf("��һ���㷨������������\n");
		for(i=2;i<1000;i++)
		{
			if(zishounum1(i)==1)			//���õ�һ���㷨
			{
				System.out.printf("%d ",i);
			}
		}
		System.out.printf("\n");

		System.out.printf("�ڶ����㷨������������\n");
		for(i=2;i<200000;i++)
		{
			if(zishounum2(i)==1)			//���õڶ����㷨
			{
				System.out.printf("%d ",i);
			}
		}
		System.out.printf("\n");
	}

}
