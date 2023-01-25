import java.util.List;

public class List7
{

    public boolean checkIfAsc(int[] list)
    {
        for (int i = 1; i <list.length ; i++)
        {
            if(list[i]<list[i-1]) return false;
        }
        return true;
    }



    public int[] insert(int[] list,int elem)
    {
        boolean foundPlace =false;

        if(list.length==0)
        {
            return new int[]{elem};
        }

        int i=0;

        if(list.length==1)
        {
            if(elem>list[0])
            return new int[]{list[0],elem};
            else
                return new int[]{elem,list[0]};
        }

        boolean isAscending = checkIfAsc(list);

        while(!foundPlace && i<list.length)
        {
            if(!(isAscending ^ (list[i]>=elem)))
            {
                foundPlace=true;
            }
            i++;
        }


        int[] newList = new int[list.length+1];

        for (int j = 0; j < (i); j++)
        {
        newList[j]=list[j];
        }

        if(i==list.length)
        {
        newList[i]=elem;
        return newList;
        }

        newList[i-1]=elem;

        for (int j = i; j <= list.length ; j++)
        {
            newList[j]=list[j-1];
        }

        return newList;
    }



    public static void main(String[] args)
    {
        List7 list = new List7();
        int[] listTest1 = {-1,3,5,7};
        int[] listTest2 = new int[0];
        int[] listTest3 = {5,3,1};
        int[] listTest4 = {1};
        int elem = -4;
        int[] test1 = list.insert(listTest1,elem);
        int[] test2 = list.insert(listTest2,elem);
        int[] test3 = list.insert(listTest3,elem);
        int[] test4 = list.insert(listTest4,elem);
    }
}
