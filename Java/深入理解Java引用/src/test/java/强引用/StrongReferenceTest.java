package 强引用;

/**
 * 作者: LiangKe 时间: 2021/12/19 12:56 描述:
 */
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
public class StrongReferenceTest {
  /**
   * JVM参数：
   * -Xms10m -Xmx10m  -XX:+PrintHeapAtGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+HeapDumpOnOutOfMemoryError
   */
  @Test(expected = OutOfMemoryError.class)
  public void testStrongReference() {
    int size = 1000000;
    //用list保持强引用，即使发生OOM，垃圾回收器也不会回收list中的对象
    List<Integer> list = new ArrayList(size);
    for (int i = 0; i < size; i++) {
      list.add(i);
    }
  }
}