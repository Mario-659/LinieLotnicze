package org.example.model;

public class Promocja {

    public Promocja(int nP, float wP, int kR){
        this.numerPromocji = nP;
        this.kodRabatowy = kR;
        this.wartoscProcentowa = wP;
    }
    private int numerPromocji;
    private float wartoscProcentowa;

    private int kodRabatowy;

    public int getNumerPromocji() {
        return numerPromocji;
    }

    public void setNumerPromocji(int numerPromocji) {
        this.numerPromocji = numerPromocji;
    }

    public float getWartoscProcentowa() {
        return wartoscProcentowa;
    }

    public void setWartoscProcentowa(float wartoscProcentowa) {
        this.wartoscProcentowa = wartoscProcentowa;
    }

    public int getKodRabatowy() {
        return kodRabatowy;
    }

    public void setKodRabatowy(int kodRabatowy) {
        this.kodRabatowy = kodRabatowy;
    }
}
