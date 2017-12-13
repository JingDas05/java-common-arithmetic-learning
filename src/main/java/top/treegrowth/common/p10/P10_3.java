package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_3 
{
	static void JTTL(int head,int foot,int[] tu,int[] ji)
	{
	    tu[0]=(foot-2*head)/2; 				//���ӵ�����
	    ji[0]=head-tu[0];  					//��������
	}
	public static void main(String[] args) 
	{
		int[] ji={0},tu={0};
		int head,foot;

	    System.out.printf("����ͬ���������!\n");
		System.out.printf("����ͷ��:");
	    Scanner input=new Scanner(System.in);
		head=input.nextInt();				//����ͷ��
	    System.out.printf("�������:");
	    foot=input.nextInt();				//�������
	    
		JTTL(head,foot,tu,ji);
		
	    System.out.printf("����:%dֻ,������:%dֻ��\n",ji[0],tu[0]);

	}
}
