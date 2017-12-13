package top.treegrowth.common.p6;

public class P6_26 {
	static final int MaxNum=10;
	static int array[][]={{3,5,-4,0},
			              {7,2,6,-4},
			              {4,-1,5,-5}};//输入的增广矩阵			
	static int[] unuse_result=new int[MaxNum];			//判断是否是不确定的变量
	static int GaussFun(int equ,int var,int result[])	//高斯消元法算法
	{
	    int i,j,k,col,num1,num2;
	    int max_r,ta,tb,gcdtemp,lcmtemp;
	    int temp,unuse_x_num,unuse_index=0;
	    col=0;						//第1列开始处理 
	    for(k=0;k<equ && col<var;k++,col++) //循环处理增广矩阵中的各行
	    {    
	        max_r=k;					//保存绝对值最大的行号
	        for(i=k+1;i<equ;i++)
			{
	            if(Math.abs(array[i][col])>Math.abs(array[max_r][col]))
				{
	                max_r=i;			//保存绝对值最大的行号 
				}
			}
	        if(max_r!=k)					//最大行不是当前行，则与第k行交换
			{
	            for(j=k;j<var+1;j++)		//交换矩阵右上角数据
				{
					temp=array[k][j];
					array[k][j]=array[max_r][j];
					array[max_r][j]=temp;
				}
			}
	        if(array[k][col]==0) 			//说明col列第k行以下全是0，则处理当前行的下一列
	        {
	            k--;
	            continue;
	        }
	        for(i=k+1;i<equ;i++) 			//查找要删除的行
	        {
	            if(array[i][col]!=0) 			//如果左列不为0，进行消元运算 
	            {	
					num1=Math.abs(array[i][col]);
					num2=Math.abs(array[k][col]);
					while(num2!= 0)
					{
						temp=num2;
						num2=num1%num2;
						num1=temp;
					}
					gcdtemp=num1;	//最大公约数
					lcmtemp=(Math.abs(array[i][col]) * Math.abs(array[k][col]))/gcdtemp;//求最小公倍数

	                ta=lcmtemp/Math.abs(array[i][col]);
	                tb=lcmtemp/Math.abs(array[k][col]);
	                if(array[i][col]*array[k][col]<0) 	//如果两数符号不同 
					{
	                    tb=-tb;					//异号的情况是两个数相加
					}
	                for(j=col;j<var+1;j++)  
					{
	                    array[i][j]=array[i][j]*ta-array[k][j]*tb;
					}
	            }
	        }
	    }
	    for(i=k;i<equ;i++)				//判断最后一行最后一列
		{
	        if(array[i][col]!=0) 			//若不为0，表示无解
			{
	            return -1; 				//返回-1，表示无解
			}
		}
	    if(k<var)						//自由变量有var-k个，即不确定的变量至少有var-k个.
	    {
	        for(i=k-1;i>=0;i--)
	        {
	            unuse_x_num=0; 		//判断该行中不确定变量数量，
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
	                continue; 			//若超过1个，则无法求解
				}
	            temp=array[i][var];
	            for(j=0;j<var;j++)
	            {
	                if(array[i][j]!=0 && j!=unuse_index)
					{
	                    temp-=array[i][j]*result[j];
					}
	            }
	            result[unuse_index]=temp/array[i][unuse_index]; 	//求出该变量
	            unuse_result[unuse_index]=0; 				//该变量是确定的
	        }
	        return var-k; 								//自由变量有var-k个
	    }
	    for(i=var-1;i>=0;i--)				//求解 
	    {
	        temp=array[i][var];
	        for(j=i+1;j<var;j++)
	        {
	            if(array[i][j]!=0)
				{
	                temp-=array[i][j]*result[j];
				}
	        }
	        if(temp % array[i][i]!=0)		//若不能整除 
			{
	            return -2; 				//返回有浮点数解，但无整数解
			}
	        result[i]=temp/array[i][i];
	    }
	    return 0;
	}
	public static void main(String[] args) {
		 int i, type;
		    int equnum, varnum;
			int[] result=new int[MaxNum]; 		//保存方程的解
			equnum=3;
			varnum=3;
		   
		    type=GaussFun(equnum,varnum,result); //调用高斯函数 
		    if(type==-1) 			//无解 
			{
		        System.out.printf("该方程无解!\n");
			}
		    else if(type==-2)			//只有浮点数解 
			{
		        System.out.printf("该方程有浮点数解，无整数解!\n");
			}
		    else if(type>0) 			//无穷多个解 
		    {
		         System.out.printf("该方程有无穷多解! 自由变量数量为%d\n",type);
		         for(i=0;i<varnum;i++)
		         {
		             if(unuse_result[i]!=0)
					 {
		                 System.out.printf("x%d 是不确定的\n",i+1);
					 }
		             else
					 {
		                 System.out.printf("x%d: %d\n",i+1,result[i]);
					 }
		         }
		    }
		    else
			{
				    System.out.printf("该方程的解为:\n");
		        for(i=0;i<varnum;i++) //输出解 
		        {
		            System.out.printf("x%d=%d\n",i+1,result[i]);
		        }
		    }

	}

}
