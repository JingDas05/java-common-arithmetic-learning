package top.treegrowth.common.p9;

public class P9_4 {
	static int zishounum1(long n)				//判断自守数算法1
	{
		long temp,m,k;
		int count;

		k=1;
		count=0;
		while(k>0)						//判断位数
		{
			k=n-(long)Math.pow(10,count);
			count++;
		}
		m=count-1;					//位数
		temp=(n*n)%((long)(Math.pow(10,m)));	
		if(temp==n)					//判断是否为自守数
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	static int zishounum2(long num) 			//判断自守数算法2
	{
	    long faciend,mod,n_mod,p_mod; 	//mod被乘数的系数，n_mod乘数的系数,p_mod部分乘积的系数 
	    long t,n;  						//临时变量 

		faciend=num; 					//被乘数 
	    mod=1;
	    do
		{
	        mod*=10; 					//被乘数的系数 
	        faciend/=10;
	    }while(faciend>0); 				//循环求出被乘数的系数 
	    p_mod=mod; 					//p_mod为截取部分积时的系数 
	    faciend=0; 					//积的最后N位 
	    n_mod=10; 					//截取乘数相应位时的系数 
	    while(mod>0)
	    {
	       t=num % (mod*10); 			//获取被乘数 
	       n=num%n_mod-num%(n_mod/10);//分解出每一位乘数作为乘数 
	       t=t*n; 						//相乘的结果 
	       faciend=(faciend+t)%p_mod; 	//截取乘积的后面几位
	       mod/=10; 					//调整被乘数的系数 
	       n_mod*=10; 				//调整乘数的系数 
	    }
	    if(num==faciend) 				//判断自守数，并返回
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public static void main(String[] args) {
		long i;

		System.out.printf("第一种算法计算自守数：\n");
		for(i=2;i<1000;i++)
		{
			if(zishounum1(i)==1)			//调用第一种算法
			{
				System.out.printf("%d ",i);
			}
		}
		System.out.printf("\n");

		System.out.printf("第二种算法计算自守数：\n");
		for(i=2;i<200000;i++)
		{
			if(zishounum2(i)==1)			//调用第二种算法
			{
				System.out.printf("%d ",i);
			}
		}
		System.out.printf("\n");
	}

}
