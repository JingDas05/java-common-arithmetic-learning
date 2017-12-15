package top.treegrowth.common.p2;

import java.util.Scanner;


class DATA4 {
    String name;
    int age;
}

class SQType {
    static final int QUEUELEN = 15;
    //��������
    DATA4[] data = new DATA4[QUEUELEN];
    //��ͷ
    int head;
    //��β
    int tail;

    SQType SQTypeInit() {
        SQType q;
        //�����ڴ�
        if ((q = new SQType()) != null) {
            //���ö�ͷ
            q.head = 0;
            //���ö�β
            q.tail = 0;
            return q;
        } else {
            //���ؿ�
            return null;
        }
    }

    //�жϿն���
    int SQTypeIsEmpty(SQType q) {
        int temp = 0;
        if (q.head == q.tail)
            temp = 1;
        return (temp);
    }

    // �ж�������
    int SQTypeIsFull(SQType q) {
        int temp = 0;
        if (q.tail == QUEUELEN)
            temp = 1;
        return (temp);
    }

    // ��ն���
    void SQTypeClear(SQType q) {
        //���ö�ͷ
        q.head = 0;
        //���ö�β
        q.tail = 0;
    }

    //�ͷŶ���
    void SQTypeFree(SQType q) {
        if (q != null) {
            q = null;
        }
    }

    //�����
    int InSQType(SQType q, DATA4 data) {
        if (q.tail == QUEUELEN) {
            System.out.print("��������!����ʧ��!\n");
            return (0);
        } else {
            //��Ԫ������У���β�����
            q.data[q.tail++] = data;
            return (1);
        }
    }

    //������
    DATA4 OutSQType(SQType q) {
        if (q.head == q.tail) {
            System.out.print("\n�����ѿ�!����ʧ��!\n");
            System.exit(0);
        } else {
            return q.data[q.head++];
        }
        return null;
    }

    //���������
    DATA4 PeekSQType(SQType q) {
        if (SQTypeIsEmpty(q) == 1) {
            System.out.print("\n�ն���!\n");
            return null;
        } else {
            return q.data[q.head];
        }
    }

    //������г���
    int SQTypeLen(SQType q) {
        int temp;
        temp = q.tail - q.head;
        return (temp);
    }

}

public class P2_4 {

    public static void main(String[] args) {
        SQType st = new SQType();
        DATA4 data1;
        Scanner input = new Scanner(System.in);
        //��ʼ������
        SQType stack = st.SQTypeInit();
        System.out.print("����в�����\n");
        System.out.println("�������� �����������в���:");
        do {
            DATA4 data = new DATA4();
            data.name = input.next();
            data.age = input.nextInt();
            if (data.name.equals("0")) {
                //������0�����˳�
                break;
            } else {
                st.InSQType(stack, data);
            }
        } while (true);
        String temp = "1";
        System.out.println("�����в���:�������0�����г�ջ����:");
        temp = input.next();
        while (!temp.equals("0")) {
            data1 = st.OutSQType(stack);
            System.out.printf("�����е�������(%s,%d)\n", data1.name, data1.age);
            temp = input.next();
        }
        System.out.println("���Խ�����");
        //�ͷŶ�����ռ�õĿռ�
        st.SQTypeFree(stack);

    }

}
