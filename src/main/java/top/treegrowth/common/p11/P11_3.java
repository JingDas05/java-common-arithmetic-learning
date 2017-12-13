package top.treegrowth.common.p11;

import java.util.Random;
import java.util.Scanner;

class Card2
{
   int Suit;							//��ɫ 
   char Number;							//���� 
   double Num;
}

public class P11_3 {
	static Card2[] OneCard=new Card2[52];		    	//����ÿ���˿˵Ļ�ɫ������
	
	static void ShowCard() 							//��ʾ�˿��� 
	{
	   int i, j;
	   int sign=0;
	   String s="";

	   for (i = 0, j = 0; i < 52; i++, j++)
	   {
		  if (j % 13==0)
		  {
			 System.out.print("\n");
		  }
		  switch(OneCard[i].Suit)					//��ʾ��ɫ����
		  {
		  case 1:
			  s="����";
			  sign=3;
			  break;
		  case 2:
			  s="����";
			  sign=4;
			  break;
		  case 3:
			  s="÷��";
			  sign=5;
			  break;
		  case 4:
			  s="����";
			  sign=6;
			  break;
		  default:
			  ;
		  }
		  System.out.printf("  "+s+OneCard[i].Number);	//�����ʾ
	   }
	   System.out.print("\n");
	}
	
	static void Shuffle()								//�㷨
	{
		int i,j,temp;
		int suit;
		
	    Card2 tempcard=new Card2();

		suit=0;
	   for (i = 0; i < 52; i++)						//����52���� 
	   {
		  if (i % 13 == 0)
		  {
			 suit++;							//�ı仨ɫ 
		  }
		  Card2 t=new Card2();
		  t.Suit = suit;					//���滨ɫ 
		  temp = i % 13;
		  switch(temp)							//����ֵ����
		  {
		  case 0:
			  t.Number = 'A';
			  break;
		  case 9:
			  t.Number = '0';
			  break;
		  case 10:
			  t.Number = 'J';
			  break;
		  case 11:
			  t.Number = 'Q';
			  break;
		  case 12:
			  t.Number = 'K';
			  break;
		  default:
			  t.Number =(char)(temp + '1');
		  }
		  
		  if (temp >= 10)						//��0.5��
			 {
				 t.Num = 0.5;
			 }
		  else
			  {
				 t.Num = (double)(temp + 1);
			  }
		  OneCard[i]=t;

	   }
	   System.out.printf("һ�����Ƶĳ�ʼ��������:\n"); 

	   ShowCard();

	   Random r=new Random();					//�������
	   for (i = 0; i < 52; i++)
	   {
		  j = r.nextInt(52);						//�������
		  tempcard = OneCard[j];
		  OneCard[j] = OneCard[i];
		  OneCard[i] = tempcard;
	   }
	}
	
