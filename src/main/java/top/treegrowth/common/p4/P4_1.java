package top.treegrowth.common.p4;


/**
 * 冒泡法排序
 * 循环遍历数据，之后对于当前索引数据的左面或者右面的数据冒泡，将大值或者小值冒泡到当前位置
 */
public class P4_1 {
    static final int SIZE = 10;

    public static void bubbleSort(int[] a) {
        int temp;
        // i 需要排序的数据索引，如果向右冒泡的话，这个i从右开始，反之亦然
        // 只需要 a.length -1就可以
        for (int i = 1; i < a.length; i++) {
            //将相邻两个数进行比较，较大的数往后冒泡，反之也可以
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    //交换相邻两个数
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            //输出每步排序的结果
            System.out.print("第" + i + "步排序结果:");
            for (int k = 0; k < a.length; k++) {
                // 输出
                System.out.print(" " + a[k]);
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
        bubbleSort(shuzu);
        System.out.print("排序后的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            //输出排序后的数组
            System.out.print(shuzu[i] + " ");
        }
        System.out.print("\n");
    }
}
