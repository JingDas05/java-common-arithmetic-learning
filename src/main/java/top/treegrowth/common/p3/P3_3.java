package top.treegrowth.common.p3;

import java.util.Scanner;

//求阶乘函数
public class P3_3 {
    static long fact(int n) {
        if (n <= 1)
            return 1;
        else
            //递归
            return n * fact(n - 1);
    }

    public static void main(String[] args) {
        int i;
        //声明变量
        System.out.print("请输入要求阶乘的一个整数：");
        Scanner input = new Scanner(System.in);
        i = input.nextInt();                              //输入数据
        System.out.print(i + "的阶乘结果为：" + fact(i));    //调用函数
    }
}
