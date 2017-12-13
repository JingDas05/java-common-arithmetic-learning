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
    DATA3[] data=new DATA3[MAXLEN+1]; 						//����Ԫ�� 
    int top; 								//ջ�� 
    
    StackType STInit()
    {
    	StackType p;
    	
        if((p=new StackType())!=null) 	//����ջ�ڴ� 
        {
            p.top=0; 							//����ջ��Ϊ0 
            return p;							//����ָ��ջ��ָ�� 
        }
        return null;
    }

    boolean STIsEmpty(StackType s) 					//�ж�ջ�Ƿ�Ϊ�� 
    {
    	boolean t;
    	t=(s.top==0);
        return t;
    }

    boolean STIsFull(StackType s) 					//�ж�ջ�Ƿ�����
    {
    	boolean t;
    	t=(s.top==MAXLEN);
        return t;
    }

    void STClear(StackType s)  					//���ջ 
    {
        s.top=0;
    }

    void STFree(StackType s) 					//�ͷ�ջ��ռ�ÿռ� 
    {
        if(s!=null)
    	{
            s=null;
    	}
    }

    int PushST(StackType s,DATA3 data)			//��ջ���� 
    {
         if((s.top+1)>MAXLEN)
         {
             System.out.print("ջ���!\n"); 
             return 0;
         }
         s.data[++s.top]=data;					//��Ԫ����ջ
         return 1; 
    }

    DATA3 PopST(StackType s) 					//��ջ���� 
    {
         if(s.top==0)
         {
             System.out.print("ջΪ��!\n");
//             
             System.exit(0);
         }
         return (s.data[s.top--]);
    }

    DATA3 PeekST(StackType s) 					//��ջ������
    {
         if(s.top==0)
         {
             System.out.printf("ջΪ��!\n");
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

	    StackType stack=st.STInit();  						//��ʼ��ջ
	    Scanner input=new Scanner(System.in);
	    System.out.print("��ջ������\n");
	    System.out.println("�������� ���������ջ����:"); 
		do
		{
			DATA3 data=new DATA3();
			data.name=input.next();
			
			if(data.name.equals("0")) 
			{
				break; 						//������0�����˳�
			}
			else
			{
				data.age=input.nextInt();
				st.PushST(stack,data);
			}
		}while(true);
		
		String temp="1";
		System.out.println("��ջ����:�������0�����г�ջ����:");
		temp=input.next();
		while(!temp.equals("0"))
		{
		   	data1=st.PopST(stack);
			System.out.printf("��ջ��������(%s,%d)\n" ,data1.name,data1.age);	
			temp=input.next();
		}
		System.out.println("���Խ�����");
	    st.STFree(st); 							//�ͷ�ջ��ռ�õĿռ� 

	}

}
