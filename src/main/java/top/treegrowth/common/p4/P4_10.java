package top.treegrowth.common.p4;

import java.util.Scanner;


public class P4_10 {
	static void kuaiSu(char[] a,int left,int right)				//字符快速排序
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
			kuaiSu(a,left,l-1);					//递归调用
		}

	    if(l<right) 
		{
			kuaiSu(a,r+1,right);				//递归调用
		}
	}
	public static void main(String[] args) 
	{
		char[] str=new char[80];
		int N;

		System.out.print("输入一个字符串:");
		Scanner input=new Scanner(System.in);
		str=input.next().toCharArray();							//输入字符串

		N=str.length;
			
		System.out.print("排序前：\n");
		System.out.println(str);				//输出

		kuaiSu(str,0,N-1);							//排序

		System.out.print("排序后：\n");
		System.out.print(str);				//输出
	

	}

}
