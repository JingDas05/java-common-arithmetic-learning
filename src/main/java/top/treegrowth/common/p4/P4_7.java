package top.treegrowth.common.p4;

public class P4_7 {
	static final int SIZE=15;
	static void mergeOne(int a[],int b[],int n,int len) 		//���һ��ϲ��ĺ��� 
	{
	    int i,j,k,s,e;

	    s=0;
	    while(s+len<n)  
	    {
	        e=s+2*len-1;
	        if(e>=n) 						//���һ�ο�������len����� 
			{
	            e=n-1;
			}
			//��������κϲ�
			k=s;
			i=s;
			j=s+len;
			while(i<s+len && j<=e) 			//������������δ����ʱ��ѭ���Ƚ� 
			{
				if(a[i]<=a[j])				//�����С��Ԫ�ظ��Ƶ�����b�� 
				{
				   b[k++]=a[i++];
				}
				else
				{
					b[k++]=a[j++];
				}
			}
			while(i<s+len)					//δ�ϲ��Ĳ��ָ��Ƶ�����b�� 
			{
				b[k++]=a[i++];
			}
			while(j<=e)
			{
			   b[k++]=a[j++]; 				//δ�ϲ��Ĳ��ָ��Ƶ�����b�� 
			}

	        s=e+1; 						//��һ�����������εĿ�ʼ�±� 
	    }
	    if(s<n) 							//��ʣ���һ������δ�����A�и��Ƶ�����b��
		{
	        for(;s<n;s++)
			{
	            b[s]=a[s];
			}
		}
	}
	static void mergeSort(int a[],int n)				//�ϲ�����
	{
//	    int *p;
		int h,count,len,f;

		count=0;							//������
	    len=1;     						//�������еĳ��� 
	    f=0;								//����f����־
//	    if(!(p=(int *)malloc(sizeof(int)*n)))		//�����ڴ�ռ�
//	    {
//	        printf("�ڴ����ʧ��!\n");
//	        exit(0); 
//	    }
	    int[] p=new int[n];
	    while(len<n)
	    {
	        if(f==1)   						//������A��P֮��ϲ� 
			{
	            mergeOne(p,a,n,len);			//p�ϲ���a
			}
	        else
			{
	            mergeOne(a,p,n,len);			//a�ϲ���p
			}
	        len=len*2;						//�����������г���
	        f=1-f; 							//ʹfֵ��0��1֮���л� 

			count++;
			System.out.printf("��"+count+"��������:");	//���ÿ������Ľ��
			for(h=0;h<SIZE;h++)
			{
				System.out.printf(" "+a[h]);			//���
			}
			System.out.print("\n");

	    }
	    if(f==1)								//�������������
		{
	        for(h=0;h<n;h++)					//���ڴ�p�е����ݸ��ƻ�����a
			{
	            a[h]=p[h];
			}
		}
//	    free(p); 							//�ͷ��ڴ� 
	}
	public static void main(String[] args) 
	{
		int[] shuzu=new int[SIZE];
		int i;
		
		for(i=0;i<SIZE;i++)
		{
			shuzu[i]=(int)(100+Math.random()*(100+1));			//��ʼ������
		}
		
		System.out.print("����ǰ������Ϊ��\n");				//�������ǰ������
		for(i=0;i<SIZE;i++)
		{
			System.out.print(shuzu[i]+" ");
		}
		System.out.print("\n");
		
		mergeSort(shuzu,SIZE);					//�������
		
		System.out.print("����������Ϊ��\n");
		for(i=0;i<SIZE;i++)
		{
			System.out.print(shuzu[i]+" ");					//�������������
		}
		System.out.print("\n");

	}

}
