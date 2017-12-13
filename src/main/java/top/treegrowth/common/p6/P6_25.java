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
					C[i][j] += (A[i][l] * B[l][j]);	//����ۼ�
				}
			}
		}
	}
	public static void main(String[] args) {
		double A[][]={{1.0,2.0,3.0},			//����A
				{4.0,5.0,6.0},
				{7.0,8.0,9.0}};
		double B[][]={{2.0,-2.0,1.0},			//����B
				{1.0,3.0,9.0},
				{17.0,-3.0,7.0}};
		double[][] C=new double[3][3];						//�������C
		int m,n,k,i,j;
		m=3;								//����
		n=3;                                //����
		k=3;

		System.out.print("����A��B��˵Ľ��Ϊ��\n");
		matrixMul(A,B,m,n,k,C);				//����
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				System.out.printf("%10.6f ",C[i][j]);		//������
			}
			System.out.print("\n");
		}

	}

}
