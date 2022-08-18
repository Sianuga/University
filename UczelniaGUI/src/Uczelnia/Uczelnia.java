package Uczelnia;

import Wydarzenia.Podmiot;
import Wydarzenia.Wydarzenie;

import javax.swing.*;
import java.io.*;
import java.util.*;


public class Uczelnia implements Serializable, Podmiot
{
    private JTextField wpisywanie;
    private JComboBox wpisywanieWybor;
    private JTextArea outputText;
    private boolean waitingForInput = true;
    private JCheckBox booleanInput;
    private ArrayList<Osoba> osoby;
    private Biblioteka biblioteka;
    private ArrayList<Osoba> obserwatorzy;
    private ArrayList<Wydarzenie> wydarzenia;
    public Uczelnia()
    {
    obserwatorzy= new ArrayList<Osoba>();
    wydarzenia= new ArrayList<Wydarzenie>();
    osoby = new ArrayList<Osoba>(10);
    biblioteka= new Biblioteka();
    }
    public Uczelnia(Biblioteka biblioteka)
    {
        this.biblioteka=biblioteka;
        osoby = new ArrayList<Osoba>(10);
        obserwatorzy= new ArrayList<Osoba>();
        wydarzenia= new ArrayList<Wydarzenie>();
    }
    public Uczelnia(ArrayList<Osoba> osoby, Biblioteka biblioteka)
    {
        this.biblioteka = biblioteka;
        this.osoby=osoby;
        obserwatorzy= new ArrayList<Osoba>();
    }
    public void setWpisywanie(JTextField wpisywanie)
    {
        this.wpisywanie=wpisywanie;
    }
    public void setWpisywanieWybor(JComboBox wpisywanieWybor)
    {
        this.wpisywanieWybor=wpisywanieWybor;
    }
    public void setOutputText(JTextArea t)
    {
        outputText=t;
    }
    public void wyszukajOsobe(String parameter, Object searched,String whichTypeOfPerson)
    {
        int i=0;
        for (Osoba osoba:osoby)
        {
            switch(whichTypeOfPerson)
            {
                case "Student":
                    if(osoba.wyszukaj.checkFor(parameter,searched,osoba)&&(osoba instanceof Student))
                    {
                        if(i==0)
                        {
                            System.out.println("Osoby o wlasnosci " + parameter + " z parametrem " + searched+ " klasy "+ whichTypeOfPerson + " to:");
                            System.out.println(osoba);
                            i++;
                        }
                    }
                    break;
                case "PracownikA":
                    if(osoba.wyszukaj.checkFor(parameter,searched,osoba)&&(osoba instanceof PracownikA))
                    {
                        if(i==0)
                        {
                            System.out.println("Osoby o wlasnosci " + parameter + " z parametrem " + searched +" klasy "+ whichTypeOfPerson + " to:");
                            System.out.println(osoba);
                            i++;
                        }

                    }
                    break;
                case "PracownikB_D":
                    if(osoba.wyszukaj.checkFor(parameter,searched,osoba)&&(osoba instanceof PracownikB_D))
                    {
                        if(i==0)
                        {
                        System.out.println("Osoby o wlasnosci " + parameter + " z parametrem " + searched+  " klasy "+ whichTypeOfPerson +" to:");
                            System.out.println(osoba);
                            i++;
                        }


                    }
                    break;
            }

        }
        if(i==0)
        {
            System.out.println("Brak osob o wlasnosci " + parameter + " z parametrem "+ searched + " klasy "+ whichTypeOfPerson);
        }
        System.out.println();
    }
    public void dodajOsoba(Osoba osoba)
{
    osoby.add(osoba);
}
    public void wpiszOsoba()
    {
        Scanner scanner = new Scanner(wpisywanieWybor.getSelectedItem().toString());
        String personType = scanner.next();
       osoby.add(stworzOsoba(personType));
    }
    private Osoba stworzOsoba(String personType)
    {
        switch(personType)
        {
            case "Student":
               return new Student(daneStudent(biblioteka));

            case "PracownikA":
                return new PracownikA(danePracownikA());


            case "PracownikB_D":
             return new PracownikB_D(danePracownikB_D());
        }
        Osoba a = null;
        return a;
    }
    private Object[] daneStudent(Biblioteka biblioteka)
    {
        String imie,nazwisko,pesel;
        int wiek,liczba_kursow,k;
        boolean plec;
        int indeks,rokStudiow;
        ArrayList<Kurs> listaKursow = new ArrayList<Kurs>(10);
        boolean erasmus,student1St,student2St,studentSS,studentSNS;
        Scanner scanner = new Scanner(wpisywanie.getText());
        imie=JOptionPane.showInputDialog("Podaj imie");
        nazwisko=JOptionPane.showInputDialog("Podaj nazwisko");
        pesel=JOptionPane.showInputDialog("Podaj pesel");
        wiek=Integer.parseInt(JOptionPane.showInputDialog("Podaj wiek"));
        plec=Boolean.parseBoolean(JOptionPane.showInputDialog("Podaj plec"));
        indeks=Integer.parseInt(JOptionPane.showInputDialog("Podaj indeks"));
        liczba_kursow = Integer.parseInt(JOptionPane.showInputDialog("Podaj liczbe kursow"));
        outputText.setText("");
        System.out.println("Wybierz kursy z poniższych, wpisujac kolejno liczby odpowiadajace kursom");
        biblioteka.wyswietlWszystkie();
        for (int i = 0; i <liczba_kursow ; i++)
        {
           k=Integer.parseInt(JOptionPane.showInputDialog(null));;
           listaKursow.add(biblioteka.getKurs(k));
        }
        erasmus=Boolean.parseBoolean(JOptionPane.showInputDialog("Podaj czy erasmus"));

        student1St=Boolean.parseBoolean(JOptionPane.showInputDialog("Podaj czy student1St"));

        student2St=Boolean.parseBoolean(JOptionPane.showInputDialog("Podaj czy student2St"));

        studentSS=Boolean.parseBoolean(JOptionPane.showInputDialog("Podaj czy studentSS"));

        studentSNS=Boolean.parseBoolean(JOptionPane.showInputDialog("Podaj czy studentSNS"));

        rokStudiow= Integer.parseInt(JOptionPane.showInputDialog("Podaj rok studiow"));
        Kurs[] kursy = new Kurs[liczba_kursow];
        listaKursow.toArray(kursy);
        return new Object[]{imie,nazwisko, pesel, wiek,  plec,  indeks,  kursy,  erasmus,  student1St,  student2St,  studentSS, studentSNS, rokStudiow};
    }
    private Object[] danePracownikA()
    {
        Scanner scanner = new Scanner(wpisywanie.getText());
        String imie,nazwisko,pesel,stanowisko;
        int wiek;
        boolean plec;
       float pensja,stazPracy,liczbaNadgodzin;
        imie=JOptionPane.showInputDialog("Podaj imie");
        nazwisko=JOptionPane.showInputDialog("Podaj nazwisko");
        pesel=JOptionPane.showInputDialog("Podaj pesel");
        wiek=Integer.parseInt(JOptionPane.showInputDialog("Podaj wiek"));
        plec=Boolean.parseBoolean(JOptionPane.showInputDialog("Podaj plec"));
        stanowisko=JOptionPane.showInputDialog("Podaj stanowisko");
        stazPracy=Float.parseFloat(JOptionPane.showInputDialog("Podaj stazPracy"));
        pensja=Float.parseFloat(JOptionPane.showInputDialog("Podaj pensja"));
        liczbaNadgodzin=Float.parseFloat(JOptionPane.showInputDialog("Podaj liczbaNadgodzin"));
        return new Object[]{imie,nazwisko, pesel, wiek,  plec, stanowisko,stazPracy,pensja,liczbaNadgodzin};

    }
    private Object[] danePracownikB_D()
    {
        Scanner scanner = new Scanner(wpisywanie.getText());
        String imie,nazwisko,pesel,stanowisko;
        int wiek,dorobekNaukowy;
        boolean plec;
        float pensja,stazPracy;
        imie=JOptionPane.showInputDialog("Podaj imie");
        nazwisko=JOptionPane.showInputDialog("Podaj nazwisko");
        pesel=JOptionPane.showInputDialog("Podaj pesel");
        wiek=Integer.parseInt(JOptionPane.showInputDialog("Podaj wiek"));
        plec=Boolean.parseBoolean(JOptionPane.showInputDialog("Podaj plec"));
        stanowisko=JOptionPane.showInputDialog("Podaj stanowisko");
        stazPracy=Float.parseFloat(JOptionPane.showInputDialog("Podaj stazPracy"));
        pensja=Float.parseFloat(JOptionPane.showInputDialog("Podaj pensja"));
        dorobekNaukowy=Integer.parseInt(JOptionPane.showInputDialog("Podaj dorobekNaukowy"));
        return new Object[]{imie,nazwisko, pesel, wiek,  plec, stanowisko,stazPracy,pensja,dorobekNaukowy};
    }
    public void usunOsoba(String parameter, Object searched, String whichTypeOfPerson)
    {
        int i = 0,index=0;
        for (Osoba osoba : osoby)
        {
            switch (whichTypeOfPerson)
            {
                case "Student":
                    if (osoba.wyszukaj.checkFor(parameter, searched, osoba) && (osoba instanceof Student))
                    {
                        if (i == 0)
                        {

                            index=osoby.indexOf(osoba);
                            i++;
                        }

                    }
                    break;
                case "PracownikA":
                    if (osoba.wyszukaj.checkFor(parameter, searched, osoba) && (osoba instanceof PracownikA))
                    {
                        if (i == 0)
                        {

                            index=osoby.indexOf(osoba);
                            i++;
                        }
                    }
                    break;
                case "PracownikB_D":
                    if (osoba.wyszukaj.checkFor(parameter, searched, osoba) && (osoba instanceof Student))
                    {
                        if (i == 0)
                        {

                            index = osoby.indexOf(osoba);
                            i++;
                        }
                    }
                    break;
            }
        }
        if(i==1)
        {
            osoby.remove(index);
            System.out.println("Osoba o wlasnosci " + parameter + " z parametrem " + searched + " klasy " + whichTypeOfPerson + " zostala usunieta");
        }
        else
        {

        }

    }
    public void wyswietlWszystkie(String whichTypeOfPerson)
    {
        System.out.println("Wszystkie osoby" + " klasy "+ whichTypeOfPerson + " to:");
        for (Osoba osoba:osoby)
        {
            switch(whichTypeOfPerson)
            {
                case "Student":
                    if(osoba instanceof Student)  System.out.println(osoba.toString());
                    break;
                case "PracownikA":
                    if(osoba instanceof PracownikA) System.out.println(osoba.toString());
                    break;
                case "PracownikB_D":
                    if(osoba instanceof PracownikB_D)  System.out.println(osoba.toString());
                    break;
            }
        }
        System.out.println();
    }
    public void wyswietlWszystkie()
    {
        System.out.println("Wszystkie osoby to:");
        for (Osoba osoba:osoby)
        {
            System.out.println(osoba.toString());
        }
        System.out.println();
    }
    public void zapiszDoPliku(String nazwaPliku)
    {
        try{

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nazwaPliku));
            out.writeObject(this);
            out.close();

        } catch(IOException e)
        {
            System.out.println("AAAAAA");
        }
    }
    public void wczytajZPliku(String nazwaPliku)
    {
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nazwaPliku));
            Uczelnia u = (Uczelnia) in.readObject();
            in.close();
           this.biblioteka=u.biblioteka;
          this.osoby=u.osoby;
          this.wydarzenia=u.wydarzenia;
          this.obserwatorzy=u.obserwatorzy;

        } catch (IOException | ClassNotFoundException e)
        {
            System.out.println("AAAAA");
        }
    }
    public void posortujWedlug(String typComparator)
    {

        switch (typComparator)
        {
            case "nazwisko":
                Collections.sort(osoby,(o1,o2)-> (o1.getNazwisko()).compareTo(o2.getNazwisko()));
                break;
            case "nazwiskoImie":
                Collections.sort(osoby,(o1,o2)->
                {

                    if(o1.getNazwisko().compareTo(o2.getNazwisko())==0)
                    {
                        return (o1.getImie()).compareTo(o2.getImie());
                    }
                    else
                        return o1.getNazwisko().compareTo(o2.getNazwisko());
                });
                break;
            case "nazwiskoWiek":
                Collections.sort(osoby,(o1, o2) ->
                        {
                            if(o1.getNazwisko().compareTo(o2.getNazwisko())==0)
                            {
                                    return o2.getWiek()-o1.getWiek();
                            }
                            else
                                return o1.getNazwisko().compareTo(o2.getNazwisko());

                        }
                        );
                break;
        }
    }
    public void usunDuplikaty()
    {
       /* HashSet<PracownikUczelni> p = new HashSet<PracownikUczelni>();
        HashSet<Student> s = new HashSet<Student>();
        for(Osoba osoba:osoby)
        {
            if(osoba instanceof PracownikUczelni)
            {
                p.add((PracownikUczelni) osoba);
            }
            if(osoba instanceof Student)
            {
                s.add((Student) osoba);
            }
        }
           osoby.clear();
            osoby.addAll(p);
            osoby.addAll(s);*/
        osoby = new ArrayList<Osoba>(new HashSet<Osoba>(osoby));
    }

    public void dodajObserwatora(Object o)
    {
        obserwatorzy.add((Osoba)o);
    }
    public void usunObserwatora(Object o)
    {
        obserwatorzy.remove(o);
    }
    public void powiadomObserwatorow()
    {
        for(Osoba osoba:obserwatorzy)
        {
        osoba.aktualizuj(wydarzenia.get(wydarzenia.size()-1));
        }
    }
    public void dodajWydarzenie(Wydarzenie w)
    {
    wydarzenia.add(w);
    powiadomObserwatorow();
    }
    public void wyswietlWydarzenia()
    {
        for(Wydarzenie w: wydarzenia)
        {
            System.out.println(w);
        }
    }
    public void wyswietlObserwatorow()
    {
        for(Osoba w: obserwatorzy)
        {
            System.out.println(w);
        }
    }



    public Biblioteka getBiblioteka()
    {
        return biblioteka;
    }
    public void setBiblioteka(Biblioteka biblioteka)
    {
        this.biblioteka=biblioteka;
    }
}
