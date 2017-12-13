package top.treegrowth.common.p13;

public class Guess
{
	 public static boolean isPrime(int i) 
	    {
	        // 判断参数i是否是素数，是则返回true反之则返回false
	        int n;
	        boolean flag = true;
	        if (1 == i)                        // 1本身不是素数，因此需把这个特殊的数字抛出
	            flag = false;
	        for (n = 2; n <= i - 1; n++)        /* 判断i是否是素数的一个方法是看2～i-1之间有其因子（能被2整除），有则不是素数返回false，反之则返回true*/
	            if (i % n == 0) 
	            {
	                flag = false;
	                break;
	            }
	        return flag;
	    }
	 
	 public static boolean isGoldbach(int a) 
	    {    // 判断参数a是否符合哥德巴赫猜想
	        int i;
	        boolean flag = false;
	        for (i = 1; i <= a / 2; i++) 
	        {
	            if (isPrime(i) && isPrime(a - i)) 
	            {    // 根据试题分析中的表达式，传入相关的两个参数
	                flag = true;
//	                System.out.print(a + "=" + i + "+" + (a - i) + "  ");
	                System.out.printf("%3d=%3d+%3d  ",a,i,(a - i));
	                break;
	                // 只要有一个符合条件的就可以退出循环，判断下一个偶数
	            }
	        }
	        return flag;
	    }
	
	 public static boolean Testify_Guess(int low, int high) 
	    {
	        // 判断1～100范围内的所有偶数是否符合哥德巴赫猜想，符合则返回true，反之则返回false
	        int i, j = 0;
	        boolean flag = true;
	        for (i = low; i <= high; i++)
	            if (i % 2 == 0 && i > 2)        // 在1～200之间选取大于2的偶数进行猜想测试
	                if (isGoldbach(i)) 
	                {
	                    j++;                   // j用来控制输出格式 ，每行输出5个数据
	                    if (j == 10) 
	                    {
	                        System.out.println();
	                        j = 0;
	                    }
	                } 
	                else 
	                {
	                    flag = false;
	                    break;
	                }
	        return flag;
	    }
	 
	public static void main(String[] args) 
    {
        System.out.println("\n在1~200范围内，现在开始证实哥德巴赫猜想：");
        if (Testify_Guess(1, 200)) 
        {
            System.out.println("\n在 1~200范围内，哥德巴赫猜想是正确的。");
        }
        else 
        {
            System.out.println("\n哥德巴赫猜想是错误的");
        }
    }
    
    
    
    
   
}