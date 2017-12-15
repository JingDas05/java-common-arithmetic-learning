package top.treegrowth.common.p2;

import java.util.Scanner;


class DATA3 {
    String name;
    int age;
}

class StackType {
    static final int MAXLEN = 50;
    //����Ԫ��
    DATA3[] data = new DATA3[MAXLEN + 1];
    //ջ��
    int top;

    StackType STInit() {
        StackType p;
        //����ջ�ڴ�
        if ((p = new StackType()) != null) {
            //����ջ��Ϊ0
            p.top = 0;
            //����ָ��ջ��ָ��
            return p;
        }
        return null;
    }

    //�ж�ջ�Ƿ�Ϊ��
    boolean STIsEmpty(StackType s) {
        boolean t;
        t = (s.top == 0);
        return t;
    }

    //�ж�ջ�Ƿ�����
    boolean STIsFull(StackType s) {
        boolean t;
        t = (s.top == MAXLEN);
        return t;
    }

    //���ջ
    void STClear(StackType s) {
        s.top = 0;
    }

    //�ͷ�ջ��ռ�ÿռ�
    void STFree(StackType s) {
        if (s != null) {
            s = null;
        }
    }

    //��ջ����
    int PushST(StackType s, DATA3 data) {
        // �ж��Ƿ��Ѿ����
        if ((s.top + 1) > MAXLEN) {
            System.out.print("ջ���!\n");
            return 0;
        }
        // ��Ԫ����ջ�����Լ�����ջ
        s.data[++s.top] = data;
        return 1;
    }

    //��ջ����
    DATA3 PopST(StackType s) {
        if (s.top == 0) {
            System.out.print("ջΪ��!\n");
            System.exit(0);
        }
        // �ȳ�ջ�����Լ�
        return (s.data[s.top--]);
    }

    //��ջ�����ݣ�ָ�벻�ƶ�
    DATA3 PeekST(StackType s) {
        if (s.top == 0) {
            System.out.printf("ջΪ��!\n");
            System.exit(0);
        }
        return (s.data[s.top]);
    }
}

public class P2_3 {

    public static void main(String[] args) {
        StackType st = new StackType();
        DATA3 data1 = new DATA3();

        //��ʼ��ջ
        StackType stack = st.STInit();
        Scanner input = new Scanner(System.in);
        System.out.print("��ջ������\n");
        System.out.println("�������� ���������ջ����:");
        do {
            DATA3 data = new DATA3();
            data.name = input.next();
            //������0�����˳�
            if (data.name.equals("0")) {
                break;
            } else {
                data.age = input.nextInt();
                st.PushST(stack, data);
            }
        } while (true);

        String temp;
        System.out.println("��ջ����:�������0�����г�ջ����:");
        temp = input.next();
        while (!temp.equals("0")) {
            data1 = st.PopST(stack);
            System.out.printf("��ջ��������(%s,%d)\n", data1.name, data1.age);
            temp = input.next();
        }
        System.out.println("���Խ�����");
        //�ͷ�ջ��ռ�õĿռ�
        st.STFree(st);

    }

}
