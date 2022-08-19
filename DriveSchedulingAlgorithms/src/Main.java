public class Main
 {
  public static void main(String[] args)
  {
   int N=1000,sTime=500,mCylinder=125;
   ProcessGenerator processGenerator = new ProcessGenerator();
  Process[] processes = processGenerator.generateProcessesWithCylinders(N,sTime,mCylinder);
   Process[] processesTest = new Process[]{
           new Process(0,"Alfa",60),
           new Process(40,"Beta",80,true,100),
           new Process(70,"Charlie",10, true, 180),
           new Process(70,"Gamma",30, true, 300),
           new Process(125,"Lambda",75),
           new Process(150,"Theta",1)};
FCFS fcfs = new FCFS(processesTest);

fcfs.showAll();
   System.out.println("FCFS algorithm timeline: ");
   fcfs.setShowInfo(true);
fcfs.process();
fcfs.showResult();
SSTF sstf = new SSTF(processesTest);
   System.out.println("SSTF algorithm timeline: ");
   sstf.setShowInfo(true);
sstf.process();
sstf.showResult();
System.out.println("Scan algorithm timeline: ");
SCAN scan = new SCAN(processesTest);
scan.setShowInfo(true);
scan.process();
scan.showResult();
CSCAN cscan = new CSCAN(processesTest);
cscan.setShowInfo(true);
cscan.setMAX_VALUE(100);
System.out.println("C-Scan algorithm timeline: ");
cscan.process();
cscan.showResult();
   System.out.println("EDF algorithm timeline: ");
EDF edf = new EDF(processesTest);
edf.setShowInfo(true);
edf.process();
edf.showResult();
      System.out.println("FD-Scan algorithm timeline: ");
FDSCAN fdscan = new FDSCAN(processesTest);
fdscan.setShowInfo(true);
fdscan.process();
fdscan.showResult();


   FCFS fcfsRandom = new FCFS(processes);
   SSTF sstfRandom = new SSTF(processes);
   SCAN scanRandom = new SCAN(processes);
   CSCAN cScanRandom = new CSCAN(processes);
   EDF edfRandom = new EDF(processes);
   FDSCAN fdScanRandom = new FDSCAN(processes);
   cScanRandom.setMAX_VALUE(mCylinder);
   System.out.println("Random tests on each algorithm with number of elements= "+ N + " max start time= "+ sTime+ " and max cylinder value= " + mCylinder);
   System.out.println();
   fcfsRandom.process();
   sstfRandom.process();
   scanRandom.process();
   cScanRandom.process();
   edfRandom.process();
   fdScanRandom.process();
   fcfsRandom.showResult();
   sstfRandom.showResult();
   scanRandom.showResult();
   cScanRandom.showResult();
   System.out.println("EDF fail count:" + edfRandom.getFailed());
   edfRandom.showResult();
   System.out.println("FD-Scan fail count:" + fdScanRandom.getFailed());
   fdScanRandom.showResult();



  }
}
