package com.company.algorithmes.generateurDeCles;

import com.company.donnees.cles.CleInteger;
import com.company.donnees.cles.Cles;
import com.company.utils.RandNum;

public class GenerateurDeClesCesar implements GenerateurDeCles{

    private Integer randNum = 0;

    public GenerateurDeClesCesar() {
        this.randNum = new RandNum().getRandomNumberInRange(0, 25);
        System.out.println(this.randNum);
    }


    public Cles genererClePublique() {
        return null;
    }

    public Cles genererClePrivee() {
        Cles cle = new Cles();

        cle.addCle("cleCesar", new CleInteger(this.randNum));

        return cle;
    }
}
