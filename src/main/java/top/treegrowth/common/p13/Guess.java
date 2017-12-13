package top.treegrowth.common.p13;

public class Guess
{
	 public static boolean isPrime(int i) 
	    {
	        // �жϲ���i�Ƿ������������򷵻�true��֮�򷵻�false
	        int n;
	        boolean flag = true;
	        if (1 == i)                        // 1�������������������������������׳�
	            flag = false;
	        for (n = 2; n <= i - 1; n++)        /* �ж�i�Ƿ���������һ�������ǿ�2��i-1֮���������ӣ��ܱ�2����������������������false����֮�򷵻�true*/
	            if (i % n == 0) 
	            {
	                flag = false;
	                break;
	            }
	        return flag;
	    }
	 
	 public static boolean isGoldbach(int a) 
	    {    // �жϲ���a�Ƿ���ϸ�°ͺղ���
	        int i;
	        boolean flag = false;
	        for (i = 1; i <= a / 2; i++) 
	        {
	            if (isPrime(i) && isPrime(a - i)) 
	            {    // ������������еı��ʽ��������ص���������
	                flag = true;
//	                System.out.print(a + "=" + i + "+" + (a - i) + "  ");
	                System.out.printf("%3d=%3d+%3d  ",a,i,(a - i));
	                break;
	                // ֻҪ��һ�����������ľͿ����˳�ѭ�����ж���һ��ż��
	            }
	        }
	        return flag;
	    }
	
	 public static boolean Testify_Guess(int low, int high) 
	    {
	        // �ж�1��100��Χ�ڵ�����ż���Ƿ���ϸ�°ͺղ��룬�����򷵻�true����֮�򷵻�false
	        int i, j = 0;
	        boolean flag = true;
	        for (i = low; i <= high; i++)
	            if (i % 2 == 0 && i > 2)        // ��1��200֮��ѡȡ����2��ż�����в������
	                if (isGoldbach(i)) 
	                {
	                    j++;                   // j�������������ʽ ��ÿ�����5������
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
        System.out.println("\n��1~200��Χ�ڣ����ڿ�ʼ֤ʵ��°ͺղ��룺");
        if (Testify_Guess(1, 200)) 
        {
            System.out.println("\n�� 1~200��Χ�ڣ���°ͺղ�������ȷ�ġ�");
        }
        else 
        {
            System.out.println("\n��°ͺղ����Ǵ����");
        }
    }
    
    
    
    
   
}