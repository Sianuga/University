#include <iostream>
#include "CTable.h"




int main()
{
	CTable cTable0("A",6), cTable1;



	// Exercise 1 crashes because after using "=" operator, 
	// both objects point to the same array, thus if we consider
	// that destructors are called in reverse order (1st created, last to destroy)
	// cTable1 deletes any remnants of array both of them pointed at
	// and then cTable0 destructor is called and tries to delete something
	// that does not exist
	
	//cTable0.bSetNewSize(6);
	//cTable1.bSetNewSize(4);
	//cTable0 = cTable1;

	// Exercise 2, after former explanation if we comment/delete destructor or simply
	// the line that deletes the pointer of an array, the programme will proceed successfully,
	// however we will have a data leak

	// Exercise 3

	cTable0.vSetValueAt(0, 1);
	cTable0.vSetValueAt(1, 2);
	cTable0.vSetValueAt(2, 3);
	cTable0.vSetValueAt(3, 4);
	cTable0.vSetValueAt(4, 5);
	cTable0.vSetValueAt(5, 6);

	cTable0.vPrint();

	cTable1.vSetValueAt(0, 51);
	cTable1.vSetValueAt(1, 52);
	cTable1.vSetValueAt(2, 53);
	cTable1.vSetValueAt(3, 54);

	cTable1.vPrint();

	CTable cTable2 = cTable0 + cTable1 +cTable0;
	cTable2.vPrint();

	return 0;
}