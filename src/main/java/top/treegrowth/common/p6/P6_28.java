package top.treegrowth.common.p6;

public class P6_28 {
	static double func(double x) 								//待求解方程 
	{
	    return x*x*x*x-3*x*x*x+1.5*x*x-4.0;
	}
	static double dfunc(double x) 								//导数方程
	{
	    return 4*x*x*x-9*x*x+3*x;
	}
	static int NewtonMethod(double[] x,int maxcyc,double precision) 
	{
	    double x0,x1;
	    int i;

	    x0=x[0];
		i=0;
		while(i<maxcyc)
	    {
	        if(dfunc(x0)==0.0)							//若通过初值，函数返回值为0
	        {
	            System.out.print("迭代过程中导数为0!\n");
	            return 0;
	        }
	        x1=x0-func(x0)/dfunc(x0);						//牛顿迭代计算 
	        if(Math.abs(x1-x0)<precision || Math.abs(func(x1))<precision) 	//达到预设的结束条件 
	        {
	            x[0]=x1; 									//返回结果 
	            return 1;
	        }
	        else 										//未达到结束条件 
			{
	            x0=x1; 								//准备下一次迭代 
			}
			i++;										//迭代次数累加
	    }
	    System.out.print("迭代次数超过预设值!仍没有达到精度！\n");
	    return 0;
	}
	public static void main(String[] args) {
		double precision;
	    int maxcyc,result;

		double[] x={2.0};										//初始值
		maxcyc=1000;									//迭代次数
		precision=0.00001;								//精度
		result=NewtonMethod(x,maxcyc,precision);
	    if(result==1) 									//得到结果
		{
	        System.out.printf("方程x*x*x*x-3*x*x*x+1.5*x*x-4.0=0\n在2.0附近的根为:%f\n",x[0]);
		}
	    else 											//未得到结果
		{
	        System.out.print("迭代失败!\n");
		}

	}

}
