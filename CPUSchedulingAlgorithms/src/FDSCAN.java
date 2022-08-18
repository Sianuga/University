import java.util.ArrayList;

public class FDSCAN
{
    private Process[] processes;
    private ArrayList<Process> processesQueue = new ArrayList<Process>();
    private int time=0,currentCylinderPos=0,armMovesCounter=0, lastProcessCylinder, firstProcessCylinder,failed=0;
    private boolean showInfo=false, movingUp=true;
    private final int MAX_VALUE=200;

    FDSCAN(Process[] processes)
    {
        this.processes = new Process[processes.length];
        for (int i = 0; i <processes.length ; i++)
        {
            this.processes[i]= new Process(processes[i].getStartTime(),processes[i].getName(),processes[i].getCylinderPos(),processes[i].isPriority(),processes[i].getDeadline());
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
                setUpFinalValues();
                takeAction();
            }


        }
        if(showInfo)
            System.out.println();
    }

    public void takeAction()
    {
        if(processesQueue.get(0).isPriority())
        {
            if(processesQueue.get(0).getCylinderPos()>currentCylinderPos)
            {
                movingUp=true;
            }
            else
            {
                movingUp=false;
            }
        }
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
            if(currentCylinderPos==lastProcessCylinder)
            {
                movingUp=false;
            }
            if(currentCylinderPos==firstProcessCylinder)
            {
                movingUp=true;
            }
        }
        else
        {
//            if( currentCylinderPos==MAX_VALUE)
//            {
//                movingUp=false;
//            }
//            if(currentCylinderPos==firstProcessCylinder || currentCylinderPos==1)
//            {
//                movingUp=true;
//            }
            if(((processesQueue.get(0).getDeadline()-time)<Math.abs(currentCylinderPos-processesQueue.get(0).getCylinderPos())) && processesQueue.get(0).isPriority())
            {
                if(showInfo)
                {
                    System.out.println("Process with name: "+ processesQueue.get(0).getName() + " failed because of exceeding deadline");
                }
                for (int i = 0; i < processes.length; i++)
                {
                    if (processes[i].getName().equals(processesQueue.get(0).getName()))
                    {
                        processes[i] = processesQueue.get(0);
                        processes[i].setProcessFinished(true);
                    }
                }
                failed++;
                processesQueue.remove(0);
            }
            else
            {
                if(movingUp)
                {
                    currentCylinderPos++;
                }
                else
                    currentCylinderPos--;

                armMovesCounter++;
            }
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



                    if(o1.isPriority())
                    {
                        if(o2.isPriority())
                        {
                            if(Math.abs(currentCylinderPos - o1.getCylinderPos())>  Math.abs(currentCylinderPos - o2.getCylinderPos()))
                                return 1;
                            else if(Math.abs(currentCylinderPos - o1.getCylinderPos())<  Math.abs(currentCylinderPos - o2.getCylinderPos()))
                                return -1;
                            else return 0;
                        }
                        return -1;
                    }
                    else if(o2.isPriority())
                    {
                        if(o1.isPriority())
                        {
                            if(Math.abs(currentCylinderPos - o2.getCylinderPos())>  Math.abs(currentCylinderPos - o1.getCylinderPos()))
                                return 1;
                            else if(Math.abs(currentCylinderPos - o2.getCylinderPos())<  Math.abs(currentCylinderPos - o1.getCylinderPos()))
                                return -1;
                            else return 0;
                        }
                        return 1;
                    }

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
    private void setUpFinalValues()
    {
        firstProcessCylinder =processesQueue.get(0).getCylinderPos();
        lastProcessCylinder =processesQueue.get(0).getCylinderPos();
        for (int i=1;i <processesQueue.size();i++)
        {
            if(firstProcessCylinder>processesQueue.get(i).getCylinderPos())
                firstProcessCylinder=processesQueue.get(i).getCylinderPos();
            if(lastProcessCylinder<processesQueue.get(i).getCylinderPos())
                lastProcessCylinder=processesQueue.get(i).getCylinderPos();
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
        System.out.println("Number of cylinders travelled by head of hard drive arm in FD-SCAN algorithm is: "+ armMovesCounter);
        System.out.println();
    }

    public int getFailed()
    {
        return failed;
    }
}
