package Uczelnia;

import Wyszukiwanie.Wyszukaj;
import Wyszukiwanie.WyszukajKurs;

import java.io.Serializable;

public class Kurs implements Serializable
{
    Wyszukaj wyszukaj;
    private String nazwaKursu;
    private String imieP,nazwiskoP;
    private int ects;

    public Kurs(String nazwaKursu, String imieP, String nazwiskoP, int ects)
    {
        this.nazwaKursu = nazwaKursu;
        this.imieP = imieP;
        this.nazwiskoP = nazwiskoP;
        this.ects = ects;
        wyszukaj = new WyszukajKurs();
    }

    public Kurs(Object[] parameterList)
    {
        this.nazwaKursu = (String)parameterList[0];
        this.imieP = (String)parameterList[1];
        this.nazwiskoP = (String)parameterList[2];
        this.ects = (int)parameterList[3];
        wyszukaj = new WyszukajKurs();
    }


    public Wyszukaj getWyszukiwanie()
    {
        return wyszukaj;
    }

    public void setWyszukiwanie(Wyszukaj wyszukiwanie)
    {
        this.wyszukaj = wyszukiwanie;
    }

    public String getNazwaKursu()
    {
        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu)
    {
        this.nazwaKursu = nazwaKursu;
    }

    public String getImieP()
    {
        return imieP;
    }

    public void setImieP(String imieP)
    {
        this.imieP = imieP;
    }

    public String getNazwiskoP()
    {
        return nazwiskoP;
    }

    public void setNazwiskoP(String nazwiskoP)
    {
        this.nazwiskoP = nazwiskoP;
    }

    public int getEcts()
    {
        return ects;
    }

    public void setEcts(int ects)
    {
        this.ects = ects;
    }


    public String toString()
    {
        return
                " nazwaKursu= " + nazwaKursu + ' ' +
                " imieP= " + imieP + ' ' +
                " nazwiskoP= " + nazwiskoP + ' ' +
                " ects= " + ects;
    }

}
