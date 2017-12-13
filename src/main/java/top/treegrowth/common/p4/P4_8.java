package top.treegrowth.common.p4;

public class P4_8 {
	static final int SIZE=10;
	static void insertionSort(int[] a,int len)  				//��������
	{
	    int i,j,t,h;

	    for (i=1;i<len;i++)
	    {
			t=a[i];
			j=i-1;
			while(j>=0 && t>a[j])					//����
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=t;

			System.out.print("��"+i+"��������:");			//���ÿ������Ľ��
			for(h=0;h<len;h++)
			{
				System.out.print(" "+a[h]);				//���
			}
			System.out.print("\n");
		}
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
		
		insertionSort(shuzu,SIZE);					//�������
		
		System.out.print("����������Ϊ��\n");
		for(i=0;i<SIZE;i++)
		{
			System.out.print(shuzu[i]+" ");					//�������������
		}
		System.out.print("\n");

	}

}
