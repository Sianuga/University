package Algorithms;

import MemoryManagmentUnit.Page;
import MemoryManagmentUnit.Reference;

import java.util.ArrayList;

public class FIFO extends Algorithm
{
    public FIFO()
    {

    }
    @Override
    public int decidePage(ArrayList<Reference> references, int time, Page[] physicalMemory)
    {
        int min=physicalMemory[0].getInsertionTime();
        int minIndex =0;
        int i=1;
        for (; i < physicalMemory.length; i++)
        {
            if(physicalMemory[i]!=null)
            {
                if(min>physicalMemory[i].getInsertionTime() )
                {
                    min = physicalMemory[i].getInsertionTime();
                    minIndex=i;
                }
            }

        }
       return minIndex;
    }



}
