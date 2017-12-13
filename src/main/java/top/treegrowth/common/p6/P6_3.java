package top.treegrowth.common.p6;

import java.text.DecimalFormat;


public class P6_3 {
	static double polynomial2D(double a[][],int m,int n,double x,double y)
	{
		int i,j;
	    double result,temp,tt;
	    result=0.0; 
		tt=1.0;
	    for(i=0;i<m;i++)						//������ֵ
		{
	    	temp=a[i][n-1]*tt;
	        for(j=n-2;j>=0;j--)					//�ڲ�ĵ����㷨
			{
	        	 temp=temp*y+a[i][j]*tt;
			}
	        result+=temp; 
			tt*=x;
	      }
	    return result;						//���ؽ��
	}
	public static void main(String[] args) 
	{
		double result;
		double x,y;
		DecimalFormat df = new DecimalFormat("0.000E000"); 
	    double a[][]={{1.0,2.0,3.0,4.0,5.0},		//��ʼ����ά����ʽ��ϵ��
	                    {6.0,7.0,8.0,9.0,10.0},
	                    {11.0,12.0,13.0,14.0,15.0},
	                    {16.0,17.0,18.0,19.0,20.0}};

		x=0.5;							//����ֵ�ĵ�
		y=-2.0;
	    System.out.print("��ά����ʽ��ֵ��\n");
	    result=polynomial2D(a,4,5,x,y);			//���ú�������
	    System.out.print("p("+x+","+y+")="+df.format(result)+"\n");
	    System.out.print("\n");

	}

}
