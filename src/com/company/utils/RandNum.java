package com.company.utils;

import java.util.Random;

public class RandNum {

    public int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max dois etre plus grand que min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
