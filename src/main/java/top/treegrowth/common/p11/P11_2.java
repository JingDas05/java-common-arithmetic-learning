package top.treegrowth.common.p11;

import java.util.Random;
import java.util.Scanner;


public class P11_2 {
	static int computer,user,last;
	static Scanner input=new Scanner(System.in);
	static void quhuochai()							//游戏算法
	{
		Random r=new Random();							//随机种子
		while(true)
	   {
	        System.out.printf(" ----------  目前还有火柴 %d 根 ----------\n",last);
	        System.out.printf("用户取火柴数量:") ;
	       
	        user=input.nextInt();					//用户取火柴数量
	        if(user<1 || user>4 || user>last)
	        {
				System.out.printf("你违规了，你取的火柴数有问题!\n\n");
				continue;
			}
	        last = last - user;						//剩余火柴数量
	        if(last == 0)
			{
				System.out.printf("\n用户取了最后一个火柴,因此计算机赢了!\n"); 
				break;
			}
			else
			{
				if(last>5)						//计算机取火柴数量
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
				System.out.printf("计算机取火柴数量:%d  \n",computer);
				if(last == 0)
				{
					System.out.printf("\n计算机取了最后一根火柴,因此用户赢了!\n"); 
					break;
				}
			}
	   }
	}
	public static void main(String[] args) {
		int num;

		System.out.printf("取火柴游戏！\n");
		System.out.printf("请先输入火柴的总量为:");
		num=input.nextInt();						//火柴的总量
		System.out.printf("火柴的总量为%d：",num);
		last=num;
		quhuochai();						//执行游戏

	}

}
