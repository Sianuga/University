package Uczelnia;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Biblioteka implements Serializable
{
    private ArrayList<Kurs> kursy;

    public Biblioteka(ArrayList<Kurs> kursy)
    {
        this.kursy = kursy;
    }
    public Biblioteka()
    {
        kursy = new ArrayList<Kurs>(10);
    }
    public void dodajKurs(Kurs kurs)
    {
        kursy.add(kurs);
    }
    public void usunKurs(String parameter, Object searched)
    {
        int i=0,index=0;
        for(Kurs kurs:kursy)
        {
            if(kurs.wyszukaj.checkFor(parameter,searched,kurs)&&(i==0))
            {
                index=kursy.indexOf(kurs);
                i++;
            }
        }
        if(i==1)
        {
            kursy.remove(index);
            System.out.println("Kurs usuniety");
        }

    }
    public void wyszukajKurs(String parameter, Object searched)
    {
        int i=0;
        for (Kurs kurs:kursy)
        {
            if(kurs.wyszukaj.checkFor(parameter,searched,kurs))
            {
                if(i==0)   System.out.println("Kursy o wlasnosci " + parameter + " z parametrem " + searched+ " to:");
                System.out.println(kurs.toString());
                i++;
            }
        }
        if(i==0)
        {
            System.out.println("Brak kursow o wlasnosci " + parameter + " z parametrem "+ searched );
        }
        System.out.println();
    }
    public void wyswietlWszystkie()
    {
        int i=1;
        System.out.println("Wszystkie kursy to:");
        for (Kurs kurs:kursy)
        {
                    System.out.println(i++ + kurs.toString());
        }
        System.out.println();
    }
    public Kurs getKurs(int k)
    {
        return kursy.get(k-1);
    }
    public void stworzKurs()
    {
        kursy.add(new Kurs(daneKurs()));
    }
    public Object[] daneKurs()
    {
    Scanner scanner = new Scanner(System.in);
    String imieP,nazwiskoP,nazwaKursu;
            int ects;
        nazwaKursu= JOptionPane.showInputDialog("Podaj nazwaKursu");
        imieP=JOptionPane.showInputDialog("Podaj imieP");
        nazwiskoP=JOptionPane.showInputDialog("Podaj nazwiskoP");
        ects=Integer.parseInt(JOptionPane.showInputDialog("Podaj ects"));
        return new Object[]{nazwaKursu,imieP,nazwiskoP,ects};
    }
    public void posortujWedlug(String typComparator)
    {

        switch (typComparator)
        {
            case "ects":
                Collections.sort(kursy,(k1, k2)-> k2.getEcts()-k1.getEcts());
                break;
            case "nazwiskoP":
                Collections.sort(kursy,(k1,k2)-> k1.getNazwiskoP().compareTo(k2.getNazwiskoP()));

        }
    }
}
