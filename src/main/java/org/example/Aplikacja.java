package org.example;

import org.example.model.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Aplikacja {
    private List<Lot> loty;
    private List<Promocja> promocje;

    private List<Rezerwacja> rezerwacje;

    private String zalogowanyUzytkownik;

    public String getZalogowanyUzytkownik() {
        return zalogowanyUzytkownik;
    }

    public void setZalogowanyUzytkownik(String zalogowanyUzytkownik) {
        this.zalogowanyUzytkownik = zalogowanyUzytkownik;
    }

    private List<Klient> klienci = List.of(
            new Klient("Johny", "Bravo", "12342783", "johny_bravo0@wp.pl"),
            new Klient("Johny", "Bravo", "12342783", "johny_bravo1@wp.pl"),
            new Klient("Johny", "Bravo", "12342783", "johny_bravo2@wp.pl"),
            new Klient("Johny", "Bravo", "12342783", "johny_bravo3@wp.pl"),
            new Klient("Johny", "Bravo", "12342783", "johny_bravo4@wp.pl")
    );

    public void dodajRezerwacje(Rezerwacja rezerwacja) {
        rezerwacje.add(rezerwacja);
    }

    public void usunRezerwacje(Rezerwacja rezerwacja) {
        rezerwacje.remove(rezerwacja);
    }

    public Rezerwacja wyszukajRezerwacje(int numerRezerwacji) {
        for (var rezerwacja : rezerwacje) {
            if (rezerwacja.getNumerRezerwacji() == numerRezerwacji) return rezerwacja;
        }
        return null;
    }

    public boolean getCzyMiejsceLosowe() {
        return true;
    }

 public boolean stworzRezerwacje(int numerLotu) {
        Lot lot = wyszukajLot(numerLotu);
        lot.wyswietlMiejsca();
        Miejsce miejsceDoZarezerwowania = null;
        if (getCzyMiejsceLosowe()) {
            miejsceDoZarezerwowania = lot.wybierzPierwszeWolneMiejsce();
            if (miejsceDoZarezerwowania == null) {
                System.out.println("Brak wolnych miejsc");
                return false;
            }
            miejsceDoZarezerwowania.setCzyMiejsceJestZajete(true);
            System.out.println("Zarezerwowano miejsce o numerze " + miejsceDoZarezerwowania.getNumerMiejsca());
        }
        else {
            int numerMiejsca = pobierzNumerMiejsca();
            Miejsce miejsce = lot.wyszukajMiejsce(numerMiejsca);
            if(miejsce == null || !miejsce.getCzyMiejsceJestZajete()) {
                miejsce.setCzyMiejsceJestZajete(true);
                System.out.println("Zarezerwowano miejsce o numerze " + miejsce.getNumerMiejsca());
                miejsceDoZarezerwowania = miejsce;
            }
            else {
                System.out.println("Miejsce jest zajete");
                return false;
            }
        }
        Klient daneZalogowanegoKlienta = pobierzDaneKlienta(getZalogowanyUzytkownik());
        String[] danePlatnosci = daneZalogowanegoKlienta.getDanePlatnosci();
        if (zweryfikujDanePlatnosci(danePlatnosci) == false) {
            System.out.println("Niepoprawne dane płatnosci");
            miejsceDoZarezerwowania.setCzyMiejsceJestZajete(false);
            return false;
        }

        Rezerwacja nowaRezerwacja = new Rezerwacja(new Date(), lot, miejsceDoZarezerwowania.getNumerMiejsca(), daneZalogowanegoKlienta);
        rezerwacje.add(nowaRezerwacja);
        return true;
    }

    private boolean zweryfikujDanePlatnosci(String[] danePlatnosci) {
        return true;
    }

    private DanePlatnosci getDanePlatnosci() {
        return null;
    }

    private int pobierzNumerMiejsca() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer miejsca: ");
        String numerMiejsca = scanner.nextLine();
        return Integer.parseInt(numerMiejsca);
    }


    public void wyswietlLoty() {
        Iterator<Lot> iterator = loty.iterator();
        while (iterator.hasNext()) {
            Lot lot = iterator.next();
            System.out.println(lot.toString());
        }
    }


    private Klient pobierzDaneKlienta(String adresPocztyElektronicznej) {
        for (var klient : klienci) {
            if (klient.getAdresPocztyElektronicznej().equals(adresPocztyElektronicznej)) {
                return klient;
            }
        }
        return null;
    }

    public void dodajLot(Lot lot) {
        loty.add(lot);
    }

    public void usunLot(Lot lot) {
        loty.remove(lot);
    }

    public Lot wyszukajLot(int numerLotu) {
        for (var lot : loty) {
            if (lot.getNumerLotu() == numerLotu) return lot;
        }
        return null;
    }

    public boolean dodajPromocje(Promocja promocja) {
        Iterator<Promocja> iterator = promocje.iterator();
        while(iterator.hasNext()) {
            Promocja istniejacaPromocja = iterator.next();
            if (istniejacaPromocja.getNumerPromocji() == promocja.getNumerPromocji()) {
                return false;
            }
        }
        promocje.add(promocja);
        return true;
    }

    public void usunPromocje(Promocja promocja) {
        promocje.remove(promocja);
    }

    public Promocja wyszukajPromocje(int numerPromocji) {
        for (var promocja : promocje) {
            if (promocja.getNumerPromocji() == numerPromocji) return promocja;
        }
        return null;
    }
}
