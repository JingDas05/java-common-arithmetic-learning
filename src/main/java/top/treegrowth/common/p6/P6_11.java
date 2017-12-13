package top.treegrowth.common.p6;

public class P6_11 {
	static double rand01(double[] r)
	{
	    double base,u,v,p,temp1,temp2,temp3;
	    base=256.0;					//基数
		u=17.0; 
		v=139.0;

		temp1=u*(r[0])+v;				//计算总值
		temp2=(int)(temp1/base);			//计算商
		temp3=temp1-temp2*base;		//计算余数
		r[0]=temp3;						//更新随机种子，为下一次使用
		p=r[0]/base;						//随机数

	    return p;
	}
	static double randZT(double u,double t, double[] r)	//正态分布的随机数
	{
		int i;
		double total=0.0;
		double result;
		for(i=0;i<12;i++)
		{
			total+=rand01(r);				//累加
		}
		result=u+t*(total-6.0);				//随机数
		return result;
	}
	public static void main(String[] args) {
		int i;
	    double u,t;
	    double[] r={5.0};
		u=2.0;
		t=3.5;

	    System.out.print("产生10个正态分布的随机数：\n");
	    for (i=0; i<10; i++)				//循环调用
		{
	       System.out.printf("%10.5f\n",randZT(u,t,r));
		}
	    System.out.print("\n");

	}

}
