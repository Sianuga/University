package Uczelnia;

import Wydarzenia.Wydarzenie;

import java.io.Serializable;

public class PracownikA extends PracownikUczelni implements Serializable
{
    protected float liczbaNadgodzin;

    public PracownikA(String imie, String nazwisko, String pesel, int wiek, boolean plec, String stanowisko, float stazPracy, float pensja, float liczbaNadgodzin)
    {
        super(imie, nazwisko, pesel, wiek, plec, stanowisko, stazPracy, pensja);
        this.liczbaNadgodzin = liczbaNadgodzin;
    }
    public PracownikA(Object[] parameterList)
    {
        super((String)parameterList[0], (String)parameterList[1], (String)parameterList[2], (int)parameterList[3], (boolean)parameterList[4], (String) parameterList[5], (float) parameterList[6],(float) parameterList[7]);
        this.liczbaNadgodzin = (float) parameterList[8];
    }

    public float getLiczbaNadgodzin()
    {
        return liczbaNadgodzin;
    }

    public void setLiczbaNadgodzin(float liczbaNadgodzin)
    {
        this.liczbaNadgodzin = liczbaNadgodzin;
    }

    public String toString()
    {
        return
                "PracownikA " +
                " imie= " + imie + ' ' +
                " nazwisko= " + nazwisko + ' ' +
                " pesel= " + pesel + ' ' +
                " wiek= " + wiek +
                " plec= " + plec +
                " liczbaNadgodzin= " + liczbaNadgodzin +
                " stanowisko= " + stanowisko + ' ' +
                " stazPracy= " + stazPracy +
                " pensja= " + pensja;
    }


}
