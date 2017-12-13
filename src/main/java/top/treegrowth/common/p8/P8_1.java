package top.treegrowth.common.p8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class LinkList						//����ṹ
{
    char data;							//������
    LinkList next;					//ָ����
}
	

public class P8_1 {
	static Scanner input=new Scanner(System.in);
	static char chc;
	static LinkList CreatLinkList()					//��������
	{
	    char ch;
	    LinkList list=null;
	    
	    list=new LinkList();
	    list.data=chc;
	    list.next=null;

	    return list;
	}

	static void insertList(LinkList list,char e)	//������
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

	static void DynamicSort(LinkList q)				//��̬��������
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
	                t=p.data;				//��������
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
		
		LinkList  list,q;						//��������

	    System.out.printf("��̬��������\n");
	    System.out.printf("������һ���ַ�����0������\n");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ch = (char)reader.read();
        chc=(char)ch;                       //��������ĵ�һ������ 
        q=list=CreatLinkList();				//����һ��������
        while(ch!='0'){
            ch = reader.read();
            if(ch!='0'){
            insertList(q,(char)ch) ;
            q=q.next;
            }
        }
		
	    DynamicSort(list);					//��̬��������
		System.out.printf("\n");
		System.out.printf("�Ը���������֮�󣬵õ����½����\n");
	    while(list!=null)							
	    {
	        System.out.printf("%c ",list.data);				//�����������������
	        list=list.next;
	    }
		System.out.printf("\n");

	}

}
