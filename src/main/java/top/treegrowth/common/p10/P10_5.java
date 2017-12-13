package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_5 {
	static double mai(int n)					//�ằ�������㷨
	{
		int i;
		double temp,sum;

		temp=1;
		sum=0;						//�ܺ�

		for(i=1;i<=n;i++)				//����ȱȼ����ĺ�
	    {
	        temp=temp*2;
	        sum=sum+temp;
	    }
		return sum;
	}
	public static void main(String[] args) {
		int n;
		double sum;

		System.out.printf("�ằ������������⣡\n");
		System.out.printf("�������̸�����:");
	    Scanner input=new Scanner(System.in);
		n=input.nextInt(); 
		sum=mai(n);					//���
	    System.out.printf("�ằ������������Ϊ:%f����\n",sum);
	    System.out.printf("��:%.2f�֡�\n",sum/25000/1000);

	}

}
