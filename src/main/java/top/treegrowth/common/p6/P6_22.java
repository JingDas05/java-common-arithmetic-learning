package top.treegrowth.common.p6;

public class P6_22 {
	static double jiShuPI() 			//级数算法
	{
		double PI,temp;
	    int n,m;
		n=1;					//分子
		m=3;					//分母
		temp=2;				//精度
		PI=2;				//初始化PI

	    while(temp>1e-15)		//数列大于指定的精度 
	    {
	        temp=temp*n/m;		//计算一个项的值 
	        PI+=temp;			//添加到pi中 
	        n++;				//分子增加1 
	        m+=2;				//分母增加2 
	    }
		return PI;				//返回PI
	}
	public static void main(String[] args) {
		double PI;

	    PI=jiShuPI();			//计算
	    System.out.println("PI="+PI); 		//输出结果 

	}

}
