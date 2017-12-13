package top.treegrowth.common.p13;

import java.util.Arrays;
import java.util.Random;   
import java.util.Scanner;
  
public class caipiao1 
{   
    /**  
     * ���ݸ�������С���ֺ�������֣��Լ�������ĸ���������ָ���Ĳ��ظ�������  
     * @param begin ��С���֣�����������  
     * @param end ������֣�������������  
     * @param size ָ������������ĸ���  
     */  
    public static int[] generateRandomNumber(int begin, int end, int size) {   
        // �����߼��жϣ�ȷ��begin<end����size���ܴ��ڸñ�ʾ��Χ   
        if (begin >= end || (end - begin) < size) 
        {   
            return null;   
        }          
        // ����������������ɣ��������ظ�   
        int[] seed = new int[end - begin];    
       
        for (int i = begin; i < end; i ++) 
        {   
            seed[i - begin] = i;   
        }   
        int[] ranArr = new int[size];   
        Random ran = new Random();   
        // ����������Լ����塣   
        for (int i = 0; i < size; i++) 
        {   
            // �õ�һ��λ��   
            int j = ran.nextInt(seed.length - i);              
            // �õ��Ǹ�λ�õ���ֵ   
            ranArr[i] = seed[j];   
            // �����һ��δ�õ����ַŵ�����   
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
    	
    	System.out.println("��ӭʹ��˫ɫ���Զ�ҡ��ϵͳ");
    	System.out.print("ȷʵҡ��(y/n)?");
    	String go;
    	go=input.next();
    	
    	while(go.equalsIgnoreCase("y")){
    		 ranArr= generateRandomNumber(1,33,6); 
    		 red=ran.nextInt(16);
    		 System.out.println(Arrays.toString(ranArr)+" "+red);   
    		 System.out.print("����ҡ��(y/n)?");
    		 go=input.next();
    	}
        System.out.println("ллʹ�ã�");   
    }   
  
}  
