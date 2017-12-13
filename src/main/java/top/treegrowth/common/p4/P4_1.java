package top.treegrowth.common.p4;

public class P4_1 {
	static final int SIZE=10;
	public static void bubbleSort(int[] a) {
		 int temp;
		 for (int i = 1; i < a.length; i++) {
              //���������������бȽϣ��ϴ��������ð��
        	  for (int j = 0; j < a.length - i; j++) {
        		  if (a[j] > a[j + 1]) {
                   //��������������
        			  temp=a[j];
        			  a[j]=a[j+1];
        			  a[j+1]=temp;
        		  }
        	  }
        	  System.out.print("��"+i+"��������:");			//���ÿ������Ľ��
        	  for(int k=0;k<a.length;k++)
        	  {
        		  System.out.print(" "+a[k]); // ���
        	  }
        	  System.out.print("\n"); 
		 }
	 } 

	public static void main(String[] args) {
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
		bubbleSort(shuzu);					//�������
		System.out.print("����������Ϊ��\n");
		for(i=0;i<SIZE;i++)
		{
			System.out.print(shuzu[i]+" ");					//�������������
		}
		System.out.print("\n");

	}

}
