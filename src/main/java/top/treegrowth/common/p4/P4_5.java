package top.treegrowth.common.p4;

public class P4_5 {
	static final int SIZE=18;
	static void quickSort(int[] arr,int left,int right)			//快速排序算法
	{
	    int f,t;
		int rtemp,ltemp;

	    ltemp=left;
	    rtemp=right;
	    f=arr[(left+right)/2];						//分界值
		while(ltemp<rtemp)
		{
	        while(arr[ltemp]<f)
			{
				++ltemp;
			}
	        while(arr[rtemp]>f) 
			{
				--rtemp;
			}
	        if(ltemp<=rtemp)
	        {
				t=arr[ltemp];
		        arr[ltemp]=arr[rtemp];
	    	    arr[rtemp]=t;
				--rtemp;
	        	++ltemp;
			}
	    }
	    if(ltemp==rtemp) 
		{
			ltemp++;
		}

	    if(left<rtemp) 
		{
			quickSort(arr,left,ltemp-1);			//递归调用
		}
	    if(ltemp<right) 
		{
			quickSort(arr,rtemp+1,right);			//递归调用
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
		
		quickSort(shuzu,0,SIZE-1);					//排序操作
		
		System.out.print("排序后的数组为：\n");
		for(i=0;i<SIZE;i++)
		{
			System.out.print(shuzu[i]+" ");					//输出排序后的数组
		}
		System.out.print("\n");

	}

}
