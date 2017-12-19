package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_4 {
    static final int MAXNUM = 30;

    //算法
    static int FalseCoin(int coin[], int low, int high) {
        int i, sum1, sum2, sum3;
        int re = 0;
        sum1 = sum2 = sum3 = 0;
        // 如果两个硬币挨着的话
        if (low + 1 == high) {
            if (coin[low] < coin[high]) {
                re = low + 1;
                return re;
            } else {
                re = high + 1;
                return re;
            }
        }
        // 如果硬币区间的个数是偶数的话
        if ((high - low + 1) % 2 == 0)                //n是偶数
        {
            for (i = low; i <= low + (high - low) / 2; i++) {
                sum1 = sum1 + coin[i];        //前半段和
            }
            for (i = low + (high - low) / 2 + 1; i <= high; i++) {
                sum2 = sum2 + coin[i];        //后半段和
            }
            if (sum1 > sum2) {
                re = FalseCoin(coin, low + (high - low) / 2 + 1, high);
                return re;
            } else if (sum1 < sum2) {
                re = FalseCoin(coin, low, low + (high - low) / 2);
                return re;
            } else {
            }
        } else {
            for (i = low; i <= low + (high - low) / 2 - 1; i++) {
                sum1 = sum1 + coin[i];        //前半段和
            }
            for (i = low + (high - low) / 2 + 1; i <= high; i++) {
                sum2 = sum2 + coin[i];        //后半段和
            }
            sum3 = coin[low + (high - low) / 2];
            if (sum1 > sum2) {
                re = FalseCoin(coin, low + (high - low) / 2 + 1, high);
                return re;
            } else if (sum1 < sum2) {
                re = FalseCoin(coin, low, low + (high - low) / 2 - 1);
                return re;
            } else {
            }
            // 判断假币是否是那个奇数单着的那个
            if (sum1 + sum3 == sum2 + sum3) {
                re = low + (high - low) / 2 + 1;
                return re;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] coin = new int[MAXNUM];
        int i, n;
        int weizhi;
        System.out.println("分治算法求解假银币问题！");
        System.out.print("请输入银币总的个数：");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();                        //银币总的个数
        System.out.print("请输入银币的真假：");
        for (i = 0; i < n; i++) {
            coin[i] = input.nextInt();            //输入银币的真假
        }
        weizhi = FalseCoin(coin, 0, n - 1);            //求解
        System.out.println("在上述" + MAXNUM + "个银币中，第" + weizhi + "个银币是假的！");
    }
}
