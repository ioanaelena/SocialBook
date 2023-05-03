package com.example.guiex1.domain;

import java.time.LocalDateTime;


public class Prietenie extends Entity<Tuple<Long,Long>> {

    LocalDateTime date;

    Utilizator utilizator1;

    Utilizator utilizator2;

    String status;

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Utilizator getUtilizator1() {
        return utilizator1;
    }

    public void setUtilizator1(Utilizator utilizator1) {
        this.utilizator1 = utilizator1;
    }

    public Utilizator getUtilizator2() {
        return utilizator2;
    }

    public void setUtilizator2(Utilizator utilizator2) {
        this.utilizator2 = utilizator2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Prietenie(LocalDateTime date, Utilizator utilizator1, Utilizator utilizator2, String status) {
        this.date = date;
        this.utilizator1 = utilizator1;
        this.utilizator2 = utilizator2;
        this.status = status;
    }

    /**
     *
     * @return the date when the friendship was created
     */
    public LocalDateTime getDate() {
        return date;
    }
}
