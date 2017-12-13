package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_1{
	static int chichen,habbit; //chichen代表鸡的个数，habbit代表兔的个数
	public static  int qiongJu(int head , int foot) {//穷举算法
		int re,i,j; 
		re=0;
	    for(i=0;i<=head;i++)						//循环
	    {
	        j=head-i;
	        if(i*2+j*4==foot)						//判断，找到答案
	        {
	           re=1;  
			   chichen=i;
			   habbit=j;
	        } 
	    }
	    return re;
	}
	public static void main(String[] args) {       //主方法
		int re,head,foot;
		System.out.println("穷举法求解鸡兔同笼问题:");
		System.out.print("请输入头数：");
		Scanner input=new Scanner(System.in);
		head=input.nextInt();                     //输入头数
		System.out.print("请输入脚数：");
		foot=input.nextInt();                     //输入脚数
		re=qiongJu(head,foot);
		if(re==1){
			System.out.println("鸡有"+chichen+"只，兔有"+habbit+"只。");
		}
		else{
			System.out.println("无法求解！");
		}
	}
}
