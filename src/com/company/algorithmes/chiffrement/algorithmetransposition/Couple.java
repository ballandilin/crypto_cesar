package com.company.algorithmes.chiffrement.algorithmetransposition;


/**
 * Class permettant de creer des Couple avec un caractere et une position
 */
public class Couple {

    private char caractere = 0;
    private int position = 0;

    public Couple(char caractere, int position) {
        this.caractere = caractere;
        this.position = position;
    }



    // ##################### Getter et Setter ########################


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
