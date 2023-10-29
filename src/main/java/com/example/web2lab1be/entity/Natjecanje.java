package com.example.web2lab1be.entity;

public class Natjecanje {

    private Integer natjecanjeid;
    private String naziv;
    private Integer brojnatjecatelja;
    private String listanatjecatelja;
    private String listarezultata;
    private String pairing;
    private Integer brojrunde;
    private String format;
    private Integer userid;

    public Natjecanje(Integer natjecanjeid, String naziv, Integer brojnatjecatelja, String listanatjecatelja, String listarezultata, String pairing, Integer brojrunde, String format, Integer userid) {
        this.natjecanjeid = natjecanjeid;
        this.naziv = naziv;
        this.brojnatjecatelja = brojnatjecatelja;
        this.listanatjecatelja = listanatjecatelja;
        this.listarezultata = listarezultata;
        this.pairing = pairing;
        this.brojrunde = brojrunde;
        this.format = format;
        this.userid = userid;
    }

    public Natjecanje() {

    }

    public Integer getNatjecanjeid() {
        return natjecanjeid;
    }

    public void setNatjecanjeid(Integer natjecanjeid) {
        this.natjecanjeid = natjecanjeid;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getBrojnatjecatelja() {
        return brojnatjecatelja;
    }

    public void setBrojnatjecatelja(Integer brojnatjecatelja) {
        this.brojnatjecatelja = brojnatjecatelja;
    }

    public String getListanatjecatelja() {
        return listanatjecatelja;
    }

    public void setListanatjecatelja(String listanatjecatelja) {
        this.listanatjecatelja = listanatjecatelja;
    }

    public String getListarezultata() {
        return listarezultata;
    }

    public void setListarezultata(String listarezultata) {
        this.listarezultata = listarezultata;
    }

    public Integer getBrojrunde() {
        return brojrunde;
    }

    public void setBrojrunde(Integer brojrunde) {
        this.brojrunde = brojrunde;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPairing() {
        return pairing;
    }

    public void setPairing(String pairing) {
        this.pairing = pairing;
    }
}

