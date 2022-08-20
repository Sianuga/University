package Algorithms;

import MemoryManagmentUnit.Page;
import MemoryManagmentUnit.Reference;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ALRU extends Algorithm
{
    Queue<Page> queue = new LinkedList<>();
    public ALRU()
    {

    }

    @Override
    public int decidePage(ArrayList<Reference> references, int time, Page[] physicalMemory)
    {

        Page refBitCheck=null;
        for (int i = 0; i < physicalMemory.length ; i++)
        {
            if(physicalMemory[i]!=null)
            refBitCheck=new Page(physicalMemory[i].getName(), physicalMemory[i].isValidBit(), physicalMemory[i].getLastTimeAccessed(), physicalMemory[i].getInsertionTime(), !physicalMemory[i].isReferenceBit());
            if(!queue.contains( physicalMemory[i]) && physicalMemory[i]!=null && !queue.contains(refBitCheck))
            {
                physicalMemory[i].setReferenceBit(true);
               queue.add(physicalMemory[i]);
            }
        }

        Page tmp;
            int j=0;
            if(!queue.isEmpty() && isPhysicalFull(physicalMemory))
            {
                if(checkIfSame(references,physicalMemory))
                {
                return 0;
                }

                    for (int i = 0; i <= physicalMemory.length; i++)
                    {
                        if (queue.element().isReferenceBit())
                        {
                            j = findIndex(physicalMemory,queue);
                            tmp = new Page(physicalMemory[j].getName(), physicalMemory[j].isValidBit(), physicalMemory[j].getLastTimeAccessed(), physicalMemory[j].getInsertionTime(), physicalMemory[j].isReferenceBit());
                            queue.remove();
                            tmp.setReferenceBit(false);
                            queue.add(tmp);
                        }
                        else
                        {
                            i = findIndex(physicalMemory,queue);
                            queue.remove();
                            return i;
                        }



                }
            }
    return 0;
    }

    public boolean isPhysicalFull(Page[] physicalMemory)
    {
        for (int i = 0; i <physicalMemory.length ; i++)
        {
            if(physicalMemory[i]==null)
                return false;
        }
        return true;
    }
//    private boolean needToSwitch(ArrayList<Reference> references, Page[] physicalMemory)
//    {
//        for (int i = 0; i < physicalMemory.length ; i++)
//        {
//            if(physicalMemory[i]!=null)
//            {
//                if(physicalMemory[i].getName().equals(references.get(0).getPageName()))
//                {
//                    return false;
//                }
//            }
//
//        }
//        return true;
//    }
    private boolean checkIfSame(ArrayList<Reference> references, Page[] physicalMemory)
    {
        for (int i = 0; i < physicalMemory.length ; i++)
        {
            if(physicalMemory[i]!=null)
            {
                if(physicalMemory[i].getName().equals(references.get(0).getPageName()))
                {
                    physicalMemory[i].setReferenceBit(true);
                    return true;
                }
            }

        }
        return false;
    }
    private int findIndex(Page[] physicalMemory, Queue<Page> queue)
    {
        for (int i = 0; i < physicalMemory.length ; i++)
        {
            if(queue.element().getName().equals(physicalMemory[i].getName()))
            {
                return i;
            }
        }
        return 0;
    }

}
