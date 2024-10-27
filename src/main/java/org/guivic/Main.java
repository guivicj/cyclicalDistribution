package org.guivic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idThread = 1;
        System.out.print("Introduce a positive number: ");
        int counter = sc.nextInt();
        System.out.print("Introduce a number of threads: ");
        int thread = sc.nextInt();

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