package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_18 {
	static void threeball(int red,int yellow,int green,int n)		//�㷨
	{
		int i,j,k;

		System.out.printf("�ܹ������¼��ֿ���!\n");
		System.out.printf("\t����\t����\t����\n");
		for(i=0;i<=3;i++)         					//��ɫ��
		{
			for(j=0;j<=3;j++)   					//��ɫ��
			{
				for(k=0;k<=6;k++)				//��ɫ��
				{
					if(i+j+k== n)				//�ж��Ƿ����
					{
						System.out.printf("\t%d\t%d\t%d\n",i,j,k);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int red,yellow,green;
		int n;

		System.out.printf("��ɫ��������⣡\n");
		System.out.printf("����������������Ϊ:");
		Scanner input=new Scanner(System.in);
		red=input.nextInt();						//���������
		System.out.printf("����������������Ϊ:");
		yellow=input.nextInt();						//���������
		System.out.printf("�����������������Ϊ:");
		green=input.nextInt();						//���������
		System.out.printf("��������ȡ���������Ϊ:");
		n=input.nextInt();							//ȡ���������

		threeball(red,yellow,green,n);				//���

	}

}
