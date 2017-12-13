package top.treegrowth.common.p4;

import java.util.Scanner;


public class P4_10 {
	static void kuaiSu(char[] a,int left,int right)				//�ַ���������
	{
	    int f,l,r;
	    char t;

	    l=left;
	    r=right;
	    f=a[(left+right)/2];
		while(l<r)
		{
	        while(a[l]<f) ++l;
	        while(a[r]>f) --r;
	        if(l<=r)
	        {
				t=a[l];
		        a[l]=a[r];
	    	    a[r]=t;
	        	++l;
				--r;
			}
	    }
	    if(l==r) 
			l++;
	    if(left<r) 
		{
			kuaiSu(a,left,l-1);					//�ݹ����
		}

	    if(l<right) 
		{
			kuaiSu(a,r+1,right);				//�ݹ����
		}
	}
	public static void main(String[] args) 
	{
		char[] str=new char[80];
		int N;

		System.out.print("����һ���ַ���:");
		Scanner input=new Scanner(System.in);
		str=input.next().toCharArray();							//�����ַ���

		N=str.length;
			
		System.out.print("����ǰ��\n");
		System.out.println(str);				//���

		kuaiSu(str,0,N-1);							//����

		System.out.print("�����\n");
		System.out.print(str);				//���
	

	}

}
