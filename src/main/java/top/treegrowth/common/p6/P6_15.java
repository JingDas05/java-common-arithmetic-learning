package top.treegrowth.common.p6;

public class P6_15 {
	static void cLog(double a,double b,double[] e,double[] f)	//复对数运算
	{
		double temp;
	    temp=Math.log(Math.sqrt(a*a+b*b));
	    e[0]=temp;						//实部
		f[0]=Math.atan2(b,a);					//虚部
	}
	public static void main(String[] args) {
		double a,b;
		double[] e={0},f={0};
		a=2.0;b=3.0;

		cLog(a,b,e,f);				//复对数运算
		System.out.printf("ln(%f+%fi)= %f+%fi\n",a,b,e[0],f[0]);

	}

}
