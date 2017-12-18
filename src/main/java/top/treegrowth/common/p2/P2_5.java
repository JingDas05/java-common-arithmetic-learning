package top.treegrowth.common.p2;

import java.util.Scanner;

//定义二叉树结点类型
class CBTType {
    //元素数据
    String data;
    //左子树结点指针
    CBTType left;
    //右子树结点指针
    CBTType right;
}


public class P2_5 {
    static final int MAXLEN = 20;
    static Scanner input = new Scanner(System.in);

    //初始化二叉树的根
    CBTType InitTree() {
        CBTType node;
        //申请内存
        if ((node = new CBTType()) != null) {
            System.out.printf("请先输入一个根结点数据:\n");
            node.data = input.next();
            node.left = null;
            node.right = null;
            //如果二叉树根结点不为空
//            if (node != null) {
            return node;
//            } else {
//                return null;
//            }
        }
        return null;
    }

    //添加结点
    void AddTreeNode(CBTType treeNode) {
        // pnode是要添加的节点
        CBTType pnode, parent;
        // 父节点数据
        String data;
        int menusel;

        //分配内存
        if ((pnode = new CBTType()) != null) {
            System.out.printf("输入二叉树结点数据:\n");
            pnode.data = input.next();
            //设置左右子树为空
            pnode.left = null;
            pnode.right = null;

            System.out.printf("输入该结点的父结点数据:");
            data = input.next();

            // 根据父节点的数据，查找指定数据的结点
            parent = TreeFindNode(treeNode, data);
            // 如果未找到
            if (parent == null) {
                System.out.printf("未找到该父结点!\n");
                // 释放创建的结点内存
                pnode = null;
                return;
            }
            System.out.printf("1.添加该结点到左子树\n2.添加该结点到右子树\n");
            do {
                // 输入选择项
                menusel = input.nextInt();
                if (menusel == 1 || menusel == 2) {
                    if (parent == null) {
                        System.out.printf("不存在父结点，请先设置父结点!\n");
                    } else {
                        switch (menusel) {
                            //添加到左结点
                            case 1:
                                //左子树不为空，要求左子树为空才可以添加
                                if (parent.left != null) {
                                    System.out.printf("左子树结点不为空!\n");
                                } else {
                                    parent.left = pnode;
                                }
                                break;
                            //添加到右结点
                            case 2:
                                //右子树不为空
                                if (parent.right != null) {
                                    System.out.printf("右子树结点不为空!\n");
                                } else {
                                    parent.right = pnode;
                                }
                                break;
                            default:
                                System.out.printf("无效参数!\n");
                        }
                    }
                }
            } while (menusel != 1 && menusel != 2);
        }
    }

    //递归查找结点
    CBTType TreeFindNode(CBTType treeNode, String data) {
        CBTType ptr;
        if (treeNode == null) {
            return null;
        } else {
            if (treeNode.data.equals(data)) {
                return treeNode;
            } else {
                // 分别向左右子树递归查找
                if ((ptr = TreeFindNode(treeNode.left, data)) != null) {
                    return ptr;
                } else if ((ptr = TreeFindNode(treeNode.right, data)) != null) {
                    return ptr;
                } else {
                    return null;
                }
            }
        }
    }

    //获取左子树
    CBTType TreeLeftNode(CBTType treeNode) {
        if (treeNode != null) {
            //返回值
            return treeNode.left;
        } else {
            return null;
        }
    }

    //获取右子树
    CBTType TreeRightNode(CBTType treeNode) {
        if (treeNode != null) {
            //返回值
            return treeNode.right;
        } else {
            return null;
        }
    }

    //判断空树，不等于空返回0，等于空返回1
    int TreeIsEmpty(CBTType treeNode) {
        if (treeNode != null) {
            return 0;
        } else {
            return 1;
        }
    }

    //计算二叉树深度(暂且没看懂)
    int TreeDepth(CBTType treeNode) {
        int depleft, depright;

        if (treeNode == null) {
            //对于空树，深度为0
            return 0;
        } else {
            //左子树深度 (递归调用)
            depleft = TreeDepth(treeNode.left);
            //右子树深度 (递归调用)
            depright = TreeDepth(treeNode.right);
            // 递归左树或者右树的深度，取大值，加1返回
            if (depleft > depright) {
                return depleft + 1;
            } else {
                return depright + 1;
            }
        }
    }

