package top.treegrowth.common.p2;

import java.util.Scanner;

class CBTType 				//���������������� 
{
    String data;				//Ԫ������
    CBTType left;				//���������ָ��
    CBTType right;			//���������ָ��
}


public class P2_5 {
	static final int MAXLEN=20;
	 static Scanner input=new Scanner(System.in);
	 CBTType InitTree()  						//��ʼ���������ĸ� 
	{
	CBTType node;
	
	    if((node=new CBTType())!=null) //�����ڴ�
	    {
	        System.out.printf("��������һ�����������:\n");
	        node.data=input.next();
	        node.left=null;
	        node.right=null;
//			if(node!=null) 					//�������������㲻Ϊ�� 
//			{
				return node;
//			}
//			else
//			{
//				return null;
//			}
	    }
	    return null;
	}

	void AddTreeNode(CBTType treeNode)			//��ӽ��
	{
		// pnode��Ҫ��ӵĽڵ�
	     CBTType pnode,parent;
	     // ���ڵ�����
	     String data;
	     int menusel;

	    if((pnode=new CBTType())!=null) //�����ڴ�
	    {
	        System.out.printf("����������������:\n");
	         
	       pnode.data=input.next();
	        pnode.left=null; 					//������������Ϊ�� 
	        pnode.right=null;

	        System.out.printf("����ý��ĸ��������:");
	        data=input.next();
	
	        parent=TreeFindNode(treeNode,data);	//����ָ�����ݵĽ�� 
	        if(parent==null)							//���δ�ҵ�
	        {
	            System.out.printf("δ�ҵ��ø����!\n");
	            pnode=null; 					//�ͷŴ����Ľ���ڴ� 
	            return;
	         }
	         System.out.printf("1.��Ӹý�㵽������\n2.��Ӹý�㵽������\n");
	         do
			 {
	            menusel=input.nextInt();					//����ѡ����
	        
	            if(menusel==1 || menusel==2)
				{
					if(parent==null)
					{
						System.out.printf("�����ڸ���㣬�������ø����!\n");
					} 
					else
					{
						switch(menusel)
						{
							case 1: 			//��ӵ����� 
								if(parent.left!=null) 	//��������Ϊ�� 
					            {
	                				System.out.printf("��������㲻Ϊ��!\n");
	            				}
								else
								{
	                				parent.left=pnode;
								}
	            				break;
							case 2:			//��ӵ��ҽ��
								if( parent.right!=null) //��������Ϊ�� 
								{
								    System.out.printf("��������㲻Ϊ��!\n"); 
								}
								else
								{
									parent.right=pnode;
								}
								break;
							default:
								System.out.printf("��Ч����!\n");
						}
					}
				}
	         }while(menusel!=1 && menusel!=2);
	    }
	}
	
	CBTType TreeFindNode(CBTType treeNode,String data) 	//���ҽ��
	{
	CBTType ptr;

	    if(treeNode==null)
		{
	        return null;
		}
	    else
	    {
	        if(treeNode.data.equals(data))
			{
	            return treeNode; 
			}
	        else
			{										// �ֱ������������ݹ���� 
	            if((ptr=TreeFindNode(treeNode.left,data))!=null)
				{
	                return ptr;
				}
	            else if((ptr=TreeFindNode(treeNode.right, data))!=null) 
				{
	                return ptr;
				}
	            else
				{
	                return null; 
				}
	        } 
	    } 
	}

	CBTType TreeLeftNode(CBTType treeNode) 	//��ȡ������
	{
	    if(treeNode!=null)
		{
	        return treeNode.left;					//����ֵ
		}
	    else
		{
	        return null;
		}
	}
	
	CBTType TreeRightNode(CBTType treeNode) 	//��ȡ������
	{
	    if(treeNode!=null)
		{
	        return treeNode.right;				//����ֵ
		}
	    else
		{
	        return null;
		}
	}

	int TreeIsEmpty(CBTType treeNode)			//�жϿ���
	{
	    if(treeNode!=null)
		{
	        return 0;
		}
	    else
		{
	        return 1;
		}
	}

	int TreeDepth(CBTType treeNode) 				//������������
	{
	int depleft,depright;

	    if(treeNode==null)
		{
	        return 0; //���ڿ��������Ϊ0
		}
	    else
	    {
	        depleft = TreeDepth(treeNode.left); 		//��������� (�ݹ����)
	        depright = TreeDepth(treeNode.right); 	//��������� (�ݹ����)
	        if(depleft>depright)
			{
	           return depleft + 1; 
			}
	        else
			{
	            return depright + 1; 
			}
	    } 
	}

