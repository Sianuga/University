import java.util.LinkedList;
import java.util.Queue;

public class FCFS
{

    private Process[] processes;
    private Queue<Process> processesQueue = new LinkedList<Process>();
    private int time=0,currentCylinderPos=0,armMovesCounter=0;
    private boolean showInfo=false;

    FCFS(Process[] processes)
    {
        this.processes = new Process[processes.length];
        for (int i = 0; i <processes.length ; i++)
        {
            this.processes[i]= new Process(processes[i].getStartTime(),processes[i].getName(),processes[i].getCylinderPos());
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

        if(processesQueue.element().getCylinderPos()==currentCylinderPos)
        {
            for (int i = 0; i < processes.length; i++)
            {
                if (processes[i].getName().equals(processesQueue.element().getName()))
                {
                    processes[i] = processesQueue.element();
                    processes[i].setProcessFinished(true);
                }
            }
            if(showInfo)
            {
                processesQueue.element().processFinished();
                System.out.println(" at arm move number: "+ armMovesCounter);
            }

            processesQueue.remove();
            time--;
        }
        else
        {
            if(currentCylinderPos>processesQueue.element().getCylinderPos())
           currentCylinderPos--;
            else
                currentCylinderPos++;
            armMovesCounter++;
        }

    }



    public void getAllProcessesAtThisTime()
    {

        for (int i = 0; i < processes.length; i++)
        {
            if (processes[i].getStartTime() == time && processes[i].isAlreadyUsed()==false)
            {
                processesQueue.add(processes[i]);
                processes[i].setAlreadyUsed(true);
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
    public void showResult()
    {
        System.out.println("Number of cylinders travelled by head of hard drive arm in FCFS algorithm is: "+ armMovesCounter);
        System.out.println();
    }

}
