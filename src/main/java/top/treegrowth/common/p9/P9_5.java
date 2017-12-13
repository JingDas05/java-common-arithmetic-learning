package top.treegrowth.common.p9;

import java.util.Scanner;


public class P9_5 {
	static int gcd(int a, int b) 			//���Լ�� 
	{
	    int m,n,r;
		if(a>b)				//m����ϴ���,n�����С��
		{
			m=a;
			n=b;
		}
		else
		{
			m=b;
			n=a;
		}
	    r=m%n; 				//������ 
	    while(r!=0) 			//շת��� 
	    {
	        m=n;
	        n=r;
	        r=m%n;
	    }
	    return n; 				//�������Լ�� 
	}
	public static void main(String[] args) {
		int a,b,c;
		
	    System.out.printf("��������������:");
	    Scanner input=new Scanner(System.in);
	    a=input.nextInt();
	    b=input.nextInt();	//��������
		c=gcd(a,b);
	    System.out.printf("%d��%d�����Լ��:%d\n",a,b,gcd(a,b));

	}

}
