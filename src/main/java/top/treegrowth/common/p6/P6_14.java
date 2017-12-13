package top.treegrowth.common.p6;

public class P6_14 {
	static void cExp(double a,double b,double[] e,double[] f)		//复指数运算
	{
		double temp;
		temp=Math.exp(a);
	    e[0]=temp*Math.cos(b);
		f[0]=temp*Math.sin(b);
	}
	public static void main(String[] args) {
		double a,b;
		double[] e={0},f={0};
		a=3;b=2;									//初始化

		cExp(a,b,e,f);							//复指数运算
		System.out.printf("e的(%f+%fi)次幂= %f+%fi\n",a,b,e[0],f[0]);

	}

}
