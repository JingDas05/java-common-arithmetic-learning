package top.treegrowth.common.p6;

public class P6_23 {
	static void MatrixPlus(double A[][],double B[][],int m,int n,double C[][]) 
	{
		int i,j;
		for(i=0;i<m;i++)
		    for(j=0;j<n;j++)
		    {
		      C[i][j]=A[i][j]+B[i][j];                     //各元素相加
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
		int m,n,i,j;
		m=3;								//行数
		n=3;								//列数

		System.out.print("矩阵A和B相加的结果为：\n");
		MatrixPlus(A,B,m,n,C);				//运算
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
