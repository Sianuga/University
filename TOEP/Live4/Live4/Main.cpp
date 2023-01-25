#include <iostream>
#include <string>
#include <vector>

template <typename T, typename U>
class CDict {
public:
    // Konstruktor domy�lny
    CDict() {}

    // Konstruktor kopiuj�cy
    CDict(const CDict<T, U>& dict) {
        *this = dict;
    }

    // Destruktor
    ~CDict() {}

    // Operator podstawienia
    CDict<T, U>& operator=(const CDict<T, U>& dict) {
        if (this != &dict) {
            index = dict.index;
            values = dict.values;
        }
        return *this;
    }

    // Operator indeksowania
    U& operator[](const T& key) {
        for (int i = 0; i < index.size(); i++) {
            if (index[i] == key) {
                return values[i];
            }
        }
        index.push_back(key);
        values.push_back(U());
        return values[values.size() - 1];
    }

    // Metoda s�u��ca do usuni�cia wszystkich element�w ze s�ownika
    void clear() {
        index.clear();
        values.clear();
    }

private:
    // Wektor przechowuj�cy indeksy
    std::vector<T> index;

    // Wektor przechowuj�cy warto�ci
    std::vector<U> values;
};



int main() {
    CDict<std::string, std::string> dict, dict_copy;

    dict["kot"] = "cat";
    std::cout << dict["kot"] << std::endl; // Wypisze: cat

    dict["kot"] = "dog";
    std::cout << dict["kot"] << std::endl; // Wypisze: dog

    std::cout << dict["pies"] << std::endl; // Wypisze warto�� domy�ln� typu V, w tym wypadku pusty ci�g znak�w

    dict.clear();
    dict_copy = dict;

    CDict<int, double> dict_w;
    dict_w[-1] = 3.45;
    dict_w[10000] = 10.45;

    CDict<char, std::string> dict_i_s;
    dict_i_s['h'] = "pies";

    return 0;
}