package top.treegrowth.common.p6;

import java.text.DecimalFormat;


public class P6_4 {
	static void polynomial_mul(double A[],int m,double B[],int n,double R[],int k)
	{ 
		int i,j;
	    for (i=0; i<k; i++)						//��ʼ��
		{
			R[i]=0.0;
		}
	    for (i=0; i<m; i++)					//�������ϵ��
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

	    polynomial_mul(A,6,B,4,R,9);			//���ú���������
	    System.out.print("����ʽA(x)��B(x)�˻��ĸ���ϵ�����£�\n");
	    for (i=0; i<9; i++)
		{
			System.out.print(" R("+i+")="+df.format(R[i])+"\n");	//�������ϵ��
		}
	    System.out.print("\n");

	}

}
