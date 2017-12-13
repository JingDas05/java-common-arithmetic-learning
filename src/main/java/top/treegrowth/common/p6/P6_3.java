package top.treegrowth.common.p6;

import java.text.DecimalFormat;


public class P6_3 {
	static double polynomial2D(double a[][],int m,int n,double x,double y)
	{
		int i,j;
	    double result,temp,tt;
	    result=0.0; 
		tt=1.0;
	    for(i=0;i<m;i++)						//递推求值
		{
	    	temp=a[i][n-1]*tt;
	        for(j=n-2;j>=0;j--)					//内层的递推算法
			{
	        	 temp=temp*y+a[i][j]*tt;
			}
	        result+=temp; 
			tt*=x;
	      }
	    return result;						//返回结果
	}
	public static void main(String[] args) 
	{
		double result;
		double x,y;
		DecimalFormat df = new DecimalFormat("0.000E000"); 
	    double a[][]={{1.0,2.0,3.0,4.0,5.0},		//初始化二维多项式的系数
	                    {6.0,7.0,8.0,9.0,10.0},
	                    {11.0,12.0,13.0,14.0,15.0},
	                    {16.0,17.0,18.0,19.0,20.0}};

		x=0.5;							//待求值的点
		y=-2.0;
	    System.out.print("二维多项式求值：\n");
	    result=polynomial2D(a,4,5,x,y);			//调用函数计算
	    System.out.print("p("+x+","+y+")="+df.format(result)+"\n");
	    System.out.print("\n");

	}

}
