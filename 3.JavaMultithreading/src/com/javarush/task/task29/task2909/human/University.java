package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public List getStudents() {
        return students;
    }

    public void setStudents(List students) {
        this.students = students;
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

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double value) {
        //TODO:
        Student student = null;
        for (Student st : students) {
            if (st.getAverageGrade() == value) {
                student = st;
            }
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student student = null;
        double average = 0.0;
        for (Student st : students) {
            if (st.getAverageGrade() > average) {
                average = st.getAverageGrade();
            }
        }

        for (Student st : students) {
            if (st.getAverageGrade() == average) {
                student = st;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        int index = 0;
        double average = 100;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < average) {
                average = students.get(i).getAverageGrade();
                index = i;
            }
        }
        return students.get(index);
    }

    public void expel(Student student) {
        students.remove(student);
    }
}