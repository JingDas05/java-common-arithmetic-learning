package top.treegrowth.common.p8;

import java.util.Scanner;


public class P8_2 {
	static final int Num=41; 						//������
	static final int KillMan=3; 						//��ɱ�߱���

	static void Josephus(int alive)					//Լɪ���㷨
	{
	    int[] man=new int[Num];
	    int count=1;
	    int i=0,pos=-1;

	    while(count<=Num)
	    {
	        do{
	            pos=(pos+1) % Num;  		//������
	            if(man[pos]==0)
	                i++;
	            if(i==KillMan) 				//������ɱ
	            {
	                i=0;
	                break;
	            }
	        }while(true);
	        man[pos]=count;
			System.out.printf("��%2d������ɱ��Լɪ�򻷱��Ϊ%2d",pos+1,man[pos]);
			if(count%2==1)
			{
				System.out.printf(" -> ");
			}
			else
			{
				System.out.printf(" ->\n");				//�������
			}
	        count++;
	    }
	    System.out.printf("\n");
	    System.out.printf("��%d��Ҫ�����˳�ʼλ��Ӧ�����������:\n",alive);
	    alive=Num-alive;
	    for(i=0;i<Num;i++)
		{
	        if(man[i]>alive)
			{
	            System.out.printf("��ʼ���:%d,Լɪ�򻷱��:%d\n",i+1,man[i]);
			}
		}
	    System.out.printf("\n");
	}
	public static void main(String[] args) 
	{
		int alive;
		Scanner input=new Scanner(System.in);
	    System.out.printf("Լɪ���������!\n");
		System.out.printf("������Ҫ������˵�����:");		
	    alive=input.nextInt();			//����������˵�����
		Josephus(alive);

	}

}
