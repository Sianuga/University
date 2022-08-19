public class Calculator
{


    public void calculateAverages(Algorithm algorithm)
    {
        Process[] processes = algorithm.getProcesses();
        float averagePresenceTime=0,averageWaitingTime=0;
        for (int i = 0; i < processes.length; i++)
        {
            averageWaitingTime+=processes[i].getWaitingTime();
            averagePresenceTime+=processes[i].getPresenceTime();
        }
        averageWaitingTime/=processes.length;
        averagePresenceTime/=processes.length;
        System.out.println("Average time for "+ algorithm.getClass().toString().substring(6)+ " is averagePresenceTime: "+ String.format("%.2f",averagePresenceTime) + " and averageWaitingTime: "+ String.format("%.2f",averageWaitingTime));
        System.out.println();
    }
}
