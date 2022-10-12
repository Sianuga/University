#include <iostream>
#include "Allocs.h"
#include "Params.h"


int main()
{
    int** pTable;

    std::cout << "Exercise 1:" << std::endl;
    allocTableFill34(arraySize);

    std::cout << "Exercise 2:" << std::endl;
    alloc2DTable(pTable, sizeX, sizeY);

 /*   for (int i = 0; i < sizeX; i++)
    {
        for (int j = 0; j < sizeY; j++)
        {
            pTable[i][j] = i;
            std::cout << pTable[i][j];
        }
        std::cout << std::endl;
    }*/

    std::cout << "Exercise 3:" << std::endl;
    dealloc2DTable(pTable, sizeX, sizeY);          //sizeY is unnecessary 


    std::cout << "Exercise 4:" << std::endl;


    return 0;
}

