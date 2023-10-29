package com.example.web2lab1be.entity;

public class Runda {

    private Integer rundaid;
    private Integer brojrunde;

    public Runda(Integer brojrunde) {
        this.brojrunde = brojrunde;
    }

    public Runda() {

    }

    public Integer getRundaid() {
        return rundaid;
    }

    public void setRundaid(Integer rundaid) {
        this.rundaid = rundaid;
    }

    public Integer getBrojrunde() {
        return brojrunde;
    }

    public void setBrojrunde(Integer brojrunde) {
        this.brojrunde = brojrunde;
    }
}
