package top.treegrowth.common.p2;

import java.util.Scanner;

class GraphMatrix {
    static final int MaxNum = 20;
    static final int MaxValue = 65535;
    // 保存顶点信息(序号或字母)
    char[] Vertex = new char[MaxNum];
    //图的类型(0:无向图，1:有向图)
    int GType;
    //顶点的数量
    int VertexNum;
    //边的数量
    int EdgeNum;
    //保存边的权
    int[][] EdgeWeight = new int[MaxNum][MaxNum];
    //遍历标志
    int[] isTrav = new int[MaxNum];
}

public class P2_6 {
    static Scanner input = new Scanner(System.in);

    //创建邻接矩阵图
    static void CreateGraph(GraphMatrix GM) {
        // 位置暂存值
        int i, j, k;
        //权
        int weight;
        //边的起始顶点
        char EstartV, EendV;
        System.out.printf("输入图中各顶点信息\n");
        //输入顶点
        for (i = 0; i < GM.VertexNum; i++) {
            System.out.printf("第%d个顶点:", i + 1);
            //保存到各顶点数组元素中
            GM.Vertex[i] = (input.next().toCharArray())[0];
        }
        System.out.printf("输入构成各边的顶点及权值:\n");
        //输入边的信息
        for (k = 0; k < GM.EdgeNum; k++) {
            System.out.printf("第%d条边：", k + 1);
            EstartV = input.next().charAt(0);
            EendV = input.next().charAt(0);
            weight = input.nextInt();
            //在已有顶点中查找始点
            for (i = 0; EstartV != GM.Vertex[i]; i++) ;
            //在已有顶点中查找结终点
            for (j = 0; EendV != GM.Vertex[j]; j++) ;
            //对应位置保存权值，表示有一条边
            GM.EdgeWeight[i][j] = weight;
            //若是无向图
            if (GM.GType == 0) {
                //在对角位置保存权值
                GM.EdgeWeight[j][i] = weight;
            }
        }
    }

    static void ClearGraph(GraphMatrix GM) {
        int i, j;
        //清空矩阵
        for (i = 0; i < GM.VertexNum; i++) {
            for (j = 0; j < GM.VertexNum; j++) {
                //设置矩阵中各元素的值为MaxValue
                GM.EdgeWeight[i][j] = GraphMatrix.MaxValue;
            }
        }
    }

    //输出邻接矩阵
    static void OutGraph(GraphMatrix GM) {
        int i, j;
        for (j = 0; j < GM.VertexNum; j++) {
            //在第1行输出顶点信息
            System.out.printf("\t%c", GM.Vertex[j]);
        }
        System.out.printf("\n");
        for (i = 0; i < GM.VertexNum; i++) {
            System.out.printf("%c", GM.Vertex[i]);
            for (j = 0; j < GM.VertexNum; j++) {
                //若权值为最大值
                if (GM.EdgeWeight[i][j] == GraphMatrix.MaxValue) {
                    //以Z表示无穷大
                    System.out.printf("\tZ");
                } else {
                    //输出边的权值
                    System.out.printf("\t%d", GM.EdgeWeight[i][j]);
                }
            }
            System.out.printf("\n");
        }
    }

    //从第n个结点开始，深度遍历图
    static void DeepTraOne(GraphMatrix GM, int n) {
        int i;
        //标记该顶点已处理过
        GM.isTrav[n] = 1;
        //输出结点数据
        System.out.printf("->%c", GM.Vertex[n]);
        //添加处理节点的操作
        for (i = 0; i < GM.VertexNum; i++) {
            if (GM.EdgeWeight[n][i] != GraphMatrix.MaxValue && GM.isTrav[n] == 0) {
                DeepTraOne(GM, i);            //递归进行遍历
            }
        }
    }

    static void DeepTraGraph(GraphMatrix GM)        //深度优先遍历
    {
        int i;

        for (i = 0; i < GM.VertexNum; i++)            //清除各顶点遍历标志
        {
            GM.isTrav[i] = 0;
        }
        System.out.printf("深度优先遍历结点:");
        for (i = 0; i < GM.VertexNum; i++) {
            if (GM.isTrav[i] == 0)                //若该点未遍历
            {
                DeepTraOne(GM, i);            //调用函数遍历
            }
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        GraphMatrix GM = new GraphMatrix();                    //定义保存邻接表结构的图

        System.out.printf("输入生成图的类型:");
        GM.GType = input.nextInt();            //图的种类
        System.out.printf("输入图的顶点数量:");
        GM.VertexNum = input.nextInt();        //输入图顶点数
        System.out.printf("输入图的边数量:");
        GM.EdgeNum = input.nextInt();            //输入图边数
        ClearGraph(GM);                    //清空图
        CreateGraph(GM);                    //生成邻接表结构的图
        System.out.printf("该图的邻接矩阵数据如下:\n");
        OutGraph(GM);                    //输出邻接矩阵
        DeepTraGraph(GM);                //深度优先搜索遍历图

    }

}
