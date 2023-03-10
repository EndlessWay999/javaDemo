package com.endlessway.colectiondemo.setdemo;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        /*
         * Set集合的特点
         *
         * - 元素存取无序
         * - 没有索引、只能通过迭代器或增强for循环遍历
         * - 不能存储重复元素
         */

        //创建集合对象
        Set<String> set = new HashSet<>();

        //添加元素
        set.add("java");
        set.add("spring");
        set.add("mvc");
        set.add("mybatis");

        //不包含重复元素的集合
        set.add("mvc");
        //遍历可修改，因为set的底层是HashMap
        for(String s : set) {
            System.out.println(s);
            if("mvc".equals(s)){
                set.add("js");
            }
        }

        System.out.println(set);
    }
}
/**
 * LinkedHashSet集合概述和特点
 */
class LinkedHashSetDemo{
    public static void main(String[] args) {
        /*LinkedHashSet集合特点
         - 哈希表和链表实现的Set接口，具有可预测的迭代次序
         - 由链表保证元素有序，也就是说元素的存储和取出顺序是一致的
         - 由哈希表保证元素唯一，也就是说没有重复的元素
         *
         */

        LinkedHashSet<String> set = new LinkedHashSet<>();
        //添加元素
        set.add("java");
        set.add("spring");
        set.add("mvc");
        set.add("mybatis");

        //遍历
        for(String s : set) {
            System.out.println(s);
        }
    }
}
/**
 * TreeSet
 */
class TreeSetDemo{
    public static void main(String[] args) {
        /*
         * TreeSet集合概述
         *
         * - 元素有序，可以按照一定的规则进行排序，具体排序方式取决于构造方法
         *   - TreeSet()：根据其元素的自然排序进行排序
         *   - TreeSet(Comparator comparator) ：根据指定的比较器进行排序
         * - 没有带索引的方法，所以不能使用普通for循环遍历
         * - 由于是Set集合，所以不包含重复元素的集合
         */

        //创建集合对象
        TreeSet<Integer> ts = new TreeSet<>();

        //添加元素
        ts.add(10);
        ts.add(40);
        ts.add(30);
        ts.add(50);
        ts.add(20);
        ts.add(30);

        //遍历集合
        for(Integer i : ts) {
            System.out.println(i);
        }
    }
}
/**
 * 自然排序Comparable的使用
 */
class ComparableDemo{
    public static void main(String[] args) {
        /*
         * - 案例需求
         *
         *   - 存储学生对象并遍历，创建TreeSet集合使用无参构造方法
         *   - 要求：按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序
         *
         * - 实现步骤
         *
         *   - 用TreeSet集合存储自定义对象，无参构造方法使用的是自然排序对元素进行排序的
         *   - 自然排序，就是让元素所属的类实现Comparable接口，重写compareTo(T o)方法
         *   - 重写方法时，一定要注意排序规则必须按照要求的主要条件和次要条件来写
         */
        Set<Student> set = new TreeSet<>();
        set.add(new Student("张飞",21));
        set.add(new Student("关羽",22));
        set.add(new Student("刘备",23));

        //遍历集合
        for (Student s : set) {
            System.out.println(s.getName() + "," + s.getAge());
        }


    }
}
class Student implements Comparable<Student>{
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

    @Override
    public int compareTo(Student s) {
//        return 0;
//        return 1;
//        return -1;
        //按照年龄从小到大排序
        int num = this.age - s.age;
//        int num = s.age - this.age;
        //年龄相同时，按照姓名的字母顺序排序
        int num2 = num==0?this.name.compareTo(s.name):num;
        return num2;
    }
}
/**
 * 比较器排序Comparator的使用
 */
class ComparatorDemo{
    public static void main(String[] args) {
        /*
         * - 案例需求
         *
         *   - 存储学生对象并遍历，创建TreeSet集合使用带参构造方法
         *   - 要求：按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序
         *
         * - 实现步骤
         *
         *   - 用TreeSet集合存储自定义对象，带参构造方法使用的是比较器排序对元素进行排序的
         *   - 比较器排序，就是让集合构造方法接收Comparator的实现类对象，重写compare(T o1,T o2)方法
         *   - 重写方法时，一定要注意排序规则必须按照要求的主要条件和次要条件来写
         */

        TreeSet<Student> set = new TreeSet<>((o1, o2) -> {
            int num = o1.getAge() - o2.getAge();
            int num0 = num == 0? o1.getName().compareTo(o2.getName()):num;
            return num0;
        });
        set.add(new Student("张飞",21));
        set.add(new Student("关羽",22));
        set.add(new Student("刘备",23));


        for (Student s:set) {
            System.out.println(s.getName()+","+s.getAge());
        }

    }
}
