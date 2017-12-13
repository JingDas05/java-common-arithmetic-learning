package top.treegrowth.common.p5;

import java.util.Scanner;


public class P5_1 {
	static final int N=15;
	static int searchFun(int a[],int n,int x)					//˳����Һ���
	{
	    int i,f=-1;

		for(i=0;i<n;i++)
		{
		    if(x==a[i])
		    {
				f=i;
				break;						//�˳�
			}
		}

		return f;
	}

	public static void main(String[] args) {
		int x,n,i;
	    int[] shuzu=new int[N];

	    for(i=0;i<N;i++)
		{
			shuzu[i]=(int)(100+Math.random()*(100+1));;			//��������
		}
		
		System.out.print("˳������㷨��ʾ��\n");
	    System.out.print("��������:\n");
	    for(i=0;i<N;i++)
		{
	        System.out.print(" "+shuzu[i]);					//�������
		}
		System.out.print("\n\n");
	    System.out.print("����Ҫ���ҵ���:");
	    Scanner input=new Scanner(System.in);
	    x=input.nextInt();							//����Ҫ���ҵ���

	    n=searchFun(shuzu,N,x);					//����

	    if(n<0)								//������ҽ��
		{
			System.out.println("û�ҵ�����:"+x);
		}
		else
		{
			System.out.println("����:"+x+" λ������ĵ�"+(n+1)+" ��Ԫ�ش���");
		}

	}

}
