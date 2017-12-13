package top.treegrowth.common.p2;

import java.util.Scanner;


class DATA3
{
    String name;
    int age;
}

class StackType
{
	static final int MAXLEN=50;
    DATA3[] data=new DATA3[MAXLEN+1]; 						//数据元素 
    int top; 								//栈顶 
    
    StackType STInit()
    {
    	StackType p;
    	
        if((p=new StackType())!=null) 	//申请栈内存 
        {
            p.top=0; 							//设置栈顶为0 
            return p;							//返回指向栈的指针 
        }
        return null;
    }

    boolean STIsEmpty(StackType s) 					//判断栈是否为空 
    {
    	boolean t;
    	t=(s.top==0);
        return t;
    }

    boolean STIsFull(StackType s) 					//判断栈是否已满
    {
    	boolean t;
    	t=(s.top==MAXLEN);
        return t;
    }

    void STClear(StackType s)  					//清空栈 
    {
        s.top=0;
    }

    void STFree(StackType s) 					//释放栈所占用空间 
    {
        if(s!=null)
    	{
            s=null;
    	}
    }

    int PushST(StackType s,DATA3 data)			//入栈操作 
    {
         if((s.top+1)>MAXLEN)
         {
             System.out.print("栈溢出!\n"); 
             return 0;
         }
         s.data[++s.top]=data;					//将元素入栈
         return 1; 
    }

    DATA3 PopST(StackType s) 					//出栈操作 
    {
         if(s.top==0)
         {
             System.out.print("栈为空!\n");
//             
             System.exit(0);
         }
         return (s.data[s.top--]);
    }

    DATA3 PeekST(StackType s) 					//读栈顶数据
    {
         if(s.top==0)
         {
             System.out.printf("栈为空!\n");
//             
             System.exit(0);
         }
         return (s.data[s.top]);
    }
}

public class P2_3 {

	public static void main(String[] args) {
		StackType st=new StackType();
	    DATA3 data1=new DATA3();    

	    StackType stack=st.STInit();  						//初始化栈
	    Scanner input=new Scanner(System.in);
	    System.out.print("入栈操作：\n");
	    System.out.println("输入姓名 年龄进行入栈操作:"); 
		do
		{
			DATA3 data=new DATA3();
			data.name=input.next();
			
			if(data.name.equals("0")) 
			{
				break; 						//若输入0，则退出
			}
			else
			{
				data.age=input.nextInt();
				st.PushST(stack,data);
			}
		}while(true);
		
		String temp="1";
		System.out.println("出栈操作:按任意非0键进行出栈操作:");
		temp=input.next();
		while(!temp.equals("0"))
		{
		   	data1=st.PopST(stack);
			System.out.printf("出栈的数据是(%s,%d)\n" ,data1.name,data1.age);	
			temp=input.next();
		}
		System.out.println("测试结束！");
	    st.STFree(st); 							//释放栈所占用的空间 

	}

}
