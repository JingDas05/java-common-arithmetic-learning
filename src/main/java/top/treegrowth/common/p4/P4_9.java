package top.treegrowth.common.p4;

public class P4_9 {
	static final int N=5;
	static void quickSort(String[] arr,int left,int right)			//快速排序算法
	{
	    String  f,t;
		int rtemp,ltemp;

	    ltemp=left;
	    rtemp=right;
	    f=arr[(left+right)/2];						//分界值
		while(ltemp<rtemp)
		{
	        while(arr[ltemp].compareTo(f)<0)
			{
				++ltemp;
			}
	        while(arr[rtemp].compareTo(f)>0) 
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
		String[] arr=new String[]{"One","World","Dream","Beijing","Olympic"};	//声明并初始化
		int i;

		System.out.print("排序前：\n");
		for(i=0;i<N;i++)
		{
			System.out.println(arr[i]);					//输出排序前
		}

		quickSort(arr,0,N-1);							//排序

		System.out.print("排序后：\n");
		for(i=0;i<N;i++)
		{
			System.out.println(arr[i]);					//输出排序后
		}
		

	}
}


