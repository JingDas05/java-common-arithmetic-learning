package top.treegrowth.common.p6;

public class P6_13 {
	static void cMul(double a,double b,double c,double d,double[] e,double[] f)		//乘法
	{
		e[0]=a*c-b*d;
		f[0]=a*d+b*c;
	}
	static void cPowN(double a,double b,int n,double[] e,double[] f)			//幂运算
	{
		double result;
		int i;
		e[0]=a;
		f[0]=b;

		if(n==1)											//1次幂为其本身
		{
			return;
		}
		else
		{
			for(i=1;i<n;i++)
			{
				cMul(e[0],f[0],a,b,e,f);							//递推得到n次幂
			}
		}
	}
	public static void main(String[] args) {
		double a,b;
		double[] e={0},f={0};
		int n;
		a=1;b=1;											//初始化复数的实部和虚部
		n=5;												//幂次

		cPowN(a,b,n,e,f);									//幂运算
		System.out.printf("(%f+%fi)的%d次幂= %f+%fi\n",a,b,n,e[0],f[0]);

	}

}
