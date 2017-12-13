package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_5 {
	static double MontePI(int n) 				//���ؿ����㷨
	{
		double PI;
	    double x,y;
		int i,sum;
		sum=0;
	    for(i=1;i<n;i++)
	    {
	        x=Math.random();	//����0~1֮���һ������� 
	        y=Math.random();	//����0~1֮���һ������� 
	        if((x*x+y*y)<=1)				//������Ӱ���� 
	            sum++;				//���� 
	    }
		PI=4.0*sum/n;					//����PI
		return PI;
	}
	public static void main(String[] args) {
		int n; 
		double PI;
		System.out.println("���ؿ��޸����㷨�����:");
		Scanner input=new Scanner(System.in);
		System.out.print("����������:");
	    n=input.nextInt(); 				//�����������
	    PI=MontePI(n);					//����PI
	    System.out.println("PI="+PI); 				//������ 
	}
}
