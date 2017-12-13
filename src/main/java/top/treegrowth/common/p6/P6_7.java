package top.treegrowth.common.p6;

import java.util.Random;


public class P6_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i,j;											//声明变量

		Random r=new Random(); 			        //随机种子
		for(j=0;j<10;j++)
		{
			for(i=0;i<10;i++)
			{
				System.out.printf("%3d  ",r.nextInt(100));						//输出随机数
			}
			System.out.print("\n");
		}

	}

}
