package top.treegrowth.common.p5;

import java.util.Scanner;


public class P5_4 {
	public static void main(String[] args) {
		CLType node, head=null;
//	    Data1 nodeData;
	    String key;
	    Scanner input=new Scanner(System.in);
	    
	    System.out.print("链表测试!\n先输入链表中的数据。\n"); 
	    do
		{
	    	System.out.print("输入添加的结点(学号 姓名 年龄)："); 
		    Data1 data=new Data1();  
		    data.key=input.next();
		       
	        if(data.key.equals("0")) 
			{
				break; //若输入0，则退出
			}
			else
			{	CLType t=new CLType();
				data.name=input.next();
			    data.age=input.nextInt();
				head=t.CLAddEnd(head,data);//在链表尾部添加结点
			}
	    }while(true);   
	    head.CLAllNode(head); 							//显示所有结点
	 
	    System.out.print("\n演示在链表中查找，输入查找关键字:");
	    key=input.next();								//输入查找关键字 
	    node=head.CLFindNode(head,key);					//调用查找函数，返回结点指针 
	    if(node!=null)									//若返回结点指针有效 
	    {
	        Data1 nodeData=node.nodeData;				//获取结点的数据 
	        System.out.println("关键字"+key+"对应的结点为:("+nodeData.key+" "+nodeData.name+" "+nodeData.age+")");        
	    }
		else										//若结点指针无效 
		{
	        System.out.print("在链表中未找到关键字为"+key+"的结点！\n"); 
		}

	}

}

class Data1
{
    String key;								//关键字
    String name;
    int age;
}

class   CLType						//定义链表结构
{
    Data1 nodeData=new Data1();
    CLType nextNode;
    
    CLType CLAddEnd(CLType head,Data1 nodeData)  	//追加结点 
    {
        CLType node,htemp;
//        if(!(node=(CLType *)malloc(sizeof(CLType))))
//        {
//            printf("申请内存失败！\n"); 
//            return NULL;  							//分配内存失败 
//        }

        node=new CLType();
    	node.nodeData=nodeData; 				//保存数据 
    		node.nextNode=null;  				//设置结点指针为空，即为表尾 
    		if(head==null)  						//头指针 
    		{
    			head=node;
    			return head;
    		}
    		htemp=head;
    		while(htemp.nextNode!=null) 			//查找链表的末尾 
    		{
    			htemp=htemp.nextNode;
    		}
    		htemp.nextNode=node;
    		return head;
    	}
    

    CLType CLFindNode(CLType head,String key) 		//查找结点
    {
        CLType htemp;
        htemp=head;       							//保存链表头指针 
        while(htemp!=null)      							//若结点有效，则进行查找 
        {
            if(htemp.nodeData.key.equals(key)) 		//若结点关键字与传入关键字相同 
    		{
                return htemp;  						//返回该结点指针 
    		}
            htemp=htemp.nextNode; 					//处理下一结点 
        }
        return null; 								//返回空指针 
    }

    int CLLength(CLType head)						//计算链表长度
    {
        CLType htemp;
        int Len=0;
        htemp=head;
        while(htemp!=null)      							//遍历整个链表 
        {
            Len++; 								//累加结点数量 
            htemp=htemp.nextNode;					//处理下一结点 
        }
        return Len;									//返回结点数量 
    }

    void CLAllNode(CLType head) 					//遍历链表 
    {
        CLType htemp;
        Data1 nodeData;
        htemp=head;
        System.out.print("当前链表共有"+CLLength(head)+"个结点。链表所有数据如下：\n"); 
        while(htemp!=null) 								//循环处理链表每个结点 
        {
            nodeData=htemp.nodeData;				//获取结点数据 
            System.out.println("结点("+nodeData.key+" "+nodeData.name+" "+nodeData.age+")"); 
            htemp=htemp.nextNode;					//处理下一结点 
        }
    }
}

