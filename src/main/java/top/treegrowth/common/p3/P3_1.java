package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_1 {
    //chichen�����ĸ�����habbit�����õĸ���
    static int chichen, habbit;

    //����㷨
    public static int qiongJu(int head, int foot) {
        int re, i, j;
        re = 0;
        //ѭ��
        for (i = 0; i <= head; i++) {
            j = head - i;
            //�жϣ��ҵ���
            if (i * 2 + j * 4 == foot) {
                re = 1;
                chichen = i;
                habbit = j;
            }
        }
        return re;
    }

    //������
    public static void main(String[] args) {
        int re, head, foot;
        System.out.println("��ٷ���⼦��ͬ������:");
        System.out.print("������ͷ����");
        Scanner input = new Scanner(System.in);
        //����ͷ��
        head = input.nextInt();
        System.out.print("�����������");
        //�������
        foot = input.nextInt();
        re = qiongJu(head, foot);
        if (re == 1) {
            System.out.println("����" + chichen + "ֻ������" + habbit + "ֻ��");
        } else {
            System.out.println("�޷���⣡");
        }
    }
}
