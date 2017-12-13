package top.treegrowth.common.p6;

import java.util.Random;


public class P6_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i,j;											//��������

		Random r=new Random(); 			        //�������
		for(j=0;j<10;j++)
		{
			for(i=0;i<10;i++)
			{
				System.out.printf("%3d  ",r.nextInt(100));						//��������
			}
			System.out.print("\n");
		}

	}

}
