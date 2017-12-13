package top.treegrowth.common.p4;

public class P4_9 {
	static final int N=5;
	static void quickSort(String[] arr,int left,int right)			//���������㷨
	{
	    String  f,t;
		int rtemp,ltemp;

	    ltemp=left;
	    rtemp=right;
	    f=arr[(left+right)/2];						//�ֽ�ֵ
		while(ltemp<rtemp)
		{
	        while(arr[ltemp].compareTo(f)<0)
			{
				++ltemp;
			}
	        while(arr[rtemp].compareTo(f)>0) 
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
			quickSort(arr,left,ltemp-1);			//�ݹ����
		}
	    if(ltemp<right) 
		{
			quickSort(arr,rtemp+1,right);			//�ݹ����
		}
	}
	public static void main(String[] args) 
	{
		String[] arr=new String[]{"One","World","Dream","Beijing","Olympic"};	//��������ʼ��
		int i;

		System.out.print("����ǰ��\n");
		for(i=0;i<N;i++)
		{
			System.out.println(arr[i]);					//�������ǰ
		}

		quickSort(arr,0,N-1);							//����

		System.out.print("�����\n");
		for(i=0;i<N;i++)
		{
			System.out.println(arr[i]);					//��������
		}
		

	}
}


