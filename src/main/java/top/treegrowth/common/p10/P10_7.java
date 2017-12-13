package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_7 
{
	static double maxvalue;							//��������ֵ
	static double totalvalue;							//��Ʒ�ܼ�ֵ
	static double maxwt; 								//�������õ��������
	static int num;									//��Ʒ����
	static char[] seltemp; 								//��ʱ���� 
	
	static void backpack(GType[] goods, int i, double wt, double vt)//�㷨 
	{
	   int k;
	   if (wt + goods[i].weight <= maxwt)			//����Ʒi�����ڵ�ǰ����,�ж�����С�ڵ����������� 
	   {
		  seltemp[i] = 1; 						//ѡ�е�i����Ʒ 
		  if (i < num - 1) 						//�����Ʒi�������һ����Ʒ
		  {
			 backpack(goods, i + 1, wt + goods[i].weight, vt); //�ݹ����,���������Ʒ
		  }
		  else 
		  {
			 for (k = 0; k < num; ++k) 
			 {
				goods[k].isSelect = seltemp[k];
			 }
			 maxvalue = vt; 					//���浱ǰ����������ֵ 
		  }
	 }
	   seltemp[i] = 0; 							//ȡ����Ʒi��ѡ��״̬ 
	   if (vt - goods[i].value >maxvalue)			//�����Լ��������Ʒ 
	   {
		  if (i < num - 1) 
		  {
			 backpack(goods, i + 1, wt, vt - goods[i].value); //�ݹ����
		  }
		  else 
		  {
			 for (k = 0; k < num; ++k) 
			 {
				goods[k].isSelect = seltemp[k];
			 }
			 maxvalue = vt - goods[i].value; 
		  }
	   }
	}
	
	public static void main(String[] args) 
	{
		   double sumweight;
		   int i;

		   System.out.print("����������⣡\n");
		   System.out.print("�������������ɵ��������:");
		   Scanner input=new Scanner(System.in);
		   maxwt=input.nextDouble();						//�������������ɵ��������
		   System.out.print("��ѡ��Ʒ����:"); 
		   num=input.nextInt();						//��ѡ��Ʒ����
		   
		   GType[] goods=new GType[num];
		   seltemp=new char[num];
		   
		   totalvalue=0;							//��ʼ���ܼ�ֵ
		   for (i = 0; i < num; i++)
		   {
			  GType t=new GType();
			  System.out.print("�����"+(i+1)+"����Ʒ�������ͼ�ֵ:");
			  t.weight=input.nextDouble();
			  t.value=input.nextDouble();
			  totalvalue+=t.value;				//ͳ��������Ʒ���ܼ�ֵ
			  goods[i]=t;
		   }
		   System.out.print("\n���������װ������Ϊ:  "+maxwt+" \n\n");
		   for (i = 0; i < num; i++)
		   {
			  System.out.print("��"+(i+1)+"����Ʒ��:  "+goods[i].weight+" ,��ֵ:"+goods[i].value+" \n");
			  }
		   for (i = 0; i < num; i++)
		   {
		       seltemp[i]=0;
		   }
		   maxvalue=0;					
		   backpack(goods,0,0.0,totalvalue); 			//��� 

		   sumweight=0; 
		   System.out.print("\n�ɽ�������Ʒװ�뱳��,ʹ����װ����Ʒ��ֵ���:\n");
		   for (i = 0; i < num; ++i)
		   {
			  if (goods[i].isSelect==1)
			  {
				 System.out.print("��"+(i+1)+"����Ʒ,����:  "+goods[i].weight+" ,��ֵ:  "+goods[i].value+" \n");
				 sumweight+=goods[i].weight;
		      }	 
		   }
		   System.out.print("\n������Ϊ:  "+sumweight+" ,�ܼ�ֵΪ:  "+maxvalue+" \n");

	}

}

class GType							//�ṹ
{
    double value; 							//��ֵ
    double weight; 						//����
    char isSelect; 							//�Ƿ�ѡ�е����� 
}
