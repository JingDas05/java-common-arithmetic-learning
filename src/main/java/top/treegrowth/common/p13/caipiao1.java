package top.treegrowth.common.p13;

import java.util.Arrays;
import java.util.Random;   
import java.util.Scanner;

public class caipiao1 
{   
    /**  
     * 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组  
     * @param begin 最小数字（包含该数）  
     * @param end 最大数字（不包含该数）  
     * @param size 指定产生随机数的个数  
     */  
    public static int[] generateRandomNumber(int begin, int end, int size) {   
        // 加入逻辑判断，确保begin<end并且size不能大于该表示范围   
        if (begin >= end || (end - begin) < size) 
        {   
            return null;   
        }          
        // 种子你可以随意生成，但不能重复   
        int[] seed = new int[end - begin];    
       
        for (int i = begin; i < end; i ++) 
        {   
            seed[i - begin] = i;   
        }   
        int[] ranArr = new int[size];   
        Random ran = new Random();   
        // 数量你可以自己定义。   
        for (int i = 0; i < size; i++) 
        {   
            // 得到一个位置   
            int j = ran.nextInt(seed.length - i);              
            // 得到那个位置的数值   
            ranArr[i] = seed[j];   
            // 将最后一个未用的数字放到这里   
            seed[j] = seed[seed.length - 1 - i];   
        }   
        return ranArr;   
    }   
  
    public static void main(String[] args) 
    { 
    	int[] ranArr={};
    	int red;
    	Scanner input=new Scanner(System.in);
    	Random ran = new Random(); 
    	
    	System.out.println("欢迎使用双色球自动摇号系统");
    	System.out.print("确实摇号(y/n)?");
    	String go;
    	go=input.next();
    	
    	while(go.equalsIgnoreCase("y")){
    		 ranArr= generateRandomNumber(1,33,6); 
    		 red=ran.nextInt(16);
    		 System.out.println(Arrays.toString(ranArr)+" "+red);   
    		 System.out.print("继续摇号(y/n)?");
    		 go=input.next();
    	}
        System.out.println("谢谢使用！");   
    }   
  
}  
