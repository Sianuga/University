public class Main
{
    public static void main(String[] args)
    {
        ProcessGenerator processGenerator = new ProcessGenerator();
        Process[] processes = processGenerator.generateProcesses(100,20,60);
        Process[] processesTest = new Process[]{
                new Process("Alfa",6,0),
                new Process("Beta",1,3),
                new Process("Charlie",5,3),
                new Process("Gamma",2,6),
                new Process("Lambda",5,6)};
        FCFS fcfs = new FCFS(processesTest);
        SJF sjf = new SJF(processesTest);
        SRTF srtf = new SRTF(processesTest);
        RoundRobin rr = new RoundRobin(processesTest,2);
        System.out.println();
        System.out.println("Times for test processes");
        System.out.println();

        System.out.println(fcfs.getClass().toString().substring(6));
       fcfs.showAll();
       fcfs.setShowInfo(true);
        fcfs.process();
        System.out.println(sjf.getClass().toString().substring(6));
        sjf.showAll();
        sjf.setShowInfo(true);
        sjf.process();
        System.out.println(srtf.getClass().toString().substring(6));
        srtf.showAll();
        srtf.setShowInfo(true);
        srtf.process();
        System.out.println(rr.getClass().toString().substring(6));
        rr.showAll();
        rr.setShowInfo(true);
        rr.process();
        Calculator calculator = new Calculator();
        calculator.calculateAverages(fcfs);
        calculator.calculateAverages(sjf);
        calculator.calculateAverages(srtf);
        calculator.calculateAverages(rr);


        System.out.println("Times for randomly generated processes");
        FCFS fcfsR = new FCFS(processes);
        SJF sjfR = new SJF(processes);
        SRTF srtfR = new SRTF(processes);

        RoundRobin rrR = new RoundRobin(processes);
        System.out.println("Time slice being used in RR: " + rrR.generateTimeSlice());
        System.out.println();
        fcfsR.process();
        sjfR.process();
        srtfR.process();
        rrR.process();
        calculator.calculateAverages(fcfsR);
        calculator.calculateAverages(sjfR);
        calculator.calculateAverages(srtfR);
        calculator.calculateAverages(rrR);
    }
}
