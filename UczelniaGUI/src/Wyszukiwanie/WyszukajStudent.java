package Wyszukiwanie;

import Uczelnia.Student;

public class WyszukajStudent implements Wyszukaj
{

    public boolean checkFor(String parametr, Object szukanaInformacja,Object sprawdzanaOsoba)
    {
        int szukanaInformacjaTekst;
        switch(parametr)
        {
            case "nazwisko":
                if(szukanaInformacja instanceof String)
                {
                    if((((Student)sprawdzanaOsoba).getNazwisko()).equals((String)szukanaInformacja))
                return true;
                }
                else
                {
                    System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                }
                break;
            case "imie":
                if(szukanaInformacja instanceof String)
                {
                    if((((Student)sprawdzanaOsoba).getImie()).equals((String)szukanaInformacja))
                        return true;
                }
                else
                {
                    System.out.println("Parameter "+ szukanaInformacja +" is not valid type");
                }
                break;
            case "indeks":
                szukanaInformacjaTekst =Integer.parseInt((String)szukanaInformacja);
                    if(((Student)sprawdzanaOsoba).getIndeks()==(int)szukanaInformacjaTekst)
                        return true;


                break;
                case "wiek":
                    szukanaInformacjaTekst =Integer.parseInt((String)szukanaInformacja);
                        if(((Student)sprawdzanaOsoba).getWiek()==(int)szukanaInformacjaTekst)
                            return true;

                break;
            case "rokStudiow":
                szukanaInformacjaTekst =Integer.parseInt((String)szukanaInformacja);
                    if(((Student)sprawdzanaOsoba).getRokStudiow()==(int)szukanaInformacjaTekst)
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
