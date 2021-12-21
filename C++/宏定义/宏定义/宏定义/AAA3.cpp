#include <iostream>

#include "CCC.h"

#ifdef __cplusplus
extern "C" {
#endif

	void* dddd3() {
		std::cout << "我被定义了3";

		return 0;
	}
	void* dddd4() {
		std::cout << "我被定义了4";
		return 0;
	}

#ifdef __cplusplus
}
#endif
