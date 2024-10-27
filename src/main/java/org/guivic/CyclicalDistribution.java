package org.guivic;

public class CyclicalDistribution extends Thread {

    private int idThread;
    private int counter;
    private int threads;

    public CyclicalDistribution(int idThread, int counter, int threads) {
        this.idThread = idThread;
        this.counter = counter;
        this.threads = threads;
    }

    @Override
    public void run() {
        for (int i = idThread; i < counter; i += threads) {
            System.out.println("Thread " + idThread + " Work index: " + i);
        }
    }
}
