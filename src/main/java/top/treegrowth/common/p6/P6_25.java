package top.treegrowth.common.p6;

public class P6_25 {
	static void matrixMul(double A[][],double B[][],int m,int n,int k,double C[][]) 
	{
		int i,j,l;
	    for (i=0; i<m; i++)
		{
			for (j=0; j<n; j++)
			{ 
				C[i][j]=0;
				for(l=0; l<k; l++)
				{
					C[i][j] += (A[i][l] * B[l][j]);	//相乘累加
				}
			}
		}
	}
	public static void main(String[] args) {
		double A[][]={{1.0,2.0,3.0},			//矩阵A
				{4.0,5.0,6.0},
				{7.0,8.0,9.0}};
		double B[][]={{2.0,-2.0,1.0},			//矩阵B
				{1.0,3.0,9.0},
				{17.0,-3.0,7.0}};
		double[][] C=new double[3][3];						//结果矩阵C
		int m,n,k,i,j;
		m=3;								//行数
		n=3;                                //列数
		k=3;

		System.out.print("矩阵A和B相乘的结果为：\n");
		matrixMul(A,B,m,n,k,C);				//运算
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				System.out.printf("%10.6f ",C[i][j]);		//输出结果
			}
			System.out.print("\n");
		}

	}

}
