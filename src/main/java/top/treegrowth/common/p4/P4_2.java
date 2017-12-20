package top.treegrowth.common.p4;

/**
 * ѡ������
 */
public class P4_2 {
    static final int SIZE = 10;

    public static void selectSort(int[] a) {
        int index, temp;
        // ѭ������ȫ������
        for (int i = 0; i < a.length - 1; i++) {
            // �洢��ǰ����
            index = i;
            // ������ǰ���������������ݣ��ҳ���Сֵ
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            //����������
            if (index != i) {
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
            //���ÿ������Ľ��
            System.out.print("��" + i + "��������:");
            for (int h = 0; h < a.length; h++) {
                //���
                System.out.print(" " + a[h]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[] shuzu = new int[SIZE];
        int i;
        for (i = 0; i < SIZE; i++) {
            //��ʼ������
            shuzu[i] = (int) (100 + Math.random() * (100 + 1));
        }
        //�������ǰ������
        System.out.print("����ǰ������Ϊ��\n");
        for (i = 0; i < SIZE; i++) {
            System.out.print(shuzu[i] + " ");
        }
        System.out.print("\n");
        //�������
        selectSort(shuzu);
        System.out.print("����������Ϊ��\n");
        for (i = 0; i < SIZE; i++) {
            //�������������
            System.out.print(shuzu[i] + " ");
        }
        System.out.print("\n");
    }
}
