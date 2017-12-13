package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_6 {
	static long count; 						//�ƶ��Ĵ��� 

	static void hanoi(int n,char a,char b,char c) 	//��ŵ���㷨 
	{
	    if(n==1)
	    {        
	       System.out.printf("��%d���ƶ�:\tԲ�̴�%c���ƶ���%c��\n",++count,a,c);
	    }
	    else
	    {
	        hanoi(n-1,a,c,b); 			//�ݹ����
	        System.out.printf("��%d���ƶ�:\tԲ�̴�%c���ƶ���%c��\n",++count,a,c);
	        hanoi(n-1,b,a,c); 			//�ݹ����
	    }
	}
	public static void main(String[] args) {
		int n; 						//Բ������ 

	    count=0;
	    System.out.printf("��ŵ��������⣡\n");
	    System.out.printf("�����뺺ŵ��Բ�̵�����:");
	    Scanner input=new Scanner(System.in);
	    n=input.nextInt();
	    hanoi(n,'A','B','C');    			//���
	    System.out.printf("�����ϣ��ܹ���Ҫ%d���ƶ���\n",count);

	}

}
