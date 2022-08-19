import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FCFS extends Algorithm
{
    private Process[] processes;
    private Queue<Process> processesQueue = new LinkedList<Process>();
    int time=0;
    boolean showInfo=false;

    FCFS(Process[] processes)
    {
        this.processes = new Process[processes.length];
        for (int i = 0; i <processes.length ; i++)
        {
            this.processes[i]= new Process(processes[i].getName(),processes[i].getBurstTime(),processes[i].getStartTime());
        }
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

        processesQueue.element().setBurstTimeLeft(processesQueue.element().getBurstTimeLeft()-1);

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
