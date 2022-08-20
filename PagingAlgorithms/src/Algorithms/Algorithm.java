package Algorithms;

import MemoryManagmentUnit.Page;
import MemoryManagmentUnit.Reference;

import java.util.ArrayList;

public abstract class Algorithm
{

  //  public abstract void movePage(MemoryManagmentUnit.Page[] physicalMemory, MemoryManagmentUnit.Page[] logicalMemory, MemoryManagmentUnit.Page[] virtualMemory);
    public abstract int decidePage(ArrayList<Reference> references, int time, Page[] physicalMemory);


}
