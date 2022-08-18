package Wydarzenia;

import java.io.Serializable;

public class Wydarzenie implements Serializable
{
    String nazwa,typ;
    static int i=0;
    int ID;

    public String toString()
    {
        return "Wydarzenie{" +
                "nazwa='" + nazwa + '\'' +
                ", ID=" + ID +
                '}';
    }

    public String getTyp()
    {
        return typ;
    }

    public Wydarzenie(String nazwa, String typ)
    {
        this.nazwa = nazwa;
        this.typ = typ;
        this.ID=i++;
    }
}
