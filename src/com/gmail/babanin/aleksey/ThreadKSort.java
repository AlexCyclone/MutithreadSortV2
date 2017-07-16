package com.gmail.babanin.aleksey;

public class ThreadKSort implements Runnable {
    private int[] array;
    private Thread thr;
    private int ki;
    private int[] k;
    private int thread;
    private int threads;

    public ThreadKSort(int[] array, int ki, int[] k, int thread, int threads) {
        super();
        this.array = array;
        this.ki = ki;
        this.k = k;
        this.thread = thread;
        this.threads = threads;
        thr = new Thread(this);
        thr.start();
    }

    public Thread getThr() {
        return thr;
    }

    @Override
    public void run() {
        for (int i = k[ki] + thread; i < array.length; i += threads) {
            int j = i;
            int temp = array[i];
            while ((j >= k[ki]) && (array[j - k[ki]] > temp)) {
                array[j] = array[j - k[ki]];
                j -= k[ki];
            }
            array[j] = temp;
        }
    }
}
