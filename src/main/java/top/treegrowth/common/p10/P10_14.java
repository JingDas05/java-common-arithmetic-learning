package top.treegrowth.common.p10;

public class P10_14
{
	static int jieti()							//�㷨
	{
		int i,res;
		int count;

		count=7;
	    for(i=1;i<=100;i++)				//ѭ��
	    {
	        if((count%2==1)&&(count%3==2)&&(count%5==4)&&(count%6==5) ) 	//�ж��Ƿ�����
	        {
	            res=count;
	            break;          			//�ҵ�������ѭ��
	        }
	        count=7*(i+1);				//��һ��
	    }
		return count;					//����
	}
	public static void main(String[] args) 
	{
		int num;

		System.out.printf("����˹̹����������⣡\n");
		num=jieti();					//���
		System.out.printf("��������ܹ���%d��̨�ף�\n",num);

	}

}
