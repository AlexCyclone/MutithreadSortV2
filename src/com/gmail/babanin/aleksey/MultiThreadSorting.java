package com.gmail.babanin.aleksey;

public class MultiThreadSorting {
    static void sort(int[] array, int threads) {
        if (threads > array.length) {
            threads = array.length;
        }

        int[] k = { 1, 4, 10, 23, 57, 145, 356, 911, 1968, 4711, 11969, 27901, 84801, 213331, 543749, 1355339, 3501671,
                8810089, 21521774, 58548857, 157840433, 410151271, 1131376761, 2147483647 };
        int ki = k.length - 1;
        while (array.length < k[ki]) {
            ki -= 1;
        }
        ThreadKSort[] kSort = new ThreadKSort[threads];

        try {
            while (ki >= 0) {
                if (k[ki] <= threads) {
                    threads = k[ki];
                }
                for (int thread = 0; thread < threads; thread += 1) {
                    kSort[thread] = new ThreadKSort(array, ki, k, thread, threads);
                }
                for (int thread = 0; thread < threads; thread += 1) {
                    kSort[thread].getThr().join();
                }
                ki -= 1;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}