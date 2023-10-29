package com.example.web2lab1be.requests;

public class CreateTournamentRequestBody {

    private String naziv;
    private Integer brojnatjecatelja;
    private String listanatjecatelja;
    private String listarezultata;
    private String format;
    private Integer userid;

    public CreateTournamentRequestBody(String naziv, Integer brojnatjecatelja, String listanatjecatelja, String listarezultata, Integer userid, String format) {
        this.naziv = naziv;
        this.brojnatjecatelja = brojnatjecatelja;
        this.listanatjecatelja = listanatjecatelja;
        this.listarezultata = listarezultata;
        this.format = format;
        this.userid = userid;
    }

    public CreateTournamentRequestBody() {

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getListarezultata() {
        return listarezultata;
    }

    public void setListarezultata(String listarezultata) {
        this.listarezultata = listarezultata;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
