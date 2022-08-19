import java.util.*;

public class SJF extends Algorithm
{
    private Process[] processes;
    private ArrayList<Process> processesQueue = new ArrayList<Process>();
    private Process processInProcessor;
    int time=0;
    boolean showInfo=false;
    SJF(Process[] processes)
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

    public void process()
    {

        while(!areProcessesFinished())
        {
            getAllProcessesAtThisTime();
            setUpTheWaitingLine();
            time++;
            if(!processesQueue.isEmpty())
            takeAction();
        }
        if(showInfo)
            System.out.println();

     }

    private void setUpTheWaitingLine()
    {

       processesQueue.sort( ((o1, o2) ->
               {
                    if(o1.getBurstTime()> o2.getBurstTime() || o2.isAlreadyUsed() )
                   return 1;
                    else if (o1.getBurstTime()< o2.getBurstTime() || o1.isAlreadyUsed())
                        return -1;
                    else
                        return 0;
               }

       )
       );

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

    public void takeAction()
    {
        processesQueue.get(0).setBurstTimeLeft(processesQueue.get(0).getBurstTimeLeft()-1);
        processesQueue.get(0).setAlreadyUsed(true);

        if(processesQueue.get(0).getBurstTimeLeft()==0)
        {
            processesQueue.get(0).setPresenceTime(time-processesQueue.get(0).getStartTime());
            processesQueue.get(0).setWaitingTime(processesQueue.get(0).getPresenceTime()-processesQueue.get(0).getBurstTime());
            processesQueue.get(0).setFinishTime(time);
            for (int i = 0; i < processes.length; i++)
            {
                if (processes[i].getName().equals(processesQueue.get(0).getName()))
                {
                    processes[i] = processesQueue.get(0);
                    processes[i].setProcessFinished(true);
                }
            }
              if(showInfo)
            processesQueue.get(0).processFinished();
            processesQueue.remove(0);
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



    public void showAll()
    {
        System.out.println("All processes are: ");
        for (Process process:processes)
        {
            System.out.println(process);
        }
        System.out.println();
    }
    public Process[] getProcesses()
    {
        return processes;
    }

}
