package top.treegrowth.common.p9;

public class P9_2 {
	static int[] ga=new int[100],gb=new int[100];				//保存因子的数组

	static int friendnum(int a)				//亲密数对算法
	{
			int i,b1,b2,count;
			for(i=0;i<100;i++) 		//清空数组 
			{
				ga[i]=gb[i]=0;
			}
			count=0;				//数组下标 
			b1=0;				//累加和 
			for(i=1;i<a/2+1;i++)		//求数a的因子 
			{
				if(a%i==0)			//a能被i整除 
				{
					ga[count++]=i; 	//保存因子到数组，方便输出 
					b1+=i;		//累加因子之和 
				}
			}
			count=0;
			b2=0;
			for(i=1;i<b1/2+1;i++) 	//将数a因子之和再进行因子分解 
			{
				if(b1%i==0) 		//b1能被i整除 
				{
					gb[count++]=i; //保存因子到数组 
					b2=b2+i;	  	//累加因子之和 
				}
			}
			if(b2==a && a<b1) 		//判断A，B的输出条件	
			{
				return b1;
			}
			else
			{
				return 0;
			}
	}
	public static void main(String[] args) {
		int i,b,fanwei,count;

		fanwei=5000;				//初始化
		System.out.printf("列举1~%d之间的所有亲密数对!\n",fanwei);
		for(i=1;i<fanwei;i++)
		{
			b=friendnum(i);
			if(b!=0)
			{
	            System.out.printf("\n%d--%d是亲密数，示例如下：",i,b); //输出亲密数 
	            System.out.printf("\n%d的各个因子之和为:1",i);
	            count=1;
	            while(ga[count]>0)	//输出一个数的因子 
	            {
	                System.out.printf("+%d",ga[count]);
	                count++;
	            }
				System.out.printf("=%d\n",b);
	            System.out.printf("%d的各个因子之和为:1",b);
	            count=1;
	            while(gb[count]>0)	//输出另一个数的因子 
	            {
	                System.out.printf("+%d",gb[count]);
	                count++;
	            }
				System.out.printf("=%d\n",i);
			}
		}

	}

}
