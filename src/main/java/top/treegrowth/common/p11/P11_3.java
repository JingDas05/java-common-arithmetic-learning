package top.treegrowth.common.p11;

import java.util.Random;
import java.util.Scanner;

class Card2
{
   int Suit;							//花色 
   char Number;							//牌数 
   double Num;
}

public class P11_3 {
	static Card2[] OneCard=new Card2[52];		    	//保存每张扑克的花色、数字
	
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
		
	    Card2 tempcard=new Card2();

		suit=0;
	   for (i = 0; i < 52; i++)						//生成52张牌 
	   {
		  if (i % 13 == 0)
		  {
			 suit++;							//改变花色 
		  }
		  Card2 t=new Card2();
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
		  
		  if (temp >= 10)						//记0.5点
			 {
				 t.Num = 0.5;
			 }
		  else
			  {
				 t.Num = (double)(temp + 1);
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
	
	static void tenhalf() 								//10点半算法
	{
	   int i, count = 0;							//count为牌的计数器 
	   int iUser = 0, iComputer = 0;				//iUser为游戏者牌的数量,iComputer为计算机牌的数量 
	   int flag = 1, flagc = 1;	 
	   String jixu,s="";
	   Card2[] User=new Card2[20], Computer=new Card2[20];				//保存游戏者和计算机手中的牌 
	   float TotalU = 0, TotalC = 0;					//统计游戏者和计算机的总点数 
	   
	   Scanner input=new Scanner(System.in);

	   while (flag == 1 && count < 52)				//还有牌，继续发牌 
	   {
		  //游戏者取牌 
		  User[iUser++] = OneCard[count++];		//发牌给游戏者 
		  TotalU += User[iUser - 1].Num;			//累加游戏者总点数 
		  //接下为由计算机取牌
		  if (count >= 52)						//牌已取完 
		  {
			 flag = 0;
		  }
		  else if (TotalU > 10.5)					//游戏者炸了
		  {
			 flagc = 0; 						//计算机不再要牌 
		  }
		  else
		  {
			 if ((TotalC < 10.5 && TotalC < TotalU) || TotalC < 7) 
			 {
				Computer[iComputer++] = OneCard[count++];	//计算机取一张牌 
				TotalC += Computer[iComputer - 1].Num;		//累计计算机总点数 
			 }
		  }
		  System.out.printf("\n用户的总点数为:%.1f\t", TotalU);
		  System.out.printf("用户的牌为:");
		  for (i = 0; i < iUser; i++)					//显示用户的牌
		  {		
			  
			  switch(User[i].Suit)					//显示花色符号
			  {
			  case 1:
				  s="黑桃";
				  break;
			  case 2:
				  s="红桃";
				  break;
			  case 3:
				  s="梅花";
				  break;
			  case 4:
				  s="方块";
				  break;
			  default:
				  ;
			  }
			  System.out.printf("  "+s+User[i].Number);
		  }
		  System.out.printf("\n");
		  System.out.printf("计算机的总点数为:%.1f\t", TotalC);
		  System.out.printf("计算机的牌为:");
		  for (i = 0; i < iComputer; i++)				//显示计算机的牌
		  {
			  switch(Computer[i].Suit)					//显示花色符号
			  {
			  case 1:
				  s="黑桃";
				  break;
			  case 2:
				  s="红桃";
				  break;
			  case 3:
				  s="梅花";
				  break;
			  case 4:
				  s="方块";
				  break;
			  default:
				  ;
			  }
			  System.out.printf("  "+s+Computer[i].Number);
		  }
		  System.out.printf("\n");
		  if (TotalU < 10.5)						//如果游戏者点数小于10.5,可继续要牌 
		  {
			 do
			 {
				 System.out.printf("还要牌吗(y/n)?");
				
				jixu=input.next();
			 }while (!jixu.equalsIgnoreCase("y") &&!jixu.equalsIgnoreCase("n"));
			 if (jixu.equalsIgnoreCase("y"))				//继续要牌
			 {
				flag = 1;
			 }
			 else
			 {
				flag = 0;
			 }
			 if (count == 52)
			 {
				 System.out.printf("牌已经发完了！\n");
				
				break;
			 }
		  }
	      else
			 break;
	   }
	   while (flagc==1 && count < 52)				//游戏者不要牌
	   {
		  if (TotalU > 10.5)						//游戏者炸了
		  {
			 break;
		  }
		  else
		  {
			 if (TotalC < 10.5 && TotalC < TotalU)	
			 {
				Computer[iComputer++] = OneCard[count++];	//计算机取一张牌 
				TotalC += Computer[iComputer - 1].Num;		//累计计算机取得牌的总点数 
			 }
			 else
			 {
			     break;
			 }
		  }
	   }
	   System.out.printf("\n用户的总点数:%.1f\t", TotalU);
	   System.out.printf("用户的牌为:");
	   for (i = 0; i < iUser; i++)					//显示用户的牌
	   {
		   switch(User[i].Suit)					//显示花色符号
			  {
			  case 1:
				  s="黑桃";
				  break;
			  case 2:
				  s="红桃";
				  break;
			  case 3:
				  s="梅花";
				  break;
			  case 4:
				  s="方块";
				  break;
			  default:
				  ;
			  }
			  System.out.printf("  "+s+User[i].Number);
	   }
	   System.out.printf("\n");
	   System.out.printf("\n计算机的总点数为:%.1f\t", TotalC);
	   System.out.printf("计算机的牌为:");
	   for (i = 0; i < iComputer; i++)				//显示计算机的牌
	   {
		   switch(Computer[i].Suit)					//显示花色符号
			  {
			  case 1:
				  s="黑桃";
				  break;
			  case 2:
				  s="红桃";
				  break;
			  case 3:
				  s="梅花";
				  break;
			  case 4:
				  s="方块";
				  break;
			  default:
				  ;
			  }
			  System.out.printf("  "+s+Computer[i].Number);
	   }
	   System.out.printf("\n");

	   if(TotalC == TotalU)						//输出游戏结果
	   {
		   System.out.printf("\n用户和计算机打成了平手!\n");
	   }
	   else
	   {
		   if(TotalU > 10.5 && TotalC > 10.5)
		   {
			   System.out.printf("\n用户和计算机打成了平手!\n");
		   }
		   else if(TotalU > 10.5)
		   {
			   System.out.printf("\n你输了!继续努力吧!\n");
		   }
		   else if(TotalC > 10.5)
		   {
			   System.out.printf("\n恭喜，用户赢了!\n");
		   }
		   else if(TotalC > TotalU)
		   {
			   System.out.printf("\n你输了!继续努力吧!\n");
		   }
		   else
		   {
			   System.out.printf("\n恭喜，用户赢了!\n");
		   }
	   }
	}
	
	public static void main(String[] args) {
		 System.out.printf("10点半游戏！\n");
	 Shuffle();							//洗牌 
		 	  tenhalf();							//开始游戏

	}

}
