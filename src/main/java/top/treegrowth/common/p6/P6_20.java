package top.treegrowth.common.p6;

import java.util.Scanner;


public class P6_20 {
	static void cyclotomic(int n)			//��Բ���㷨
	{
		int i,s;
		double k,len;
		i=0;
		k=3.0;					//��ֵ
		len=1.0;					//�߳���ֵ
		s=6;						//��ʼ�ڽ���6����

		while(i<=n)
	    {
	        System.out.printf("��%2d���и�,Ϊ��%5d����,PI=%.24f\n",i,s,k*Math.sqrt(len));
	        s*=2;					//�����ӱ� 
	        len=2-Math.sqrt(4-len); 		//�ڽӶ���εı߳� 
	        i++;
	        k*=2.0;        
	    } 
	}
	public static void main(String[] args) {
		int n;
	    System.out.print("�����и����:");
	    Scanner input=new Scanner(System.in);
	    n=input.nextInt(); 			//�����и����
		cyclotomic(n);				//����ÿ���и��Բ����

	}

}
