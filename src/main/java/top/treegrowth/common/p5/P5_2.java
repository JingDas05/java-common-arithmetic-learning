package top.treegrowth.common.p5;

import java.util.Scanner;


public class P5_2 {
	static final int N=15;
	static void quickSort(int[] arr,int left,int right)			//���������㷨
	{
	    int f,t;
		int rtemp,ltemp;

	    ltemp=left;
	    rtemp=right;
	    f=arr[(left+right)/2];						//ȷ���ֽ�ֵ
		while(ltemp<rtemp)
		{
	        while(arr[ltemp]<f)
			{
				++ltemp;
			}
	        while(arr[rtemp]>f) 
			{
				--rtemp;
			}
	        if(ltemp<=rtemp)
	        {
				t=arr[ltemp];
		        arr[ltemp]=arr[rtemp];
	    	    arr[rtemp]=t;
				--rtemp;
	        	++ltemp;
			}
	    }
	    if(ltemp==rtemp) 
		{
			ltemp++;
		}

	    if(left<rtemp) 
		{
			quickSort(arr,left,ltemp-1);				//�ݹ����
		}
	    if(ltemp<right) 
		{
			quickSort(arr,rtemp+1,right);				//�ݹ����
		}
	}
	
	static int searchFun(int a[],int n,int x)					//�۰����
	{
	    int mid,low,high;

		low=0;
		high=n-1;
	    while(low<=high)
	    {
	   		mid=(low+high)/2;
			if(a[mid]==x)
	            return mid;						//�ҵ�
			else if(a[mid]>x)
			    high=mid-1;
	        else
				low=mid+1;
	    }

		return -1;								//δ�ҵ�
	}
	
	public static void main(String[] args) {
		int[] shuzu=new int[N];
		int x,n,i;

		for(i=0;i<N;i++)
		{
			shuzu[i]=(int)(100+Math.random()*(100+1));;				//��������
		}
		
		System.out.print("�۰�����㷨��ʾ��\n");
	    System.out.print("����ǰ��������:\n");
	    for(i=0;i<N;i++)
		{
	        System.out.print(" "+shuzu[i]);					//�������
		}
		System.out.print("\n\n");
		quickSort(shuzu,0,N-1);				//����
	    System.out.print("�������������:\n");
	    for(i=0;i<N;i++)
		{
	        System.out.print(" "+shuzu[i]);					//�������
		}
		System.out.print("\n\n");
	    System.out.print("����Ҫ���ҵ���:");
	    Scanner input=new Scanner(System.in);
	    x=input.nextInt();							//����Ҫ���ҵ���

	    n=searchFun(shuzu,N,x);						//����

	    if(n<0)								//������ҽ��
		{
			System.out.println("û�ҵ�����:"+x);
		}
		else
		{
			System.out.println("����:"+x+" λ������ĵ�"+(n+1)+" ��Ԫ�ش���");
		}

	}

}
