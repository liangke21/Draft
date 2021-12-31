package cn.itcast.jiaoben.d;

import java.util.ArrayList;

/**
 * 作者: QQ群:799145059
 * 时间: 2021/4/27 8:48
 * 描述:
 */
public class MainClass {

    public static void main(String[] args) {


       /* ArrayList list = new ArrayList();
       list.add("java");
       list.add(100);
       list.add(true);
*/
       /* for (int i = 0; i <list.size() ; i++) {
            Object o = list.get(i);
            String s = (String) o;
            System.out.println(s);
        }*/


        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        for (int i = 0; i < list1.size(); i++) {
            String s = list1.get(i);
            System.out.println(s);
        }


    }
}
