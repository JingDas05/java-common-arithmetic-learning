package top.treegrowth.common.p5;

import java.util.Scanner;


public class P5_4 {
	public static void main(String[] args) {
		CLType node, head=null;
//	    Data1 nodeData;
	    String key;
	    Scanner input=new Scanner(System.in);
	    
	    System.out.print("�������!\n�����������е����ݡ�\n"); 
	    do
		{
	    	System.out.print("������ӵĽ��(ѧ�� ���� ����)��"); 
		    Data1 data=new Data1();  
		    data.key=input.next();
		       
	        if(data.key.equals("0")) 
			{
				break; //������0�����˳�
			}
			else
			{	CLType t=new CLType();
				data.name=input.next();
			    data.age=input.nextInt();
				head=t.CLAddEnd(head,data);//������β����ӽ��
			}
	    }while(true);   
	    head.CLAllNode(head); 							//��ʾ���н��
	 
	    System.out.print("\n��ʾ�������в��ң�������ҹؼ���:");
	    key=input.next();								//������ҹؼ��� 
	    node=head.CLFindNode(head,key);					//���ò��Һ��������ؽ��ָ�� 
	    if(node!=null)									//�����ؽ��ָ����Ч 
	    {
	        Data1 nodeData=node.nodeData;				//��ȡ�������� 
	        System.out.println("�ؼ���"+key+"��Ӧ�Ľ��Ϊ:("+nodeData.key+" "+nodeData.name+" "+nodeData.age+")");        
	    }
		else										//�����ָ����Ч 
		{
	        System.out.print("��������δ�ҵ��ؼ���Ϊ"+key+"�Ľ�㣡\n"); 
		}

	}

}
class Data1
{
    String key;								//�ؼ���
    String name;
    int age;
}

class   CLType						//��������ṹ
{
    Data1 nodeData=new Data1();
    CLType nextNode;
    
    CLType CLAddEnd(CLType head,Data1 nodeData)  	//׷�ӽ�� 
    {
        CLType node,htemp;
//        if(!(node=(CLType *)malloc(sizeof(CLType))))
//        {
//            printf("�����ڴ�ʧ�ܣ�\n"); 
//            return NULL;  							//�����ڴ�ʧ�� 
//        }

        node=new CLType();
    	node.nodeData=nodeData; 				//�������� 
    		node.nextNode=null;  				//���ý��ָ��Ϊ�գ���Ϊ��β 
    		if(head==null)  						//ͷָ�� 
    		{
    			head=node;
    			return head;
    		}
    		htemp=head;
    		while(htemp.nextNode!=null) 			//���������ĩβ 
    		{
    			htemp=htemp.nextNode;
    		}
    		htemp.nextNode=node;
    		return head;
    	}
    

    CLType CLFindNode(CLType head,String key) 		//���ҽ��
    {
        CLType htemp;
        htemp=head;       							//��������ͷָ�� 
        while(htemp!=null)      							//�������Ч������в��� 
        {
            if(htemp.nodeData.key.equals(key)) 		//�����ؼ����봫��ؼ�����ͬ 
    		{
                return htemp;  						//���ظý��ָ�� 
    		}
            htemp=htemp.nextNode; 					//������һ��� 
        }
        return null; 								//���ؿ�ָ�� 
    }

    int CLLength(CLType head)						//����������
    {
        CLType htemp;
        int Len=0;
        htemp=head;
        while(htemp!=null)      							//������������ 
        {
            Len++; 								//�ۼӽ������ 
            htemp=htemp.nextNode;					//������һ��� 
        }
        return Len;									//���ؽ������ 
    }

    void CLAllNode(CLType head) 					//�������� 
    {
        CLType htemp;
        Data1 nodeData;
        htemp=head;
        System.out.print("��ǰ������"+CLLength(head)+"����㡣���������������£�\n"); 
        while(htemp!=null) 								//ѭ����������ÿ����� 
        {
            nodeData=htemp.nodeData;				//��ȡ������� 
            System.out.println("���("+nodeData.key+" "+nodeData.name+" "+nodeData.age+")"); 
            htemp=htemp.nextNode;					//������һ��� 
        }
    }
}

