package com.nzpq.$01array;


/**
 * @author 鹏
 * @Date 2020-10-13 22:24
 */
public class ArrayDemo {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.addLast(0);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        System.out.println(array.get(3));
        System.out.println(array);
        array.set(3,33);
        System.out.println(array);
        System.out.println(array.contain(33));
        System.out.println(array.find(33));

        array.remove(0);
        array.removeElement(4);
        System.out.println(array);

        System.out.println(array.removeFirst());
        System.out.println(array.removeLast());
        System.out.println(array);
        System.out.println("*********************");

//        array.add(2,66);


        Student stu1 = new Student("熊大",11);
        Student stu2 = new Student("熊二",12);
        Student stu3 = new Student("熊三",13);
        Student stu5 = new Student("熊五",15);

        Array<Student> students = new Array<>(5);
        System.out.println(students);//容量为3

        students.addLast(stu1);
        students.addLast(stu2);
        students.addLast(stu3);
        students.addLast(stu5);

        System.out.println(students); //容量为6

        students.removeLast();
        students.removeLast();
        System.out.println(students); //容量为2

//        students.remove(1);
//        System.out.println(students.toString());

    }
}
