package top.treegrowth.common.p2;

import java.util.Scanner;


class DATA2 {
    //结点数据的关键字
    String key;
    String name;
    int age;
}

//定义链表结构
class CLType {
    // 链表节点包换的数据
    DATA2 nodeData = new DATA2();
    CLType nextNode;

    //尾部追加结点
    CLType CLAddEnd(CLType head, DATA2 nodeData) {
        CLType node, htemp;
        // 新建节点，并且判断是否申请成功
        if ((node = new CLType()) == null) {
            System.out.print("申请内存失败！\n");
            //分配内存失败
            return null;
        } else {
            // 将新建节点的数据指向要添加的数据
            node.nodeData = nodeData;
            //设置结点指针（后节点）为空，即为表尾
            node.nextNode = null;
            //头指针
            if (head == null) {
                head = node;
                return head;
            }
            // 将 head 暂存到 htemp
            htemp = head;
            //查找链表的末尾
            while (htemp.nextNode != null) {
                htemp = htemp.nextNode;
            }
            // 添加数据
            htemp.nextNode = node;
            return head;
        }
    }

    CLType CLAddFirst(CLType head, DATA2 nodeData) {
        CLType node;
        // 构建要插入的节点
        if ((node = new CLType()) == null) {
            System.out.print("申请内存失败！\n");
            //分配内存失败
            return null;
        } else {
            //保存数据
            node.nodeData = nodeData;
            //指向头指针所指结点
            node.nextNode = head;
            //头指针指向新增结点
            head = node;
            return head;
        }
    }

    //查找结点
    CLType CLFindNode(CLType head, String key) {
        //保存链表头指针
        CLType htemp;
        //若结点有效，则进行查找
        htemp = head;
        while (htemp != null) {
            //若结点关键字与传入关键字相同
            if (htemp.nodeData.key.compareTo(key) == 0) {
                //返回该结点指针
                return htemp;
            }
            //处理下一结点
            htemp = htemp.nextNode;
        }
        //返回空指针
        return null;
    }

    //插入结点，插入到key为findkey节点的后面
    CLType CLInsertNode(CLType head, String findkey, DATA2 nodeData) {
        // node 是要插入的节点
        CLType node, nodetemp;
        //分配保存结点的内容
        if ((node = new CLType()) == null) {
            System.out.print("申请内存失败！\n");
            //分配内存失败
            return null;
        }
        //保存结点中的数据
        node.nodeData = nodeData;
        //查找要插入的结点
        nodetemp = CLFindNode(head, findkey);
        //若找到要插入的结点
        if (nodetemp != null) {
            //新插入结点指向关键结点的下一结点
            node.nextNode = nodetemp.nextNode;
            //设置关键结点指向新插入结点
            nodetemp.nextNode = node;
        } else {
            System.out.print("未找到正确的插入位置！\n");
            //释放内存
//            free(node);
        }
        //返回头指针
        return head;
    }

    // 删除节点，需要传入头节点以及数据key
    int CLDeleteNode(CLType head, String key) {
        //node保存删除结点的前一结点，htemp为要删除的节点
        CLType node, htemp;
        // 循环遍历用的指针
        htemp = head;
        node = head;
        while (htemp != null) {
            //找到关键字，执行删除操作
            if (htemp.nodeData.key.compareTo(key) == 0) {
                //使前一结点指向当前结点的下一结点
                node.nextNode = htemp.nextNode;
                //释放内存
                //free(htemp);
                return 1;
            } else {
                //指向当前结点,删除时当前节点直接指向下一节点
                node = htemp;
                //指向下一结点
                htemp = htemp.nextNode;
            }
        }
        //未删除
        return 0;
    }

    //计算链表长度
    int CLLength(CLType head) {
        CLType htemp;
        int Len = 0;
        htemp = head;
        while (htemp != null) {
            //累加结点数量
            Len++;
            //处理下一结点
            htemp = htemp.nextNode;
        }
        //返回结点数量
        return Len;
    }

    //遍历链表
    void CLAllNode(CLType head) {
        CLType htemp;
        // 暂存节点数据
        DATA2 nodeData;
        htemp = head;
        System.out.printf("当前链表共有%d个结点。链表所有数据如下：\n", CLLength(head));
        //循环处理链表每个结点
        while (htemp != null) {
            //获取结点数据
            nodeData = htemp.nodeData;
            System.out.printf("结点(%s,%s,%d)\n", nodeData.key, nodeData.name, nodeData.age);
            //处理下一结点
            htemp = htemp.nextNode;
        }
    }
}

public class P2_2 {

    public static void main(String[] args) {
        CLType node, head = null;
        CLType CL = new CLType();
        String key, findkey;
        Scanner input = new Scanner(System.in);

        System.out.print("链表测试。先输入链表中的数据，格式为：关键字 姓名 年龄\n");
        do {
            DATA2 nodeData = new DATA2();
            nodeData.key = input.next();
            if (nodeData.key.equals("0")) {
                break; //若输入0，则退出
            } else {
                nodeData.name = input.next();
                nodeData.age = input.nextInt();
                //在链表尾部添加结点
                head = CL.CLAddEnd(head, nodeData);
            }
        } while (true);
        //显示所有结点
        CL.CLAllNode(head);

        System.out.printf("\n演示插入结点，输入插入位置的关键字：");
        //输入插入位置关键字
        findkey = input.next();
        System.out.print("输入插入结点的数据(关键字 姓名 年龄):");
        DATA2 nodeData = new DATA2();
        //输入插入结点数据
        nodeData.key = input.next();
        nodeData.name = input.next();
        nodeData.age = input.nextInt();
        //调用插入函数
        head = CL.CLInsertNode(head, findkey, nodeData);
        //显示所有结点
        CL.CLAllNode(head);

        System.out.print("\n演示删除结点，输入要删除的关键字:");

        //输入删除结点关键字
        key = input.next();
        //调用删除结点函数
        CL.CLDeleteNode(head, key);
        //显示所有结点
        CL.CLAllNode(head);

        System.out.printf("\n演示在链表中查找，输入查找关键字:");
        //输入查找关键字
        key = input.next();
        //调用查找函数，返回结点指针
        node = CL.CLFindNode(head, key);
        //若返回结点指针有效
        if (node != null) {
            //获取结点的数据
            nodeData = node.nodeData;
            System.out.printf("关键字%s对应的结点为(%s,%s,%d)\n", key, nodeData.key, nodeData.name, nodeData.age);
        } else {
            //若结点指针无效
            System.out.printf("在链表中未找到关键字为%s的结点！\n", key);
        }

    }

}
