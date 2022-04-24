package com.alexsobiek.luc.comp272.sorting.replit;

public class Student implements Comparable<Student> {
    String name;
    int age;
    double GPA;

    public Student(String a, int b, double c) {
        name = a;
        age = b;
        GPA = c;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    @Override //override needed to use comparable
    public int compareTo(Student b) {
        //Add code in here
        if (this.age > b.age) return 1;
        else if (this.age < b.age) return -1;
        else { // age is equal
            if (this.GPA > b.GPA) return 1;
            else if (this.GPA < b.GPA) return -1;
            else return 0;  // Completely identical
        }
    }

    @Override
    public String toString() {
        return String.format("(\"%s\", %d, %f)", name, age, GPA);
    }
}