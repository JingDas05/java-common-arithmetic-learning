package top.treegrowth.common.p8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/** 
 * 使用数组实现堆栈，包括入栈、出栈、获取堆栈长度、 
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
        	 	System.out.println("栈已满!");        
        	 	return false;        
        	}        
        this.data[++top] = data;        
        return true;        
    }        
          
    public char pop() throws Exception
    {        
    	if(isEmpty())   
    	{        
    		throw new Exception("栈已空!");        
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

  	  	stack=new Stack(0) ;						//初始化一个栈结构,空栈
  	  	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  	  	ch =(char)reader.read(); 				//输入一个字符
  	  	while(ch!='0')							//循环处理
  	  	{		
  	  		if(getElementCount()==-1)
  	  		{
  	  			push(ch);  
  	  		}
  	  		else
  	  		{
  	  			temp=pop();			//取出栈顶元素
  	  			match=0;

  			if(temp=='(' && ch==')')			//判断是否匹配
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

            if(match==0)					//如果不匹配
    		 {		
                 push(temp);		//原栈顶元素重新入栈
                 push(ch);			//将输入的括号字符入栈
             }
          }
          ch =(char)reader.read(); 				//输入一个字符
      }
      if(getElementCount()==-1)  
  	  {
  		  System.out.printf("输入的括号完全匹配!\n"); 		//完全匹配
  	  }
      else  
  	  {
  		  System.out.printf("输入的括号不匹配，请检查!\n"); 	//不完全匹配
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
		System.out.printf("括号匹配问题！\n");
		
		do{
		System.out.printf("请先输入一组括号组合，以0表示结束。支持的括号包括：{},(),[],<>。\n");
	
		s.pipei();			//匹配算法
		
		System.out.print("\n继续玩吗(y/n)?");
		go=input.next();
		}while(go.equalsIgnoreCase("y"));
	  
		System.out.printf("游戏结束！\n");
       
	}        
}       

