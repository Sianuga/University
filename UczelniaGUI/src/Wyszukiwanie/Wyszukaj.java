package Wyszukiwanie;

import java.io.Serializable;

public interface Wyszukaj extends Serializable
{
    public boolean checkFor(String parametr, Object szukanaInformacja, Object sprawdzanaOsoba);
}
