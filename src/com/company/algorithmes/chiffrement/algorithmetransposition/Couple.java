package com.company.algorithmes.chiffrement.algorithmetransposition;

public class Couple {

    private char caractere = 0;
    private int position = 0;

    public Couple(char caractere, int position) {
        this.caractere = caractere;
        this.position = position;
    }


    public char getCaractere() {
        return caractere;
    }

    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
