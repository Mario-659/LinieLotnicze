package org.example.model;

import java.util.Date;

public class Rezerwacja {
    private static int licznikRezerwacji = 1;
    private int numerRezerwacji;
    private Date dataRezerwacji;
    private Lot lot;
    private int numerMiejsca;
    private Klient klient;

    public Rezerwacja(Date dataRezerwacji, Lot lot, int numerMiejsca, Klient klient) {
        this.numerRezerwacji = licznikRezerwacji++;
        this.dataRezerwacji = dataRezerwacji;
        this.lot = lot;
        this.numerMiejsca = numerMiejsca;
        this.klient = klient;
    }

    public int getNumerRezerwacji() {
        return numerRezerwacji;
    }

    public void setNumerRezerwacji(int numerRezerwacji) {
        this.numerRezerwacji = numerRezerwacji;
    }

    public Date getDataRezerwacji() {
        return dataRezerwacji;
    }

    public void setDataRezerwacji(Date dataRezerwacji) {
        this.dataRezerwacji = dataRezerwacji;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public int getNumerMiejsca() {
        return numerMiejsca;
    }

    public void setNumerMiejsca(int numerMiejsca) {
        this.numerMiejsca = numerMiejsca;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }
}
