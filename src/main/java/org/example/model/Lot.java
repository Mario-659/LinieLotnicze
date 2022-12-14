package org.example.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Lot {
    public Lot(int numerLotu, String samolot, String lotniskoStartowe, String lotniskoDocelowe, Date dataOdlotu, Date dataPrzylotu, BigDecimal cenaBazowa) {
        this.numerLotu = numerLotu;
        this.samolot = samolot;
        this.lotniskoStartowe = lotniskoStartowe;
        this.lotniskoDocelowe = lotniskoDocelowe;
        this.dataOdlotu = dataOdlotu;
        this.dataPrzylotu = dataPrzylotu;
        this.cenaBazowa = cenaBazowa;
    }

    private int numerLotu;
    private String samolot;
    private String lotniskoStartowe;
    private String lotniskoDocelowe;
    private Date dataOdlotu;
    private Date dataPrzylotu;
    private BigDecimal cenaBazowa;
    private Promocja promocja;
    private List<Miejsce> miejsca;

    public List<Miejsce> getMiejsca() {
        return miejsca;
    }

    public void setMiejsca(List<Miejsce> miejsca) {
        this.miejsca = miejsca;
    }

    public void dodajMiejsce(Miejsce miejsce) {
        this.miejsca.add(miejsce);
    }

    public int getNumerLotu() {
        return numerLotu;
    }

    public void setNumerLotu(int numerLotu) {
        this.numerLotu = numerLotu;
    }

    public String getSamolot() {
        return samolot;
    }

    public void setSamolot(String samolot) {
        this.samolot = samolot;
    }

    public String getLotniskoStartowe() {
        return lotniskoStartowe;
    }

    public void setLotniskoStartowe(String lotniskoStartowe) {
        this.lotniskoStartowe = lotniskoStartowe;
    }

    public String getLotniskoDocelowe() {
        return lotniskoDocelowe;
    }

    public void setLotniskoDocelowe(String lotniskoDocelowe) {
        this.lotniskoDocelowe = lotniskoDocelowe;
    }

    public Date getDataOdlotu() {
        return dataOdlotu;
    }

    public void setDataOdlotu(Date dataOdlotu) {
        this.dataOdlotu = dataOdlotu;
    }

    public Date getDataPrzylotu() {
        return dataPrzylotu;
    }

    public void setDataPrzylotu(Date dataPrzylotu) {
        this.dataPrzylotu = dataPrzylotu;
    }

    public BigDecimal getCenaBazowa() {
        return cenaBazowa;
    }

    public void setCenaBazowa(BigDecimal cenaBazowa) {
        this.cenaBazowa = cenaBazowa;
    }

    public Promocja getPromocja() {
        return promocja;
    }

    public void setPromocja(Promocja promocja) {
        this.promocja = promocja;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + numerLotu +
                ", samolot='" + samolot + '\'' +
                ", lotniskoStartowe='" + lotniskoStartowe + '\'' +
                ", lotniskoDocelowe='" + lotniskoDocelowe + '\'' +
                ", dataOdlotu=" + dataOdlotu +
                ", dataPrzylotu=" + dataPrzylotu +
                ", cenaBazowa=" + cenaBazowa +
                '}';
    }

    public void wyswietlMiejsca() {
        Iterator<Miejsce> iterator = miejsca.iterator();
        while (iterator.hasNext()) {
            Miejsce nastepneMiejsce = iterator.next();
            System.out.println(nastepneMiejsce.toString());
        }
    }

    public Miejsce wybierzPierwszeWolneMiejsce() {
        Iterator<Miejsce> iterator = miejsca.iterator();
        while (iterator.hasNext()) {
            Miejsce nastepneMiejsce = iterator.next();
            if(nastepneMiejsce.getCzyMiejsceJestZajete() == false) return nastepneMiejsce;
        }
        return null;
    }

    public Miejsce wyszukajMiejsce(int numerMiejsca){
        Iterator<Miejsce> iterator = miejsca.iterator();
        while (iterator.hasNext()) {
            Miejsce nastepneMiejsce = iterator.next();
            if(nastepneMiejsce.getNumerMiejsca() == numerMiejsca && !nastepneMiejsce.getCzyMiejsceJestZajete()) {
                return nastepneMiejsce;
            }
        }
        return null;
    }

    public BigDecimal obliczWartoscPromocji(){
        return this.cenaBazowa * this.promocja.getWartoscProcentowa();
    }
}
