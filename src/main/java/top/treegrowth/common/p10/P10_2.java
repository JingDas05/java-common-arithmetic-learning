package top.treegrowth.common.p10;

public class P10_2 {
	static void WJGJ(int[] len1,int[] len2,int[] len3,int[] len4,int[] len5,int[] len)	//��ҹ����㷨
	{
		for(len5[0]=4; ;len5[0]+=4)                     //len5Ϊ4�ı��� 
			
			for(len1[0]=5; ;len1[0]+=5)                 //len1Ϊ5�ı��� 
			{ 
				len4[0]=len5[0]+len1[0]/5; 
				len3[0]=len4[0]+len5[0]/4; 
				
				if(len3[0]%2!=0||len4[0]%3!=0)
					continue;                          //������ܱ�2�����������ܱ�3������������һ��ѭ�� 
				
				len2[0]=len3[0]+len4[0]/3; 
				if(len2[0]+len3[0]/2<len1[0])
					break;                             //�л�len5[0]ѭ��(��Ϊx̫����) 
				
				if(len2[0]+len3[0]/2==len1[0])
				{ 
					len[0]=2*(len1[0])+(len2[0]);     //���㾮�� 
					return;
				} 
			} 
	   								

	}
	public static void main(String[] args)
	{
		int[] len1={0};
		int[] len2={0};
		int[] len3={0};
		int[] len4={0};
		int[] len5={0};
		int[] len={0};
			
		WJGJ(len1,len2,len3,len4,len5,len);				//����㷨
		
	    System.out.printf("��ҹ����������������:\n");					//������
	    System.out.printf("�׼Ҿ�������Ϊ:%d\n",len1[0]);
	    System.out.printf("�ҼҾ�������Ϊ:%d\n",len2[0]);
	    System.out.printf("���Ҿ�������Ϊ:%d\n",len3[0]);
	    System.out.printf("���Ҿ�������Ϊ:%d\n",len4[0]);
	    System.out.printf("��Ҿ�������Ϊ:%d\n",len5[0]);
	    System.out.printf("����:%d\n",len[0]);

	}

}
