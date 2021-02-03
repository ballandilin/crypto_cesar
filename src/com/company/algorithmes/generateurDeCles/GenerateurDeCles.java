package com.company.algorithmes.generateurDeCles;

import com.company.donnees.cles.Cles;


/**
 * Interface permettant de gérer Les generateurs de Cles
 */
public interface GenerateurDeCles {

    Cles genererClePublique();
    Cles genererClePrivee();
}