	static void tenhalf() 								//10����㷨
	{
	   int i, count = 0;							//countΪ�Ƶļ����� 
	   int iUser = 0, iComputer = 0;				//iUserΪ��Ϸ���Ƶ�����,iComputerΪ������Ƶ����� 
	   int flag = 1, flagc = 1;	 
	   String jixu,s="";
	   Card2[] User=new Card2[20], Computer=new Card2[20];				//������Ϸ�ߺͼ�������е��� 
	   float TotalU = 0, TotalC = 0;					//ͳ����Ϸ�ߺͼ�������ܵ��� 
	   
	   Scanner input=new Scanner(System.in);

	   while (flag == 1 && count < 52)				//�����ƣ��������� 
	   {
		  //��Ϸ��ȡ�� 
		  User[iUser++] = OneCard[count++];		//���Ƹ���Ϸ�� 
		  TotalU += User[iUser - 1].Num;			//�ۼ���Ϸ���ܵ��� 
		  //����Ϊ�ɼ����ȡ��
		  if (count >= 52)						//����ȡ�� 
		  {
			 flag = 0;
		  }
		  else if (TotalU > 10.5)					//��Ϸ��ը��
		  {
			 flagc = 0; 						//���������Ҫ�� 
		  }
		  else
		  {
			 if ((TotalC < 10.5 && TotalC < TotalU) || TotalC < 7) 
			 {
				Computer[iComputer++] = OneCard[count++];	//�����ȡһ���� 
				TotalC += Computer[iComputer - 1].Num;		//�ۼƼ�����ܵ��� 
			 }
		  }
		  System.out.printf("\n�û����ܵ���Ϊ:%.1f\t", TotalU);
		  System.out.printf("�û�����Ϊ:");
		  for (i = 0; i < iUser; i++)					//��ʾ�û�����
		  {		
			  
			  switch(User[i].Suit)					//��ʾ��ɫ����
			  {
			  case 1:
				  s="����";
				  break;
			  case 2:
				  s="����";
				  break;
			  case 3:
				  s="÷��";
				  break;
			  case 4:
				  s="����";
				  break;
			  default:
				  ;
			  }
			  System.out.printf("  "+s+User[i].Number);
		  }
		  System.out.printf("\n");
		  System.out.printf("��������ܵ���Ϊ:%.1f\t", TotalC);
		  System.out.printf("���������Ϊ:");
		  for (i = 0; i < iComputer; i++)				//��ʾ���������
		  {
			  switch(Computer[i].Suit)					//��ʾ��ɫ����
			  {
			  case 1:
				  s="����";
				  break;
			  case 2:
				  s="����";
				  break;
			  case 3:
				  s="÷��";
				  break;
			  case 4:
				  s="����";
				  break;
			  default:
				  ;
			  }
			  System.out.printf("  "+s+Computer[i].Number);
		  }
		  System.out.printf("\n");
		  if (TotalU < 10.5)						//�����Ϸ�ߵ���С��10.5,�ɼ���Ҫ�� 
		  {
			 do
			 {
				 System.out.printf("��Ҫ����(y/n)?");
				
				jixu=input.next();
			 }while (!jixu.equalsIgnoreCase("y") &&!jixu.equalsIgnoreCase("n"));
			 if (jixu.equalsIgnoreCase("y"))				//����Ҫ��
			 {
				flag = 1;
			 }
			 else
			 {
				flag = 0;
			 }
			 if (count == 52)
			 {
				 System.out.printf("���Ѿ������ˣ�\n");
				
				break;
			 }
		  }
	      else
			 break;
	   }
	   while (flagc==1 && count < 52)				//��Ϸ�߲�Ҫ��
	   {
		  if (TotalU > 10.5)						//��Ϸ��ը��
		  {
			 break;
		  }
		  else
		  {
			 if (TotalC < 10.5 && TotalC < TotalU)	
			 {
				Computer[iComputer++] = OneCard[count++];	//�����ȡһ���� 
				TotalC += Computer[iComputer - 1].Num;		//�ۼƼ����ȡ���Ƶ��ܵ��� 
			 }
			 else
			 {
			     break;
			 }
		  }
	   }
	   System.out.printf("\n�û����ܵ���:%.1f\t", TotalU);
	   System.out.printf("�û�����Ϊ:");
	   for (i = 0; i < iUser; i++)					//��ʾ�û�����
	   {
		   switch(User[i].Suit)					//��ʾ��ɫ����
			  {
			  case 1:
				  s="����";
				  break;
			  case 2:
				  s="����";
				  break;
			  case 3:
				  s="÷��";
				  break;
			  case 4:
				  s="����";
				  break;
			  default:
				  ;
			  }
			  System.out.printf("  "+s+User[i].Number);
	   }
	   System.out.printf("\n");
	   System.out.printf("\n��������ܵ���Ϊ:%.1f\t", TotalC);
	   System.out.printf("���������Ϊ:");
	   for (i = 0; i < iComputer; i++)				//��ʾ���������
	   {
		   switch(Computer[i].Suit)					//��ʾ��ɫ����
			  {
			  case 1:
				  s="����";
				  break;
			  case 2:
				  s="����";
				  break;
			  case 3:
				  s="÷��";
				  break;
			  case 4:
				  s="����";
				  break;
			  default:
				  ;
			  }
			  System.out.printf("  "+s+Computer[i].Number);
	   }
	   System.out.printf("\n");

	   if(TotalC == TotalU)						//�����Ϸ���
	   {
		   System.out.printf("\n�û��ͼ���������ƽ��!\n");
	   }
	   else
	   {
		   if(TotalU > 10.5 && TotalC > 10.5)
		   {
			   System.out.printf("\n�û��ͼ���������ƽ��!\n");
		   }
		   else if(TotalU > 10.5)
		   {
			   System.out.printf("\n������!����Ŭ����!\n");
		   }
		   else if(TotalC > 10.5)
		   {
			   System.out.printf("\n��ϲ���û�Ӯ��!\n");
		   }
		   else if(TotalC > TotalU)
		   {
			   System.out.printf("\n������!����Ŭ����!\n");
		   }
		   else
		   {
			   System.out.printf("\n��ϲ���û�Ӯ��!\n");
		   }
	   }
	}
	
	public static void main(String[] args) {
		 System.out.printf("10�����Ϸ��\n");
	 Shuffle();							//ϴ�� 
		 	  tenhalf();							//��ʼ��Ϸ

	}

}
