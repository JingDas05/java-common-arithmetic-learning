package top.treegrowth.common.p8;

import java.util.Scanner;

class  LinkList2            //节点类
{
   int  no ;          //序列
   int psw;   
   LinkList2 next;         //下一个节点

   public LinkList2(int no,int psw) 
   { 
	  this.no=no;
	  this.psw=psw;
    }

  public LinkList2(int no,int psw,LinkList2 next)   //构造方法
  {
   this.no=no;
   this.psw=psw;
   this.next=next;
  }
}

public class P8_3 {
	static  LinkList2 head=null,tail=null;      // 头指针，尾指针
	int size=0;

    public void addhead(int i,int psw)   
    {
    	head=new LinkList2(i,psw,head);
        if (tail == null) 
            tail = head;
        size++;
    }

   public void addtail(int i,int psw)   
   {
	   	tail.next = new LinkList2(i,psw);   
        tail = tail.next;
        tail.next=head;
        size++;
    }
   
   static  void CircleFun(LinkList2 list, int m)					//算法
	{
	    LinkList2 p ,q;
	    int i;
	    q = p = list ;
	    while(q.next != p) 
		{
			q=q.next;  
		}
	    System.out.printf("游戏者按照如下的顺序出列。\n") ;
	    while(p.next != p)
		{
			for(i=0;i<m-1;i++)
			{                  
				q = p;
				p = p.next;
			}
			q.next = p.next;						//删除p指向的结点
			System.out.printf("第%d个人出列，其手中的出列数字为%d。\n",p.no,p.psw );
			m = p.psw;							//重置出列数字
			p=null;				
			p = q.next;				
	    }
	    System.out.printf("\n最后一个人是%d，其手中的出列数字为%d。",p.no,p.psw);
	}
	public static void main(String[] args)
	{
		  P8_3 LL=new P8_3();
		  int e,baoshu;
		  System.out.printf("约瑟夫环问题求解！\n");
		  System.out.printf("请输入约瑟夫环中的人数：\n");
		  Scanner input=new Scanner(System.in);
		  int  num=input.nextInt();							//输入约瑟夫环的人数

		  System.out.printf("按照顺序输入每个人手中的出列数字：\n");
		  e=input.nextInt();
		    
		  LL.addhead(1,e);

		  for (int i=2; i<=num;i++ )         //构造循环链表
		  { 
			       e=input.nextInt();
		           LL.addtail(i,e);
		  }
		  
		  System.out.printf("请输入第一次出列的数字：\n");
		  baoshu=input.nextInt();		
		  CircleFun(head,baoshu) ;						//求解约瑟夫环
		  System.out.printf("\n");

	}

}
