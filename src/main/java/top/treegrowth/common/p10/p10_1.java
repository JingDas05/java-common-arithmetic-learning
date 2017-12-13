package top.treegrowth.common.p10;

public class p10_1 {
	static void BQBJ(int m,int n)				//百钱买百鸡算法
	{
	    int x,y,z;
	    for(x=0;x<=n;x++)				//公鸡数量
	    {
	        for(y=0;y<=n;y++)			//母鸡数量
	        {
	            z=n-x-y;				//小鸡数量
	            if (z>0 && z%3==0 && x*5+y*3+z/3==m)
				{
	                System.out.printf("公鸡：%d只,母鸡：%d只,小鸡：%d只\n",x,y,z);
				}
				else					//无法求解!
				{
				}
	        }
	    }  
	}
	public static void main(String[] args) 
	{
		int m,n;

		m=100;						//百钱
		n=100;						//百鸡
		System.out.printf("%d钱买%d鸡问题的求解结果为：\n",m,n);
		BQBJ(m,n);

	}

}
