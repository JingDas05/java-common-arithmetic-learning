package top.treegrowth.common.p6;

public class P6_27 {
	static double func(double x) 			//���� 
	{
	    return  2*x*x*x-5*x-1;
	}
	static double erfen(double a,double b,double err)	//�����㷨
	{
	    double c;
	    c=(a+b)/2.0;				//�м�ֵ

	    while(Math.abs(func(c))>err && func(a-b)>err)
	    {
	        if(func(c)*func(b)<0) 		//ȷ���µ����� 
			{
	            a=c; 
			}
	        if(func(a)*func(c)<0)
			{
	            b=c; 
			}
	        c=(a+b)/2; 				//���ַ�ȷ���µ����� 
	    }

		return c;
	}
	public static void main(String[] args) {
		double a=1.0,b=2.0;			//��ʼ���� 
		double err=1e-5;			//�������
	    double result;

	    result=erfen(a,b,err);
	    System.out.print("���ַ��ⷽ��:2*x*x*x-5*x-1\n");
	    System.out.printf("���x=%.5f\n",result); //����� 

	}

}
