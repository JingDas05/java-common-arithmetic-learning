package top.treegrowth.common.p6;

import java.text.DecimalFormat;


public class P6_5 {
	static void polynomial_div(double A[],int m,double B[],int n,double R[],int k,double L[],int l)
	{
		int i,j,mm,ll;
	    for (i=0; i<k; i++)					//初值
		{
			R[i]=0.0;
		}
	    ll=m-1;
	    for (i=k; i>0; i--)
	    {
			R[i-1]=A[ll]/B[n-1];			//除法，计算商多项式系数
	        mm=ll;
	        for (j=1; j<=n-1; j++)
	        {
				A[mm-1]-=R[i-1]*B[n-j-1];
	            mm-=1;
	        }
	        ll-=1;
	    }
	    for (i=0; i<l; i++)					//余多项式系数
		{
			L[i]=A[i];
		}
	}
	public static void main(String[] args) {
		int i;
	    double A[]={-3.0,6.0,-3.0,4.0,2.0};
	    double B[]={-1.0,+1.0,1.0};
	    double[] R=new double[3];
	    double[] L=new double[2];
	    DecimalFormat df=new DecimalFormat("0.00E000");

	    System.out.print("计算A(x)/B(x)的商多项式和余多项式：\n");
	    polynomial_div(A,5,B,3,R,3,L,2);	//调用函数计算
	    for (i=0; i<=2; i++)				//输出商多项式系数
		{
			System.out.print("商多项式系数 R("+i+")="+df.format(R[i])+"\n");
		}
	    System.out.print("\n");
	    for (i=0; i<=1; i++)				//输出余多项式系数
		{
			System.out.print("余多项式系数 L("+i+")="+df.format(L[i])+"\n");
		}
	    System.out.print("\n");

	}

}
