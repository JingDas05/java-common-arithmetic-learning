package top.treegrowth.common.p6;

public class P6_15 {
	static void cLog(double a,double b,double[] e,double[] f)	//����������
	{
		double temp;
	    temp=Math.log(Math.sqrt(a*a+b*b));
	    e[0]=temp;						//ʵ��
		f[0]=Math.atan2(b,a);					//�鲿
	}
	public static void main(String[] args) {
		double a,b;
		double[] e={0},f={0};
		a=2.0;b=3.0;

		cLog(a,b,e,f);				//����������
		System.out.printf("ln(%f+%fi)= %f+%fi\n",a,b,e[0],f[0]);

	}

}
