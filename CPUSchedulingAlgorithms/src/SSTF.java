import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SSTF
{
    private Process[] processes;
    private ArrayList<Process> processesQueue = new ArrayList<Process>();
    private int time=0,currentCylinderPos=0,armMovesCounter=0;
    private boolean showInfo=false;

    SSTF(Process[] processes)
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
            {
                setUpTheWaitingLine();
                takeAction();
            }

        }
        if(showInfo)
            System.out.println();
    }

    public void takeAction()
    {

        if(processesQueue.get(0).getCylinderPos()==currentCylinderPos)
        {
            for (int i = 0; i < processes.length; i++)
            {
                if (processes[i].getName().equals(processesQueue.get(0).getName()))
                {
                    processes[i] = processesQueue.get(0);
                    processes[i].setProcessFinished(true);
                }
            }
            if(showInfo)
            {
                processesQueue.get(0).processFinished();
                System.out.println(" at arm move number: "+ armMovesCounter);
            }

            processesQueue.remove(0);
            time--;
        }
        else
        {
            if(currentCylinderPos>processesQueue.get(0).getCylinderPos())
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

    private void setUpTheWaitingLine()
    {

        processesQueue.sort( ((o1, o2) ->
                {
                    if( Math.abs(currentCylinderPos - o1.getCylinderPos())>  Math.abs(currentCylinderPos - o2.getCylinderPos())  )
                        return 1;
                    else if ( Math.abs(currentCylinderPos - o1.getCylinderPos())< Math.abs(currentCylinderPos - o2.getCylinderPos()) )
                        return -1;
                    else
                        return 0;
                }

                )
        );

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
        System.out.println("Number of cylinders travelled by head of hard drive arm in SSTF algorithm is: "+ armMovesCounter);
        System.out.println();
    }
}
