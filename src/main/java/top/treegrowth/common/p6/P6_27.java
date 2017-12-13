package top.treegrowth.common.p6;

public class P6_27 {
	static double func(double x) 			//函数 
	{
	    return  2*x*x*x-5*x-1;
	}
	static double erfen(double a,double b,double err)	//二分算法
	{
	    double c;
	    c=(a+b)/2.0;				//中间值

	    while(Math.abs(func(c))>err && func(a-b)>err)
	    {
	        if(func(c)*func(b)<0) 		//确定新的区间 
			{
	            a=c; 
			}
	        if(func(a)*func(c)<0)
			{
	            b=c; 
			}
	        c=(a+b)/2; 				//二分法确定新的区间 
	    }

		return c;
	}
	public static void main(String[] args) {
		double a=1.0,b=2.0;			//初始区间 
		double err=1e-5;			//绝对误差
	    double result;

	    result=erfen(a,b,err);
	    System.out.print("二分法解方程:2*x*x*x-5*x-1\n");
	    System.out.printf("结果x=%.5f\n",result); //输出解 

	}

}
