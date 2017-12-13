package top.treegrowth.common.p10;

public class P10_14
{
	static int jieti()							//算法
	{
		int i,res;
		int count;

		count=7;
	    for(i=1;i<=100;i++)				//循环
	    {
	        if((count%2==1)&&(count%3==2)&&(count%5==4)&&(count%6==5) ) 	//判断是否满足
	        {
	            res=count;
	            break;          			//找到，跳出循环
	        }
	        count=7*(i+1);				//下一个
	    }
		return count;					//返回
	}
	public static void main(String[] args) 
	{
		int num;

		System.out.printf("爱因斯坦阶梯问题求解！\n");
		num=jieti();					//求解
		System.out.printf("这个阶梯总共有%d个台阶！\n",num);

	}

}
