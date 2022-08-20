package MemoryManagmentUnit;

public class PageManager
{
    int pagesAmount;
    PageManager(int pagesAmount)
    {
        this.pagesAmount=pagesAmount;
    }
public Page[] generate(int pagesNumber)
{
    Page[] pages = new Page[pagesNumber];
    for (int i = 0; i <pagesNumber ; i++)
    {
        pages[i]= new Page("P"+(i+1));
    }
    return pages;
}
public Page[] copy(Page[] pages)
{
    Page[] newPages= new Page[pages.length];
    for (int i = 0; i < pages.length ; i++)
    {
        newPages[i]= new Page(pages[i].getName(),pages[i].isValidBit(),pages[i].getLastTimeAccessed(),pages[i].getInsertionTime(),pages[i].isReferenceBit());
    }
    return newPages;
}
public int pageTableV(Page page)
{
return (page.getName().hashCode())%pagesAmount;
}
}
