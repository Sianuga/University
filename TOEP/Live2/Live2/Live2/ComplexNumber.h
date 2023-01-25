#include <iostream>
class Cmplx
{
private:
	double _re, _im;

public:

	Cmplx(double re, double im);
	~Cmplx();
	Cmplx operator+(const Cmplx& cmplxOther);
	Cmplx operator+(const double& cmplxOther);
	void operator+=(const Cmplx& cmplxOther);
	friend std::ostream& operator<<(std::ostream& os, const Cmplx& cmplxOther);

};