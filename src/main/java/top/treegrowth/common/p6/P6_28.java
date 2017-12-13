package top.treegrowth.common.p6;

public class P6_28 {
	static double func(double x) 								//����ⷽ�� 
	{
	    return x*x*x*x-3*x*x*x+1.5*x*x-4.0;
	}
	static double dfunc(double x) 								//��������
	{
	    return 4*x*x*x-9*x*x+3*x;
	}
	static int NewtonMethod(double[] x,int maxcyc,double precision) 
	{
	    double x0,x1;
	    int i;

	    x0=x[0];
		i=0;
		while(i<maxcyc)
	    {
	        if(dfunc(x0)==0.0)							//��ͨ����ֵ����������ֵΪ0
	        {
	            System.out.print("���������е���Ϊ0!\n");
	            return 0;
	        }
	        x1=x0-func(x0)/dfunc(x0);						//ţ�ٵ������� 
	        if(Math.abs(x1-x0)<precision || Math.abs(func(x1))<precision) 	//�ﵽԤ��Ľ������� 
	        {
	            x[0]=x1; 									//���ؽ�� 
	            return 1;
	        }
	        else 										//δ�ﵽ�������� 
			{
	            x0=x1; 								//׼����һ�ε��� 
			}
			i++;										//���������ۼ�
	    }
	    System.out.print("������������Ԥ��ֵ!��û�дﵽ���ȣ�\n");
	    return 0;
	}
	public static void main(String[] args) {
		double precision;
	    int maxcyc,result;

		double[] x={2.0};										//��ʼֵ
		maxcyc=1000;									//��������
		precision=0.00001;								//����
		result=NewtonMethod(x,maxcyc,precision);
	    if(result==1) 									//�õ����
		{
	        System.out.printf("����x*x*x*x-3*x*x*x+1.5*x*x-4.0=0\n��2.0�����ĸ�Ϊ:%f\n",x[0]);
		}
	    else 											//δ�õ����
		{
	        System.out.print("����ʧ��!\n");
		}

	}

}
