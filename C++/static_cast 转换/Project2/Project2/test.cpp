#include <iostream>


int main() {
	struct B { 
	    
		B() {
			std::cout << "c++��ɶ"<<std::endl;
		}

	};
	struct D : B {
	
	void	V() {
		std::cout << "c++��C��dage" << std::endl;
	}
	};
	D d;
	B& br = d;
	//br.V();//E0135	�� "B" û�г�Ա "V"	20	IntelliSense

auto a=	static_cast<D&>(br); // ����ֵָ��ԭ���� d ����

a.V();

}