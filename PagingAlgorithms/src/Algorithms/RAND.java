package Algorithms;

import MemoryManagmentUnit.Page;
import MemoryManagmentUnit.Reference;

import java.util.ArrayList;
import java.util.Random;

public class RAND extends Algorithm
{
    public RAND()
    {

    }

    @Override
    public int decidePage(ArrayList<Reference> references, int time, Page[] physicalMemory)
    {
        Random rand = new Random();
        return rand.nextInt(physicalMemory.length-1);
    }
}
