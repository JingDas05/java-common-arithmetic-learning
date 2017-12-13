package top.treegrowth.common.p6;

public class P6_1 {
	
	static int LeapYear(int year)					//判断闰年
	{
		if((year%400==0) || (year%100!=0) && (year%4==0)) 
		{
			return 1;						//是闰年,则返回1
		}
		else
		{
			return 0;						//不是闰年,则返回0
		}
	}
	
	
	public static void main(String[] args)
	{
		int year;
		int count=0;
		
		System.out.print("2000年到3000年之间所有的闰年如下：\n");
		for(year=2000;year<=3000;year++)
		{
			if(LeapYear(year)==1)
			{
				System.out.print(year+" ");			//输出闰年年份
				count++;
				if(count%16==0)
					System.out.print("\n");
			}
		}
		System.out.print("\n");
	}
}
