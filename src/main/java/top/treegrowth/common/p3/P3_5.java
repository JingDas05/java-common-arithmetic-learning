package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_5 {
    //蒙特卡罗算法
    static double MontePI(int n) {
        double PI;
        double x, y;
        int i, sum;
        sum = 0;
        for (i = 1; i < n; i++) {
            //产生0~1之间的一个随机数
            x = Math.random();
            //产生0~1之间的一个随机数
            y = Math.random();
            //若在阴影区域
            if ((x * x + y * y) <= 1)
                //计数
                sum++;
        }
        //计算PI
        PI = 4.0 * sum / n;
        return PI;
    }

    public static void main(String[] args) {
        int n;
        double PI;
        System.out.println("蒙特卡罗概率算法计算π:");
        Scanner input = new Scanner(System.in);
        System.out.print("输入点的数量:");
        //输入撒点个数
        n = input.nextInt();
        //计算PI
        PI = MontePI(n);
        //输出结果
        System.out.println("PI=" + PI);
    }
}
