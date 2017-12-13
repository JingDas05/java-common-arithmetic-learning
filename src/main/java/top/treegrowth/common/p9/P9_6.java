package top.treegrowth.common.p9;

import java.util.Scanner;


public class P9_6 {
	static int gcd(int a, int b) 			//���Լ�� 
	{
	    int m,n;

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
	   if(n==0)				//����С��Ϊ0 
	   {
	       return m; 			//������һ��Ϊ���Լ�� 
	   }
	   if(m%2==0 && n%2 ==0)	//m��n����ż�� 
	   {
	       return 2*gcd(m/2,n/2); 	//�ݹ����gcd��������m��n������2 
	   }
	   if ( m%2 == 0)			//mΪż�� 
	   {
	       return gcd(m/2,n); 	//�ݹ����gcd��������m����2 
	   }
	   if ( n%2==0 )			//nΪż�� 
	   {
	       return gcd(m,n/2);		//�ݹ����gcd��������n����2
	   }
	   return gcd((m+n)/2,(m-n)/2);//m��n�����������ݹ����gcd
	}

	static int lcm(int a,int b) 			//��С������ 
	{
	    int c,d;

		c= gcd(a,b); 			//��ȡ���Լ��
		d=(a*b)/c;
	    return d; 				//������С������ 
	}
	public static void main(String[] args) {
		int a,b,c,d;
	    System.out.printf("��������������:");
	    Scanner input=new Scanner(System.in);
	    a=input.nextInt();
	    b=input.nextInt();	//��������
		c=gcd(a,b);			//���Լ��
	    System.out.printf("%d��%d�����Լ��:%d\n",a,b,c);
		d=lcm(a,b);			//��С������
	    System.out.printf("%d��%d����С������:%d\n",a,b,d);
	}

}
