package ru.job4j.pojo;

import java.time.LocalDateTime;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Leonardo DiCaprio");
        student.setGroop("actors");
        student.setAdmissionDate(LocalDateTime.now());
        System.out.println(student.getFio() + " " + student.getGroop() + " " + student.getAdmissionDate());
    }
}
