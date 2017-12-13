package top.treegrowth.common.p6;

public class P6_12 {
	static void cPlus(double a,double b,double c,double d,double[] e,double[] f)		//�ӷ�
	{
		e[0]=a+c;
		f[0]=b+d;
	}
	static void cMinus(double a,double b,double c,double d,double[] e,double[] f)	//����
	{
		e[0]=a-c;
		f[0]=b-d;
	}

	static void cMul(double a,double b,double c,double d,double[] e,double[] f)		//�˷�
	{
		e[0]=a*c-b*d;
		f[0]=a*d+b*c;
	}

	static void cDiv(double a,double b,double c,double d,double[] e,double[] f)		//����
	{
		double sq;
		sq=c*c+d*d;
		e[0]=(a*c+b*d)/sq;
		f[0]=(b*c-a*d)/sq;
	}
	public static void main(String[] args) {
		double a,b,c,d;
		double[] e={0},f={0};
		a=4;b=6;						//��һ��������ʵ�����鲿
		c=2;d=-1;						//�ڶ���������ʵ�����鲿

		cPlus(a,b,c,d,e,f);			//�ӷ�
		System.out.printf("(%f+%fi) + (%f+%fi)= %f+%fi\n",a,b,c,d,e[0],f[0]);
		cMinus(a,b,c,d,e,f);			//����
		System.out.printf("(%f+%fi) - (%f+%fi)= %f+%fi\n",a,b,c,d,e[0],f[0]);
		cMul(a,b,c,d,e,f);				//�˷�
		System.out.printf("(%f+%fi) * (%f+%fi)= %f+%fi\n",a,b,c,d,e[0],f[0]);
		cDiv(a,b,c,d,e,f);				//����
		System.out.printf("(%f+%fi) / (%f+%fi)= %f+%fi\n",a,b,c,d,e[0],f[0]);
	}

}
