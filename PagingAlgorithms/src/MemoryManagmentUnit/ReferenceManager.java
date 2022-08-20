package MemoryManagmentUnit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ReferenceManager
{

    public ReferenceManager()
    {

    }
    public ArrayList<Reference> generate(int amount,int pageNumber)
    {
        ArrayList<Reference> references = new ArrayList<Reference>();

        int time=1;
        String name;
        Random rand = new Random();
        Queue<String> lastUsed = new LinkedList<String>();
        references.add(new Reference(time,"P"+rand.nextInt(1,pageNumber)));
        lastUsed.add("P"+rand.nextInt(1,pageNumber));
        String lastOne= lastUsed.peek();
        int startIndex,randomizer;

        for (int i = 1; i <amount ; i++)
        {
            time++;

            if(rand.nextInt(1,100)<=30)
            {
                name=lastUsed.peek();
                lastOne=lastUsed.peek();
                lastUsed.add(lastUsed.peek());
            }
            else
            {
                startIndex= Integer.parseInt(lastOne.substring(1)) ;
                if(rand.nextInt(1,100)<=30)
                {
                    if(rand.nextBoolean())
                    {
                        if(startIndex+1<pageNumber)
                        startIndex++;
                        else
                            startIndex--;
                    }
                    else
                    {
                        if(startIndex-1>1)
                        startIndex--;
                        else
                            startIndex++;
                    }



                }
                else
                {
                    randomizer=rand.nextInt(-(startIndex-1),pageNumber-startIndex);
                    startIndex+= randomizer  ;

                }
               name="P"+startIndex;
                lastOne="P"+ startIndex;
                lastUsed.add(lastOne);

            }
            references.add(new Reference(time,name));

            if(lastUsed.size()>3)
            {
                lastUsed.remove();
            }
        }
        return references;
    }
    public ArrayList<Reference> copy(ArrayList<Reference> references)
    {
        ArrayList<Reference> refs = new ArrayList<Reference>();
        for (Reference reference: references)
        {
            refs.add(new Reference(reference.getReferenceTime(),reference.getPageName()));
        }

        return refs;
    }





}
