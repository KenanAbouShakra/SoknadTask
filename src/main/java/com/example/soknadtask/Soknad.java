package com.example.soknadtask;

public class Soknad {
    private int soknadId;

    public int getSoknadId() {
        return soknadId;
    }

    public void setSoknadId(int soknadId) {
        this.soknadId = soknadId;
    }

    private String personnr;

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    private String fornavn;
    private String etternavn;
    private String tel;
    private int belop;
    public Soknad() {
    }
    public Soknad(int soknadId,  String personnr, String fornavn, String etternavn, String tel, int belop, String soknadstekst) {
        this.soknadId = soknadId;

        this.personnr = personnr;
        this.fornavn = fornavn;
        this.etternavn=etternavn;
        this.tel = tel;
        this.belop= belop;
        this.soknadstekst = soknadstekst;
    }

    public String getPersonnr() {
        return personnr;
    }

    public void setPersonnr(String personnr) {
        this.personnr = personnr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getBelop() {
        return belop;
    }

    public void setBelop(int belop) {
        this.belop = belop;
    }

    public String getSoknadstekst() {
        return soknadstekst;
    }

    public void setSoknadstekst(String soknadstekst) {
        this.soknadstekst = soknadstekst;
    }

    private String soknadstekst;

}
