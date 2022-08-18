package Wyszukiwanie;

import Uczelnia.Kurs;

public class WyszukajKurs implements Wyszukaj
{
    public boolean checkFor(String parametr, Object szukanaInformacja, Object sprawdzanaOsoba)
    {

            switch(parametr)
            {
                case "nazwaKursu":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((Kurs)sprawdzanaOsoba).getNazwaKursu()).equals(szukanaInformacja))
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "imieP":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((Kurs)sprawdzanaOsoba).getImieP()).equals(szukanaInformacja))
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "nazwiskoP":
                    if(szukanaInformacja instanceof String)
                    {
                        if((((Kurs)sprawdzanaOsoba).getNazwiskoP()).equals(szukanaInformacja))
                            return true;
                    }
                    else
                    {
                        System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                    }
                    break;
                case "ects":
                    int searched2 = Integer.parseInt((String)szukanaInformacja);
                        if(((Kurs)sprawdzanaOsoba).getEcts()==(int)searched2)
                            return true;


                    break;
                default:
                {
                    System.out.println("There is no such thing as "+parametr+" to be found in: " + sprawdzanaOsoba.getClass());
                }

            }
            return false;
        }
    }

