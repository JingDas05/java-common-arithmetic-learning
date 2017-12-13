package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_13 
{
	static int fish(int yufu)								//�游�����㷨
	{
		int init;
		int n;
		int s;

		init=yufu+1;
		n=yufu-1;
	   s = init;
	   while(n!=0)
	   {
	        s=5*s+1;							//����
	        n--;
	   }
	   return s;
	}
	public static void main(String[] args) 
	{
		int num;
		int yufu;

		System.out.printf("�游����������⣡\n");
		System.out.printf("���������游�ĸ�����");
		Scanner input=new Scanner(System.in);
		yufu=input.nextInt();						//�游����
		num=fish(yufu);							//���
	    System.out.printf("������ٺϻﲶ��%d���㣡\n",num);

	}

}
