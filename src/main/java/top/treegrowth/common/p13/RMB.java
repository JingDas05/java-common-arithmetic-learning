package top.treegrowth.common.p13;

import java.text.DecimalFormat;
import java.text.NumberFormat;   
import java.util.Scanner;

public final class RMB 
{   
     private double amount = 0.0D;   
     private static final String NUM = "零壹贰叁肆伍陆柒捌玖";   
     private static final String UNIT = "仟佰拾个";   
     private static final String GRADEUNIT = "仟万亿兆";   
     private static final String DOTUNIT = "角分厘";   
     private static final int GRADE = 4;  
     private static final String SIGN = "￥";   
     private static final NumberFormat nf = new DecimalFormat("#0.###");   
   
     private RMB(double amount) 
     {   
        this.amount = amount;   
   
     }  
     
     public static String toBigAmt(double amount) 
     {   
         nf.setMinimumFractionDigits(3);//小数点后不足的补零   
         String amt = nf.format(amount);//将double类型的数格式化并转换成字符串,实际上进行了四舍五入   
         System.out.println(amt);   
         Double d = new Double(amount);   
         String dotPart = ""; //取小数位   
         String intPart = ""; //取整数位   
   
         int dotPos;   
         if ((dotPos = amt.indexOf('.')) != -1) 
         {   
             intPart = amt.substring(0, dotPos);   
             dotPart = amt.substring(dotPos + 1);   
 
             if(dotPart.length()>4)
             { //超过4位直接截取   
                 dotPart = dotPart.substring(0,4);   
             }   
         } 
         else 
         {   
             intPart = amt;   
         }   
   
         if (intPart.length() > 16)   
             throw new InternalError("数额太大，无法转换。");

         String intBig = intToBig(intPart);   
         String dotBig = dotToBig(dotPart);   
   
         //以下代码稍做修改，现在好多了。   
   
         if ((dotBig.length() == 0) && (intBig.length() != 0)) 
         {   
             return intBig + "元整";   
         } 
         else if ((dotBig.length() == 0) && (intBig.length() == 0)) 
         {   
             return intBig + "零元";   
         } 
         else if ((dotBig.length() != 0) && (intBig.length() != 0)) 
         {   
             return intBig + "元" + dotBig;   
          } 
         else 
         {   
             return dotBig;   
         }   
   
     }   
   
   
   
     /**  
  
      * 用来处理几角几分几厘  
  
      * @param dotPart  
  
      * @return  
  
      */  
   
     private static String dotToBig(String dotPart) 
     {   
         //得到转换后的大写（小数部分）   
         String strRet = "";   
         for (int i = 0; i < dotPart.length() && i < 3; i++) 
         {   
             int num;   
             if ((num = Integer.parseInt(dotPart.substring(i, i + 1))) != 0)   
   
                 strRet += NUM.substring(num, num + 1)   
   
                         + DOTUNIT.substring(i, i + 1);   
         }   
   
         return strRet;   
   
     }   
   
  
     /**  
  
      * 用来处理多少元 ，这个要仔细考虑才行  
  
      * @param intPart  
  
      * @return  
  
      */  
   
     private static String intToBig(String intPart) 
     {   
         //得到转换后的大写（整数部分）   
         int grade; //级长   
         String result = "";   
         String strTmp = "";   
        //得到当级长   
         grade = intPart.length() / GRADE;   
   
         //调整级次长度   
         if (intPart.length() % GRADE != 0)   
             grade += 1;   
        //对每级数字处理，先处理最高级，然后再处理低级的   
         for (int i = grade; i >= 1; i--) 
         {   
             strTmp = getNowGradeVal(intPart, i);//取得当前级次数字   
             result += getSubUnit(strTmp);//转换大写   
   
             //System.out.println(strTmp+"|"+getSubUnit(strTmp));   
   
             result = dropZero(result);//除零 去掉连续的零   
   
             //System.out.println("result="+result);   
   
             //加级次单位   
   
             if (i > 1) //末位不加单位   
   
                 //单位不能相连续   
   
                 //注意：连续4个零的时候要特殊处理(wmj修改此bug)   
   
                 if(getSubUnit(strTmp).equals("零零零零"))
                 {   
                     result = result+"零";   
                  }
                 else
                 {   
                     result += GRADEUNIT.substring(i - 1, i);   
                 }   
   
         }   
         return result;   
     }   
   
    private static String getNowGradeVal(String strVal, int grade) 
     {   
   
         //得到当前级次的串   
   
         String rst;   
   
         if (strVal.length() <= grade * GRADE)   
   
             rst = strVal.substring(0, strVal.length() - (grade - 1) * GRADE);   
   
         else  
   
             rst = strVal.substring(strVal.length() - grade * GRADE, strVal   
   
                     .length()   
   
                     - (grade - 1) * GRADE);   
   
         return rst;   
   
     }   
   
    private static String getSubUnit(String strVal) 
     {   
         //数值转换   
         String rst = "";   
  
         for (int i = 0; i < strVal.length(); i++) 
         {   
             String s = strVal.substring(i, i + 1);   
             int num = Integer.parseInt(s);   
   
             if (num == 0) 
             {   
                 //“零”作特殊处理   
                 if (i != strVal.length()) //转换后数末位不能为零   
                     rst += "零";   
              } 
             else 
             {   
                 //If IntKey = 1 And i = 2 Then   
   
                 //“壹拾”作特殊处理   
   
                 //“壹拾”合理   
   
                 //Else   
   
                 rst += NUM.substring(num, num + 1);   
   
                 //End If   
   
                 //追加单位   
   
                 if (i != strVal.length() - 1)//个位不加单位   
   
                     rst += UNIT.substring(i + 4 - strVal.length(), i + 4  
   
                             - strVal.length() + 1);   
   
             }   
   
         }   
   
         return rst;   
   
     }   

    /**  
  
      *   
  
      * @param strVal  
  
      * @return  
  
      */  
   
     private static String dropZero(String strVal) 
     {   
         //去除连继的“零”   
         String strRst;   
         String strBefore; //前一位置字符   
         String strNow; //现在位置字符   
   
        strBefore = strVal.substring(0, 1);   
        strRst = strBefore;   
   
        for (int i = 1; i < strVal.length(); i++) 
         {   
             strNow = strVal.substring(i, i + 1);   
   
             if (strNow.equals("零") && strBefore.equals("零"))   
   
                 ;//同时为零   
              else  
                  strRst += strNow;   
              strBefore = strNow;   
          }   
         
        //末位去零   
        if (strRst.substring(strRst.length() - 1, strRst.length()).equals("零"))   
   
             strRst = strRst.substring(0, strRst.length() - 1);   
   
         return strRst;   
   
     }   
   
     public static void main(String[] args) 
     {  
    	 String  rmb;
    	 double  str;
    	 System.out.println("请输入金额数：");
         Scanner scanner = new Scanner(System.in);
         str = scanner.nextDouble();
         System.out.println("转换后的金额为：");
         
         rmb=RMB.toBigAmt(str);
         System.out.println(rmb);
   
     }   
   
 }  
