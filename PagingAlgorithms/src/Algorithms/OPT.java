package Algorithms;

import MemoryManagmentUnit.Page;
import MemoryManagmentUnit.Reference;

import java.util.ArrayList;

public class OPT extends Algorithm
{
    public OPT()
    {

    }

    @Override
    public int decidePage(ArrayList<Reference> references, int time, Page[] physicalMemory)
    {
        int[] timeToNextUse = new int[physicalMemory.length];

        for (int i = 0; i <physicalMemory.length ; i++)
        {
            if(physicalMemory[i]!=null)
            {
                timeToNextUse[i] = findTimeToNextUse(references, physicalMemory, i);

            }
        }
        int maxIndex =0;
        int max=timeToNextUse[0];
        int i=1;
        for (; i < timeToNextUse.length; i++)
        {
            if(physicalMemory[i]!=null)
            {
                if(max<timeToNextUse[i])
                {
                    max=timeToNextUse[i];
                    maxIndex=i;
                }
            }

        }

        return maxIndex;
    }

    private int findTimeToNextUse(ArrayList<Reference> references, Page[] physicalMemory, int i)
    {
        for (int j = 0; j < references.size() ; j++)
        {
            if(references.get(j).getPageName().equals(physicalMemory[i].getName()))
            {
                return references.get(j).getReferenceTime();
            }
        }
        return Integer.MAX_VALUE;
    }
}
