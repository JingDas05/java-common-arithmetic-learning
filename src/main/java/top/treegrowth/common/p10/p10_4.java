package top.treegrowth.common.p10;

import java.util.Scanner;


public class p10_4 {
	static int peach(int n) 					//���ӳ����㷨
	{
		int pe;
	    if(n==1)
		{
	        return 1;  					//��10���ֻʣ1����
		}
	    else
		{
			pe=(peach(n-1)+1)*2; 		//ǰһ���ܱȺ�1���һ���1
		}
	    return pe; 
	}
	public static void main(String[] args) 
	{
		int n; 						//���� 
	    int peachnum; 				//��������� 

	    System.out.printf("���ӳ���������⣡\n");
		System.out.printf("��������:");
	    Scanner input=new Scanner(System.in);
		n=input.nextInt(); 
		
	    peachnum=peach(n);				//���
	    System.out.printf("�����������Ϊ:%d����\n",peachnum);

	}

}
