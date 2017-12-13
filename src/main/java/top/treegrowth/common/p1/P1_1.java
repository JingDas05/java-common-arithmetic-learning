package top.treegrowth.common.p1;

import java.util.Random;
import java.util.Scanner;

public class P1_1 {
    static int N = 20;

    public static void main(String[] args) {
        int[] arr = new int[N];
        int x, n, i;
        int f = -1;

        Random r = new Random();                    //随机种子
        for (i = 0; i < N; i++) {
            arr[i] = r.nextInt(100);                    //产生数组
        }

        System.out.print("随机生成的数据序列:\n");
        for (i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");                    //输出序列
        }
        System.out.print("\n\n");

        System.out.print("输入要查找的整数:");
        Scanner input = new Scanner(System.in);
        x = input.nextInt();                            //输入要查找的数

        for (i = 0; i < N; i++)                            //顺序查找
        {
            if (x == arr[i])                            //找到数据
            {
                // 如果找到了，就将j等于数据实际的位置
                f = i;
                break;
            }
        }


        if (f < 0)                                    //输出查找结果
        {
            System.out.println("没找到数据:" + x);
        } else {
            System.out.print("数据:" + x + " 位于数组的第 " + (f + 1) + " 个元素处.\n");
        }

    }

}
