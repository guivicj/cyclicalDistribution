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


        Thread[] threads = new Thread[thread];
        Thread t1 = new CyclicalDistribution(idThread, counter, thread);
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

        System.out.println("Cyclical Distribution Done");

        int blockSize = counter / thread;
        int remainder = counter % thread;

        Thread[] threads2 = new Thread[thread];
        int start = 0;
        for (int i = 0; i < thread; i++) {
            int end = start + blockSize - 1;
            if (i < remainder) {
                end += 1;
            }
            threads2[i] = new BlockDistribution(start, end);
            threads2[i].start();
            start = end + 1;
        }

        for (int i = 0; i < thread; i++) {
            try {
                threads2[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Block Distribution Done");
    }
}