package top.treegrowth.common.p6;

import java.util.Random;
import java.util.Scanner;


public class P6_21 {
	static double montePI(int n) 				//���ؿ����㷨
	{
		int i,sum;
		double PI;
	    double x,y;
		sum=0;

		Random r=new Random();    
	    for(i=1;i<n;i++)
	    {
	        x=r.nextDouble();	//����0~1֮���һ������� 
	        y=r.nextDouble();	//����0~1֮���һ������� 
	        if((x*x+y*y)<=1)				//������Ӱ���� 
	            sum++;				//���� 
	    }
		PI=4.0*sum/n;					//����PI
		return PI;
	}
	public static void main(String[] args) {
		int n; 
		double PI;

	    System.out.print("����������:");
	    Scanner input=new Scanner(System.in);
	    n=input.nextInt(); 				//�����������
	    PI=montePI(n);					//����PI
	    System.out.println("PI="+PI); 				//������ 

	}

}
