package top.treegrowth.common.p9;

import java.util.Scanner;


public class P9_10 {
	static int isPrime(int a)			//�ж������㷨
	{  
	    int i;
	    for(i=2;i<a;i++)
		{
			if(a % i == 0)
			{
				return 0;      //�������� 
			}
		}
	    return 1;      			//������ 
	}

	static void PrimeFactor(int n)		//�ֽ��������㷨
	{ 
	    int i;
	    if(isPrime(n)==1)  
		{
			System.out.printf("%d*",n);
		}
	    else
	    {
	        for(i=2;i<n;i++)
			{
	            if(n % i == 0)
	            {
	                 System.out.printf("%d*",i); 	//��һ������һ���������� 
	                 if(isPrime(n/i)==1) 
					 {			//�жϵڶ��������Ƿ������� 
	                     System.out.printf("%d",n/i);
	                     break; 		//�ҵ�ȫ�������� 
	                 }
	                else
					{
	                    PrimeFactor(n/i);//�ݹ�ص���PrimeFactor �ֽ�n/i 
					}
	            break;
	            }
			}
	    }
	}
	public static void main(String[] args) {
		int n;
	    System.out.printf("����������һ����n��\n")  ;
	    Scanner input=new Scanner(System.in);
	    n=input.nextInt();
	    System.out.printf("n=%d=",n);
	    PrimeFactor(n);   			//��n�ֽ������� 

	}

}
