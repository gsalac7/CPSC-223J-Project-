#include <iostream>

using namespace std;

int main() {
	short n = 20, m = 6, shortProd, shortQuo, shortRem;
	int a = 10, b = 3, intProd = 5, intQuo, intRem;

	_asm {
		mov			ax, m;
		imul		n;
		mov			shortProd, ax;

		mov			ax, m;
		cwd;
		idiv		n;
		mov			shortQuo, ax;
		mov			shortRem, dx;

		mov			eax, a;
		imul		eax, b;
		mov			intProd, eax;

		mov			eax, a;
		cdq;
		idiv		b;
		mov			intQuo, eax;
		mov			intRem, edx;

	}

	cout << m << " * " << n << " = " << shortProd << endl;
	cout << m << " / " << n << " = " << shortQuo << endl;
	cout << m << " % " << n << " = " << shortRem << endl;

	cout << a << " * " << n << " = " << intProd << endl;
	cout << a << " / " << n << " = " << intQuo << endl;
	cout << a << " % " << n << " = " << intRem << endl;

	return 0;

}