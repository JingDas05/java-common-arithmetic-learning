package top.treegrowth.common.p10;

public class p10_1 {
	static void BQBJ(int m,int n)				//��Ǯ��ټ��㷨
	{
	    int x,y,z;
	    for(x=0;x<=n;x++)				//��������
	    {
	        for(y=0;y<=n;y++)			//ĸ������
	        {
	            z=n-x-y;				//С������
	            if (z>0 && z%3==0 && x*5+y*3+z/3==m)
				{
	                System.out.printf("������%dֻ,ĸ����%dֻ,С����%dֻ\n",x,y,z);
				}
				else					//�޷����!
				{
				}
	        }
	    }  
	}
	public static void main(String[] args) 
	{
		int m,n;

		m=100;						//��Ǯ
		n=100;						//�ټ�
		System.out.printf("%dǮ��%d������������Ϊ��\n",m,n);
		BQBJ(m,n);

	}

}
