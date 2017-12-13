package top.treegrowth.common.p13;

import java.util.Scanner;

public class KMPAlgorithm {  
  
    /** 
     * �ж��Ƿ�ƥ�� 
     * @param target Ŀ���ı��� 
     * @param mode ģʽ�� 
     * @return ƥ���� 
     */  
    public static boolean matchString(String target, String mode) 
    {  
        //Ϊ�˺��㷨����һ�£�ʹindex��1��ʼ������һǰ׺   
        String newTarget = "x" + target;   
        String newMode = 'x' + mode;  
          
        int[] K = calculateK(mode);  
          
        int i = 1;  
        int j = 1;  
        while(i <= target.length() && j <= mode.length()) 
        {  
            if (j == 0 || newTarget.charAt(i) == newMode.charAt(j)) 
            {  
                i++;  
                j++;  
            } 
            else 
            {  
                j = K[j];  
            }  
        }  
          
        if (j > mode.length()) 
        {  
            return true;  
        }  
        return false;  
    }  
      
    /* 
     * ����Kֵ 
     */  
    private static int[] calculateK(String mode) 
    {  
        //Ϊ�˺��㷨����һ�£�ʹindex��1��ʼ������һǰ׺   
        String newMode = "x" + mode;  
        int[] K = new int[newMode.length()];  
        int i = 1;  
        K[1] = 0;  
        int j = 0;  
          
        while(i < mode.length()) 
        {  
            if (j == 0 || newMode.charAt(i) == newMode.charAt(j))
            {  
                i++;  
                j++;  
                K[i] = j;  
            } 
            else 
            {  
                j = K[j];  
            }  
        }  
          
        return K;  
    }  
    /** 
     * @param args 
     */  
    public static void main(String[] args) 
    {  
        String s1,s2;
        boolean b;
    	Scanner input=new Scanner(System.in);
        
    	System.out.println("�������ַ���1��");
    	s1=input.next();
    	System.out.println("�������ַ���2��");
    	s2=input.next();
        
    	b=KMPAlgorithm.matchString(s1, s2);
    	System.out.println("ƥ��ɹ���"+b);  
  
    }  
  
}  
