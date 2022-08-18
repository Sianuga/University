package Uczelnia;

import Wydarzenia.Wydarzenie;

import java.io.Serializable;

public class PracownikB_D extends PracownikUczelni implements Serializable
{
    protected int dorobekNaukowy;

    public PracownikB_D(String imie, String nazwisko, String pesel, int wiek, boolean plec, String stanowisko, float stazPracy, float pensja, int dorobekNaukowy)
    {
        super(imie, nazwisko, pesel, wiek, plec, stanowisko, stazPracy, pensja);
        this.dorobekNaukowy = dorobekNaukowy;
    }
    public PracownikB_D(Object[] parameterList)
    {
        super((String)parameterList[0], (String)parameterList[1], (String)parameterList[2], (int)parameterList[3], (boolean)parameterList[4], (String) parameterList[5], (float) parameterList[6],(float) parameterList[7]);
        this.dorobekNaukowy = (int) parameterList[8];
    }


    public String toString()
    {
        return
                "PracownikB_D " +
                " imie= " + imie + ' ' +
                " nazwisko= " + nazwisko + ' ' +
                " pesel= " + pesel + ' ' +
                " wiek= " + wiek +
                " plec= " + plec +
                " dorobekNaukowy= " + dorobekNaukowy +
                " stanowisko= " + stanowisko + ' ' +
                " stazPracy= " + stazPracy +
                " pensja= " + pensja;
    }

    public int getDorobekNaukowy()
    {
        return dorobekNaukowy;
    }

    public void setDorobekNaukowy(int dorobekNaukowy)
    {
        this.dorobekNaukowy = dorobekNaukowy;
    }


}
