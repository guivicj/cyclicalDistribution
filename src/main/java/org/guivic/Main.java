package org.guivic;

public class Main {
    public static void main(String[] args) {
        int idThread = 1;
        int counter = 10;
        int thread = 2;

        Thread t1 = new CyclicalDistribution(idThread, counter, thread);
        Thread[] threads = new Thread[thread];
        for (int i = 0; i < thread; i++) {
            threads[i] = new CyclicalDistribution(i, counter, thread);
            threads[i].start();
        }

        for (int i = 0; i < thread; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Work Done");
    }
}