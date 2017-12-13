package top.treegrowth.common.p6;

import java.text.DecimalFormat;


public class P6_4 {
	static void polynomial_mul(double A[],int m,double B[],int n,double R[],int k)
	{ 
		int i,j;
	    for (i=0; i<k; i++)						//初始化
		{
			R[i]=0.0;
		}
	    for (i=0; i<m; i++)					//计算各项系数
		{
			for (j=0; j<n; j++)
			{
				R[i+j]+=A[i]*B[j];
			}
		}
	}
	public static void main(String[] args) {
		int i;
	    double A[]={-4.0,5.0,2.0,-1.0,3.0,2.0};
	    double B[]={-3.0,-2.0,1.0,3.0};
	    double[] R=new double[9];
	    DecimalFormat df = new DecimalFormat("0.0000000E000");

	    polynomial_mul(A,6,B,4,R,9);			//调用函数来计算
	    System.out.print("多项式A(x)和B(x)乘积的各项系数如下：\n");
	    for (i=0; i<9; i++)
		{
			System.out.print(" R("+i+")="+df.format(R[i])+"\n");	//输出各项系数
		}
	    System.out.print("\n");

	}

}
