package top.treegrowth.common.p13;

import java.util.*;

class Expression {
	 private ArrayList<Integer> num=new ArrayList<Integer>();
	 private ArrayList<String> sign=new ArrayList<String>();
	 
	 public void add(int num2)
	 {
		 num.add(num2);
	 }
	 public void add(String sign2)
	 {
		 sign.add(sign2);
	 }
	 private int getPriority(String sign)
	 {
		 if (sign.equals("+")) return 1;
		 if (sign.equals("-")) return 1;
		 if (sign.equals("*")) return 2;
		 if (sign.equals("/")) return 2;
		 return -1;
	 }
	 private String toString(int layer)
	 {
		 if (layer==0)
		 {
			 return num.get(0)+sign.get(0)+num.get(1);
		 }
		 else
		 {
			String result=this.toString(layer-1);
			if (getPriority(sign.get(layer))>getPriority(sign.get(layer-1))) 
				result="("+result+")";
			result+=sign.get(layer)+num.get(layer+1);
			return result;
		 }
	 }
	 public String toString()
	 {
		 return toString(2);
	 }
	 public void clear()
	 {
		 num.clear();
		 sign.clear();
	 }
	}

 
 class Thinker {
	 private Expression exp;
	 public Thinker(Expression expression)
	 {
		 exp=expression;
	 }
	 public boolean count(ArrayList<Integer> array,int num,int target)
	 {
		 if (num==1)
		 {
			 if ((array.get(0)+array.get(1))==target)
			 {
				 exp.add(array.get(0));
				 exp.add(array.get(1));
				 exp.add("+");
				 return true;
			 }
			 if ((array.get(0)-array.get(1))==target)
			 {
				 exp.add(array.get(0));
				 exp.add(array.get(1));
				 exp.add("-");
				 return true;
			 }
			 if ((array.get(1)-array.get(0))==target)
			 {
				 exp.add(array.get(1));
				 exp.add(array.get(0));
				 exp.add("-");
				 return true;
			 }
			 if ((array.get(0)*array.get(1))==target)
			 {
				 exp.add(array.get(0));
				 exp.add(array.get(1));
				 exp.add("*");
				 return true;
			 }
			 if ((array.get(0)*target==array.get(1)))
			 {
				 exp.add(array.get(1));
				 exp.add(array.get(0));
				 exp.add("/");
				 return true;
			 }
			 if ((array.get(1)*target==array.get(0)))
			 {
				 exp.add(array.get(0));
				 exp.add(array.get(1));
				 exp.add("/");
				 return true;
			 }
			 return false;
		 }
		 else 
		 {
			 for (int current=0;current<array.size();current++)
			 {
				 ArrayList<Integer> array1=new ArrayList<Integer>();
				 int currentNum=array.get(current);
				 for (int i=0;i<array.size();i++)
				 if (i!=current) array1.add(array.get(i));
				 if (count(array1,num-1,target-currentNum))
				 {
					 exp.add("+");
					 exp.add(currentNum);
					 if (num==3) 
					 {
						 System.out.println(exp.toString());
						 exp.clear();
					 }
					 if (num!=3) return true;	 
				 }
				 if (count(array1,num-1,target+currentNum))
				 {
					 exp.add("-");
					 exp.add(currentNum);
					 if (num==3) 
					 {
						 System.out.println(exp.toString());
						 exp.clear();
					 }
					 if (num!=3) return true;	 
				 }
				 if (count(array1,num-1,target*currentNum))
				 {
					 exp.add("/");
					 exp.add(currentNum);
					 if (num==3) 
					 {
						 System.out.println(exp.toString());
						 exp.clear();
					 }
					 if (num!=3) return true;	 
				 }
				 if (target%currentNum==0)
				 {
					 if (count(array1,num-1,(int)(target/currentNum)))
					 {
						 exp.add("*");
						 exp.add(currentNum);
						 if (num==3) 
						 {
							 System.out.println(exp.toString());
							 exp.clear();
						 }
						 if (num!=3) return true;	 
					 }
				 }
			 }
			 return false;
		 }
	 }

	}


public class ersi2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Expression expression=new Expression();
		Thinker thinker=new Thinker(expression);
		ArrayList<Integer> card=new ArrayList<Integer>();
		int target=24;
		
		Scanner input=new Scanner(System.in);
		System.out.println("������4�����֣�");
		int t;
		for(int i=0;i<4;i++){
			t=input.nextInt();
			card.add(t);
		}
//		
//		
//		card.add(2);
//		card.add(4);
//		card.add(6);
//		card.add(3);
		
		thinker.count(card,card.size()-1,target);
	}

}