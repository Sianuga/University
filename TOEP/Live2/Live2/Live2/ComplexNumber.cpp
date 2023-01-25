#include "ComplexNumber.h"


	Cmplx::Cmplx(double re, double im)
	{
		_re = re;
		_im = im;
	}
	Cmplx::~Cmplx()
	{

	}
	Cmplx Cmplx::operator+(const Cmplx& cmplxOther)
	{
		return Cmplx(_re + cmplxOther._re, _im + cmplxOther._im);
	}
	Cmplx Cmplx::operator+(const double& cmplxOther)
	{
		return Cmplx(_re + cmplxOther, _im);
	}

	void Cmplx::operator+=(const Cmplx& cmplxOther)
	{
		_re += cmplxOther._re;
		_im += cmplxOther._im;
	}

	std::ostream& operator<<(std::ostream& os, const Cmplx& cmplxOther)
	{
		os << cmplxOther._re << '+' << cmplxOther._im;
		return os;
	}
