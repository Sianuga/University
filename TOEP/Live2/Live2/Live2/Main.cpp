#include "ComplexNumber.h"
#include <iostream>

int main()
{
	Cmplx cmplx0(2,5),cmplx1(3,4);
	Cmplx cmplx2 = cmplx0 + cmplx1;
	Cmplx cmplx3 = cmplx0 + 3;
	std::cout << cmplx1;
	cmplx0 += cmplx1;
}