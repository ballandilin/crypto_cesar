package com.company.algorithmes.chiffrement.algorithmetransposition;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class ComparateurCouple implements Comparator<Couple> {


    @Override
    public int compare(Couple o1, Couple o2) {

        int res = 0;

        if((o1.getCaractere() < o2.getCaractere()) || ((o1.getCaractere() == o2.getCaractere()) && (o1.getPosition() < o2.getPosition()))) {
            res = o2.getPosition() - o1.getPosition();
        } else {
            res = o1.getPosition() - o2.getPosition();
        }

        return res;
    }

}
