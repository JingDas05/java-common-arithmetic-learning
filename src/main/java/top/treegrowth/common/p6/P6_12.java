package top.treegrowth.common.p6;

public class P6_12 {
	static void cPlus(double a,double b,double c,double d,double[] e,double[] f)		//加法
	{
		e[0]=a+c;
		f[0]=b+d;
	}
	static void cMinus(double a,double b,double c,double d,double[] e,double[] f)	//减法
	{
		e[0]=a-c;
		f[0]=b-d;
	}

	static void cMul(double a,double b,double c,double d,double[] e,double[] f)		//乘法
	{
		e[0]=a*c-b*d;
		f[0]=a*d+b*c;
	}

	static void cDiv(double a,double b,double c,double d,double[] e,double[] f)		//除法
	{
		double sq;
		sq=c*c+d*d;
		e[0]=(a*c+b*d)/sq;
		f[0]=(b*c-a*d)/sq;
	}
	public static void main(String[] args) {
		double a,b,c,d;
		double[] e={0},f={0};
		a=4;b=6;						//第一个复数的实部和虚部
		c=2;d=-1;						//第二个复数的实部和虚部

		cPlus(a,b,c,d,e,f);			//加法
		System.out.printf("(%f+%fi) + (%f+%fi)= %f+%fi\n",a,b,c,d,e[0],f[0]);
		cMinus(a,b,c,d,e,f);			//减法
		System.out.printf("(%f+%fi) - (%f+%fi)= %f+%fi\n",a,b,c,d,e[0],f[0]);
		cMul(a,b,c,d,e,f);				//乘法
		System.out.printf("(%f+%fi) * (%f+%fi)= %f+%fi\n",a,b,c,d,e[0],f[0]);
		cDiv(a,b,c,d,e,f);				//除法
		System.out.printf("(%f+%fi) / (%f+%fi)= %f+%fi\n",a,b,c,d,e[0],f[0]);
	}

}
