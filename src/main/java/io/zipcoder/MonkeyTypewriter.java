package io.zipcoder;

import java.lang.reflect.Array;
import java.util.Random;

public class MonkeyTypewriter {

    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        SafeCopier safeCopier = new SafeCopier(introduction);

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        Thread[] threadArray = new Thread[5];

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(unsafeCopier);
            threadArray[i] = thread;
        }

        for (int i = 0; i < threadArray.length; i++) {
            Thread thread = threadArray[i];
            int num = unsafeCopier.possibleRandomPause();
            if (num < 5) {
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            thread.start();
        }

        Thread thread6 = new Thread(safeCopier);
        Thread thread7 = new Thread(safeCopier);
        Thread thread8 = new Thread(safeCopier);
        Thread thread9 = new Thread(safeCopier);
        Thread thread10 = new Thread(safeCopier);


        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }



        // Print out the copied versions here.

        System.out.println("Unsafe Version:");
        System.out.println(unsafeCopier.copied);
        System.out.println("\n");
        System.out.println("Safe Version:");
        System.out.println(safeCopier.copied);
    }
}