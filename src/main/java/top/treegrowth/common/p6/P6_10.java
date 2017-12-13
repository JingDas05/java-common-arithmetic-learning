package top.treegrowth.common.p6;

public class P6_10 {
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
	public static void main(String[] args) {
		int i,m,n;
	    double[] r={5.0};
		m=100;
		n=200;

	    System.out.print("产生10个[100,200]之间的随机整数：\n");
	    for (i=0; i<10; i++)				//循环调用
		{
	       System.out.printf(" %d\n",m+(int)((n-m)*rand01(r)));
		}
	    System.out.print("\n");

	}

}