    // 递归清空二叉树
    void ClearTree(CBTType treeNode) {
        if (treeNode != null) {
            //清空左子树
            ClearTree(treeNode.left);
            //清空右子树
            ClearTree(treeNode.right);
            treeNode = null;
//	         treeNode=null;
        }
    }

    // 显示结点数据
    void TreeNodeData(CBTType p) {
        //输出结点数据
        System.out.printf("%s ", p.data);
    }


    // 按层遍历
    void LevelTree(CBTType treeNode) {
        CBTType p;
        //定义一个顺序栈
        CBTType[] q = new CBTType[MAXLEN];
        int head = 0, tail = 0;

        //如果队首指针不为空
        if (treeNode != null) {
            //计算循环队列队尾序号
            tail = (tail + 1) % MAXLEN;
            //将二叉树根指针进队
            q[tail] = treeNode;
        }
        //队列不为空，循环遍历
        while (head != tail) {
            //计算循环队列的队首序号
            head = (head + 1) % MAXLEN;
            //获取队首元素
            p = q[head];
            //处理队首元素
            TreeNodeData(p);
            //如果结点存在左子树
            if (p.left != null) {
                //计算循环队列的队尾序号
                tail = (tail + 1) % MAXLEN;
                //将左子树指针进队
                q[tail] = p.left;
            }

            //如果结点存在右子树
            if (p.right != null) {
                //计算循环队列的队尾序号
                tail = (tail + 1) % MAXLEN;
                //将右子树指针进队
                q[tail] = p.right;
            }
        }
    }


    // 先序遍历
    // 考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根左右)
    void DLRTree(CBTType treeNode) {
        if (treeNode != null) {
            //显示结点的数据
            TreeNodeData(treeNode);
            DLRTree(treeNode.left);
            DLRTree(treeNode.right);
        }
    }

    // 中序遍历
    // 考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左根右)
    void LDRTree(CBTType treeNode) {
        if (treeNode != null) {
            //中序遍历左子树
            LDRTree(treeNode.left);
            //显示结点数据
            TreeNodeData(treeNode);
            //中序遍历右子树
            LDRTree(treeNode.right);
        }
    }

    // 后序遍历
    // 考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左右根)
    void LRDTree(CBTType treeNode) {
        if (treeNode != null) {
            //后序遍历左子树
            LRDTree(treeNode.left);
            //后序遍历右子树
            LRDTree(treeNode.right);
            //显示结点数据
            TreeNodeData(treeNode);
        }
    }

    public static void main(String[] args) {
        //root为指向二叉树根结点的指针
        CBTType root = null;
        int menusel;
        P2_5 t = new P2_5();
        //设置根元素
        root = t.InitTree();
        //添加结点
        do {
            System.out.printf("请选择菜单添加二叉树的结点\n");
            //显示菜单
            System.out.printf("0.退出\t");
            System.out.printf("1.添加二叉树的结点\n");
            menusel = input.nextInt();
            switch (menusel) {
                //添加结点
                case 1:
                    t.AddTreeNode(root);
                    break;
                case 0:
                    break;
                default:
                    ;
            }
        } while (menusel != 0);

        //遍历
        do {
            System.out.printf("请选择菜单遍历二叉树,输入0表示退出:\n");
            //显示菜单
            System.out.printf("1.先序遍历DLR\t");
            System.out.printf("2.中序遍历LDR\n");
            System.out.printf("3.后序遍历LRD\t");
            System.out.printf("4.按层遍历\n");
            menusel = input.nextInt();
            switch (menusel) {
                case 0:
                    break;
                case 1:
                    //先序遍历
                    System.out.printf("\n先序遍历DLR的结果：");
                    t.DLRTree(root);
                    System.out.printf("\n");
                    break;
                case 2:
                    //中序遍历
                    System.out.printf("\n中序LDR遍历的结果：");
                    t.LDRTree(root);
                    System.out.printf("\n");
                    break;
                case 3:
                    //后序遍历
                    System.out.printf("\n后序遍历LRD的结果：");
                    t.LRDTree(root);
                    System.out.printf("\n");
                    break;
                case 4:
                    //按层遍历
                    System.out.printf("\n按层遍历的结果：");
                    t.LevelTree(root);
                    System.out.printf("\n");
                    break;
                default:
                    ;
            }
        } while (menusel != 0);
        //深度
        System.out.printf("\n二叉树深度为:%d\n", t.TreeDepth(root));

        //清空二叉树
        t.ClearTree(root);
        root = null;
    }
}
