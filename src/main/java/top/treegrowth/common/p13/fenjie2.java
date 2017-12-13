package top.treegrowth.common.p13;

import java.util.Scanner;

public class fenjie2
{
	int[] result=new int[100];
	int x=0;


	public static boolean isPrime(int n)
	{
		if(n==2) return true;
		for(int i=2;i<Math.sqrt(n);i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	public static int[] minPrime(int n)
	{
		int[] pri=new int[100];
		int a=0;
		for(int i=2;i<=n;i++)
		{
			if(isPrime(i))
			{
				pri[a++]=i;
			}
		}
		return pri;
}

	public void dispose(int n)
	{
		int j;
		int[] min=fenjie2.minPrime(n);
		for(j=0;j<min.length;j++)
		{
			if(n%min[j]==0)
			{
				this.result[x++]=min[j];
				if(n==min[j]) return ;
				break;
			}
		}
		this.dispose(n/min[j]);
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner input=new Scanner(System.in);
		fenjie2 obj=new fenjie2();
		String s="";
		String go;


		System.out.println("���������֣�");
		int num=input.nextInt();
		obj.dispose(num);
		for(int i=0;i<obj.result.length;i++)
		{
			if(obj.result[i]>0)
			{
				s +=obj.result[i]+"*";
			}

		}
		System.out.println(num+"="+s.substring(0,s.length()-1));
	
		System.out.println("������");
		
	}
} 
 
 
