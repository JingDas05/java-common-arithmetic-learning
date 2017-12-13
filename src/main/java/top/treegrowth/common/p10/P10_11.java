package top.treegrowth.common.p10;

import java.util.ArrayList;
import java.util.List;

//青蛙过河类
class FrogOverRiver
{
     //初始化青蛙队列
     public  List<Frog> initializeFrogQueue()
    {
         List<Frog> frogQueue = new ArrayList<Frog>();
         frogQueue.add(new Frog(0, "左1", Frog.frogDirection.向右, false));
         frogQueue.add(new Frog(1, "左2", Frog.frogDirection.向右, true));
         frogQueue.add(new Frog(2, "左3", Frog.frogDirection.向右, true));
         frogQueue.add(new Frog(3));
         frogQueue.add(new Frog(4, "右1", Frog.frogDirection.向左, true));
         frogQueue.add(new Frog(5, "右2", Frog.frogDirection.向左, true));
         frogQueue.add(new Frog(6, "右3", Frog.frogDirection.向左, false));
         return frogQueue;
    }

     //当一个青蛙跳动后,形成一个新的队列
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
             if ((newEmptyPositonID - newFrog.position) > 0 && (newEmptyPositonID - newFrog.position) < 3 && newFrog.direction == Frog.frogDirection.向右)
                     newFrog.canJump = true;

             if ((newFrog.position - newEmptyPositonID) > 0 && (newFrog.position - newEmptyPositonID) < 3 && newFrog.direction == Frog.frogDirection.向左)
                     newFrog.canJump = true;

             newFrogQueue.add(newFrog);
         }
             return newFrogQueue;
     }

    //是否已经完成位置对换,即前三个青蛙的位置都大于3
    private boolean isComplete(List<Frog> frogQueue)
    {
         return (frogQueue.get(0).position > 3 && frogQueue.get(1).position > 3 && frogQueue.get(2).position > 3);
    }

   //是否还有可以跳动的青蛙,只要有可以跳动的,就没有达到最后的状态，但都不可以跳动了也不一定对换完了，这里只是控制递归
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

   // 获取青蛙的跳动步骤
   public String frogJump(List<Frog> frogQueue, int emptyPositionId)  //当前青蛙队列,空位置编号
   {
          String frogJumpInfo = "";
       for(int i=0;i<frogQueue.size();i++)
       {
           Frog frog=(Frog)frogQueue.get(i);
           //是空位置
           if (frog.isEmpty)
               continue;
           if (!frog.canJump)
               continue;

           frogJumpInfo ="青蛙" + frog.frogName + " " + frog.direction + "跳到" + (emptyPositionId + 1) + "\r\n";

           int newPositionId = frog.position;
           List<Frog> newFrogQueue = this.editFrogQueue(frogQueue, frog.frogName, emptyPositionId, newPositionId);

           //只要能继续跳就递归
           if (this.canFrogJump(newFrogQueue))
           {
               frogJumpInfo += this.frogJump(newFrogQueue, newPositionId);
           }
           else
           {
              if (this.isComplete(newFrogQueue))
              {
                  frogJumpInfo = frogJumpInfo + "成功";
                  break;
              }
           }
           if (frogJumpInfo.contains("成功"))
                    break;
            }
            //循环结束
            return frogJumpInfo;
        }
    }


class Frog
{
	static enum frogDirection { 向左, 向右 };

    public String frogName;//青蛙名称
    public int position;    //青蛙位置
    public frogDirection direction; //青蛙跳动的方向
    public boolean canJump;//是否可以跳
    public boolean isEmpty = false; //是否是空格
 
    public Frog(int positon, String frogName, frogDirection direction, boolean canJump)
    {
         this.position = positon;
         this.frogName = frogName;
         this.direction = direction;
         this.canJump = canJump;
    }
 
    public Frog(int positon)
    {
        this.frogName = "空";
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


