package MemoryManagmentUnit;

public class Page
{
    String name;
    boolean validBit=false,referenceBit=false;
    int lastTimeAccessed,insertionTime;
    Page(String name)
    {
        this.name=name;
    }
    public Page(String name, boolean validBit, int lastTimeAccessed, int insertionTime, boolean referenceBit)
    {
        this.name=name;
        this.validBit=validBit;
        this.lastTimeAccessed=lastTimeAccessed;
        this.insertionTime=insertionTime;
        this.referenceBit=referenceBit;
    }



    public boolean isReferenceBit()
    {
        return referenceBit;
    }



    public void setReferenceBit(boolean referenceBit)
    {
        this.referenceBit = referenceBit;
    }

    public void setValidBit(boolean validBit)
    {
        this.validBit = validBit;
    }

    public boolean isValidBit()
    {
        return validBit;
    }

    public String getName()
    {
        return name;
    }

    public int getLastTimeAccessed()
    {
        return lastTimeAccessed;
    }

    public int getInsertionTime()
    {
        return insertionTime;
    }

    public void setInsertionTime(int insertionTime)
    {
        this.insertionTime = insertionTime;
    }

    public void setLastTimeAccessed(int lastTimeAccessed)
    {
        this.lastTimeAccessed = lastTimeAccessed;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return name.equals(page.getName());
    }


}
