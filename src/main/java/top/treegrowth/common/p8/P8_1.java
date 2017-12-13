package top.treegrowth.common.p8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class LinkList						//链表结构
{
    char data;							//数据域
    LinkList next;					//指针域
}


public class P8_1 {
	static Scanner input=new Scanner(System.in);
	static char chc;
	static LinkList CreatLinkList()					//创建链表
	{
	    char ch;
	    LinkList list=null;
	    
	    list=new LinkList();
	    list.data=chc;
	    list.next=null;

	    return list;
	}

	static void insertList(LinkList list,char e)	//插入结点
	{
		LinkList p;
	    p=new LinkList();
	    p.data=e;
	    if(list==null)
		{
			list=p;
			p.next=null;
	    }
	    else
		{
	        p.next=list.next;
	        list.next=p;
	    }    
	}

	static void DynamicSort(LinkList q)				//动态数组排序
	{
	    LinkList p=q;
	    int i,j,k=0;
		char t;

	    while(p!=null)
		{
			k++;
			p=p.next;
		}
	    p=q;
	    for(i=0;i<k-1;i++)
	    {
	        for(j=0;j<k-i-1;j++)
	        {
				if(p.data>p.next.data)
	            {
	                t=p.data;				//交换数据
	                p.data=p.next.data;
					p.next.data=t;
	            }
	            p=p.next;
	        }
	    p=q;
	    }
	}
	
	
	public static void main(String[] args) throws IOException 
	{
		int ch;
		
		LinkList  list,q;						//声明链表

	    System.out.printf("动态数组排序！\n");
	    System.out.printf("请输入一组字符，以0结束！\n");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ch = (char)reader.read();
        chc=(char)ch;                       //输入链表的第一个数据 
        q=list=CreatLinkList();				//创建一个链表结点
        while(ch!='0'){
            ch = reader.read();
            if(ch!='0'){
            insertList(q,(char)ch) ;
            q=q.next;
            }
        }
		
	    DynamicSort(list);					//动态数组排序
		System.out.printf("\n");
		System.out.printf("对该数组排序之后，得到如下结果：\n");
	    while(list!=null)							
	    {
	        System.out.printf("%c ",list.data);				//输出排序后的数组内容
	        list=list.next;
	    }
		System.out.printf("\n");

	}

}
