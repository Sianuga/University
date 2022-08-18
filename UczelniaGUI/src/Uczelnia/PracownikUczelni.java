package Uczelnia;

import Wydarzenia.Wydarzenie;
import Wyszukiwanie.WyszukajPracownik;

import java.io.Serializable;
import java.util.Objects;

public abstract class PracownikUczelni extends Osoba implements Serializable
{
protected String stanowisko;
protected float stazPracy,pensja;

    public PracownikUczelni(String imie, String nazwisko, String pesel, int wiek, boolean plec, String stanowisko, float stazPracy, float pensja)
    {
        super(imie, nazwisko, pesel, wiek, plec);
        this.stanowisko = stanowisko;
        this.stazPracy = stazPracy;
        this.pensja = pensja;
        wyszukaj = new WyszukajPracownik();
    }

    public PracownikUczelni(Object[] parameterList)
    {
            super((String)parameterList[0], (String)parameterList[1], (String)parameterList[2], (int)parameterList[3], (boolean)parameterList[4]);
        this.stanowisko = (String)parameterList[5];
        this.stazPracy = (float)parameterList[6];
        this.pensja =(float) parameterList[7];
    wyszukaj = new WyszukajPracownik();
    }


    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return false;
        PracownikUczelni that = (PracownikUczelni) o;
        return that.pesel.equals(pesel);
    }


    public int hashCode()
    {
        return Objects.hash(pesel);
    }

    abstract public String toString();

    public String getStanowisko()
    {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko)
    {
        this.stanowisko = stanowisko;
    }

    public float getStazPracy()
    {
        return stazPracy;
    }

    public void setStazPracy(float stazPracy)
    {
        this.stazPracy = stazPracy;
    }

    public float getPensja()
    {
        return pensja;
    }

    public void setPensja(float pensja)
    {
        this.pensja = pensja;
    }


    public void aktualizuj(Wydarzenie w)
    {
    if(w.getTyp().equals("P") || w.getTyp().equals("W"))
    {
        System.out.println("Pracownik o peselu " + pesel +" poinformowany o nowym wydarzeniu "+ w);
    }
    }
}
