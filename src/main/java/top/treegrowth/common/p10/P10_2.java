package top.treegrowth.common.p10;

public class P10_2 {
	static void WJGJ(int[] len1,int[] len2,int[] len3,int[] len4,int[] len5,int[] len)	//五家共井算法
	{
		for(len5[0]=4; ;len5[0]+=4)                     //len5为4的倍数 
			
			for(len1[0]=5; ;len1[0]+=5)                 //len1为5的倍数 
			{ 
				len4[0]=len5[0]+len1[0]/5; 
				len3[0]=len4[0]+len5[0]/4; 
				
				if(len3[0]%2!=0||len4[0]%3!=0)
					continue;                          //如果不能被2整除或若不能被3整除，进行下一次循环 
				
				len2[0]=len3[0]+len4[0]/3; 
				if(len2[0]+len3[0]/2<len1[0])
					break;                             //切回len5[0]循环(因为x太大了) 
				
				if(len2[0]+len3[0]/2==len1[0])
				{ 
					len[0]=2*(len1[0])+(len2[0]);     //计算井深 
					return;
				} 
			} 
	   								

	}
	public static void main(String[] args)
	{
		int[] len1={0};
		int[] len2={0};
		int[] len3={0};
		int[] len4={0};
		int[] len5={0};
		int[] len={0};
			
		WJGJ(len1,len2,len3,len4,len5,len);				//求解算法
		
	    System.out.printf("五家共井问题求解结果如下:\n");					//输出结果
	    System.out.printf("甲家井绳长度为:%d\n",len1[0]);
	    System.out.printf("乙家井绳长度为:%d\n",len2[0]);
	    System.out.printf("丙家井绳长度为:%d\n",len3[0]);
	    System.out.printf("丁家井绳长度为:%d\n",len4[0]);
	    System.out.printf("戌家井绳长度为:%d\n",len5[0]);
	    System.out.printf("井深:%d\n",len[0]);

	}

}
