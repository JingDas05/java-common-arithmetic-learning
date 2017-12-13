package top.treegrowth.common.p4;

public class P4_2 {
	static final int SIZE=10;
	public static void selectSort(int[] a) 
	{
		 int index,temp;
         for (int i = 0; i < a.length-1; i++) 
         {
        	index = i;
        	for (int j = i+1; j <a.length; j++) 
        	{
        		if (a[j] < a[index]) 
        		{
        			index = j;
        		}
        	}
        	//交换两个数
        	if(index!=i)
        	{
        	temp=a[i];
        	a[i]=a[index];
        	a[index]=temp;
        	}
        	System.out.print("第"+i+"步排序结果:");			//输出每步排序的结果
    		for(int h=0;h<a.length;h++)
    		{
    			System.out.print(" "+a[h]);				//输出
    		}
    		System.out.print("\n");
        }
	}

	public static void main(String[] args) 
	{
		int[] shuzu=new int[SIZE];
		int i;
		
		for(i=0;i<SIZE;i++)
		{
			shuzu[i]=(int)(100+Math.random()*(100+1));			//初始化数组
		}
		
		System.out.print("排序前的数组为：\n");				//输出排序前的数组
		for(i=0;i<SIZE;i++)
		{
			System.out.print(shuzu[i]+" ");
		}
		
		System.out.print("\n");
		
		selectSort(shuzu);					//排序操作
		
		System.out.print("排序后的数组为：\n");
		for(i=0;i<SIZE;i++)
		{
			System.out.print(shuzu[i]+" ");					//输出排序后的数组
		}
		System.out.print("\n");

	}

}
