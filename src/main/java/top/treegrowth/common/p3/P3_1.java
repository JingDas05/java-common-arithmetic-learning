package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_1{
	static int chichen,habbit; //chichen�����ĸ�����habbit�����õĸ���
	public static  int qiongJu(int head , int foot) {//����㷨
		int re,i,j; 
		re=0;
	    for(i=0;i<=head;i++)						//ѭ��
	    {
	        j=head-i;
	        if(i*2+j*4==foot)						//�жϣ��ҵ���
	        {
	           re=1;  
			   chichen=i;
			   habbit=j;
	        } 
	    }
	    return re;
	}
	public static void main(String[] args) {       //������
		int re,head,foot;
		System.out.println("��ٷ���⼦��ͬ������:");
		System.out.print("������ͷ����");
		Scanner input=new Scanner(System.in);
		head=input.nextInt();                     //����ͷ��
		System.out.print("�����������");
		foot=input.nextInt();                     //�������
		re=qiongJu(head,foot);
		if(re==1){
			System.out.println("����"+chichen+"ֻ������"+habbit+"ֻ��");
		}
		else{
			System.out.println("�޷���⣡");
		}
	}
}