	void ClearTree(CBTType treeNode) 		// ��ն�����
	{
	     if(treeNode!=null)
	     {
	         ClearTree(treeNode.left); 		//��������� 
	         ClearTree(treeNode.right);		//��������� 
	         treeNode=null;					//�ͷŵ�ǰ�����ռ�ڴ� 
//	         treeNode=null;
	     }
	}

	void TreeNodeData(CBTType p) 			//��ʾ�������
	{
	     System.out.printf("%s ",p.data); 				//����������
	}
	
	
	void LevelTree(CBTType treeNode) 	//������� 
	{
	     CBTType p;
	     CBTType[] q=new CBTType[MAXLEN]; 										//����һ��˳��ջ 
	     int head=0,tail=0;

	     if(treeNode!=null)												//�������ָ�벻Ϊ��     
	     {
	         tail=(tail+1)%MAXLEN;									//����ѭ�����ж�β��� 
	         q[tail] = treeNode;										//����������ָ�����
	     }
	     while(head!=tail) 											//���в�Ϊ�գ�����ѭ�� 
	     {
	         head=(head+1)%MAXLEN; 								//����ѭ�����еĶ������ 
	         p=q[head]; 											//��ȡ����Ԫ�� 
	         TreeNodeData(p);										//�������Ԫ�� 
	         if(p.left!=null) 										//���������������
	         {
	             tail=(tail+1)%MAXLEN;								//����ѭ�����еĶ�β��� 
	             q[tail]=p.left;										//��������ָ����� 
	         }
	                 
	         if(p.right!=null)										//��������������� 
	         {
	             tail=(tail+1)%MAXLEN;								//����ѭ�����еĶ�β��� 
	             q[tail]=p.right;										//��������ָ����� 
	         }
	     }
	}
	

	void DLRTree(CBTType treeNode)  //������� 
	{     
	     if(treeNode!=null)	
	     {
	         TreeNodeData(treeNode); 							//��ʾ�������� 
	         DLRTree(treeNode.left);
	         DLRTree(treeNode.right);
	     }
	}

	void LDRTree(CBTType treeNode)  //������� 
	{
	     if(treeNode!=null) 
	     {
	         LDRTree(treeNode.left); 					//�������������
	         TreeNodeData(treeNode);								//��ʾ������� 
	         LDRTree(treeNode.right); 				//�������������
	     }
	}
	
	void LRDTree(CBTType treeNode) //�������
	{
	     if(treeNode!=null)
	     {
	         LRDTree(treeNode.left); 					//������������� 
	         LRDTree(treeNode.right); 				//�������������
	         TreeNodeData(treeNode);								//��ʾ�������
	     }
	}
	
	public static void main(String[] args) {
		CBTType root=null; 		//rootΪָ�������������ָ�� 
	    int menusel;
	    P2_5 t=new P2_5();
		//���ø�Ԫ��
		root=t.InitTree();
		//��ӽ��
		do{
	        System.out.printf("��ѡ��˵���Ӷ������Ľ��\n");
	        System.out.printf("0.�˳�\t");			//��ʾ�˵�
	        System.out.printf("1.��Ӷ������Ľ��\n");
			menusel=input.nextInt();
	        switch(menusel)
			{
				case 1:			//��ӽ��
					t.AddTreeNode(root);
					break;
				case 0:
					break;
				default:
					;
			}
		}while(menusel!=0);

		//����
	    do{
	        System.out.printf("��ѡ��˵�����������,����0��ʾ�˳�:\n");
	        System.out.printf("1.�������DLR\t");	//��ʾ�˵�
	        System.out.printf("2.�������LDR\n");
	        System.out.printf("3.�������LRD\t");
	        System.out.printf("4.�������\n");
	        menusel=input.nextInt();
	        switch(menusel)
			{
	        case 0:
	             break;
	        case 1:				//�������
	             System.out.printf("\n�������DLR�Ľ����");
	             t.DLRTree(root);
	             System.out.printf("\n");
	             break;
	        case 2:				//������� 
	             System.out.printf("\n����LDR�����Ľ����");
	             t.LDRTree(root);
	             System.out.printf("\n");
	             break;
	        case 3:				//������� 
	             System.out.printf("\n�������LRD�Ľ����");
	             t.LRDTree(root);
	             System.out.printf("\n");
	             break;
	        case 4:				//�������
	             System.out.printf("\n��������Ľ����");
	             t.LevelTree(root);
	             System.out.printf("\n");
	             break;
			default:
				;
	        }
	    }while(menusel!=0);
		//���
		System.out.printf("\n���������Ϊ:%d\n",t.TreeDepth(root));

	    t.ClearTree(root);			//��ն����� 
	    root=null;


	}

}
