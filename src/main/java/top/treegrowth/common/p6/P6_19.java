package top.treegrowth.common.p6;

import java.util.Scanner;


public class P6_19 {
	static long fact(int n)								//求阶乘函数
	{
	    if(n<=1)
	        return 1;
	    else
	        return n*fact(n-1);			//递归
	}
	public static void main(String[] args) {
int i;									//声明变量
		
	    System.out.print("请输入要求阶乘的一个整数："); 
	    Scanner input=new Scanner(System.in);
	    i=input.nextInt();							//输入数据
	    System.out.println(i+"的阶乘结果为："+fact(i)); 		//调用函数

	}

}
