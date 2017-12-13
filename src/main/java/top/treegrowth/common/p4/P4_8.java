package top.treegrowth.common.p4;

public class P4_8 {
	static final int SIZE=10;
	static void insertionSort(int[] a,int len)  				//插入排序
	{
	    int i,j,t,h;

	    for (i=1;i<len;i++)
	    {
			t=a[i];
			j=i-1;
			while(j>=0 && t>a[j])					//反序
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=t;

			System.out.print("第"+i+"步排序结果:");			//输出每步排序的结果
			for(h=0;h<len;h++)
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
		
		insertionSort(shuzu,SIZE);					//排序操作
		
		System.out.print("排序后的数组为：\n");
		for(i=0;i<SIZE;i++)
		{
			System.out.print(shuzu[i]+" ");					//输出排序后的数组
		}
		System.out.print("\n");

	}

}
