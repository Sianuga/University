#include <iostream>
#include "Allocs.h"
#include "Params.h"
#include "CTable.h"
#include "List1.h"


int main()
{
    int** pTable;

    std::cout << "Exercise 1:" << std::endl;

    allocTableFill34(ARRAYSIZE);

    std::cout << std::endl;

    std::cout << "Exercise 2:" << std::endl;

    alloc2DTable(&pTable, SIZE_X, SIZE_Y);
    printArray(pTable, SIZE_X, SIZE_Y);

    std::cout << std::endl;

    std::cout << "Exercise 3:" << std::endl;
    std::cout << std::endl;

    dealloc2DTable(&pTable, SIZE_X, SIZE_Y);          //sizeY is unnecessary 

    std::cout << "Exercise 4:" << std::endl;

    CTable cTableDef;
    CTable cTable("A",5);
    CTable cTablePCOther(cTable);
    CTable* cTableCopy = cTableDef.pcClone();
  
    cTable.bSetNewSize(7);
    cTable.vSetName("B");

    v_mod_tab(&cTableDef, 10);
    v_mod_tab(cTableDef, 11);

    return 0;
}



