package top.treegrowth.common.p6;

public class P6_22 {
	static double jiShuPI() 			//�����㷨
	{
		double PI,temp;
	    int n,m;
		n=1;					//����
		m=3;					//��ĸ
		temp=2;				//����
		PI=2;				//��ʼ��PI

	    while(temp>1e-15)		//���д���ָ���ľ��� 
	    {
	        temp=temp*n/m;		//����һ�����ֵ 
	        PI+=temp;			//��ӵ�pi�� 
	        n++;				//��������1 
	        m+=2;				//��ĸ����2 
	    }
		return PI;				//����PI
	}
	public static void main(String[] args) {
		double PI;

	    PI=jiShuPI();			//����
	    System.out.println("PI="+PI); 		//������ 

	}

}
