#include <iostream>

void add(void* v);

void ff( void (*b)(void* v)  ) {
	(*b)(add);

}

int main() {

	ff(add);

}
void add(void* v) {

	std::cout << "c++ÌìÏÂÎÞµÐ";
}