package top.treegrowth.common.p5;

import java.util.Scanner;


public class P5_3 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i;
	    SLType SL=new SLType();         		//定义顺序表变量 
		Data pdata;				//定义结点保存指针变量 
		Scanner input=new Scanner(System.in);
		System.out.print("顺序表操作演示!\n"); 
		
	    SL.SLInit(SL);       			//初始化顺序表 
	    
		System.out.print("初始化顺序表完成!\n");

	    do 
		{                    		//循环添加结点数据 
	        System.out.print("输入添加的结点(学号 姓名 年龄)："); 
	    	Data data=new Data();  
	        data.key=input.next();
	        data.name=input.next();
	        data.age=input.nextInt();
	        if(data.age>0)               //若年龄不为0 
	        {	
	            if(SL.SLAdd(SL,data)==0)   //若添加结点失败 
				{
	                break;            //退出死循环 
				}
	        }
		   else   				//若年龄为0 
		   {
	            break;          		//退出死循环
		   }
	    }while(true);
	    System.out.print("\n顺序表中的结点顺序为：\n");
	    SL.SLAll(SL);                  //显示所有结点数据 
	    
	    System.out.print("\n要取出结点的序号：");
	    i=input.nextInt(); //输入结占点序号    
	    pdata=SL.SLFindByNum(SL,i);  //按序号查找结点 
	    if(!pdata.equals(null))        			//若返回的结点指针不为NULL
		{ 
	        System.out.print("第"+i+"个结点为：<"+pdata.key+" "+pdata.name+" "+pdata.age+">");
		}

	}

}

class Data{
	String key;                 //结点的关键字 
	String name;
    int age;
}    					//定义结点类型

class SLType    				//定义顺序表结构
{	static final int MAXLEN=100;
    Data[] ListData=new Data[MAXLEN+1];	//保存顺序表的结构数组 
    int ListLen;              		//顺序表已存结点的数量 
    
    void SLInit(SLType SL) 			//初始化顺序表
    {
        SL.ListLen=0;    			//初始化为空表
    }

    int SLLength(SLType SL)  		
    {
        return SL.ListLen;    		//返回顺序表的元素数量
    }

    int SLAdd(SLType SL,Data data)  //增加元素到顺序表尾部
    {
        if(SL.ListLen==MAXLEN)  	//顺序表已满 
        {
            System.out.print("顺序表已满，不能再添加结点了！\n");
            return 0;    
        }
        SL.ListData[++SL.ListLen]=data;
        return 1;
    }

    Data SLFindByNum(SLType SL,int n)  //根据序号返回数据元素
    {
        if(n<1 || n>SL.ListLen+1)  		//元素序号不正确
        {
            System.out.print("结点序号错误，不能返回结点！\n");
            return null;              	//不成功，则返回0
        } 
        return SL.ListData[n];
    }

    int SLFindByCont(SLType SL,String key)  		//按关键字查询结点 
    {
        int i;
        for(i=1;i<=SL.ListLen;i++)
    	{
           	if(SL.ListData[i].key.compareTo(key)==0) //如果找到所需结点 
    		{
                return i;        					//返回结点序号 
    		}
    	}
        return 0;  								//搜索整个表后仍没有找到，则返回0 
    }

    int SLAll(SLType SL)  						//显示顺序表中的所有结点 
    {
        int i;
        for(i=1;i<=SL.ListLen;i++)
    	{
            System.out.println("<"+SL.ListData[i].key+" "+SL.ListData[i].name+" "+SL.ListData[i].age+">");
    	}
    	return 0;
    }
    
}