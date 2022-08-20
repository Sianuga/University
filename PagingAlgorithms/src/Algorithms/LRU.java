package Algorithms;

import MemoryManagmentUnit.Page;
import MemoryManagmentUnit.Reference;

import java.util.ArrayList;

public class LRU extends Algorithm
{
    public LRU()
    {

    }
    @Override
    public int decidePage(ArrayList<Reference> references, int time, Page[] physicalMemory)
    {
        int min=physicalMemory[0].getLastTimeAccessed();
        int minIndex =0;
        int i=1;
        for (; i < physicalMemory.length; i++)
        {
            if(physicalMemory[i]!=null)
            {
                if(min>physicalMemory[i].getLastTimeAccessed() )
                {
                    min = physicalMemory[i].getLastTimeAccessed();
                    minIndex=i;
                }
            }

        }
        return minIndex;
    }
}
