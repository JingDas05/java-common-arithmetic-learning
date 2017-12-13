package top.treegrowth.common.p10;

public class P10_17 {
	static int wi,wj,wk;								//����ƥ��ֵ

	static int HW(char husband[], char wife[])				//�㷨
	{
		int i,j,k;
		int match=0;								//�Ƿ�ƥ��

	    for(i=0;i<3;i++)
		{
	        for(j=0;j<3;j++)
			{
	            for(k=0;k<3;k++)
				{
	                if(i!=j && j!=k && i!=k) 
	                {
						if(wife[i] == 'X' || wife[k] == 'X' || wife[k] == 'Z')
						{
							match=0;			//Υ������
						}
						else
						{
							match=1;			//���Ϲ���
							wi=i;
							wj=j;
							wk=k;
							return match;		//����
						}
	                }
				}
			}
		}
		return match;							//����
	}
	public static void main(String[] args) {
		char[] husband = {'A','B','C'}, wife = {'X','Y','Z'};
		int i,match;

		System.out.printf("��������������⣡\n");
		System.out.printf("�μӻ��������Ϊ:");				//��ʾ����
		for(i=0;i<3;i++)
		{
			System.out.printf(" %c",husband[i]);
		}
		System.out.printf("\n");
		System.out.printf("�μӻ��������Ϊ:");				//��ʾ����
		for(i=0;i<3;i++)
		{
			System.out.printf(" %c",wife[i]);
		}
		System.out.printf("\n");

		match=HW(husband,wife);				//���
		if(match==1)
		{
			System.out.printf("A����%c��飡\n",wife[wi]);
			System.out.printf("B����%c��飡\n",wife[wj]);
			System.out.printf("C����%c��飡\n",wife[wk]);
		}

	}

}
