package top.treegrowth.common.p10;

public class P10_17 {
	static int wi,wj,wk;								//保存匹配值

	static int HW(char husband[], char wife[])				//算法
	{
		int i,j,k;
		int match=0;								//是否匹配

	    for(i=0;i<3;i++)
		{
	        for(j=0;j<3;j++)
			{
	            for(k=0;k<3;k++)
				{
	                if(i!=j && j!=k && i!=k) 
	                {
						if(wife[i] == 'X' || wife[k] == 'X' || wife[k] == 'Z')
						{
							match=0;			//违反规则
						}
						else
						{
							match=1;			//符合规则
							wi=i;
							wj=j;
							wk=k;
							return match;		//返回
						}
	                }
				}
			}
		}
		return match;							//返回
	}
	public static void main(String[] args) {
		char[] husband = {'A','B','C'}, wife = {'X','Y','Z'};
		int i,match;

		System.out.printf("新郎新娘问题求解！\n");
		System.out.printf("参加婚礼的新郎为:");				//显示新郎
		for(i=0;i<3;i++)
		{
			System.out.printf(" %c",husband[i]);
		}
		System.out.printf("\n");
		System.out.printf("参加婚礼的新娘为:");				//显示新娘
		for(i=0;i<3;i++)
		{
			System.out.printf(" %c",wife[i]);
		}
		System.out.printf("\n");

		match=HW(husband,wife);				//求解
		if(match==1)
		{
			System.out.printf("A将和%c结婚！\n",wife[wi]);
			System.out.printf("B将和%c结婚！\n",wife[wj]);
			System.out.printf("C将和%c结婚！\n",wife[wk]);
		}

	}

}
