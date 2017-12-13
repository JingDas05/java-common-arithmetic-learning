package top.treegrowth.common.p6;

import java.util.Random;


public class P6_6 {

	public static void main(String[] args) {
		int i,j;											//��������

		Random r=new Random(10); 			        //�������
		for(j=0;j<10;j++)
		{
			for(i=0;i<10;i++)
			{
				System.out.printf("%11d  ",r.nextInt());						//��������
			}
			System.out.print("\n");
		}
	}

}
