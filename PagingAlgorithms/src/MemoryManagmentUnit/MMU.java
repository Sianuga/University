package MemoryManagmentUnit;

import Algorithms.ALRU;
import Algorithms.Algorithm;

import java.util.ArrayList;

public class MMU
{
    private Page[] logicalMemory;
    private Page[] virtualMemory;
    private Page[] physicalMemory;
    private PageManager pageManager;
    private Algorithm algorithm;
    private int time=0,pageFaultCounter=0;
    private boolean showInfo=false;

    public void setShowInfo(boolean type)
    {
        showInfo=type;
    }

    public MMU()
    {
    }
    public MMU(int framesAmount, int pagesNumber, Algorithm algorithm)
    {
        pageManager = new PageManager(pagesNumber);
        physicalMemory = new Page[framesAmount];
        logicalMemory = pageManager.generate(pagesNumber);
        virtualMemory = new Page[pagesNumber];
        Page[] pages = pageManager.copy(logicalMemory);
        this.algorithm=algorithm;
    }


    private void setAlgorithm(Algorithm algorithm)
    {
        this.algorithm = algorithm;
    }

    private void newLogicalMemory(int pagesNumber)
    {
        this.logicalMemory = pageManager.generate(pagesNumber);
    }
    private void newPhysicalMemory(int framesNumber)
    {
        physicalMemory= new Page[framesNumber];
    }
    public void newMMU(int pagesNumber, int framesNumber, Algorithm algorithm)
    {
        pageFaultCounter=0;
        pageManager = new PageManager(pagesNumber);
        setAlgorithm(algorithm);
        newLogicalMemory(pagesNumber);
        newPhysicalMemory(framesNumber);
        virtualMemory = new Page[pagesNumber];
        time=0;
    }


    private void processReference(Reference ref, int pageToMoveIndex)
    {
        Page searchedPage = FindPage(ref.getPageName());
        Page pageToReplace = physicalMemory[pageToMoveIndex];
        Page virtualToReplace=null;
        if(searchedPage!=null)
        {
            virtualToReplace= FindPageV(searchedPage.getName());
            if( !searchedPage.isValidBit())
            {
                if(isPhysicalFull())
                {
                    swapPhysicalToVirtual(pageToMoveIndex, pageToReplace);
                    manageVirtual(virtualToReplace);

                }

                assignToPhysical(searchedPage);
                pageFaultCounter++;
            }
            else
            {
                lastTimeAccessesControl(searchedPage);
            }
        }

    }



    public void processAll(ArrayList<Reference> refs)
    {
        int pageToMoveIndex = 0;
        while(!refs.isEmpty())
        {
            if(refs.get(0).getReferenceTime()==time)
            {
                if(!isPhysicalEmpty() || algorithm.getClass()== ALRU.class)
                    pageToMoveIndex= algorithm.decidePage(refs, time,physicalMemory);
                processReference(refs.get(0),pageToMoveIndex);
                refs.remove(0);
            }
            if(showInfo)
            {
                System.out.println("Time is "+ time);
                showAllMem();
                System.out.println();

            }
            time++;
        }
    }
    public void showVirtualMem()
    {
        System.out.println("Virtual memory: ");
        System.out.print("|");
        for (int i = 0; i < virtualMemory.length; i++)
        {
            if(virtualMemory[i]==null)
            {
                System.out.print(" __ |");
            }
            else if(!virtualMemory[i].isValidBit())
                System.out.print(" "+virtualMemory[i].getName()+" |");
            else
                System.out.print(" __ |");
        }
        System.out.println();
    }
    public void showLogicalMem()
    {
        System.out.println("Logical memory: ");
        System.out.print("|");
        for (int i = 0; i < logicalMemory.length; i++)
        {

            System.out.print(" "+logicalMemory[i].getName()+" |");

        }
        System.out.println();
    }
    public void showPhysicalMem()
    {
        System.out.println("Physical memory: ");
        System.out.print("|");
        for (int i = 0; i < physicalMemory.length; i++)
        {
            if(physicalMemory[i]==null)
            {
                System.out.print(" __ |");
            }
            else if(physicalMemory[i].isValidBit())
                System.out.print(" "+physicalMemory[i].getName()+" |");
            else
                System.out.print(" __ |");
        }
        System.out.println();
    }
    public void showAllMem()
    {
        showLogicalMem();
        showPhysicalMem();
        showVirtualMem();
    }
    public void showPageFaults()
    {
        System.out.println();
        System.out.println("There were "+ pageFaultCounter+ " page faults");
        System.out.println();
    }







    private void lastTimeAccessesControl(Page searchedPage)
    {
        searchedPage.setLastTimeAccessed(time);
        for (int i = 0; i < physicalMemory.length; i++)
        {
            if(physicalMemory[i]!=null)
            {
                if(searchedPage.getName().equals(physicalMemory[i].getName()))
                {
                    physicalMemory[i].setLastTimeAccessed(time);
                }
            }

        }
    }


    private void assignToPhysical(Page searchedPage)
    {
        searchedPage.setInsertionTime(time);
        searchedPage.setLastTimeAccessed(time);
        searchedPage.setValidBit(true);
        physicalMemory[findEmpty()]=new Page(searchedPage.getName(), searchedPage.isValidBit(), searchedPage.getLastTimeAccessed(), searchedPage.getInsertionTime(), searchedPage.isReferenceBit());
    }

    private void manageVirtual(Page virtualToReplace)
    {
        if(virtualToReplace !=null)
         {
             for (int i = 0; i < virtualMemory.length ; i++)
             {
                 if(virtualMemory[i]!=null)
                 {
                     if(virtualMemory[i].getName().equals(virtualToReplace.getName()))
                         virtualMemory[i]=null;
                 }

             }
         }
    }

    private void swapPhysicalToVirtual(int pageToMoveIndex, Page pageToReplace)
    {
        pageToReplace.setValidBit(false);
        virtualMemory[pageManager.pageTableV(pageToReplace)] =  new Page(pageToReplace.getName(), pageToReplace.isValidBit(), pageToReplace.getLastTimeAccessed(), pageToReplace.getInsertionTime(), pageToReplace.isReferenceBit());
        physicalMemory[pageToMoveIndex]=null;
        FindPage(pageToReplace.getName()).setValidBit(false);
    }


    private boolean isPhysicalFull()
    {
        for (int i = 0; i < physicalMemory.length; i++)
        {
            if(physicalMemory[i]==null)
            {
                return false;
            }
        }
        return true;
    }
    private boolean isPhysicalEmpty()
    {
        for (int i = 0; i < physicalMemory.length; i++)
        {
            if(physicalMemory[i]!=null)
            {
                return false;
            }
        }
        return true;
    }
    private int findEmpty()
    {
        for (int i = 0; i < physicalMemory.length ; i++)
        {
            if(physicalMemory[i]==null)
                return i;

        }
        return -1;
    }
    private Page FindPage(String name)
    {
        for (int i = 0; i < logicalMemory.length; i++)
        {
            if(name.equals(logicalMemory[i].getName()))
            {
                return logicalMemory[i];
            }
        }
        return null;
    }
    private Page FindPageV(String name)
    {
        for (int i = 0; i < virtualMemory.length; i++)
        {
            if(virtualMemory[i]!=null)
            {
                if(name.equals(virtualMemory[i].getName()))
                {
                    return virtualMemory[i];
                }
            }

        }
        return null;
    }



}
