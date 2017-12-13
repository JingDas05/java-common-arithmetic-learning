package top.treegrowth.common.p10;

import java.util.ArrayList;
import java.util.List;

 //���ܹ�����
class FrogOverRiver
{
      //��ʼ�����ܶ���
      public  List<Frog> initializeFrogQueue()
     {
    	  List<Frog> frogQueue = new ArrayList<Frog>();
          frogQueue.add(new Frog(0, "��1", Frog.frogDirection.����, false));
          frogQueue.add(new Frog(1, "��2", Frog.frogDirection.����, true));
          frogQueue.add(new Frog(2, "��3", Frog.frogDirection.����, true));
          frogQueue.add(new Frog(3));
          frogQueue.add(new Frog(4, "��1", Frog.frogDirection.����, true));
          frogQueue.add(new Frog(5, "��2", Frog.frogDirection.����, true));
          frogQueue.add(new Frog(6, "��3", Frog.frogDirection.����, false));
          return frogQueue;
     }
        
      //��һ������������,�γ�һ���µĶ���
      private List<Frog> editFrogQueue(List<Frog> frogQueue, String frogName, int oldEmptyPositonID, int newEmptyPositonID)
      {
     	  List<Frog> newFrogQueue = new ArrayList<Frog>();
          for(int i=0;i<frogQueue.size();i++)
          {
              Frog frog=(Frog)frogQueue.get(i);
           	  Frog newFrog = new Frog(frog);
              if (newFrog.isEmpty)
                   newFrog.position = newEmptyPositonID;
              if (newFrog.frogName == frogName)
              {
                   newFrog.position = oldEmptyPositonID;
              }
  
              newFrog.canJump = false;
              if ((newEmptyPositonID - newFrog.position) > 0 && (newEmptyPositonID - newFrog.position) < 3 && newFrog.direction == Frog.frogDirection.����)
                      newFrog.canJump = true;
  
              if ((newFrog.position - newEmptyPositonID) > 0 && (newFrog.position - newEmptyPositonID) < 3 && newFrog.direction == Frog.frogDirection.����)
                      newFrog.canJump = true;
  
              newFrogQueue.add(newFrog);
          }
              return newFrogQueue;
      }
  
     //�Ƿ��Ѿ����λ�öԻ�,��ǰ�������ܵ�λ�ö�����3
     private boolean isComplete(List<Frog> frogQueue)
     {
          return (frogQueue.get(0).position > 3 && frogQueue.get(1).position > 3 && frogQueue.get(2).position > 3);
     }
  
    //�Ƿ��п�������������,ֻҪ�п���������,��û�дﵽ����״̬������������������Ҳ��һ���Ի����ˣ�����ֻ�ǿ��Ƶݹ�
    private boolean canFrogJump(List<Frog> frogQueue)
   {
   	   for(int i=0;i<frogQueue.size();i++)
       {
   		  Frog frog=(Frog)frogQueue.get(i);
          if (frog.canJump)
          return true;
        }
        return false;
    } 
      
    // ��ȡ���ܵ���������
    public String frogJump(List<Frog> frogQueue, int emptyPositionId)  //��ǰ���ܶ���,��λ�ñ��
    {
       	String frogJumpInfo = "";
        for(int i=0;i<frogQueue.size();i++)
        {
        	Frog frog=(Frog)frogQueue.get(i);
            //�ǿ�λ��               
            if (frog.isEmpty)
                continue;
            if (!frog.canJump)
                continue;
                 
            frogJumpInfo ="����" + frog.frogName + " " + frog.direction + "����" + (emptyPositionId + 1) + "\r\n";
           
            int newPositionId = frog.position;
            List<Frog> newFrogQueue = this.editFrogQueue(frogQueue, frog.frogName, emptyPositionId, newPositionId);
   
            //ֻҪ�ܼ������͵ݹ�
            if (this.canFrogJump(newFrogQueue))
            {
                frogJumpInfo += this.frogJump(newFrogQueue, newPositionId);
            }
            else
            {
               if (this.isComplete(newFrogQueue))
               {
                   frogJumpInfo = frogJumpInfo + "�ɹ�";
                   break;
               }
            }
            if (frogJumpInfo.contains("�ɹ�"))
                     break;
             }
             //ѭ������
             return frogJumpInfo;
         }
     }


class Frog
{
	static enum frogDirection { ����, ���� };

    public String frogName;//��������
    public int position;    //����λ��
    public frogDirection direction; //���������ķ���
    public boolean canJump;//�Ƿ������
    public boolean isEmpty = false; //�Ƿ��ǿո�
 
    public Frog(int positon, String frogName, frogDirection direction, boolean canJump)
    {
         this.position = positon;
         this.frogName = frogName;
         this.direction = direction;
         this.canJump = canJump;
    }
 
    public Frog(int positon)
    {
        this.frogName = "��";
        this.position = positon;
        this.canJump = false;
        this.isEmpty = true;
     }
     public Frog(Frog frog)
     {
        this.position = frog.position;
        this.frogName = frog.frogName;
        this.direction = frog.direction;
        this.canJump = frog.canJump;
        this.isEmpty = frog.isEmpty;
     }
} 



public class P10_11 
{
	public static void main(String[] args) 
	{	
		FrogOverRiver f= new FrogOverRiver();
		List frogQueue =f.initializeFrogQueue();
		System.out.println(f.frogJump(frogQueue, 3));

	}
}


