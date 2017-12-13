package top.treegrowth.common.p5;

import java.util.Scanner;


public class P5_1 {
	static final int N=15;
	static int searchFun(int a[],int n,int x)					//顺序查找函数
	{
	    int i,f=-1;

		for(i=0;i<n;i++)
		{
		    if(x==a[i])
		    {
				f=i;
				break;						//退出
			}
		}

		return f;
	}

	public static void main(String[] args) {
		int x,n,i;
	    int[] shuzu=new int[N];

	    for(i=0;i<N;i++)
		{
			shuzu[i]=(int)(100+Math.random()*(100+1));;			//产生数组
		}
		
		System.out.print("顺序查找算法演示！\n");
	    System.out.print("数据序列:\n");
	    for(i=0;i<N;i++)
		{
	        System.out.print(" "+shuzu[i]);					//输出序列
		}
		System.out.print("\n\n");
	    System.out.print("输入要查找的数:");
	    Scanner input=new Scanner(System.in);
	    x=input.nextInt();							//输入要查找的数

	    n=searchFun(shuzu,N,x);					//查找

	    if(n<0)								//输出查找结果
		{
			System.out.println("没找到数据:"+x);
		}
		else
		{
			System.out.println("数据:"+x+" 位于数组的第"+(n+1)+" 个元素处。");
		}

	}

}
