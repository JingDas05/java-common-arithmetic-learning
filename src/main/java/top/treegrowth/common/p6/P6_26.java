package top.treegrowth.common.p6;

public class P6_26 {
	static final int MaxNum=10;
	static int array[][]={{3,5,-4,0},
			              {7,2,6,-4},
			              {4,-1,5,-5}};//������������			
	static int[] unuse_result=new int[MaxNum];			//�ж��Ƿ��ǲ�ȷ���ı���
	static int GaussFun(int equ,int var,int result[])	//��˹��Ԫ���㷨
	{
	    int i,j,k,col,num1,num2;
	    int max_r,ta,tb,gcdtemp,lcmtemp;
	    int temp,unuse_x_num,unuse_index=0;
	    col=0;						//��1�п�ʼ���� 
	    for(k=0;k<equ && col<var;k++,col++) //ѭ��������������еĸ���
	    {    
	        max_r=k;					//�������ֵ�����к�
	        for(i=k+1;i<equ;i++)
			{
	            if(Math.abs(array[i][col])>Math.abs(array[max_r][col]))
				{
	                max_r=i;			//�������ֵ�����к� 
				}
			}
	        if(max_r!=k)					//����в��ǵ�ǰ�У������k�н���
			{
	            for(j=k;j<var+1;j++)		//�����������Ͻ�����
				{
					temp=array[k][j];
					array[k][j]=array[max_r][j];
					array[max_r][j]=temp;
				}
			}
	        if(array[k][col]==0) 			//˵��col�е�k������ȫ��0������ǰ�е���һ��
	        {
	            k--;
	            continue;
	        }
	        for(i=k+1;i<equ;i++) 			//����Ҫɾ������
	        {
	            if(array[i][col]!=0) 			//������в�Ϊ0��������Ԫ���� 
	            {	
					num1=Math.abs(array[i][col]);
					num2=Math.abs(array[k][col]);
					while(num2!= 0)
					{
						temp=num2;
						num2=num1%num2;
						num1=temp;
					}
					gcdtemp=num1;	//���Լ��
					lcmtemp=(Math.abs(array[i][col]) * Math.abs(array[k][col]))/gcdtemp;//����С������

	                ta=lcmtemp/Math.abs(array[i][col]);
	                tb=lcmtemp/Math.abs(array[k][col]);
	                if(array[i][col]*array[k][col]<0) 	//����������Ų�ͬ 
					{
	                    tb=-tb;					//��ŵ���������������
					}
	                for(j=col;j<var+1;j++)  
					{
	                    array[i][j]=array[i][j]*ta-array[k][j]*tb;
					}
	            }
	        }
	    }
	    for(i=k;i<equ;i++)				//�ж����һ�����һ��
		{
	        if(array[i][col]!=0) 			//����Ϊ0����ʾ�޽�
			{
	            return -1; 				//����-1����ʾ�޽�
			}
		}
	    if(k<var)						//���ɱ�����var-k��������ȷ���ı���������var-k��.
	    {
	        for(i=k-1;i>=0;i--)
	        {
	            unuse_x_num=0; 		//�жϸ����в�ȷ������������
	            for(j=0;j<var;j++)
	            {
//	                if(array[i][j]!=0 && unuse_result[j])
	                if(array[i][j]!=0 && unuse_result[j]!=0)
	                {
	                    unuse_x_num++;
	                    unuse_index=j;
	                }
	            }
	            if(unuse_x_num>1)
				{
	                continue; 			//������1�������޷����
				}
	            temp=array[i][var];
	            for(j=0;j<var;j++)
	            {
	                if(array[i][j]!=0 && j!=unuse_index)
					{
	                    temp-=array[i][j]*result[j];
					}
	            }
	            result[unuse_index]=temp/array[i][unuse_index]; 	//����ñ���
	            unuse_result[unuse_index]=0; 				//�ñ�����ȷ����
	        }
	        return var-k; 								//���ɱ�����var-k��
	    }
	    for(i=var-1;i>=0;i--)				//��� 
	    {
	        temp=array[i][var];
	        for(j=i+1;j<var;j++)
	        {
	            if(array[i][j]!=0)
				{
	                temp-=array[i][j]*result[j];
				}
	        }
	        if(temp % array[i][i]!=0)		//���������� 
			{
	            return -2; 				//�����и������⣬����������
			}
	        result[i]=temp/array[i][i];
	    }
	    return 0;
	}
	public static void main(String[] args) {
		 int i, type;
		    int equnum, varnum;
			int[] result=new int[MaxNum]; 		//���淽�̵Ľ�
			equnum=3;
			varnum=3;
		   
		    type=GaussFun(equnum,varnum,result); //���ø�˹���� 
		    if(type==-1) 			//�޽� 
			{
		        System.out.printf("�÷����޽�!\n");
			}
		    else if(type==-2)			//ֻ�и������� 
			{
		        System.out.printf("�÷����и������⣬��������!\n");
			}
		    else if(type>0) 			//�������� 
		    {
		         System.out.printf("�÷�����������! ���ɱ�������Ϊ%d\n",type);
		         for(i=0;i<varnum;i++)
		         {
		             if(unuse_result[i]!=0)
					 {
		                 System.out.printf("x%d �ǲ�ȷ����\n",i+1);
					 }
		             else
					 {
		                 System.out.printf("x%d: %d\n",i+1,result[i]);
					 }
		         }
		    }
		    else
			{
				    System.out.printf("�÷��̵Ľ�Ϊ:\n");
		        for(i=0;i<varnum;i++) //����� 
		        {
		            System.out.printf("x%d=%d\n",i+1,result[i]);
		        }
		    }

	}

}
