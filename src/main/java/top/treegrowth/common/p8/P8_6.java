package top.treegrowth.common.p8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/** 
 * ʹ������ʵ�ֶ�ջ��������ջ����ջ����ȡ��ջ���ȡ� 
 * 
 */  
class Stack {        
    char[] data;  
    int maxSize;    
    int top;       
  
    Scanner input=new Scanner(System.in);
    public Stack(int maxSize) 
    {        
        this.maxSize = maxSize;        
        data = new char[maxSize];        
        top = -1;        
    }        
     
    public int getSize()  
    {  
       return maxSize;  
    }  
    
    public int getElementCount()  
    {  
        return top;  
    }  

    public boolean isEmpty()  
    {  
        return top == -1;  
    }  
 
    public boolean isFull()  
    {  
        return top+1 == maxSize;  
    }  
    
    public boolean push(char data) 
    {        
        if(isFull())   
        	{        
        	 	System.out.println("ջ����!");        
        	 	return false;        
        	}        
        this.data[++top] = data;        
        return true;        
    }        
          
    public char pop() throws Exception
    {        
    	if(isEmpty())   
    	{        
    		throw new Exception("ջ�ѿ�!");        
    	}        
    	return this.data[top--];        
  }        
    
    public char peek()  
    {  
    	return this.data[getElementCount()];    
    } 
  
    void pipei() throws Exception
  	{
    	Stack stack;
    	char ch,temp;
  	  	int match;

  	  	stack=new Stack(0) ;						//��ʼ��һ��ջ�ṹ,��ջ
  	  	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  	  	ch =(char)reader.read(); 				//����һ���ַ�
  	  	while(ch!='0')							//ѭ������
  	  	{		
  	  		if(getElementCount()==-1)
  	  		{
  	  			push(ch);  
  	  		}
  	  		else
  	  		{
  	  			temp=pop();			//ȡ��ջ��Ԫ��
  	  			match=0;

  			if(temp=='(' && ch==')')			//�ж��Ƿ�ƥ��
  			{
  				match=1;
  			}
  			if(temp=='[' && ch==']')
  			{
  				match=1;
  			}
  		    if(temp=='<' && ch=='>')
  			{
  				match=1;
  			}
  		    if(temp=='{' && ch=='}')
  			{
  				match=1;
  			}

            if(match==0)					//�����ƥ��
    		 {		
                 push(temp);		//ԭջ��Ԫ��������ջ
                 push(ch);			//������������ַ���ջ
             }
          }
          ch =(char)reader.read(); 				//����һ���ַ�
      }
      if(getElementCount()==-1)  
  	  {
  		  System.out.printf("�����������ȫƥ��!\n"); 		//��ȫƥ��
  	  }
      else  
  	  {
  		  System.out.printf("��������Ų�ƥ�䣬����!\n"); 	//����ȫƥ��
  	  }
  }
  
}

public class P8_6 
{        
	public static void main(String[] args) throws Exception
	{ 
		String go;
		Scanner input=new Scanner(System.in);
		Stack s=new Stack(20);
		System.out.printf("����ƥ�����⣡\n");
		
		do{
		System.out.printf("��������һ��������ϣ���0��ʾ������֧�ֵ����Ű�����{},(),[],<>��\n");
	
		s.pipei();			//ƥ���㷨
		
		System.out.print("\n��������(y/n)?");
		go=input.next();
		}while(go.equalsIgnoreCase("y"));
	  
		System.out.printf("��Ϸ������\n");
       
	}        
}       

