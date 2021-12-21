#include <iostream>
// 必须的头文件
#include <pthread.h>



#define NUM_THREADS 5

// 线程的运行函数
void * say_hello(void *pVoid)
{
    using namespace std;
    std::cout << "在线程里运行！";
    return nullptr;
}

int main()
{
    // 定义线程的 id 变量，多个变量使用数组
    pthread_t tIDs[NUM_THREADS];

    for(auto & tID : tIDs)
    {

        //参数依次是：创建的线程id，线程参数，调用的函数，传入的函数参数
        int ret = pthread_create(&tID, nullptr, say_hello, nullptr);
        if (ret != 0)
        {
            std::cout << "创建线程错误" << ret << std::endl;
        }
        std::cout<< std::endl;
    }
    //等各个线程退出后，进程才结束，否则进程强制结束了，线程可能还没反应过来；
    pthread_exit(nullptr);
}