package top.treegrowth.common.p5;

import java.util.Scanner;


public class P5_3 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i;
	    SLType SL=new SLType();         		//����˳������ 
		Data pdata;				//�����㱣��ָ����� 
		Scanner input=new Scanner(System.in);
		System.out.print("˳��������ʾ!\n"); 
		
	    SL.SLInit(SL);       			//��ʼ��˳��� 
	    
		System.out.print("��ʼ��˳������!\n");

	    do 
		{                    		//ѭ����ӽ������ 
	        System.out.print("������ӵĽ��(ѧ�� ���� ����)��"); 
	    	Data data=new Data();  
	        data.key=input.next();
	        data.name=input.next();
	        data.age=input.nextInt();
	        if(data.age>0)               //�����䲻Ϊ0 
	        {	
	            if(SL.SLAdd(SL,data)==0)   //����ӽ��ʧ�� 
				{
	                break;            //�˳���ѭ�� 
				}
	        }
		   else   				//������Ϊ0 
		   {
	            break;          		//�˳���ѭ��
		   }
	    }while(true);
	    System.out.print("\n˳����еĽ��˳��Ϊ��\n");
	    SL.SLAll(SL);                  //��ʾ���н������ 
	    
	    System.out.print("\nҪȡ��������ţ�");
	    i=input.nextInt(); //�����ռ�����    
	    pdata=SL.SLFindByNum(SL,i);  //����Ų��ҽ�� 
	    if(!pdata.equals(null))        			//�����صĽ��ָ�벻ΪNULL
		{ 
	        System.out.print("��"+i+"�����Ϊ��<"+pdata.key+" "+pdata.name+" "+pdata.age+">");
		}

	}

}

class Data{
	String key;                 //���Ĺؼ��� 
	String name;
    int age;
}    					//����������

class SLType    				//����˳���ṹ
{	static final int MAXLEN=100;
    Data[] ListData=new Data[MAXLEN+1];	//����˳���Ľṹ���� 
    int ListLen;              		//˳����Ѵ�������� 
    
    void SLInit(SLType SL) 			//��ʼ��˳���
    {
        SL.ListLen=0;    			//��ʼ��Ϊ�ձ�
    }

    int SLLength(SLType SL)  		
    {
        return SL.ListLen;    		//����˳����Ԫ������
    }

    int SLAdd(SLType SL,Data data)  //����Ԫ�ص�˳���β��
    {
        if(SL.ListLen==MAXLEN)  	//˳������� 
        {
            System.out.print("˳�����������������ӽ���ˣ�\n");
            return 0;    
        }
        SL.ListData[++SL.ListLen]=data;
        return 1;
    }

    Data SLFindByNum(SLType SL,int n)  //������ŷ�������Ԫ��
    {
        if(n<1 || n>SL.ListLen+1)  		//Ԫ����Ų���ȷ
        {
            System.out.print("�����Ŵ��󣬲��ܷ��ؽ�㣡\n");
            return null;              	//���ɹ����򷵻�0
        } 
        return SL.ListData[n];
    }

    int SLFindByCont(SLType SL,String key)  		//���ؼ��ֲ�ѯ��� 
    {
        int i;
        for(i=1;i<=SL.ListLen;i++)
    	{
           	if(SL.ListData[i].key.compareTo(key)==0) //����ҵ������� 
    		{
                return i;        					//���ؽ����� 
    		}
    	}
        return 0;  								//�������������û���ҵ����򷵻�0 
    }

    int SLAll(SLType SL)  						//��ʾ˳����е����н�� 
    {
        int i;
        for(i=1;i<=SL.ListLen;i++)
    	{
            System.out.println("<"+SL.ListData[i].key+" "+SL.ListData[i].name+" "+SL.ListData[i].age+">");
    	}
    	return 0;
    }
    
}