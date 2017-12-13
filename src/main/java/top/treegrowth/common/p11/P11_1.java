package top.treegrowth.common.p11;

import java.util.Random;

class Card
{
   int Suit;							//��ɫ 
   char Number;							//���� 
}

public class P11_1 {
	static Card[] OneCard=new Card[52];		    	//����ÿ���˿˵Ļ�ɫ������
	
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
		
	    Card tempcard=new Card();

		suit=0;
	   for (i = 0; i < 52; i++)						//����52���� 
	   {
		  if (i % 13 == 0)
		  {
			 suit++;							//�ı仨ɫ 
		  }
		  Card t=new Card();
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
	public static void main(String[] args) {
						
		 Shuffle();								//ϴ��
		 System.out.print("\nϴ�ƺ����������:\n");
		 ShowCard();							//��ʾ���Ƶ�����

	}

}
