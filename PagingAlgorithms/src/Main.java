import Algorithms.*;
import MemoryManagmentUnit.*;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {


        ArrayList<Reference> references = new ArrayList<Reference>();
       FIFO fifo = new FIFO();
       OPT opt = new OPT();
       LRU lru = new LRU();
       ALRU alru = new ALRU();
       RAND rand = new RAND();
       Algorithm[] algorithms = new Algorithm[]{fifo,opt,lru,alru,rand};
        MMU mmu = new MMU();
        mmu.setShowInfo(true);

        references.add(new Reference(1,"P1"));
        references.add(new Reference(2,"P2"));
        references.add(new Reference(3,"P3"));
        references.add(new Reference(4,"P4"));
        references.add(new Reference(5,"P1"));
        references.add(new Reference(6,"P2"));
        references.add(new Reference(7,"P5"));
        references.add(new Reference(8,"P1"));
        references.add(new Reference(9,"P2"));
        references.add(new Reference(10,"P3"));
        references.add(new Reference(11,"P4"));
        references.add(new Reference(12,"P5"));


        ReferenceManager referenceManager = new ReferenceManager();
        int pageNumber=26,framesNumber=10,amount=10000;
        ArrayList<Reference> references2 = referenceManager.generate(amount,pageNumber);


        for (int i = 0; i < algorithms.length; i++)
        {
            System.out.println("Used "+ algorithms[i].getClass());
            mmu.newMMU(5,4,algorithms[i]);
            mmu.processAll(referenceManager.copy(references));
            mmu.showPageFaults();
        }

        mmu.setShowInfo(false);
        for (int i = 0; i <algorithms.length ; i++)
        {
            System.out.println("Used "+ algorithms[i].getClass());
            mmu.newMMU(pageNumber,framesNumber,algorithms[i]);
            mmu.processAll(referenceManager.copy(references2));
            mmu.showPageFaults();
        }




    }
}
