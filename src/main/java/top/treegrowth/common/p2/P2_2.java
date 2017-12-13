package top.treegrowth.common.p2;

import java.util.Scanner;


class DATA2
{
    String key;  				//���Ĺؼ��� 
    String name;
    int age;
}

class CLType								//��������ṹ
{
    DATA2 nodeData=new DATA2();
    CLType nextNode;
    
    CLType CLAddEnd(CLType head,DATA2 nodeData)  	//׷�ӽ�� 
    {
        CLType node,htemp;
        if((node=new CLType())==null)
        {
            System.out.print("�����ڴ�ʧ�ܣ�\n"); 
            return null;  							//�����ڴ�ʧ�� 
        }
    	else
    	{
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
    }

    CLType CLAddFirst(CLType head,DATA2 nodeData) 
    {
        CLType node;
        if((node=new CLType())==null)
        {
            System.out.print("�����ڴ�ʧ�ܣ�\n"); 
            return null;  							//�����ڴ�ʧ�� 
        }
    	else
    	{
    		node.nodeData=nodeData; 				//�������� 
    		node.nextNode=head;  					//ָ��ͷָ����ָ��� 
    		head=node;        						//ͷָ��ָ���������
    		return head; 
    	}
    }

    CLType CLFindNode(CLType head,String key) 		//���ҽ��
    {
        CLType htemp;
        htemp=head;       							//��������ͷָ�� 
        while(htemp!=null)      							//�������Ч������в��� 
        {
            if(htemp.nodeData.key.compareTo(key)==0) 		//�����ؼ����봫��ؼ�����ͬ 
    		{
                return htemp;  						//���ظý��ָ�� 
    		}
            htemp=htemp.nextNode; 					//������һ��� 
        }
        return null; 								//���ؿ�ָ�� 
    }

    CLType CLInsertNode(CLType head,String findkey,DATA2 nodeData)  	//������ 
    {
        CLType node,nodetemp;    
        if((node=new CLType())==null) 		//���䱣��������� 
        {
            System.out.print("�����ڴ�ʧ�ܣ�\n"); 
            return null;  								//�����ڴ�ʧ�� 
        }
        node.nodeData=nodeData;  					//�������е����� 
        nodetemp=CLFindNode(head,findkey);
        if(nodetemp!=null)  								//���ҵ�Ҫ����Ľ�� 
        {
            node.nextNode=nodetemp.nextNode;  		//�²�����ָ��ؼ�������һ��� 
            nodetemp.nextNode=node;    			//���ùؼ����ָ���²����� 
        }
    	else
    	{
            System.out.print("δ�ҵ���ȷ�Ĳ���λ�ã�\n"); 
//            free(node);								//�ͷ��ڴ�
        }
        return head;								//����ͷָ��
    }

    int CLDeleteNode(CLType head,String key)
    {
        CLType node,htemp; 						//node����ɾ������ǰһ��� 
        htemp=head; 
    	node=head;
        while(htemp!=null)
        {
            if(htemp.nodeData.key.compareTo(key)==0) 		//�ҵ��ؼ��֣�ִ��ɾ������ 
            {
                node.nextNode=htemp.nextNode;  		//ʹǰһ���ָ��ǰ������һ���
//                free(htemp);  						//�ͷ��ڴ� 
                return 1;
            }
    		else
    		{
                node=htemp;  						//ָ��ǰ��� 
                htemp=htemp.nextNode; 				//ָ����һ��� 
            }
         }
         return 0;									//δɾ�� 
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
        DATA2 nodeData;
        htemp=head;
        System.out.printf("��ǰ������%d����㡣���������������£�\n",CLLength(head)); 
        while(htemp!=null) 								//ѭ����������ÿ����� 
        {
            nodeData=htemp.nodeData;				//��ȡ������� 
            System.out.printf("���(%s,%s,%d)\n",nodeData.key,nodeData.name,nodeData.age); 
            htemp=htemp.nextNode;					//������һ��� 
        }
    }
  
}

public class P2_2 {

	public static void main(String[] args) {
		CLType node, head=null;
	    CLType CL=new CLType();
	    String key,findkey;
	    Scanner input=new Scanner(System.in);
	    
	    System.out.print("������ԡ������������е����ݣ���ʽΪ���ؼ��� ���� ����\n"); 
	    do
		{ 
	    	DATA2 nodeData=new DATA2();
	        nodeData.key=input.next();
	       if(nodeData.key.equals("0")) 
			{
				break; //������0�����˳�
			}
			else
			{
				nodeData.name=input.next();
				nodeData.age=input.nextInt();
				head=CL.CLAddEnd(head,nodeData);//������β����ӽ��
			}
	    }while(true);   
	    CL.CLAllNode(head); 							//��ʾ���н��
	 
	    System.out.printf("\n��ʾ�����㣬�������λ�õĹؼ��֣�") ;
	    findkey=input.next();  						//�������λ�ùؼ��� 
	    System.out.print("��������������(�ؼ��� ���� ����):");
	    DATA2 nodeData=new DATA2();
	    nodeData.key=input.next();
	    nodeData.name=input.next();
	    nodeData.age=input.nextInt();//������������� 
	    head=CL.CLInsertNode(head,findkey,nodeData);		//���ò��뺯��  
	    CL.CLAllNode(head); 							//��ʾ���н��

	    System.out.print("\n��ʾɾ����㣬����Ҫɾ���Ĺؼ���:");
	     
	    key=input.next();								//����ɾ�����ؼ��� 
	    CL.CLDeleteNode(head,key); 					//����ɾ����㺯�� 
	    CL.CLAllNode(head); 							//��ʾ���н��   

	    System.out.printf("\n��ʾ�������в��ң�������ҹؼ���:");
	    key=input.next();							//������ҹؼ��� 
	    node=CL.CLFindNode(head,key);					//���ò��Һ��������ؽ��ָ�� 
	    if(node!=null)									//�����ؽ��ָ����Ч 
	    {
	        nodeData=node.nodeData;				//��ȡ�������� 
	        System.out.printf("�ؼ���%s��Ӧ�Ľ��Ϊ(%s,%s,%d)\n" ,key,nodeData.key,nodeData.name,nodeData.age);        
	    }
		else										//�����ָ����Ч 
		{
	        System.out.printf("��������δ�ҵ��ؼ���Ϊ%s�Ľ�㣡\n",key); 
		}

	}

}
