import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin extends Algorithm
{
    private Process[] processes;
    private Queue<Process> processesQueue = new LinkedList<Process>();
    private int time=0,timeSlice,processTimeCounter=0;
    boolean showInfo=false;

    RoundRobin(Process[] processes, int timeSlice)
    {
        this.processes = new Process[processes.length];
        for (int i = 0; i <processes.length ; i++)
        {
            this.processes[i]= new Process(processes[i].getName(),processes[i].getBurstTime(),processes[i].getStartTime());
        }
        this.timeSlice=timeSlice;
    }
    RoundRobin(Process[] processes)
    {
        this.processes = new Process[processes.length];
        for (int i = 0; i <processes.length ; i++)
        {
            this.processes[i]= new Process(processes[i].getName(),processes[i].getBurstTime(),processes[i].getStartTime());
        }
        this.timeSlice=generateTimeSlice();
    }
    public void setShowInfo(boolean a)
    {
        showInfo=a;
    }
    public void showAll()
    {
        System.out.println("All processes are: ");
        for (Process process:processes)
        {
            System.out.println(process);
        }
        System.out.println();
    }
    public void process()
    {
        getAllProcessesAtThisTime();
        while(!areProcessesFinished())
        {
            time++;
            getAllProcessesAtThisTime();
            if(!processesQueue.isEmpty())
                takeAction();
        }
        if(showInfo)
            System.out.println();
    }

    public void takeAction()
    {


        {
            if (processTimeCounter < timeSlice)
            {
                processesQueue.peek().setBurstTimeLeft(processesQueue.peek().getBurstTimeLeft()-1);
                processTimeCounter++;
            }
            if(processTimeCounter==timeSlice)
            {
                if(processesQueue.peek().getBurstTimeLeft()!=0)
                {
                    processesQueue.add(processesQueue.peek());
                    processesQueue.remove();
                }
                processTimeCounter=0;
            }
        }


        if(processesQueue.element().getBurstTimeLeft()==0)
        {
            processesQueue.element().setPresenceTime(time-processesQueue.element().getStartTime());
            processesQueue.element().setWaitingTime(processesQueue.element().getPresenceTime()-processesQueue.element().getBurstTime());
            processesQueue.element().setFinishTime(time);
            for (int i = 0; i < processes.length; i++)
            {
                if (processes[i].getName().equals(processesQueue.element().getName()))
                {
                    processes[i] = processesQueue.element();
                    processes[i].setProcessFinished(true);
                }
            }
            if(showInfo)
                processesQueue.element().processFinished();
            processTimeCounter=0;
            processesQueue.remove();

        }

    }

    public void getAllProcessesAtThisTime()
    {

        for (int i = 0; i < processes.length; i++)
        {
            if (processes[i].getStartTime() == time)
            {
                processesQueue.add(processes[i]);
            }
        }
    }
    public Process[] getProcesses()
    {
        return processes;
    }
    public int generateTimeSlice()
    {
        int sum=0;
        for (int i = 0; i <processes.length ; i++)
        {
            sum+= processes[i].getBurstTime();
        }
        return (sum/processes.length);

    }

    private boolean areProcessesFinished()
    {
        for (int i = 0; i <processes.length ; i++)
        {
            if(processes[i].getProcessFinished()==false)
                return false;
        }
        return true;
    }



}
