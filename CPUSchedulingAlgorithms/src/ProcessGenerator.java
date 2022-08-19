import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.Random;

public class ProcessGenerator
{
    ArrayList<String> generatedNames = new ArrayList<String>();

    public String generateRandomName(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        String sb = new String();
        for (int i = 0; i < len; i++)
            sb+=(chars.charAt(rnd.nextInt(chars.length())));
        if(!generatedNames.contains(sb))
        {
            generatedNames.add(sb);
            return sb;
        }

        else
        return generateRandomName(len);
    }
    public int generateRandomProcessingTime(int pTime)
    {
        Random rand = new Random();
        return rand.nextInt(1,pTime);
    }
    public int generateRandomStartTime(int sTime)
    {
        Random rand = new Random();
        return rand.nextInt(0,sTime);
    }
    public  Process[] generateProcesses(int N, int pTime, int sTime)
    {
        ArrayList<Process> Processes = new ArrayList<Process>();
        for (int i = 0; i <N ; i++)
        {
         Processes.add(new Process(generateRandomName(10),generateRandomProcessingTime(pTime),generateRandomStartTime(sTime)));
        }
        Processes.sort((o1, o2) ->
        {
            if(o1.getStartTime()>o2.getStartTime())
            return 1;
            else if(o1.getStartTime()<o2.getStartTime())
                return -1;
                return 0;
        });
        Processes.get(0).setStartTime(0);
        Processes.sort( (o1, o2) ->
        {
            if(o1.getStartTime()>o2.getStartTime())
            return 1;
            else if(o1.getStartTime()<o2.getStartTime())
                return -1;
            else
                return 0;
        });
        Process[] processes = Processes.toArray(Process[]::new);
        return processes;
    }
}
