#include <iostream>


int main() {
	struct B { 
	    
		B() {
			std::cout << "c++是啥"<<std::endl;
		}

	};
	struct D : B {
	
	void	V() {
		std::cout << "c++是C它dage" << std::endl;
	}
	};
	D d;
	B& br = d;
	//br.V();//E0135	类 "B" 没有成员 "V"	20	IntelliSense

auto a=	static_cast<D&>(br); // 该左值指代原来的 d 对象

a.V();

}