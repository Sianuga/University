package Uczelnia;

import Wydarzenia.Wydarzenie;
import Wyszukiwanie.WyszukajStudent;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Osoba
{
    protected int indeks,rokStudiow;
    protected Kurs[] listaKursow;
    protected boolean erasmus,student1St,student2St,studentSS,studentSNS;

    public Student(String imie, String nazwisko, String pesel, int wiek, boolean plec, int indeks, Kurs[] listaKursow, boolean erasmus, boolean student1St, boolean student2St, boolean studentSS, boolean studentSNS, int rokStudiow)
    {
        super(imie, nazwisko, pesel, wiek, plec);
        this.indeks = indeks;
        this.listaKursow = listaKursow;
        this.erasmus = erasmus;
        this.student1St = student1St;
        this.student2St = student2St;
        this.studentSS = studentSS;
        this.studentSNS = studentSNS;
        this.rokStudiow=rokStudiow;
        wyszukaj = new WyszukajStudent();
    }
    public Student(Object[] parameterList)
    {
        super((String)parameterList[0], (String)parameterList[1], (String)parameterList[2], (int)parameterList[3], (boolean)parameterList[4]);
        this.indeks = (int)parameterList[5];
        this.listaKursow = (Kurs[])parameterList[6];
        this.erasmus = (boolean)parameterList[7];
        this.student1St = (boolean)parameterList[8];
        this.student2St = (boolean)parameterList[9];
        this.studentSS = (boolean)parameterList[10];
        this.studentSNS = (boolean)parameterList[11];
        this.rokStudiow=(int)parameterList[12];
        wyszukaj = new WyszukajStudent();
    }

    public int getIndeks()
    {
        return indeks;
    }

    public void setIndeks(int indeks)
    {
        this.indeks = indeks;
    }

    public int getRokStudiow()
    {
        return rokStudiow;
    }

    public void setRokStudiow(int rokStudiow)
    {
        this.rokStudiow = rokStudiow;
    }

    public Kurs[] getListaKursow()
    {
        return listaKursow;
    }

    public void setListaKursow(Kurs[] listaKursow)
    {
        this.listaKursow = listaKursow;
    }

    public boolean isErasmus()
    {
        return erasmus;
    }

    public void setErasmus(boolean erasmus)
    {
        this.erasmus = erasmus;
    }

    public boolean isStudent1St()
    {
        return student1St;
    }

    public void setStudent1St(boolean student1St)
    {
        this.student1St = student1St;
    }

    public boolean isStudent2St()
    {
        return student2St;
    }

    public void setStudent2St(boolean student2St)
    {
        this.student2St = student2St;
    }

    public boolean isStudentSS()
    {
        return studentSS;
    }

    public void setStudentSS(boolean studentSS)
    {
        this.studentSS = studentSS;
    }

    public boolean isStudentSNS()
    {
        return studentSNS;
    }

    public void setStudentSNS(boolean studentSNS)
    {
        this.studentSNS = studentSNS;
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return indeks == student.indeks;
    }

    public int hashCode()
    {
        return Objects.hash(indeks);
    }

    public String toString()
    {
        return
                "imie= " + imie + ' ' +
                " nazwisko= " + nazwisko + ' ' +
                " pesel= " + pesel + ' ' +
                " wiek= " + wiek +
                " plec= " + plec +
                " indeks= " + indeks +
                " rokStudiow= " + rokStudiow +
                " listaKursow= " +  Arrays.toString(listaKursow) +
                " erasmus= " + erasmus +
                " student1St= " + student1St +
                " student2St= " + student2St +
                " studentSS= " + studentSS +
                " studentSNS= " + studentSNS ;
    }


    public void aktualizuj(Wydarzenie w)
    {
        if(w.getTyp()=="S"|| w.getTyp().equals("W"))
        {
            System.out.println("Student o peselu " + pesel +" poinformowany o nowym wydarzeniu "+ w);
        }

    }
}
