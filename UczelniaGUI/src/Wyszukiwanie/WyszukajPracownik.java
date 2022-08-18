package Wyszukiwanie;

import Uczelnia.PracownikA;
import Uczelnia.PracownikB_D;

public class WyszukajPracownik implements Wyszukaj
{

    public boolean checkFor(String parametr, Object szukanaInformacja, Object sprawdzanaOsoba)
    {
        int szukanaInformacjaLiczba;
        float szukanaInformacjaZmiennoP;
        if(sprawdzanaOsoba instanceof PracownikA)
        {
            switch(parametr)
            {
                case "imie":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((PracownikA)sprawdzanaOsoba).getImie()).equals(szukanaInformacja))
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "nazwisko":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((PracownikA)sprawdzanaOsoba).getNazwisko()).equals(szukanaInformacja))
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "pesel":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((PracownikA)sprawdzanaOsoba).getPesel()).equals(szukanaInformacja))
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "wiek":
                    szukanaInformacjaLiczba =Integer.parseInt((String)szukanaInformacja);
                        if(((PracownikA)sprawdzanaOsoba).getWiek()==(int)szukanaInformacjaLiczba)
                            return true;

                    break;
                    case "plec":
                    if(szukanaInformacja instanceof Boolean)
                    {
                        if(((PracownikA)sprawdzanaOsoba).isPlec()==(boolean)szukanaInformacja)
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "liczbaNadgodzin":
                    szukanaInformacjaLiczba =Integer.parseInt((String)szukanaInformacja);
                        if(((PracownikA)sprawdzanaOsoba).getLiczbaNadgodzin()==(int)szukanaInformacjaLiczba)
                            return true;

                    break;
                case "stanowisko":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((PracownikA)sprawdzanaOsoba).getStanowisko()).equals(szukanaInformacja))
                        return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                    case "stazPracy":
                        szukanaInformacjaZmiennoP =Float.parseFloat((String)szukanaInformacja);
                        if(((PracownikA)sprawdzanaOsoba).getStazPracy()==(float)szukanaInformacjaZmiennoP)
                        return true;


                    break;
                    case "pensja":
                        szukanaInformacjaZmiennoP =Float.parseFloat((String)szukanaInformacja);
                        if(((PracownikA)sprawdzanaOsoba).getPensja()==(float)szukanaInformacjaZmiennoP)
                        return true;
                    break;
                default:
                {
                    System.out.println("There is no such thing as "+parametr+" to be found in: " + sprawdzanaOsoba.getClass());
                }

            }
        }
        else if(sprawdzanaOsoba instanceof PracownikB_D)
        {
            switch(parametr)
            {
                case "imie":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((PracownikB_D)sprawdzanaOsoba).getImie()).equals(szukanaInformacja))
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "nazwisko":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((PracownikB_D)sprawdzanaOsoba).getNazwisko()).equals(szukanaInformacja))
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "pesel":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((PracownikB_D)sprawdzanaOsoba).getPesel()).equals(szukanaInformacja))
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "wiek":
                    if(szukanaInformacja instanceof Integer)
                    {
                        if(((PracownikB_D)sprawdzanaOsoba).getWiek()==(int)szukanaInformacja)
                            return true;
                    }
                    break;
                case "plec":
                    if(szukanaInformacja instanceof Boolean)
                    {
                        if(((PracownikB_D)sprawdzanaOsoba).isPlec()==(boolean)szukanaInformacja)
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "dorobekNaukowy":
                    if(szukanaInformacja instanceof Integer)
                    {
                        if(((PracownikB_D)sprawdzanaOsoba).getDorobekNaukowy()==(int)szukanaInformacja)
                            return true;
                    }

                    break;
                case "stanowisko":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((PracownikB_D)sprawdzanaOsoba).getStanowisko()).equals(szukanaInformacja))
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "stazPracy":
                    if(szukanaInformacja instanceof Float)
                    {
                        if(((PracownikB_D)sprawdzanaOsoba).getStazPracy()==(float)szukanaInformacja)
                            return true;
                    }

                    break;
                case "pensja":
                    if(szukanaInformacja instanceof Float)
                    {
                        if(((PracownikB_D)sprawdzanaOsoba).getPensja()==(float)szukanaInformacja)
                            return true;
                    }

                    break;
                default:
                {
                    System.out.println("There is no such thing as "+parametr+" to be found in: " + sprawdzanaOsoba.getClass());
                }
            }
        }

        return false;
    }
    }

