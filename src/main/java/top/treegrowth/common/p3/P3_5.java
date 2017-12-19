package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_5 {
    //���ؿ����㷨
    static double MontePI(int n) {
        double PI;
        double x, y;
        int i, sum;
        sum = 0;
        for (i = 1; i < n; i++) {
            //����0~1֮���һ�������
            x = Math.random();
            //����0~1֮���һ�������
            y = Math.random();
            //������Ӱ����
            if ((x * x + y * y) <= 1)
                //����
                sum++;
        }
        //����PI
        PI = 4.0 * sum / n;
        return PI;
    }

    public static void main(String[] args) {
        int n;
        double PI;
        System.out.println("���ؿ��޸����㷨�����:");
        Scanner input = new Scanner(System.in);
        System.out.print("����������:");
        //�����������
        n = input.nextInt();
        //����PI
        PI = MontePI(n);
        //������
        System.out.println("PI=" + PI);
    }
}
