package Uczelnia;

import Wydarzenia.Obserwator;
import Wyszukiwanie.Wyszukaj;

import java.io.Serializable;

public abstract class Osoba implements Serializable, Obserwator
{
    protected Wyszukaj wyszukaj;
    protected String imie,nazwisko,pesel;
   protected int wiek;
    protected boolean plec;

    public Osoba(String imie, String nazwisko, String pesel, int wiek, boolean plec)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wiek = wiek;
        this.plec = plec;
    }

    public Wyszukaj getWyszukaj()
    {
        return wyszukaj;
    }

    public void setWyszukaj(Wyszukaj wyszukaj)
    {
        this.wyszukaj = wyszukaj;
    }

    public String getImie()
    {
        return imie;
    }

    public void setImie(String imie)
    {
        this.imie = imie;
    }

    public String getNazwisko()
    {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko)
    {
        this.nazwisko = nazwisko;
    }

    public String getPesel()
    {
        return pesel;
    }

    public void setPesel(String pesel)
    {
        this.pesel = pesel;
    }

    public int getWiek()
    {
        return wiek;
    }

    public void setWiek(int wiek)
    {
        this.wiek = wiek;
    }

    public boolean isPlec()
    {
        return plec;
    }

    public void setPlec(boolean plec)
    {
        this.plec = plec;
    }

    abstract public String toString();

}
