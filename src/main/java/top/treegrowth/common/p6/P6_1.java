package top.treegrowth.common.p6;

public class P6_1 {
	
	static int LeapYear(int year)					//�ж�����
	{
		if((year%400==0) || (year%100!=0) && (year%4==0)) 
		{
			return 1;						//������,�򷵻�1
		}
		else
		{
			return 0;						//��������,�򷵻�0
		}
	}
	
	
	public static void main(String[] args)
	{
		int year;
		int count=0;
		
		System.out.print("2000�굽3000��֮�����е��������£�\n");
		for(year=2000;year<=3000;year++)
		{
			if(LeapYear(year)==1)
			{
				System.out.print(year+" ");			//����������
				count++;
				if(count%16==0)
					System.out.print("\n");
			}
		}
		System.out.print("\n");
	}
}
