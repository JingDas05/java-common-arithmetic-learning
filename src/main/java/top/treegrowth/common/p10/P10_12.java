package top.treegrowth.common.p10;

public class P10_12 {
	static int count;								//对调次数
	static char color[] = "rwbwwbrbwr".toCharArray();				//三色旗子排列的数组 
	static int Blue, Write, Red;
	 
	static void swap(char[] c,int x, int y)				//对调及显示
	{
		int i;
	   char temp;

	   temp= c[x];							//对调操作
	   c[x] = c[y];
	   c[y] = temp;
	   count++;							//累加对调次数 

	   System.out.printf("第%d次对调后：",count);
	   for (i = 0; i < color.length; i++)		//输出移动后的效果 
	   {
		  System.out.printf(" %c", color[i]);
	   }
	   System.out.printf("\n");
	}

	static void threeflags()						//三色旗算法
	{
	   while (color[Write] == 'b')				//白旗 
	   {
		  Blue++;							//向后移动蓝旗
		  Write++;						//向后移动白旗
	   }
	   while (color[Red] == 'r')				//红旗 
	   {
		  Red--;							//向前移动红旗 
		}
	   while (Write <= Red)			
	   {
		  if (color[Write] == 'r')				//红旗 
		  {
			 swap(color,Write, Red);	//对调红旗和白旗 
			 Red--;	  
			 while (color[Red] == 'r')			//若是红旗 
			 {
				Red--;					//向前移动红旗
			 }
		  }
		  while (color[Write] == 'w')			//白旗
		  {
			 Write++;	
		  }
		  if (color[Write] == 'b')				//蓝旗 
		  {
			 swap(color,Write, Blue);	//对调
			 Blue++;	
			 Write++;	
		  }
	   }
	}
	public static void main(String[] args) {
		 int i;

		   Blue=0;							//初始化
		   Write=0;
		   Red=color.length - 1;
		   count=0;

		   System.out.printf("三色旗问题求解!\n");
		   System.out.printf("三色旗最初排列效果:\n");
		   System.out.printf("             ");
		   for (i = 0; i <= Red; i++)				//输出最初的旗子排列 
		   {
			   System.out.printf(" %c", color[i]);
		   }
		   System.out.printf("\n");
		   threeflags();							//求解
		   System.out.printf("通过%d次完成对调,最终结果如下:\n", count);
		   for (i = 0; i < color.length; i++)		//输出移动后的效果 
		   {
			   System.out.printf(" %c", color[i]);
		   }
		   System.out.printf("\n");

	}

}
