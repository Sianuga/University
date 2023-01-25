#include <iostream>
#include "CMySmartPointer.h"
#include <string>
#include "CTab.h"
#include "CTable.h"


void pointerTest()
{
    int* ipoint = new int[3];

    CMySmartPointer<int> point1(ipoint);
    CMySmartPointer<int> point2(point1);
    CMySmartPointer<int> point3(new int[7]);

    point3 = point2;
}

void tableTest()
{
    CTab cTab1, cTab2, cTab3;

    cTab2.bSetSize(5);
    cTab3.bSetSize(7);

    cTab2 = std::move(cTab3);

}

void cTableTest()
{
    CTable tab1("one", 1);
    CTable tab2("two", 2);
    CTable tab3("three", 3);

    CTable tab4;

    tab4 = std::move(tab1 + tab2 + tab3);

}

int main()
{
    tableTest();
    pointerTest();
    cTableTest();

}

