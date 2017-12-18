package top.treegrowth.common.p2;

import java.util.Scanner;

class GraphMatrix {
    static final int MaxNum = 20;
    static final int MaxValue = 65535;
    // ���涥����Ϣ(��Ż���ĸ)
    char[] Vertex = new char[MaxNum];
    //ͼ������(0:����ͼ��1:����ͼ)
    int GType;
    //���������
    int VertexNum;
    //�ߵ�����
    int EdgeNum;
    //����ߵ�Ȩ
    int[][] EdgeWeight = new int[MaxNum][MaxNum];
    //������־
    int[] isTrav = new int[MaxNum];
}

public class P2_6 {
    static Scanner input = new Scanner(System.in);

    //�����ڽӾ���ͼ
    static void CreateGraph(GraphMatrix GM) {
        // λ���ݴ�ֵ
        int i, j, k;
        //Ȩ
        int weight;
        //�ߵ���ʼ����
        char EstartV, EendV;
        System.out.printf("����ͼ�и�������Ϣ\n");
        //���붥��
        for (i = 0; i < GM.VertexNum; i++) {
            System.out.printf("��%d������:", i + 1);
            //���浽����������Ԫ����
            GM.Vertex[i] = (input.next().toCharArray())[0];
        }
        System.out.printf("���빹�ɸ��ߵĶ��㼰Ȩֵ:\n");
        //����ߵ���Ϣ
        for (k = 0; k < GM.EdgeNum; k++) {
            System.out.printf("��%d���ߣ�", k + 1);
            EstartV = input.next().charAt(0);
            EendV = input.next().charAt(0);
            weight = input.nextInt();
            //�����ж����в���ʼ��
            for (i = 0; EstartV != GM.Vertex[i]; i++) ;
            //�����ж����в��ҽ��յ�
            for (j = 0; EendV != GM.Vertex[j]; j++) ;
            //��Ӧλ�ñ���Ȩֵ����ʾ��һ����
            GM.EdgeWeight[i][j] = weight;
            //��������ͼ
            if (GM.GType == 0) {
                //�ڶԽ�λ�ñ���Ȩֵ
                GM.EdgeWeight[j][i] = weight;
            }
        }
    }

    static void ClearGraph(GraphMatrix GM) {
        int i, j;
        //��վ���
        for (i = 0; i < GM.VertexNum; i++) {
            for (j = 0; j < GM.VertexNum; j++) {
                //���þ����и�Ԫ�ص�ֵΪMaxValue
                GM.EdgeWeight[i][j] = GraphMatrix.MaxValue;
            }
        }
    }

    //����ڽӾ���
    static void OutGraph(GraphMatrix GM) {
        int i, j;
        for (j = 0; j < GM.VertexNum; j++) {
            //�ڵ�1�����������Ϣ
            System.out.printf("\t%c", GM.Vertex[j]);
        }
        System.out.printf("\n");
        for (i = 0; i < GM.VertexNum; i++) {
            System.out.printf("%c", GM.Vertex[i]);
            for (j = 0; j < GM.VertexNum; j++) {
                //��ȨֵΪ���ֵ
                if (GM.EdgeWeight[i][j] == GraphMatrix.MaxValue) {
                    //��Z��ʾ�����
                    System.out.printf("\tZ");
                } else {
                    //����ߵ�Ȩֵ
                    System.out.printf("\t%d", GM.EdgeWeight[i][j]);
                }
            }
            System.out.printf("\n");
        }
    }

    //�ӵ�n����㿪ʼ����ȱ���ͼ
    static void DeepTraOne(GraphMatrix GM, int n) {
        int i;
        //��Ǹö����Ѵ����
        GM.isTrav[n] = 1;
        //����������
        System.out.printf("->%c", GM.Vertex[n]);
        //��Ӵ���ڵ�Ĳ���
        for (i = 0; i < GM.VertexNum; i++) {
            if (GM.EdgeWeight[n][i] != GraphMatrix.MaxValue && GM.isTrav[n] == 0) {
                DeepTraOne(GM, i);            //�ݹ���б���
            }
        }
    }

    static void DeepTraGraph(GraphMatrix GM)        //������ȱ���
    {
        int i;

        for (i = 0; i < GM.VertexNum; i++)            //��������������־
        {
            GM.isTrav[i] = 0;
        }
        System.out.printf("������ȱ������:");
        for (i = 0; i < GM.VertexNum; i++) {
            if (GM.isTrav[i] == 0)                //���õ�δ����
            {
                DeepTraOne(GM, i);            //���ú�������
            }
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        GraphMatrix GM = new GraphMatrix();                    //���屣���ڽӱ�ṹ��ͼ

        System.out.printf("��������ͼ������:");
        GM.GType = input.nextInt();            //ͼ������
        System.out.printf("����ͼ�Ķ�������:");
        GM.VertexNum = input.nextInt();        //����ͼ������
        System.out.printf("����ͼ�ı�����:");
        GM.EdgeNum = input.nextInt();            //����ͼ����
        ClearGraph(GM);                    //���ͼ
        CreateGraph(GM);                    //�����ڽӱ�ṹ��ͼ
        System.out.printf("��ͼ���ڽӾ�����������:\n");
        OutGraph(GM);                    //����ڽӾ���
        DeepTraGraph(GM);                //���������������ͼ

    }

}
