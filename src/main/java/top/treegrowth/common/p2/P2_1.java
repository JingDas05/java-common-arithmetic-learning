package top.treegrowth.common.p2;

import java.util.Scanner;

// ����ÿ���ڵ�����ݽṹ
class DATA {
    //���Ĺؼ���
    String key;
    String name;
    int age;
}

//����˳���ṹ
class SLType {
    static final int MAXLEN = 100;
    //����˳���Ľṹ����
    DATA[] ListData = new DATA[MAXLEN + 1];
    //˳����Ѵ��������
    int ListLen;

    //��ʼ��˳���
    void SLInit(SLType SL) {
        //��ʼ��Ϊ�ձ�
        SL.ListLen = 0;
    }

    int SLLength(SLType SL) {
        //����˳����Ԫ������
        return (SL.ListLen);
    }

    // ��SL�еĵ�n��λ�ò���data
    int SLInsert(SLType SL, int n, DATA data) {
        int i;
        //˳����������ѳ����������
        if (SL.ListLen >= MAXLEN) {
            System.out.print("˳������������ܲ�����!\n");
            //����0��ʾ���벻�ɹ�
            return 0;
        }
        //��������Ų���ȷ
        if (n < 1 || n > SL.ListLen - 1) {
            System.out.print("����Ԫ����Ŵ��󣬲��ܲ���Ԫ�أ�\n");
            //����0����ʾ���벻�ɹ�
            return 0;
        }
        //��˳�����n�����������������ƶ�
        for (i = SL.ListLen; i >= n; i--) {
            SL.ListData[i + 1] = SL.ListData[i];
        }
        //������
        SL.ListData[n] = data;
        //˳�������������1
        SL.ListLen++;
        //�ɹ����룬����1
        return 1;
    }

    //����Ԫ�ص�˳���β��
    int SLAdd(SLType SL, DATA data) {
        //˳�������
        if (SL.ListLen >= MAXLEN) {
            System.out.print("˳�����������������ӽ���ˣ�\n");
            return 0;
        }
        SL.ListData[++SL.ListLen] = data;
        return 1;
    }

    //ɾ��˳����е�����Ԫ�أ���Ҫ����n����λ�ú����������ǰ��
    int SLDelete(SLType SL, int n) {
        int i;
        //ɾ�������Ų���ȷ
        if (n < 1 || n > SL.ListLen + 1) {
            System.out.print("ɾ�������Ŵ��󣬲���ɾ����㣡\n");
            //ɾ�����ɹ�������0
            return 0;
        }
        //��˳����е�������ǰ�ƶ�
        for (i = n; i < SL.ListLen; i++) {
            SL.ListData[i] = SL.ListData[i + 1];
        }
        //˳���Ԫ��������1
        SL.ListLen--;
        //�ɹ�ɾ��������1
        return 1;
    }

    //������ŷ�������Ԫ��
    DATA SLFindByNum(SLType SL, int n) {
        //Ԫ����Ų���ȷ
        if (n < 1 || n > SL.ListLen + 1) {
            System.out.print("�����Ŵ��󣬲��ܷ��ؽ�㣡\n");
            //���ɹ����򷵻�0
            return null;
        }
        return SL.ListData[n];
    }

    //���ؼ��ֲ�ѯ���
    int SLFindByCont(SLType SL, String key) {
        int i;
        // ѭ����������
        for (i = 1; i <= SL.ListLen; i++) {
            //����ҵ�������
            if (SL.ListData[i].key.compareTo(key) == 0) {
                //���ؽ�����
                return i;
            }
        }
        //�������������û���ҵ����򷵻�0
        return 0;
    }

    //��ʾ˳����е����н��
    int SLAll(SLType SL) {
        int i;
        for (i = 1; i <= SL.ListLen; i++) {
            System.out.printf("(%s,%s,%d)\n", SL.ListData[i].key, SL.ListData[i].name, SL.ListData[i].age);
        }
        return 0;
    }
}

public class P2_1 {
    public static void main(String[] args) {
        int i;
        //����˳������
        SLType SL = new SLType();
//	    DATA data=new DATA();       			//�����㱣���������ͱ���
        //�����㱣��ָ�����
        DATA pdata;
        //����ؼ���
        String key;

        System.out.print("˳��������ʾ!\n");
        //��ʼ��˳���
        SL.SLInit(SL);
        System.out.print("��ʼ��˳������!\n");
        Scanner input = new Scanner(System.in);
        do {
            //ѭ����ӽ������
            System.out.print("������ӵĽ��(ѧ�� ���� ����)��");
            DATA data = new DATA();
            data.key = input.next();
            data.name = input.next();
            data.age = input.nextInt();

            //�����䲻Ϊ0
            if (data.age != 0) {
                //����ӽ��ʧ��
                if (SL.SLAdd(SL, data) == 0) {
                    //�˳���ѭ��
                    break;
                }
            } else {
                //������Ϊ0���˳���ѭ��
                break;
            }
        } while (true);
        System.out.print("\n˳����еĽ��˳��Ϊ��\n");
        //��ʾ���н������
        SL.SLAll(SL);
        System.out.print("\nҪȡ��������ţ�");
        //�����ռ�����
        i = input.nextInt();
        //����Ų��ҽ��
        pdata = SL.SLFindByNum(SL, i);
        //�����صĽ��ָ�벻ΪNULL
        if (pdata != null) {
            System.out.printf("��%d�����Ϊ��(%s,%s,%d)\n", i, pdata.key, pdata.name, pdata.age);
        }
        System.out.print("\nҪ���ҽ��Ĺؼ��֣�");
        //����ؼ���
        key = input.next();
        //���ؼ��ֲ��� �����ؽ�����
        i = SL.SLFindByCont(SL, key);
        //����Ų�ѯ�����ؽ��ָ��
        pdata = SL.SLFindByNum(SL, i);
        //�����ָ�벻ΪNULL
        if (pdata != null) {
            System.out.printf("��%d�����Ϊ��(%s,%s,%d)\n", i, pdata.key, pdata.name, pdata.age);
        }
    }
}


