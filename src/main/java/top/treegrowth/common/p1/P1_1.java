package top.treegrowth.common.p1;

import java.util.Random;
import java.util.Scanner;

public class P1_1 {
    static int N = 20;

    public static void main(String[] args) {
        int[] arr = new int[N];
        int x, n, i;
        int f = -1;

        Random r = new Random();                    //�������
        for (i = 0; i < N; i++) {
            arr[i] = r.nextInt(100);                    //��������
        }

        System.out.print("������ɵ���������:\n");
        for (i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");                    //�������
        }
        System.out.print("\n\n");

        System.out.print("����Ҫ���ҵ�����:");
        Scanner input = new Scanner(System.in);
        x = input.nextInt();                            //����Ҫ���ҵ���

        for (i = 0; i < N; i++)                            //˳�����
        {
            if (x == arr[i])                            //�ҵ�����
            {
                // ����ҵ��ˣ��ͽ�j��������ʵ�ʵ�λ��
                f = i;
                break;
            }
        }


        if (f < 0)                                    //������ҽ��
        {
            System.out.println("û�ҵ�����:" + x);
        } else {
            System.out.print("����:" + x + " λ������ĵ� " + (f + 1) + " ��Ԫ�ش�.\n");
        }

    }

}
