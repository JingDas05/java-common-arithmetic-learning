package top.treegrowth.common.p8;

import java.util.Scanner;

class  LinkList2            //�ڵ���
{
   int  no ;          //����
   int psw;   
   LinkList2 next;         //��һ���ڵ�

   public LinkList2(int no,int psw) 
   { 
	  this.no=no;
	  this.psw=psw;
    }

  public LinkList2(int no,int psw,LinkList2 next)   //���췽��
  {
   this.no=no;
   this.psw=psw;
   this.next=next;
  }
}

public class P8_3 {
	static  LinkList2 head=null,tail=null;      // ͷָ�룬βָ��
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
   
   static  void CircleFun(LinkList2 list, int m)					//�㷨
	{
	    LinkList2 p ,q;
	    int i;
	    q = p = list ;
	    while(q.next != p) 
		{
			q=q.next;  
		}
	    System.out.printf("��Ϸ�߰������µ�˳����С�\n") ;
	    while(p.next != p)
		{
			for(i=0;i<m-1;i++)
			{                  
				q = p;
				p = p.next;
			}
			q.next = p.next;						//ɾ��pָ��Ľ��
			System.out.printf("��%d���˳��У������еĳ�������Ϊ%d��\n",p.no,p.psw );
			m = p.psw;							//���ó�������
			p=null;				
			p = q.next;				
	    }
	    System.out.printf("\n���һ������%d�������еĳ�������Ϊ%d��",p.no,p.psw);
	}
	public static void main(String[] args)
	{
		  P8_3 LL=new P8_3();
		  int e,baoshu;
		  System.out.printf("Լɪ��������⣡\n");
		  System.out.printf("������Լɪ���е�������\n");
		  Scanner input=new Scanner(System.in);
		  int  num=input.nextInt();							//����Լɪ�򻷵�����

		  System.out.printf("����˳������ÿ�������еĳ������֣�\n");
		  e=input.nextInt();
		    
		  LL.addhead(1,e);

		  for (int i=2; i<=num;i++ )         //����ѭ������
		  { 
			       e=input.nextInt();
		           LL.addtail(i,e);
		  }
		  
		  System.out.printf("�������һ�γ��е����֣�\n");
		  baoshu=input.nextInt();		
		  CircleFun(head,baoshu) ;						//���Լɪ��
		  System.out.printf("\n");

	}

}
