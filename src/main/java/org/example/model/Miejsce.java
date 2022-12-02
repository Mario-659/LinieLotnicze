package org.example.model;

public class Miejsce {
    private int numerMiejsca;
    private boolean czyMiejsceJestZajete;

    public Miejsce(int numerMiejsca, boolean czyMiejsceJestZajete) {
        this.numerMiejsca = numerMiejsca;
        this.czyMiejsceJestZajete = czyMiejsceJestZajete;
    }

    public int getNumerMiejsca() {
        return numerMiejsca;
    }

    public void setNumerMiejsca(int numerMiejsca) {
        this.numerMiejsca = numerMiejsca;
    }

    public boolean czyMiejsceJestZajete() {
        return czyMiejsceJestZajete;
    }

    public void setCzyMiejsceJestZajete(boolean czyMiejsceJestZajete) {
        this.czyMiejsceJestZajete = czyMiejsceJestZajete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Miejsce miejsce = (Miejsce) o;

        if (numerMiejsca != miejsce.numerMiejsca) return false;
        return czyMiejsceJestZajete == miejsce.czyMiejsceJestZajete;
    }

    @Override
    public String toString() {
        return "Miejsce{" +
                "numerMiejsca=" + numerMiejsca +
                ", czyMiejsceJestZajete=" + czyMiejsceJestZajete +
                '}';
    }
}
