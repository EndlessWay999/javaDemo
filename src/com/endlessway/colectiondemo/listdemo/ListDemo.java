package com.endlessway.colectiondemo.listdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
    }
}

class ArrayListDemo{
    public static void main(String[] args) {
        /*
        * | 方法名                                | 说明                                   |
        | ------------------------------------- | -------------------------------------- |
        | public boolean add(要添加的元素)      | 将指定的元素追加到此集合的末尾         |
        | public boolean remove(要删除的元素)   | 删除指定元素,返回值表示是否删除成功    |
        | public E  remove(int   index)         | 删除指定索引处的元素，返回被删除的元素 |
        | public E   set(int index,E   element) | 修改指定索引处的元素，返回被修改的元素 |
        | public E   get(int   index)           | 返回指定索引处的元素                   |
        | public int   size()                   | 返回集合中的元素的个数                 |
* */
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        //remove 删除指定元素
        //删除第一个元素
        list.remove(0);
        System.out.println(list.remove(0));
        //contains查找元素是否存在
        System.out.println(list.contains("3"));
        //size:获取元素个数
        System.out.println(list.size());
        //isEmpty判断是否为空
        System.out.println(list.isEmpty());
        //clear 清空
//        list.clear();
        // 添加一个集合
        ArrayList<String> strList = new ArrayList<>();
        strList.add("张飞");
        strList.add("刘备");
        strList.add("关羽");
        list.addAll(strList);
        System.out.println(list);
        //增加for,内部原理是一个Iterator迭代器
        for (String str:list){
            System.out.println(str);
        }


        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("lisi",20));
        arrayList.add(new Student("wangwu",22));
        arrayList.add(new Student("mazi",21));
        arrayList.add(new Student("wanger",23));

        //iterator循环修改集合，并发修改异常(ConcurrentModificationException)
//        Iterator<Student> it = arrayList.iterator();
//        while(it.hasNext()){
//            Student student = it.next();
//            if (student.getName().equals("lisi")) {
//                arrayList.add(new Student("月光", 30));
//            }
//        }

        //for增强循环修改集合,并发修改异常(ConcurrentModificationException)
//        for (Student student:arrayList){
//           if(student.getName().equals("lisi")){
//               arrayList.add(new Student("dd",30));
//           }
//        }

        //iterator循环，用于允许程序员沿任一方向遍历的列表迭代器，在迭代期间修改列表，并获取列表中迭代器的当前位置
        ListIterator<Student> it1 = arrayList.listIterator();
        while(it1.hasNext()){
            Student student = it1.next();
            if(student.getName().equals("lisi")){
                it1.add(new Student("endlessway",23));
            }
        }

        System.out.println(arrayList);
    }
}
class LinkedListDemo{
    public static void main(String[] args) {
        /*
        | 方法名                    | 说明                             |
        | ------------------------- | -------------------------------- |
        | public void addFirst(E e) | 在该列表开头插入指定的元素       |
        | public void addLast(E e)  | 将指定的元素追加到此列表的末尾   |
        | public E getFirst()       | 返回此列表中的第一个元素         |
        | public   E getLast()      | 返回此列表中的最后一个元素       |
        | public E removeFirst()    | 从此列表中删除并返回第一个元素   |
        | public   E removeLast()   | 从此列表中删除并返回最后一个元素 |
        * */
        LinkedList<String> list = new LinkedList<>();
        list.add("张飞");
        list.add("刘备");
        list.add("关羽");
        //在该列表开头插入指定的元素
        list.addFirst("曹操");
        System.out.println(list);
        //将指定的元素追加到此列表的末尾
        list.addLast("吕布");
        System.out.println(list);
        //返回此列表中的第一个元素
        System.out.println(list.getFirst());
        //返回此列表中的最后一个元素
        System.out.println(list.getLast());
        //从此列表中删除并返回第一个元素
        System.out.println(list.removeFirst());
        //从此列表中删除并返回最后一个元素
        System.out.println(list.removeLast());

        for (String s:list) {
            if("张飞".equals(s)){
                list.add("endlessway");
            }
        }

        System.out.println(list);
    }
}
class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
