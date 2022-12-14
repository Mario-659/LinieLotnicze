package org.example.model;

public class Klient {
    private String imie;
    private String nazwisko;
    private String pesel;
    private String adresPocztyElektronicznej;

    public Klient(String imie, String nazwisko, String pesel, String adresPocztyElektronicznej) {
        this.adresPocztyElektronicznej = adresPocztyElektronicznej;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public String getAdresPocztyElektronicznej() {
        return adresPocztyElektronicznej;
    }

    public void setAdresPocztyElektronicznej(String adresPocztyElektronicznej) {
        this.adresPocztyElektronicznej = adresPocztyElektronicznej;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String[] getDanePlatnosci(){
        return new String[]{"0123456789", "05/23", "123"};
    }
}
