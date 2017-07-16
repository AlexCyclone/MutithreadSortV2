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
        for (int t = thread; t < k[ki]; t += threads) {
            for (int j = t + k[ki]; j < array.length; j += k[ki]) {
                int temp = array[j];
                int i = j - k[ki];
                while (i >= 0 && array[i] > temp) {
                    array[i + k[ki]] = array[i];
                    i -= k[ki];
                }
                array[i + k[ki]] = temp;
            }
        }
    }
}
