package top.treegrowth.common.p13;

import java.io.*;
import java.util.Scanner;

class upstair{
	
    static int sum(int a[]){
        int sum=0;
        for(int i=1;i<a.length;i++)
            sum+=a[i];
       return sum;
    }
	
	static void up(int n){
		int a[]=new int[n+1];
        int count=0;         
        int i,k;
        a[0]=-2;
        for(i=1;i<n+1;i++)
            a[i]=1;
        k=n;
        while(a[k]!=-1){
            if(sum(a)<n)  k++;
            if(sum(a)==n){
              for(i=1;i<=k;i++)
                  System.out.print(a[i]+" ");
                System.out.println();
                count++;
              a[k]=0;
              while(a[--k]==2)
                   a[k]=0;
            }  
            a[k]++;            
       }
       System.out.println(n+"�Ĳ�ַ�������:"+count+"�֡�");
	}
	
	
    public static void main(String argc[]){
        int n;
    	Scanner input=new Scanner(System.in);
        System.out.println("���������֣�");
        n=input.nextInt();
        up(n);
    	
        
     }    

} 