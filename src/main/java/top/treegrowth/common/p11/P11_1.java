package top.treegrowth.common.p11;

import java.util.Random;

class Card
{
   int Suit;							//花色 
   char Number;							//牌数 
}

public class P11_1 {
	static Card[] OneCard=new Card[52];		    	//保存每张扑克的花色、数字
	
	static void ShowCard() 							//显示扑克牌 
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
		  switch(OneCard[i].Suit)					//显示花色符号
		  {
		  case 1:
			  s="黑桃";
			  sign=3;
			  break;
		  case 2:
			  s="红桃";
			  sign=4;
			  break;
		  case 3:
			  s="梅花";
			  sign=5;
			  break;
		  case 4:
			  s="方块";
			  sign=6;
			  break;
		  default:
			  ;
		  }
		  System.out.printf("  "+s+OneCard[i].Number);	//输出显示
	   }
	   System.out.print("\n");
	}
	
	static void Shuffle()								//算法
	{
		int i,j,temp;
		int suit;
		
	    Card tempcard=new Card();

		suit=0;
	   for (i = 0; i < 52; i++)						//生成52张牌 
	   {
		  if (i % 13 == 0)
		  {
			 suit++;							//改变花色 
		  }
		  Card t=new Card();
		  t.Suit = suit;					//保存花色 
		  temp = i % 13;
		  switch(temp)							//特殊值处理
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
	   System.out.printf("一付新牌的初始排列如下:\n"); 

	   ShowCard();

	   Random r=new Random();					//随机种子
	   for (i = 0; i < 52; i++)
	   {
		  j = r.nextInt(52);						//随机换牌
		  tempcard = OneCard[j];
		  OneCard[j] = OneCard[i];
		  OneCard[i] = tempcard;
	   }
	}
	public static void main(String[] args) {
						
		 Shuffle();								//洗牌
		 System.out.print("\n洗牌后的排列如下:\n");
		 ShowCard();							//显示新牌的排列

	}

}
