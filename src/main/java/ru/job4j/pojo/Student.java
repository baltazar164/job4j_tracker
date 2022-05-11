package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student {
    private String fio;
    private String groop;
    private LocalDateTime admissionDate;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroop() {
        return groop;
    }

    public void setGroop(String groop) {
        this.groop = groop;
    }

    public String getAdmissionDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
        return admissionDate.format(formatter);
    }

    public void setAdmissionDate(LocalDateTime admissionDate) {
        this.admissionDate = admissionDate;
    }
}
