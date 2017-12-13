package top.treegrowth.common.p11;

import java.util.Random;
import java.util.Scanner;


public class P11_2 {
	static int computer,user,last;
	static Scanner input=new Scanner(System.in);
	static void quhuochai()							//��Ϸ�㷨
	{
		Random r=new Random();							//�������
		while(true)
	   {
	        System.out.printf(" ----------  Ŀǰ���л�� %d �� ----------\n",last);
	        System.out.printf("�û�ȡ�������:") ;
	       
	        user=input.nextInt();					//�û�ȡ�������
	        if(user<1 || user>4 || user>last)
	        {
				System.out.printf("��Υ���ˣ���ȡ�Ļ����������!\n\n");
				continue;
			}
	        last = last - user;						//ʣ��������
	        if(last == 0)
			{
				System.out.printf("\n�û�ȡ�����һ�����,��˼����Ӯ��!\n"); 
				break;
			}
			else
			{
				if(last>5)						//�����ȡ�������
				{
					computer=r.nextInt(5);
				}
				else if(last<=1)
				{
					computer=1;
				}
				else
				{
					computer=last-1;
				}
				last = last - computer;
				System.out.printf("�����ȡ�������:%d  \n",computer);
				if(last == 0)
				{
					System.out.printf("\n�����ȡ�����һ�����,����û�Ӯ��!\n"); 
					break;
				}
			}
	   }
	}
	public static void main(String[] args) {
		int num;

		System.out.printf("ȡ�����Ϸ��\n");
		System.out.printf("���������������Ϊ:");
		num=input.nextInt();						//��������
		System.out.printf("��������Ϊ%d��",num);
		last=num;
		quhuochai();						//ִ����Ϸ

	}

}
