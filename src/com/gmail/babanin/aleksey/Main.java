package com.gmail.babanin.aleksey;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[5000000];
        Random rn = new Random();
        
        for (int i = 0; i < array.length; i+=1) {
            array[i] = rn.nextInt(100);
        }
        
        int[] array2 = array.clone();
        int[] array3 = array.clone();
        
        long tstart = System.currentTimeMillis();
        Arrays.sort(array);
        long tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + " ms" + " - Arrays sort");
        
        tstart = System.currentTimeMillis();
        MultiThreadSorting.sort(array3, Runtime.getRuntime().availableProcessors());
        tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + " ms" + " - MultiThread sort. Correct " + Arrays.equals(array, array3));
        
        tstart = System.currentTimeMillis();
        MultiThreadSorting.sort(array2, 1);
        tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + " ms" + " - Static method sort. Correct " + Arrays.equals(array, array2));
    }

}
