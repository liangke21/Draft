package 强引用;

/**
 * 作者: LiangKe 时间: 2021/12/19 12:56 描述:
 */

import java.util.ArrayList;
import java.util.List;


public class StrongReferenceTest {



  public static void main(String[] args) throws InterruptedException {
    testStrongReference();
  }

  public static void testStrongReference() throws InterruptedException {
    int size = 1000000;
    //用list保持强引用，即使发生OOM，垃圾回收器也不会回收list中的对象
    List<Integer> list = new ArrayList(size);
    for (int i = 0; i < size; i++) {
      Thread.sleep(1000);
      list.add(i);
    }
  }
}