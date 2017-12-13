package top.treegrowth.common.p13;

import java.util.Arrays;
import java.util.HashSet;   
import java.util.Iterator;   
import java.util.Random;   
import java.util.Scanner;
import java.util.Set;   
  
public class caipiao2 
{   
  
    /**  
     * ���ݸ�������С���ֺ�������֣��Լ�������ĸ���������ָ���Ĳ��ظ�������  
     *   
     * @param begin  
     *            ��С���֣�����������  
     * @param end  
     *            ������֣�������������  
     * @param size  
     *            ָ������������ĸ���  
     */  
    public static int[] generateBySet1(int begin, int end, int size) 
    {   
        // �����߼��жϣ�ȷ��begin<end����size���ܴ��ڸñ�ʾ��Χ   
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
     * ���ݸ�������С���ֺ�������֣��Լ�������ĸ���������ָ���Ĳ��ظ�������  
     *   
     * @param begin  
     *            ��С���֣�����������  
     * @param end  
     *            ������֣�������������  
     * @param size  
     *            ָ������������ĸ���  
     */  
//    public static Integer[] generateBySet2(int begin, int end, int size) {   
//        // �����߼��жϣ�ȷ��begin<end����size���ܴ��ڸñ�ʾ��Χ   
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
    	
    	System.out.println("��ӭʹ��˫ɫ���Զ�ҡ��ϵͳ");
    	System.out.print("ȷʵҡ��(y/n)?");
    	String go;
    	go=input.next();
    	
    	while(go.equalsIgnoreCase("y"))
    	{
    		 ranArr= generateBySet1(1,33,6); 
    		 red=ran.nextInt(16);
    		 System.out.println(Arrays.toString(ranArr)+" "+red);   
    		 System.out.print("����ҡ��(y/n)?");
    		 go=input.next();
    	}
        System.out.println("ллʹ�ã�");   
  
    }   
}  
