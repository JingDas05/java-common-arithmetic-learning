package top.treegrowth.common.p13;

public class bridge {
    static int index;                            //������ʱ�����������±�
    static int size = 64;
    static int N = 5;
    static int mintime = 40;                    //��С����ʱ���ܺͣ���ʼֵ30
    static int[] transit = new int[size];        //�����±���ת������
    static int program[] = new int[size];         //���ʱ���ڹ��ŵķ���;
//    static int time[] = {1, 3, 6, 8, 12};         //ÿ���˹�������Ҫ��ʱ��;
    static int time[] = {2, 5, 6, 9, 13};         //ÿ���˹�������Ҫ��ʱ��;
    /*
     * ����Ա��ţ�С�� location[0]���ܵ�location[1]��
     * �ְ�location[2]������location[3]��үүlocation[4] ÿ���˵ĵ�ǰλ�ã�0--������ߣ� 1--�����ұ�
     */
    static int location[] = new int[N];
    
    /*
     * ����˵����notPass:δ��������;usedtime:��ǰ����ʱ��;Direction:���ŷ���,1--����,0--����
     */
    public static void Find(int notPass, int usedtime, int Direction) 
    {
        if (notPass == 0) 
        {                 //�������Ѿ����ţ���������ʱ�估����
            mintime = usedtime;
            for (int i = 0; i < size && transit[i] >= 0; i++) 
            {
                program[i] = transit[i];
            }
        }
        else if (Direction == 1) 
        {         //���ŷ������ң��������ѡ�����˹���
            for (int i = 0; i < N; i++) 
            {
                if (location[i] == 0 && (usedtime + time[i]) < mintime) 
                {
                    transit[index++] = i;
                    location[i] = 1;
                    for (int j = 0; j < N; j++) 
                    {
                        int TmpMax = (time[i] > time[j] ? time[i] : time[j]);
                        if (location[j] == 0 && (usedtime + TmpMax) < mintime) 
                        {
                            transit[index++] = j;
                            location[j] = 1;
                            Find((notPass - 2), (usedtime + TmpMax), 0);
                            location[j] = 0;
                            transit[--index] = -1;
                        }
                    }
                    location[i] = 0;
                    transit[--index] = -1;
                }
            }
        }
        else 
        { //���ŷ������󣬴����Ҳ�ѡ��һ���˻����͵�
            for (int j = 0; j < N; j++) 
            {
                if (location[j] == 1 && usedtime + time[j] < mintime) 
                {
                    transit[index++] = j;
                    location[j] = 0;
                    Find(notPass + 1, usedtime + time[j], 1);
                    location[j] = 1;
                    transit[--index] = -1;
                }
            }
        }
    }
    
    public static void main(String[] args) 
    {
    	String s1="",s2="",s3="";
        for (int i = 0; i < size; i++) 
        {
            program[i] = -1;
            transit[i] = -1;                //��ʼ��������Ϊ��ֵ���������Ա��ų�ͻ
        }
        Find(N, 0, 1); // ������ѷ���
        System.out.println("��̹���ʱ��Ϊ��" + mintime);        //�����̹���ʱ��
        System.out.println("��ѹ������Ϊ��");                // �����ѹ������
        for (int i = 0; i < size && program[i] >= 0; i += 3) 
        {
        	switch (program[i])
        	{
        		case 0:
        			s1="С��";
        			break;
        		case 1:
        			s1="�ܵ�";
        			break;
        		case 2:
        			s1="�ְ�";
        			break;
        		case 3:
        			s1="����";
        			break;
        		case 4:
        			s1="үү";
        			break;
        	}
          	switch (program[i+1])
        	{
        		case 0:
        			s2="С��";
        			break;
        		case 1:
        			s2="�ܵ�";
        			break;
        		case 2:
        			s2="�ְ�";
        			break;
        		case 3:
        			s2="����";
        			break;
        		case 4:
        			s2="үү";
        			break;
        	}
          	switch (program[i+2])
        	{
        		case 0:
        			s3="С��";
        			break;
        		case 1:
        			s3="�ܵ�";
        			break;
        		case 2:
        			s3="�ְ�";
        			break;
        		case 3:
        			s3="����";
        			break;
        		case 4:
        			s3="үү";
        			break;
        		case -1:
        			s3="û��";
        			break;
        	}
        	
            System.out.println(s1 + "��" + s2+"һ�����ţ�"+ s3+"�ٻ���");
        }
    }
    
}