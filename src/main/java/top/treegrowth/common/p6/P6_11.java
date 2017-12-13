package top.treegrowth.common.p6;

public class P6_11 {
	static double rand01(double[] r)
	{
	    double base,u,v,p,temp1,temp2,temp3;
	    base=256.0;					//����
		u=17.0; 
		v=139.0;

		temp1=u*(r[0])+v;				//������ֵ
		temp2=(int)(temp1/base);			//������
		temp3=temp1-temp2*base;		//��������
		r[0]=temp3;						//����������ӣ�Ϊ��һ��ʹ��
		p=r[0]/base;						//�����

	    return p;
	}
	static double randZT(double u,double t, double[] r)	//��̬�ֲ��������
	{
		int i;
		double total=0.0;
		double result;
		for(i=0;i<12;i++)
		{
			total+=rand01(r);				//�ۼ�
		}
		result=u+t*(total-6.0);				//�����
		return result;
	}
	public static void main(String[] args) {
		int i;
	    double u,t;
	    double[] r={5.0};
		u=2.0;
		t=3.5;

	    System.out.print("����10����̬�ֲ����������\n");
	    for (i=0; i<10; i++)				//ѭ������
		{
	       System.out.printf("%10.5f\n",randZT(u,t,r));
		}
	    System.out.print("\n");

	}

}
