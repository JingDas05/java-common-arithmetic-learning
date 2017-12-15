package top.treegrowth.common.p2;

import java.util.Scanner;


class DATA2 {
    //������ݵĹؼ���
    String key;
    String name;
    int age;
}

//��������ṹ
class CLType {
    // ����ڵ����������
    DATA2 nodeData = new DATA2();
    CLType nextNode;

    //β��׷�ӽ��
    CLType CLAddEnd(CLType head, DATA2 nodeData) {
        CLType node, htemp;
        // �½��ڵ㣬�����ж��Ƿ�����ɹ�
        if ((node = new CLType()) == null) {
            System.out.print("�����ڴ�ʧ�ܣ�\n");
            //�����ڴ�ʧ��
            return null;
        } else {
            // ���½��ڵ������ָ��Ҫ��ӵ�����
            node.nodeData = nodeData;
            //���ý��ָ�루��ڵ㣩Ϊ�գ���Ϊ��β
            node.nextNode = null;
            //ͷָ��
            if (head == null) {
                head = node;
                return head;
            }
            // �� head �ݴ浽 htemp
            htemp = head;
            //���������ĩβ
            while (htemp.nextNode != null) {
                htemp = htemp.nextNode;
            }
            // �������
            htemp.nextNode = node;
            return head;
        }
    }

    CLType CLAddFirst(CLType head, DATA2 nodeData) {
        CLType node;
        // ����Ҫ����Ľڵ�
        if ((node = new CLType()) == null) {
            System.out.print("�����ڴ�ʧ�ܣ�\n");
            //�����ڴ�ʧ��
            return null;
        } else {
            //��������
            node.nodeData = nodeData;
            //ָ��ͷָ����ָ���
            node.nextNode = head;
            //ͷָ��ָ���������
            head = node;
            return head;
        }
    }

    //���ҽ��
    CLType CLFindNode(CLType head, String key) {
        //��������ͷָ��
        CLType htemp;
        //�������Ч������в���
        htemp = head;
        while (htemp != null) {
            //�����ؼ����봫��ؼ�����ͬ
            if (htemp.nodeData.key.compareTo(key) == 0) {
                //���ظý��ָ��
                return htemp;
            }
            //������һ���
            htemp = htemp.nextNode;
        }
        //���ؿ�ָ��
        return null;
    }

    //�����㣬���뵽keyΪfindkey�ڵ�ĺ���
    CLType CLInsertNode(CLType head, String findkey, DATA2 nodeData) {
        // node ��Ҫ����Ľڵ�
        CLType node, nodetemp;
        //���䱣���������
        if ((node = new CLType()) == null) {
            System.out.print("�����ڴ�ʧ�ܣ�\n");
            //�����ڴ�ʧ��
            return null;
        }
        //�������е�����
        node.nodeData = nodeData;
        //����Ҫ����Ľ��
        nodetemp = CLFindNode(head, findkey);
        //���ҵ�Ҫ����Ľ��
        if (nodetemp != null) {
            //�²�����ָ��ؼ�������һ���
            node.nextNode = nodetemp.nextNode;
            //���ùؼ����ָ���²�����
            nodetemp.nextNode = node;
        } else {
            System.out.print("δ�ҵ���ȷ�Ĳ���λ�ã�\n");
            //�ͷ��ڴ�
//            free(node);
        }
        //����ͷָ��
        return head;
    }

    // ɾ���ڵ㣬��Ҫ����ͷ�ڵ��Լ�����key
    int CLDeleteNode(CLType head, String key) {
        //node����ɾ������ǰһ��㣬htempΪҪɾ���Ľڵ�
        CLType node, htemp;
        // ѭ�������õ�ָ��
        htemp = head;
        node = head;
        while (htemp != null) {
            //�ҵ��ؼ��֣�ִ��ɾ������
            if (htemp.nodeData.key.compareTo(key) == 0) {
                //ʹǰһ���ָ��ǰ������һ���
                node.nextNode = htemp.nextNode;
                //�ͷ��ڴ�
                //free(htemp);
                return 1;
            } else {
                //ָ��ǰ���,ɾ��ʱ��ǰ�ڵ�ֱ��ָ����һ�ڵ�
                node = htemp;
                //ָ����һ���
                htemp = htemp.nextNode;
            }
        }
        //δɾ��
        return 0;
    }

    //����������
    int CLLength(CLType head) {
        CLType htemp;
        int Len = 0;
        htemp = head;
        while (htemp != null) {
            //�ۼӽ������
            Len++;
            //������һ���
            htemp = htemp.nextNode;
        }
        //���ؽ������
        return Len;
    }

    //��������
    void CLAllNode(CLType head) {
        CLType htemp;
        // �ݴ�ڵ�����
        DATA2 nodeData;
        htemp = head;
        System.out.printf("��ǰ������%d����㡣���������������£�\n", CLLength(head));
        //ѭ����������ÿ�����
        while (htemp != null) {
            //��ȡ�������
            nodeData = htemp.nodeData;
            System.out.printf("���(%s,%s,%d)\n", nodeData.key, nodeData.name, nodeData.age);
            //������һ���
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

        System.out.print("������ԡ������������е����ݣ���ʽΪ���ؼ��� ���� ����\n");
        do {
            DATA2 nodeData = new DATA2();
            nodeData.key = input.next();
            if (nodeData.key.equals("0")) {
                break; //������0�����˳�
            } else {
                nodeData.name = input.next();
                nodeData.age = input.nextInt();
                //������β����ӽ��
                head = CL.CLAddEnd(head, nodeData);
            }
        } while (true);
        //��ʾ���н��
        CL.CLAllNode(head);

        System.out.printf("\n��ʾ�����㣬�������λ�õĹؼ��֣�");
        //�������λ�ùؼ���
        findkey = input.next();
        System.out.print("��������������(�ؼ��� ���� ����):");
        DATA2 nodeData = new DATA2();
        //�������������
        nodeData.key = input.next();
        nodeData.name = input.next();
        nodeData.age = input.nextInt();
        //���ò��뺯��
        head = CL.CLInsertNode(head, findkey, nodeData);
        //��ʾ���н��
        CL.CLAllNode(head);

        System.out.print("\n��ʾɾ����㣬����Ҫɾ���Ĺؼ���:");

        //����ɾ�����ؼ���
        key = input.next();
        //����ɾ����㺯��
        CL.CLDeleteNode(head, key);
        //��ʾ���н��
        CL.CLAllNode(head);

        System.out.printf("\n��ʾ�������в��ң�������ҹؼ���:");
        //������ҹؼ���
        key = input.next();
        //���ò��Һ��������ؽ��ָ��
        node = CL.CLFindNode(head, key);
        //�����ؽ��ָ����Ч
        if (node != null) {
            //��ȡ��������
            nodeData = node.nodeData;
            System.out.printf("�ؼ���%s��Ӧ�Ľ��Ϊ(%s,%s,%d)\n", key, nodeData.key, nodeData.name, nodeData.age);
        } else {
            //�����ָ����Ч
            System.out.printf("��������δ�ҵ��ؼ���Ϊ%s�Ľ�㣡\n", key);
        }

    }

}
