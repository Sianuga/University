public class Process
{
    private String name;
    private int startTime, burstTime,finishTime,burstTimeLeft, presenceTime, waitingTime,cylinderPos,deadline;
    private boolean processFinished=false,alreadyUsed=false,priority=false;
    Process(String name, int burstTime, int startTime)
    {
        this.name=name;
        this.burstTime = burstTime;
        this.startTime = startTime;
        burstTimeLeft=burstTime;
    }
    Process( int startTime, String name, int cylinderPos )
    {
        this.name=name;
        this.startTime = startTime;
        this.cylinderPos=cylinderPos;
    }
    Process( int startTime, String name, int cylinderPos, boolean priority, int deadline )
    {
        this.name=name;
        this.startTime = startTime;
        this.cylinderPos=cylinderPos;
        this.priority=priority;
        this.deadline=deadline;
    }

    Process(String name, int burstTime, int startTime, int burstTimeLeft)
    {
        this.name=name;
        this.burstTime = burstTime;
        this.startTime = startTime;
       this. burstTimeLeft=burstTimeLeft;
    }

    public boolean isAlreadyUsed()
    {
        return alreadyUsed;
    }

    public void setAlreadyUsed(boolean alreadyUsed)
    {
        this.alreadyUsed = alreadyUsed;
    }


    public int getCylinderPos()
    {
        return cylinderPos;
    }

    public void setCylinderPos(int cylinderPos)
    {
        this.cylinderPos = cylinderPos;
    }

    public int getPresenceTime()
    {
        return presenceTime;
    }

    public int getWaitingTime()
    {
        return waitingTime;
    }

    public void setPresenceTime(int presenceTime)
    {
        this.presenceTime = presenceTime;
    }

    public void setWaitingTime(int waitingTime)
    {
        this.waitingTime = waitingTime;
    }

    public int getFinishTime()
    {
        return finishTime;
    }

    public String toString()
    {
        return "Process{" +
                "name='" + name + '\'' +
                ", cylinderPos=" + cylinderPos + ",startTime=" + startTime+
                '}';
    }

    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }

    public void setBurstTimeLeft(int burstTimeLeft)
    {
        this.burstTimeLeft = burstTimeLeft;
    }

    public void setFinishTime(int finishTime)
    {
        this.finishTime = finishTime;
    }

    public int getBurstTime()
    {
        return burstTime;
    }

    public int getBurstTimeLeft()
    {
        return burstTimeLeft;
    }

    public int getStartTime()
    {
        return startTime;
    }

    public String getName()
    {
        return name;
    }
    public void processFinished()
    {
        System.out.print("Process with name: "+ getName() +
                " cylinderPos: " + cylinderPos +
                " startingTime: "+ startTime +
                " , finished");
    }
    public void setProcessFinished(boolean processFinished)
    {
        this.processFinished = processFinished;
    }
    public boolean getProcessFinished()
    {
        return processFinished;
    }

    public boolean isPriority()
    {
        return priority;
    }

    public int getDeadline()
    {
        return deadline;
    }

    public void setBurstTime(int burstTime)
    {
        this.burstTime = burstTime;
    }
}
