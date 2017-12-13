package top.treegrowth.common.p6;

public class P6_13 {
	static void cMul(double a,double b,double c,double d,double[] e,double[] f)		//�˷�
	{
		e[0]=a*c-b*d;
		f[0]=a*d+b*c;
	}
	static void cPowN(double a,double b,int n,double[] e,double[] f)			//������
	{
		double result;
		int i;
		e[0]=a;
		f[0]=b;

		if(n==1)											//1����Ϊ�䱾��
		{
			return;
		}
		else
		{
			for(i=1;i<n;i++)
			{
				cMul(e[0],f[0],a,b,e,f);							//���Ƶõ�n����
			}
		}
	}
	public static void main(String[] args) {
		double a,b;
		double[] e={0},f={0};
		int n;
		a=1;b=1;											//��ʼ��������ʵ�����鲿
		n=5;												//�ݴ�

		cPowN(a,b,n,e,f);									//������
		System.out.printf("(%f+%fi)��%d����= %f+%fi\n",a,b,n,e[0],f[0]);

	}

}
