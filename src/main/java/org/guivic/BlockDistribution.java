package org.guivic;


public class BlockDistribution extends Thread {

    private int start;
    private int end;

    public BlockDistribution(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread().getName() + " Work index: " + i);
        }
    }
}
