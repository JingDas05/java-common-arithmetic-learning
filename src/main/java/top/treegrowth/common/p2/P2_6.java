package top.treegrowth.common.p2;

import java.util.Scanner;

class GraphMatrix
{	static final int MaxNum=20;
	static final int MaxValue=65535;
    char[] Vertex=new char[MaxNum]; 			//���涥����Ϣ(��Ż���ĸ)
    int GType;						//ͼ������(0:����ͼ��1:����ͼ)    
    int VertexNum; 					//��������� 
    int EdgeNum;					//�ߵ����� 
    int[][] EdgeWeight=new int[MaxNum][MaxNum]; //����ߵ�Ȩ 
    int[] isTrav=new int[MaxNum]; 				//������־ 
}

public class P2_6 {
	static Scanner input=new Scanner(System.in);
	static void CreateGraph(GraphMatrix GM)		//�����ڽӾ���ͼ 
	{
	    int i,j,k;
		int weight;							//Ȩ
	    char EstartV,EendV; 					//�ߵ���ʼ���� 

	    System.out.printf("����ͼ�и�������Ϣ\n");
	    for(i=0;i<GM.VertexNum;i++) 			//���붥�� 
	    {	        
	        System.out.printf("��%d������:",i+1);
	        GM.Vertex[i]=(input.next().toCharArray())[0]; 		//���浽����������Ԫ���� 
	    }
	    System.out.printf("���빹�ɸ��ߵĶ��㼰Ȩֵ:\n"); 
	    for(k=0;k<GM.EdgeNum;k++)  		//����ߵ���Ϣ 
	    {
	        System.out.printf("��%d���ߣ�",k+1);
	        EstartV=input.next().charAt(0);
	        EendV=input.next().charAt(0);
	        weight=input.nextInt();
	        for(i=0;EstartV!=GM.Vertex[i];i++); 	//�����ж����в���ʼ�� 
	        for(j=0;EendV!=GM.Vertex[j];j++); 	//�����ж����в��ҽ��յ� 
	        GM.EdgeWeight[i][j]=weight; 		//��Ӧλ�ñ���Ȩֵ����ʾ��һ����
	        if(GM.GType==0)  				//��������ͼ
			{
	            GM.EdgeWeight[j][i]=weight;	//�ڶԽ�λ�ñ���Ȩֵ  
			}
	    }
	}
	
	static void ClearGraph(GraphMatrix GM)
	{
		int i,j;

		for(i=0;i<GM.VertexNum;i++)  		//��վ��� 
		{
	        for(j=0;j<GM.VertexNum;j++)
			{
	            GM.EdgeWeight[i][j]=GraphMatrix.MaxValue; //���þ����и�Ԫ�ص�ֵΪMaxValue
			}
		}
	}
	
	static void OutGraph(GraphMatrix GM)			//����ڽӾ��� 
	{
	    int i,j;
	    for(j=0;j<GM.VertexNum;j++)
		{
	        System.out.printf("\t%c",GM.Vertex[j]);          //�ڵ�1�����������Ϣ 
		}
	    System.out.printf("\n");
	    for(i=0;i<GM.VertexNum;i++) 
	    {
	        System.out.printf("%c",GM.Vertex[i]);
	        for(j=0;j<GM.VertexNum;j++)
	        {
	            if(GM.EdgeWeight[i][j]==GraphMatrix.MaxValue) //��ȨֵΪ���ֵ 
				{
	                System.out.printf("\tZ");          		//��Z��ʾ�����
				}
	            else
				{
	                System.out.printf("\t%d",GM.EdgeWeight[i][j]); //����ߵ�Ȩֵ
				}
	        }
	        System.out.printf("\n");
	    }             
	}
	
	static  void DeepTraOne(GraphMatrix GM,int n) 	//�ӵ�n����㿪ʼ����ȱ���ͼ 
	{
	    int i;
	    GM.isTrav[n]=1; 					//��Ǹö����Ѵ���� 
	    System.out.printf("->%c",GM.Vertex[n]);			//���������� 

	    //��Ӵ���ڵ�Ĳ��� 
	    for(i=0;i<GM.VertexNum;i++)
		{
	        if(GM.EdgeWeight[n][i]!=GraphMatrix.MaxValue && GM.isTrav[n]==0)
			{
	            DeepTraOne(GM,i); 			//�ݹ���б��� 
			}
		}
	}
	
	static void DeepTraGraph(GraphMatrix GM) 		//������ȱ��� 
	{
	    int i;

	    for(i=0;i<GM.VertexNum;i++) 			//��������������־ 
		{
	        GM.isTrav[i]=0;
		}
	    System.out.printf("������ȱ������:"); 
	    for(i=0;i<GM.VertexNum;i++)
		{
	        if(GM.isTrav[i]==0) 				//���õ�δ���� 
			{
	            DeepTraOne(GM,i); 			//���ú�������
			}
		}
	    System.out.printf("\n"); 
	}
	
	public static void main(String[] args) {
		GraphMatrix GM=new GraphMatrix(); 					//���屣���ڽӱ�ṹ��ͼ 

	    System.out.printf("��������ͼ������:");
	    GM.GType=input.nextInt();			//ͼ������
	    System.out.printf("����ͼ�Ķ�������:");
	    GM.VertexNum=input.nextInt();		//����ͼ������ 
	    System.out.printf("����ͼ�ı�����:");
	    GM.EdgeNum=input.nextInt();			//����ͼ���� 
		ClearGraph(GM);					//���ͼ
	    CreateGraph(GM); 					//�����ڽӱ�ṹ��ͼ
	    System.out.printf("��ͼ���ڽӾ�����������:\n");
	    OutGraph(GM);					//����ڽӾ���             
	    DeepTraGraph(GM); 				//���������������ͼ 

	}

}
