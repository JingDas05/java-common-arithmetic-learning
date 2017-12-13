package top.treegrowth.common.p2;

import java.util.Scanner;

// 定义每个节点的数据结构
class DATA {
    //结点的关键字
    String key;
    String name;
    int age;
}

//定义顺序表结构
class SLType {
    static final int MAXLEN = 100;
    //保存顺序表的结构数组
    DATA[] ListData = new DATA[MAXLEN + 1];
    //顺序表已存结点的数量
    int ListLen;

    //初始化顺序表
    void SLInit(SLType SL) {
        //初始化为空表
        SL.ListLen = 0;
    }

    int SLLength(SLType SL) {
        //返回顺序表的元素数量
        return (SL.ListLen);
    }

    // 在SL中的第n个位置插入data
    int SLInsert(SLType SL, int n, DATA data) {
        int i;
        //顺序表结点数量已超过最大数量
        if (SL.ListLen >= MAXLEN) {
            System.out.print("顺序表已满，不能插入结点!\n");
            //返回0表示插入不成功
            return 0;
        }
        //插入结点序号不正确
        if (n < 1 || n > SL.ListLen - 1) {
            System.out.print("插入元素序号错误，不能插入元素！\n");
            //返回0，表示插入不成功
            return 0;
        }
        //将顺序表中n后面的数据依次向后移动
        for (i = SL.ListLen; i >= n; i--) {
            SL.ListData[i + 1] = SL.ListData[i];
        }
        //插入结点
        SL.ListData[n] = data;
        //顺序表结点数量增加1
        SL.ListLen++;
        //成功插入，返回1
        return 1;
    }

    //增加元素到顺序表尾部
    int SLAdd(SLType SL, DATA data) {
        //顺序表已满
        if (SL.ListLen >= MAXLEN) {
            System.out.print("顺序表已满，不能再添加结点了！\n");
            return 0;
        }
        SL.ListData[++SL.ListLen] = data;
        return 1;
    }

    //删除顺序表中的数据元素，需要将第n处的位置后的数据依次前移
    int SLDelete(SLType SL, int n) {
        int i;
        //删除结点序号不正确
        if (n < 1 || n > SL.ListLen + 1) {
            System.out.print("删除结点序号错误，不能删除结点！\n");
            //删除不成功，返回0
            return 0;
        }
        //将顺序表中的数据向前移动
        for (i = n; i < SL.ListLen; i++) {
            SL.ListData[i] = SL.ListData[i + 1];
        }
        //顺序表元素数量减1
        SL.ListLen--;
        //成功删除，返回1
        return 1;
    }

    //根据序号返回数据元素
    DATA SLFindByNum(SLType SL, int n) {
        //元素序号不正确
        if (n < 1 || n > SL.ListLen + 1) {
            System.out.print("结点序号错误，不能返回结点！\n");
            //不成功，则返回0
            return null;
        }
        return SL.ListData[n];
    }

    //按关键字查询结点
    int SLFindByCont(SLType SL, String key) {
        int i;
        // 循环遍历数组
        for (i = 1; i <= SL.ListLen; i++) {
            //如果找到所需结点
            if (SL.ListData[i].key.compareTo(key) == 0) {
                //返回结点序号
                return i;
            }
        }
        //搜索整个表后仍没有找到，则返回0
        return 0;
    }

    //显示顺序表中的所有结点
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
        //定义顺序表变量
        SLType SL = new SLType();
//	    DATA data=new DATA();       			//定义结点保存数据类型变量
        //定义结点保存指针变量
        DATA pdata;
        //保存关键字
        String key;

        System.out.print("顺序表操作演示!\n");
        //初始化顺序表
        SL.SLInit(SL);
        System.out.print("初始化顺序表完成!\n");
        Scanner input = new Scanner(System.in);
        do {
            //循环添加结点数据
            System.out.print("输入添加的结点(学号 姓名 年龄)：");
            DATA data = new DATA();
            data.key = input.next();
            data.name = input.next();
            data.age = input.nextInt();

            //若年龄不为0
            if (data.age != 0) {
                //若添加结点失败
                if (SL.SLAdd(SL, data) == 0) {
                    //退出死循环
                    break;
                }
            } else {
                //若年龄为0，退出死循环
                break;
            }
        } while (true);
        System.out.print("\n顺序表中的结点顺序为：\n");
        //显示所有结点数据
        SL.SLAll(SL);
        System.out.print("\n要取出结点的序号：");
        //输入结占点序号
        i = input.nextInt();
        //按序号查找结点
        pdata = SL.SLFindByNum(SL, i);
        //若返回的结点指针不为NULL
        if (pdata != null) {
            System.out.printf("第%d个结点为：(%s,%s,%d)\n", i, pdata.key, pdata.name, pdata.age);
        }
        System.out.print("\n要查找结点的关键字：");
        //输入关键字
        key = input.next();
        //按关键字查找 ，返回结点序号
        i = SL.SLFindByCont(SL, key);
        //按序号查询，返回结点指针
        pdata = SL.SLFindByNum(SL, i);
        //若结点指针不为NULL
        if (pdata != null) {
            System.out.printf("第%d个结点为：(%s,%s,%d)\n", i, pdata.key, pdata.name, pdata.age);
        }
    }
}


