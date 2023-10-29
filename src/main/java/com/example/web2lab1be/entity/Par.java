package com.example.web2lab1be.entity;


public class Par {

    private Integer parid;
    private String prvi;
    private String drugi;

    public Par(String prvi, String drugi) {
        this.prvi = prvi;
        this.drugi = drugi;
    }

    public Par() {

    }

    public Integer getParid() {
        return parid;
    }

    public void setParid(Integer parid) {
        this.parid = parid;
    }

    public String getPrvi() {
        return prvi;
    }

    public void setPrvi(String prvi) {
        this.prvi = prvi;
    }

    public String getDrugi() {
        return drugi;
    }

    public void setDrugi(String drugi) {
        this.drugi = drugi;
    }
}
