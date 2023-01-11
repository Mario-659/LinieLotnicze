package org.example.model;

import java.util.regex.Pattern;

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

    public Klient() {}

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

    public void wyswietlDaneKlienta() {
        String daneKlienta = String.format("Imie: %s, Nazwisko: %s, Pesel %s, Adres poczty: %s",
                imie, nazwisko, pesel, adresPocztyElektronicznej);
        System.out.println(daneKlienta);
    }

    public void podajDaneKlienta(String[] dane){
        validateDaneKlienta(dane);

        String pesel = dane[0];
        String nazwisko = dane[1];
        String imie = dane[2];
        String email = dane[3];

        this.pesel = pesel;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.adresPocztyElektronicznej = email;
    }

    private void validateDaneKlienta(String dane[]) {
        String pesel = dane[0];
        validatePesel(pesel);

        String nazwisko = dane[1];
        validateNazwisko(nazwisko);

        String imie = dane[2];
        validateImie(imie);

        String email = dane[3];
        validateEmail(email);
    }

    public void validatePesel(String pesel) {
        if (pesel.isBlank() || pesel.length() != 11) {
            throw new IllegalArgumentException();
        }

        Pattern onlyNumbers = Pattern.compile("/^[0-9]*$/gm");
        if (!onlyNumbers.matcher(pesel).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNazwisko(String nazwisko) {
        if (nazwisko.isBlank() || nazwisko.length() >= 20) {
            throw new IllegalArgumentException();
        }

        Pattern onlyNumbers = Pattern.compile("/^([^0-9]*)$/");
        if (!onlyNumbers.matcher(nazwisko).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateImie(String imie) {
        if (imie.isBlank() || imie.length() >= 20) {
            throw new IllegalArgumentException();
        }

        Pattern onlyNumbers = Pattern.compile("/^([^0-9]*)$/");
        if (!onlyNumbers.matcher(imie).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateEmail(String email) {
        if (email.isBlank()) {
            throw new IllegalArgumentException();
        }

        Pattern onlyNumbers = Pattern.compile("^(.+)@(\\\\S+)$");
        if (!onlyNumbers.matcher(email).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
