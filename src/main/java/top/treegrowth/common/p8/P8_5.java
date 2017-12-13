package top.treegrowth.common.p8;

import java.util.Scanner;

class GraphMatrix2 
{	static final int  MaxNum=20; 
    char[] Vertex=new char[MaxNum]; 			//保存顶点信息(序号或字母)
    int GType;						//图的类型(0:无向图，1:有向图)    
    int VertexNum; 					//顶点的数量 
    int EdgeNum;					//边的数量 
    int[][] EdgeWeight=new int[MaxNum][MaxNum]; //保存边的权 
    int[] isTrav=new int[MaxNum]; 				//遍历标志 
}

public class P8_5 {
	static final int  MaxValue=65535; 				//最大值(可设为一个最大整数)
	static int[] path=new int[GraphMatrix2.MaxNum];					//两点经过的顶点集合的数组
	static int[] tmpvertex=new int[GraphMatrix2.MaxNum];				//最短路径的起始点集合
	static Scanner input=new Scanner(System.in);
	static void CreateGraph(GraphMatrix2 GM)		//创建邻接矩阵图 
	{
	    int i,j,k;
		int weight;							//权
	    char EstartV,EendV; 					//边的起始顶点 

	    System.out.printf("输入图中各顶点信息\n");
	    for(i=0;i<GM.VertexNum;i++) 			//输入顶点 
	    {	        
	        System.out.printf("第%d个顶点:",i+1);
	        GM.Vertex[i]=(input.next().toCharArray())[0]; 		//保存到各顶点数组元素中 
	    }
	    System.out.printf("输入构成各边的顶点及权值:\n"); 
	    for(k=0;k<GM.EdgeNum;k++)  		//输入边的信息 
	    {
	        System.out.printf("第%d条边：",k+1);
	        EstartV=input.next().charAt(0);
	        EendV=input.next().charAt(0);
	        weight=input.nextInt();
	        for(i=0;EstartV!=GM.Vertex[i];i++); 	//在已有顶点中查找始点 
	        for(j=0;EendV!=GM.Vertex[j];j++); 	//在已有顶点中查找结终点 
	        GM.EdgeWeight[i][j]=weight; 		//对应位置保存权值，表示有一条边
	        if(GM.GType==0)  				//若是无向图
			{
	            GM.EdgeWeight[j][i]=weight;	//在对角位置保存权值  
			}
	    }
	}
	
	static void ClearGraph(GraphMatrix2 GM)
	{
		int i,j;

		for(i=0;i<GM.VertexNum;i++)  		//清空矩阵 
		{
	        for(j=0;j<GM.VertexNum;j++)
			{
	            GM.EdgeWeight[i][j]=MaxValue; //设置矩阵中各元素的值为MaxValue
			}
		}
	}
	
	static void OutGraph(GraphMatrix2 GM)			//输出邻接矩阵 
	{
	    int i,j;
	    for(j=0;j<GM.VertexNum;j++)
		{
	        System.out.printf("\t%c",GM.Vertex[j]);          //在第1行输出顶点信息 
		}
	    System.out.printf("\n");
	    for(i=0;i<GM.VertexNum;i++) 
	    {
	        System.out.printf("%c",GM.Vertex[i]);
	        for(j=0;j<GM.VertexNum;j++)
	        {
	            if(GM.EdgeWeight[i][j]==MaxValue) //若权值为最大值 
				{
	                System.out.printf("\tZ");          		//以Z表示无穷大
				}
	            else
				{
	                System.out.printf("\t%d",GM.EdgeWeight[i][j]); //输出边的权值
				}
	        }
	        System.out.printf("\n");
	    }             
	}
	
	static void DistMin(GraphMatrix2 GM,int vend)			//最短路径算法
	{
	    int[] weight=new int[GraphMatrix2.MaxNum];						//某终止点到各顶点的最短路径长度
	    int i,j,k,min;

	    vend--; 

	    for(i=0;i<GM.VertexNum;i++) 			//初始weight数组 
	    {
	        weight[i]=GM.EdgeWeight[vend][i]; 	//保存最小权值 
	    }
	    for(i=0;i<GM.VertexNum;i++) 			//初始path数组 
	    {
	        if(weight[i]<MaxValue && weight[i]>0) //有效权值 
			{
	            path[i]=vend; 				//保存边
			}
	    }
	    for(i=0;i<GM.VertexNum;i++) 			//初始tmpvertex数组 
	    {
	        tmpvertex[i]=0; 					//初始化顶点集合为空 
	    }

	    tmpvertex[vend]=1; 					//选入顶点vend
	    weight[vend]=0;  
	    for(i=0;i<GM.VertexNum;i++)
	    {
	        min=MaxValue; 
	        k=vend; 
	        for(j=0;j<GM.VertexNum;j++) 		//查找未用顶点的最小权值 
			{
	            if(tmpvertex[j]==0 && weight[j]<min)
	            {
	                min=weight[j];
	                k=j;
	            }
			}
	        tmpvertex[k]=1;   				//将顶点k选入
	        for(j=0;j<GM.VertexNum;j++) 		//以顶点k为中间点，重新计算权值 
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
		GraphMatrix2 GM=new GraphMatrix2(); //定义保存邻接表结构的图 
	    String go;
		int vend;
		int i,k;

		System.out.printf("求解最短路径问题！\n");
		
		do{
		System.out.printf("请先输入输入生成图的类型:");
			GM.GType=input.nextInt(); 			//图的种类
			System.out.printf("输入图的顶点数量:");
			GM.VertexNum=input.nextInt(); 			//输入图顶点数 
			System.out.printf("输入图的边数量:");
			GM.EdgeNum=input.nextInt(); 			//输入图边数 
			ClearGraph(GM);					//清空图
			CreateGraph(GM); 				//生成邻接表结构的图

			System.out.printf("\n请输入结束点:");
			vend=input.nextInt();
	        DistMin(GM,vend); 
			
			vend--;
			System.out.printf("\n各顶点到达顶点%c的最短路径分别为(起始点 - 结束点):\n",GM.Vertex[vend]);
			for(i=0;i<GM.VertexNum;i++)			//输出结果
			{
				if(tmpvertex[i]==1)
				{
					k=i;            
					while(k!=vend)
					{
						System.out.printf("顶点%c - ",GM.Vertex[k]);
						k=path[k];
					}
					System.out.printf("顶点%c\n",GM.Vertex[k]);
				}
				else
				{
					System.out.printf("%c - %c:无路径\n",GM.Vertex[i],GM.Vertex[vend]);
				}
			}
			
		 System.out.print("\n继续玩吗(y/n)?");
		 go=input.next();
		}while(go.equalsIgnoreCase("y"));
	  
		System.out.printf("游戏结束！\n");

	}

}
