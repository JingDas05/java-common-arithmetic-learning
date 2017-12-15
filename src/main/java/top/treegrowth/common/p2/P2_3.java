package top.treegrowth.common.p2;

import java.util.Scanner;


class DATA3 {
    String name;
    int age;
}

class StackType {
    static final int MAXLEN = 50;
    //数据元素
    DATA3[] data = new DATA3[MAXLEN + 1];
    //栈顶
    int top;

    StackType STInit() {
        StackType p;
        //申请栈内存
        if ((p = new StackType()) != null) {
            //设置栈顶为0
            p.top = 0;
            //返回指向栈的指针
            return p;
        }
        return null;
    }

    //判断栈是否为空
    boolean STIsEmpty(StackType s) {
        boolean t;
        t = (s.top == 0);
        return t;
    }

    //判断栈是否已满
    boolean STIsFull(StackType s) {
        boolean t;
        t = (s.top == MAXLEN);
        return t;
    }

    //清空栈
    void STClear(StackType s) {
        s.top = 0;
    }

    //释放栈所占用空间
    void STFree(StackType s) {
        if (s != null) {
            s = null;
        }
    }

    //入栈操作
    int PushST(StackType s, DATA3 data) {
        // 判断是否已经溢出
        if ((s.top + 1) > MAXLEN) {
            System.out.print("栈溢出!\n");
            return 0;
        }
        // 将元素入栈，先自加再入栈
        s.data[++s.top] = data;
        return 1;
    }

    //出栈操作
    DATA3 PopST(StackType s) {
        if (s.top == 0) {
            System.out.print("栈为空!\n");
            System.exit(0);
        }
        // 先出栈，再自减
        return (s.data[s.top--]);
    }

    //读栈顶数据，指针不移动
    DATA3 PeekST(StackType s) {
        if (s.top == 0) {
            System.out.printf("栈为空!\n");
            System.exit(0);
        }
        return (s.data[s.top]);
    }
}

public class P2_3 {

    public static void main(String[] args) {
        StackType st = new StackType();
        DATA3 data1 = new DATA3();

        //初始化栈
        StackType stack = st.STInit();
        Scanner input = new Scanner(System.in);
        System.out.print("入栈操作：\n");
        System.out.println("输入姓名 年龄进行入栈操作:");
        do {
            DATA3 data = new DATA3();
            data.name = input.next();
            //若输入0，则退出
            if (data.name.equals("0")) {
                break;
            } else {
                data.age = input.nextInt();
                st.PushST(stack, data);
            }
        } while (true);

        String temp;
        System.out.println("出栈操作:按任意非0键进行出栈操作:");
        temp = input.next();
        while (!temp.equals("0")) {
            data1 = st.PopST(stack);
            System.out.printf("出栈的数据是(%s,%d)\n", data1.name, data1.age);
            temp = input.next();
        }
        System.out.println("测试结束！");
        //释放栈所占用的空间
        st.STFree(st);

    }

}
