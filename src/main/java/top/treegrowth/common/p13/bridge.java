package top.treegrowth.common.p13;

public class bridge {
    static int index;                            //过桥临时方案的数组下标
    static int size = 64;
    static int N = 5;
    static int mintime = 40;                    //最小过桥时间总和，初始值30
    static int[] transit = new int[size];        //进行下标中转的数组
    static int program[] = new int[size];         //最短时间内过桥的方案;
//    static int time[] = {1, 3, 6, 8, 12};         //每个人过桥所需要的时间;
    static int time[] = {2, 5, 6, 9, 13};         //每个人过桥所需要的时间;
    /*
     * 将人员编号：小明 location[0]，弟弟location[1]，
     * 爸爸location[2]，妈妈location[3]，爷爷location[4] 每个人的当前位置：0--在桥左边， 1--在桥右边
     */
    static int location[] = new int[N];
    
    /*
     * 参数说明：notPass:未过桥人数;usedtime:当前已用时间;Direction:过桥方向,1--向右,0--向左
     */
    public static void Find(int notPass, int usedtime, int Direction) 
    {
        if (notPass == 0) 
        {                 //所有人已经过桥，更新最少时间及方案
            mintime = usedtime;
            for (int i = 0; i < size && transit[i] >= 0; i++) 
            {
                program[i] = transit[i];
            }
        }
        else if (Direction == 1) 
        {         //过桥方向向右，从桥左侧选出两人过桥
            for (int i = 0; i < N; i++) 
            {
                if (location[i] == 0 && (usedtime + time[i]) < mintime) 
                {
                    transit[index++] = i;
                    location[i] = 1;
                    for (int j = 0; j < N; j++) 
                    {
                        int TmpMax = (time[i] > time[j] ? time[i] : time[j]);
                        if (location[j] == 0 && (usedtime + TmpMax) < mintime) 
                        {
                            transit[index++] = j;
                            location[j] = 1;
                            Find((notPass - 2), (usedtime + TmpMax), 0);
                            location[j] = 0;
                            transit[--index] = -1;
                        }
                    }
                    location[i] = 0;
                    transit[--index] = -1;
                }
            }
        }
        else 
        { //过桥方向向左，从桥右侧选出一个人回来送灯
            for (int j = 0; j < N; j++) 
            {
                if (location[j] == 1 && usedtime + time[j] < mintime) 
                {
                    transit[index++] = j;
                    location[j] = 0;
                    Find(notPass + 1, usedtime + time[j], 1);
                    location[j] = 1;
                    transit[--index] = -1;
                }
            }
        }
    }
    
    public static void main(String[] args) 
    {
    	String s1="",s2="",s3="";
        for (int i = 0; i < size; i++) 
        {
            program[i] = -1;
            transit[i] = -1;                //初始方案内容为负值，避免和人员标号冲突
        }
        Find(N, 0, 1); // 查找最佳方案
        System.out.println("最短过桥时间为：" + mintime);        //输出最短过桥时间
        System.out.println("最佳过桥组合为：");                // 输出最佳过桥组合
        for (int i = 0; i < size && program[i] >= 0; i += 3) 
        {
        	switch (program[i])
        	{
        		case 0:
        			s1="小明";
        			break;
        		case 1:
        			s1="弟弟";
        			break;
        		case 2:
        			s1="爸爸";
        			break;
        		case 3:
        			s1="妈妈";
        			break;
        		case 4:
        			s1="爷爷";
        			break;
        	}
          	switch (program[i+1])
        	{
        		case 0:
        			s2="小明";
        			break;
        		case 1:
        			s2="弟弟";
        			break;
        		case 2:
        			s2="爸爸";
        			break;
        		case 3:
        			s2="妈妈";
        			break;
        		case 4:
        			s2="爷爷";
        			break;
        	}
          	switch (program[i+2])
        	{
        		case 0:
        			s3="小明";
        			break;
        		case 1:
        			s3="弟弟";
        			break;
        		case 2:
        			s3="爸爸";
        			break;
        		case 3:
        			s3="妈妈";
        			break;
        		case 4:
        			s3="爷爷";
        			break;
        		case -1:
        			s3="没人";
        			break;
        	}
        	
            System.out.println(s1 + "和" + s2+"一道过桥，"+ s3+"再回来");
        }
    }
    
}