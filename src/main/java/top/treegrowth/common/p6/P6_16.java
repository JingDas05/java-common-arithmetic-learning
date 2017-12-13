package top.treegrowth.common.p6;

public class P6_16 {
	static void cSin(double a,double b,double[] e,double[] f)	//复正弦
	{
		double p,q;
	    p=Math.exp(b); 
		q=1/p;
	    e[0]=Math.sin(a)*(p+q)/2.0; 						//实部
		f[0]=Math.cos(a)*(p-q)/2.0;						//虚部
	}
	public static void main(String[] args) {
		double a,b;
		double[] e={0},f={0};
		a=1.0;b=4.0;							//初始化

		cSin(a,b,e,f);						//复正弦运算
		System.out.printf("sin(%f+%fi)= %f+%fi\n",a,b,e[0],f[0]);

	}

}
