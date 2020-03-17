package io.zipcoder;

import java.util.Random;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    Random random;

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while(stringIterator.hasNext()) {
            copied += stringIterator.next() + " ";
        }
    }

    public int possibleRandomPause() {
        Random num = new Random();
        int randomNum = num.nextInt(10);
        return randomNum;
    }
}
