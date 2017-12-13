package top.treegrowth.common.p13;

import java.util.*;

public class caipiao2 
{   
  
    /**  
     * 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组  
     *   
     * @param begin  
     *            最小数字（包含该数）  
     * @param end  
     *            最大数字（不包含该数）  
     * @param size  
     *            指定产生随机数的个数  
     */  
    public static int[] generateBySet1(int begin, int end, int size) 
    {   
        // 加入逻辑判断，确保begin<end并且size不能大于该表示范围   
        if (begin >= end || (end - begin) < size) 
        {   
            return null;   
        }   
           
        Random ran = new Random();   
        Set<Integer> set = new HashSet<Integer>();   
        while (set.size() < size) 
        {   
            set.add(begin + ran.nextInt(end - begin));   
        }   
           
        int[] ranArr = new int[size];   
        Iterator it = set.iterator();          
           
        for (int i = 0; i < size; i ++) 
        {   
            if (!it.hasNext()) 
            {   
                break;   
            }   
            ranArr[i] = (Integer) it.next();               
        }   
        return ranArr;   
    }   
  
    /**  
     * 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组  
     *   
     * @param begin  
     *            最小数字（包含该数）  
     * @param end  
     *            最大数字（不包含该数）  
     * @param size  
     *            指定产生随机数的个数  
     */  
//    public static Integer[] generateBySet2(int begin, int end, int size) {   
//        // 加入逻辑判断，确保begin<end并且size不能大于该表示范围   
//        if (begin >= end || (end - begin) < size) {   
//            return null;   
//        }   
//           
//        Random ran = new Random();   
//        Set<Integer> set = new HashSet<Integer>();   
//        while (set.size() < size) {   
//            set.add(begin + ran.nextInt(end - begin));   
//        }   
//           
//        Integer[] ranArr = new Integer[size];   
//        ranArr = set.toArray(new Integer[size]);   
//        //ranArr = (Integer[]) set.toArray();   
//           
//        return ranArr;   
//    }   
       
    public static void main(String[] args) 
    {   
//        int[] ranArr = generateBySet1(1, 35, 7);   
//        for (int i : ranArr) {   
//            System.out.print(i + "  ");   
//        }   
    	int[] ranArr={};
    	int red;
    	Scanner input=new Scanner(System.in);
    	Random ran = new Random(); 
    	
    	System.out.println("欢迎使用双色球自动摇号系统");
    	System.out.print("确实摇号(y/n)?");
    	String go;
    	go=input.next();
    	
    	while(go.equalsIgnoreCase("y"))
    	{
    		 ranArr= generateBySet1(1,33,6); 
    		 red=ran.nextInt(16);
    		 System.out.println(Arrays.toString(ranArr)+" "+red);   
    		 System.out.print("继续摇号(y/n)?");
    		 go=input.next();
    	}
        System.out.println("谢谢使用！");   
  
    }   
}  
