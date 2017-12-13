package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_4 {
	static final int MAXNUM=30;
	static int FalseCoin(int coin[],int low,int high)	//�㷨
	{
	    int i,sum1,sum2,sum3;
		int re=0;
		sum1=sum2=sum3=0;
		// �������Ӳ�Ұ��ŵĻ�
	    if(low+1==high)
	    {
	        if(coin[low]<coin[high]) 
			{
				re=low+1;
				return re;
			}
	        else 
			{
				re=high+1;
				return re;
			}
	    }
	    // ���Ӳ������ĸ�����ż���Ļ�
	    if((high-low+1)%2 == 0)				//n��ż��
	    {
	        for(i=low;i<=low+(high-low)/2;i++)
			{
	            sum1= sum1 + coin[i];       	//ǰ��κ�
			}
	        for(i=low+(high-low)/2+1;i<=high;i++)
			{
	            sum2 = sum2 + coin[i];       	//���κ�
			}
	        if(sum1>sum2) 
			{
				re=FalseCoin(coin,low+(high-low)/2+1,high);
				return re;
			}
	        else if(sum1<sum2)
			{
				re=FalseCoin(coin,low,low+(high-low)/2);
				return re;
			}
			else
			{
			}
	    }
	    else
	    {
	        for(i=low;i<=low+(high-low)/2-1;i++)
			{
	            sum1= sum1 + coin[i];       	//ǰ��κ�
			}
	        for(i=low+(high-low)/2+1;i<=high;i++)
			{
	            sum2 = sum2 + coin[i];       	//���κ�
			}
	        sum3 = coin[low+(high-low)/2];
	        if(sum1>sum2)  
			{
				re=FalseCoin(coin,low+(high-low)/2+1,high);
	            return re;
			}
	        else if(sum1<sum2)
			{
				re=FalseCoin(coin,low,low+(high-low)/2-1);
	            return re;
			}
			else
			{
			}
			// �жϼٱ��Ƿ����Ǹ��������ŵ��Ǹ�
	        if(sum1+sum3 == sum2+sum3) 
			{
				re=low+(high-low)/2+1;
				return re;
			}
	    }
		return re;
	}
	public static void main(String[] args) {
		int[] coin=new int[MAXNUM];
		int i,n;
		int weizhi;
	    System.out.println("�����㷨�����������⣡");
		System.out.print("�����������ܵĸ�����");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();						//�����ܵĸ���
		System.out.print("���������ҵ���٣�");
		for(i=0;i<n;i++)
		{
			coin[i]=input.nextInt();			//�������ҵ����
		}
		weizhi=FalseCoin(coin,0,n-1);			//���
	    System.out.println("������"+MAXNUM+"�������У���"+weizhi+"�������Ǽٵģ�");
	}
}
