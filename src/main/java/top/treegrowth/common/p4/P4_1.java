package top.treegrowth.common.p4;


/**
 * ð�ݷ�����
 * ѭ���������ݣ�֮����ڵ�ǰ�������ݵ�����������������ð�ݣ�����ֵ����Сֵð�ݵ���ǰλ��
 */
public class P4_1 {
    static final int SIZE = 10;

    public static void bubbleSort(int[] a) {
        int temp;
        // i ��Ҫ����������������������ð�ݵĻ������i���ҿ�ʼ����֮��Ȼ
        // ֻ��Ҫ a.length -1�Ϳ���
        for (int i = 1; i < a.length; i++) {
            //���������������бȽϣ��ϴ��������ð�ݣ���֮Ҳ����
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    //��������������
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            //���ÿ������Ľ��
            System.out.print("��" + i + "��������:");
            for (int k = 0; k < a.length; k++) {
                // ���
                System.out.print(" " + a[k]);
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
        bubbleSort(shuzu);
        System.out.print("����������Ϊ��\n");
        for (i = 0; i < SIZE; i++) {
            //�������������
            System.out.print(shuzu[i] + " ");
        }
        System.out.print("\n");
    }
}
