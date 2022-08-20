package MemoryManagmentUnit;

public class Reference
{
private int referenceTime;
private String pageName;
public Reference(int referenceTime, String pageName)
{
    this.referenceTime=referenceTime;
    this.pageName=pageName;
}

    public int getReferenceTime()
    {
        return referenceTime;
    }

    public String getPageName()
    {
        return pageName;
    }

    public void setPageName(String pageName)
    {
        this.pageName = pageName;
    }

    public void setReferenceTime(int referenceTime)
    {
        this.referenceTime = referenceTime;
    }
}
