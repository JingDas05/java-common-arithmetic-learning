package top.treegrowth.common.p5;

import java.util.Scanner;


public class P5_2 {
	static final int N=15;
	static void quickSort(int[] arr,int left,int right)			//快速排序算法
	{
	    int f,t;
		int rtemp,ltemp;

	    ltemp=left;
	    rtemp=right;
	    f=arr[(left+right)/2];						//确定分界值
		while(ltemp<rtemp)
		{
	        while(arr[ltemp]<f)
			{
				++ltemp;
			}
	        while(arr[rtemp]>f) 
			{
				--rtemp;
			}
	        if(ltemp<=rtemp)
	        {
				t=arr[ltemp];
		        arr[ltemp]=arr[rtemp];
	    	    arr[rtemp]=t;
				--rtemp;
	        	++ltemp;
			}
	    }
	    if(ltemp==rtemp) 
		{
			ltemp++;
		}

	    if(left<rtemp) 
		{
			quickSort(arr,left,ltemp-1);				//递归调用
		}
	    if(ltemp<right) 
		{
			quickSort(arr,rtemp+1,right);				//递归调用
		}
	}
	
	static int searchFun(int a[],int n,int x)					//折半查找
	{
	    int mid,low,high;

		low=0;
		high=n-1;
	    while(low<=high)
	    {
	   		mid=(low+high)/2;
			if(a[mid]==x)
	            return mid;						//找到
			else if(a[mid]>x)
			    high=mid-1;
	        else
				low=mid+1;
	    }

		return -1;								//未找到
	}
	
	public static void main(String[] args) {
		int[] shuzu=new int[N];
		int x,n,i;

		for(i=0;i<N;i++)
		{
			shuzu[i]=(int)(100+Math.random()*(100+1));;				//产生数组
		}
		
		System.out.print("折半查找算法演示！\n");
	    System.out.print("排序前数据序列:\n");
	    for(i=0;i<N;i++)
		{
	        System.out.print(" "+shuzu[i]);					//输出序列
		}
		System.out.print("\n\n");
		quickSort(shuzu,0,N-1);				//排序
	    System.out.print("排序后数据序列:\n");
	    for(i=0;i<N;i++)
		{
	        System.out.print(" "+shuzu[i]);					//输出序列
		}
		System.out.print("\n\n");
	    System.out.print("输入要查找的数:");
	    Scanner input=new Scanner(System.in);
	    x=input.nextInt();							//输入要查找的数

	    n=searchFun(shuzu,N,x);						//查找

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
