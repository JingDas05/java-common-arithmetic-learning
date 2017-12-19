package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_1 {
    //chichen代表鸡的个数，habbit代表兔的个数
    static int chichen, habbit;

    //穷举算法
    public static int qiongJu(int head, int foot) {
        int re, i, j;
        re = 0;
        //循环
        for (i = 0; i <= head; i++) {
            j = head - i;
            //判断，找到答案
            if (i * 2 + j * 4 == foot) {
                re = 1;
                chichen = i;
                habbit = j;
            }
        }
        return re;
    }

    //主方法
    public static void main(String[] args) {
        int re, head, foot;
        System.out.println("穷举法求解鸡兔同笼问题:");
        System.out.print("请输入头数：");
        Scanner input = new Scanner(System.in);
        //输入头数
        head = input.nextInt();
        System.out.print("请输入脚数：");
        //输入脚数
        foot = input.nextInt();
        re = qiongJu(head, foot);
        if (re == 1) {
            System.out.println("鸡有" + chichen + "只，兔有" + habbit + "只。");
        } else {
            System.out.println("无法求解！");
        }
    }
}
