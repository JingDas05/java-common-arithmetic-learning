package top.treegrowth.common.p4;

public class P4_3 {
    static final int SIZE = 10;

    //插入排序
    static void insertionSort(int[] a) {
        int i, j, t, h;
        for (i = 1; i < a.length; i++) {
            // 将需要插入的元素赋值给t
            t = a[i];
            // 遍历要插入元素左侧所有元素
            j = i - 1;
            // 遍历要插入元素左侧所有值，寻找小于要插入元素的值
            while (j >= 0 && t < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = t;
            //输出每步排序的结果
            System.out.print("第" + i + "步排序结果:");
            for (h = 0; h < a.length; h++) {
                //输出
                System.out.print(" " + a[h]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[] shuzu = new int[SIZE];
        int i;

        for (i = 0; i < SIZE; i++) {
            //初始化数组
            shuzu[i] = (int) (100 + Math.random() * (100 + 1));
        }
        //输出排序前的数组
        System.out.print("排序前的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            System.out.print(shuzu[i] + " ");
        }
        System.out.print("\n");
        //排序操作
        insertionSort(shuzu);
        System.out.print("排序后的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            //输出排序后的数组
            System.out.print(shuzu[i] + " ");
        }
        System.out.print("\n");
    }
}
