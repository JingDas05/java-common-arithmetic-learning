package top.treegrowth.common.p8;

import java.util.Scanner;

class GraphMatrix2 
{	static final int  MaxNum=20; 
    char[] Vertex=new char[MaxNum]; 			//���涥����Ϣ(��Ż���ĸ)
    int GType;						//ͼ������(0:����ͼ��1:����ͼ)    
    int VertexNum; 					//��������� 
    int EdgeNum;					//�ߵ����� 
    int[][] EdgeWeight=new int[MaxNum][MaxNum]; //����ߵ�Ȩ 
    int[] isTrav=new int[MaxNum]; 				//������־ 
}

public class P8_5 {
	static final int  MaxValue=65535; 				//���ֵ(����Ϊһ���������)
	static int[] path=new int[GraphMatrix2.MaxNum];					//���㾭���Ķ��㼯�ϵ�����
	static int[] tmpvertex=new int[GraphMatrix2.MaxNum];				//���·������ʼ�㼯��
	static Scanner input=new Scanner(System.in);
	static void CreateGraph(GraphMatrix2 GM)		//�����ڽӾ���ͼ 
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
	
	static void ClearGraph(GraphMatrix2 GM)
	{
		int i,j;

		for(i=0;i<GM.VertexNum;i++)  		//��վ��� 
		{
	        for(j=0;j<GM.VertexNum;j++)
			{
	            GM.EdgeWeight[i][j]=MaxValue; //���þ����и�Ԫ�ص�ֵΪMaxValue
			}
		}
	}
	
	static void OutGraph(GraphMatrix2 GM)			//����ڽӾ��� 
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
	            if(GM.EdgeWeight[i][j]==MaxValue) //��ȨֵΪ���ֵ 
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
	
	static void DistMin(GraphMatrix2 GM,int vend)			//���·���㷨
	{
	    int[] weight=new int[GraphMatrix2.MaxNum];						//ĳ��ֹ�㵽����������·������
	    int i,j,k,min;

	    vend--; 

	    for(i=0;i<GM.VertexNum;i++) 			//��ʼweight���� 
	    {
	        weight[i]=GM.EdgeWeight[vend][i]; 	//������СȨֵ 
	    }
	    for(i=0;i<GM.VertexNum;i++) 			//��ʼpath���� 
	    {
	        if(weight[i]<MaxValue && weight[i]>0) //��ЧȨֵ 
			{
	            path[i]=vend; 				//�����
			}
	    }
	    for(i=0;i<GM.VertexNum;i++) 			//��ʼtmpvertex���� 
	    {
	        tmpvertex[i]=0; 					//��ʼ�����㼯��Ϊ�� 
	    }

	    tmpvertex[vend]=1; 					//ѡ�붥��vend
	    weight[vend]=0;  
	    for(i=0;i<GM.VertexNum;i++)
	    {
	        min=MaxValue; 
	        k=vend; 
	        for(j=0;j<GM.VertexNum;j++) 		//����δ�ö������СȨֵ 
			{
	            if(tmpvertex[j]==0 && weight[j]<min)
	            {
	                min=weight[j];
	                k=j;
	            }
			}
	        tmpvertex[k]=1;   				//������kѡ��
	        for(j=0;j<GM.VertexNum;j++) 		//�Զ���kΪ�м�㣬���¼���Ȩֵ 
			{
	            if(tmpvertex[j]==0 && weight[k]+GM.EdgeWeight[k][j]<weight[j])  
	            {
	                weight[j]=weight[k]+GM.EdgeWeight[k][j]; 
	                path[j]=k;
	            }
			}
	    }
	}
	
	public static void main(String[] args) {
		GraphMatrix2 GM=new GraphMatrix2(); //���屣���ڽӱ�ṹ��ͼ 
	    String go;
		int vend;
		int i,k;

		System.out.printf("������·�����⣡\n");
		
		do{
		System.out.printf("����������������ͼ������:");
			GM.GType=input.nextInt(); 			//ͼ������
			System.out.printf("����ͼ�Ķ�������:");
			GM.VertexNum=input.nextInt(); 			//����ͼ������ 
			System.out.printf("����ͼ�ı�����:");
			GM.EdgeNum=input.nextInt(); 			//����ͼ���� 
			ClearGraph(GM);					//���ͼ
			CreateGraph(GM); 				//�����ڽӱ�ṹ��ͼ

			System.out.printf("\n�����������:");
			vend=input.nextInt();
	        DistMin(GM,vend); 
			
			vend--;
			System.out.printf("\n�����㵽�ﶥ��%c�����·���ֱ�Ϊ(��ʼ�� - ������):\n",GM.Vertex[vend]);
			for(i=0;i<GM.VertexNum;i++)			//������
			{
				if(tmpvertex[i]==1)
				{
					k=i;            
					while(k!=vend)
					{
						System.out.printf("����%c - ",GM.Vertex[k]);
						k=path[k];
					}
					System.out.printf("����%c\n",GM.Vertex[k]);
				}
				else
				{
					System.out.printf("%c - %c:��·��\n",GM.Vertex[i],GM.Vertex[vend]);
				}
			}
			
		 System.out.print("\n��������(y/n)?");
		 go=input.next();
		}while(go.equalsIgnoreCase("y"));
	  
		System.out.printf("��Ϸ������\n");

	}

}
