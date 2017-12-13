package top.treegrowth.common.p9;

public class P9_3 {
	static void NarcissusNum(int n)					//判断水仙花数算法
	{
		long i,start,end,temp,num,sum;
		int j;

		start=(long)Math.pow(10,n-1);				//起始数据
		end=(long)Math.pow(10,n)-1;				//终止数据
		for(i=start;i<=end;i++)				//逐个判断
		{
			temp=0;
			num=i;
			sum=0;
			for(j=0;j<n;j++)					//分解各位
			{
				temp=num%10;
				sum=sum+(long)Math.pow(temp,n);	//n次幂累加
				num=(num-temp)/10;
			}
			if(sum==i)
			{
				System.out.printf("%d\n",i);				//输出水仙花数
			}
		}
	}
	public static void main(String[] args) {
		int n;

		n=3;								//初始化位数
		System.out.printf("列举%d位的水仙花数：\n",n);
		NarcissusNum(n);					//列举所有水仙花数
		System.out.printf("\n");
		n=4;								//初始化位数
		System.out.printf("列举%d位的水仙花数：\n",n);
		NarcissusNum(n);					//列举所有水仙花数
		System.out.printf("\n");

	}

}
