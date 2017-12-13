package top.treegrowth.common.p6;

public class P6_14 {
	static void cExp(double a,double b,double[] e,double[] f)		//��ָ������
	{
		double temp;
		temp=Math.exp(a);
	    e[0]=temp*Math.cos(b);
		f[0]=temp*Math.sin(b);
	}
	public static void main(String[] args) {
		double a,b;
		double[] e={0},f={0};
		a=3;b=2;									//��ʼ��

		cExp(a,b,e,f);							//��ָ������
		System.out.printf("e��(%f+%fi)����= %f+%fi\n",a,b,e[0],f[0]);

	}

}
