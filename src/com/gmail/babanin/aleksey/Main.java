package com.gmail.babanin.aleksey;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[2000000];
        Random rn = new Random();
        
        for (int i = 0; i < array.length; i+=1) {
            array[i] = rn.nextInt(100);
        }
        
        int[] array2 = array.clone();
        int[] array3 = array.clone();
        
        long tstart = System.currentTimeMillis();
        MultiThreadSorting.sort(array, 1);
        long tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + " ms" + "- Static method sort");
        
        tstart = System.currentTimeMillis();
        MultiThreadSorting.sort(array2, Runtime.getRuntime().availableProcessors());
        tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + " ms" + " - MultiThread sort");
        
        tstart = System.currentTimeMillis();
        Arrays.sort(array3);
        tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + " ms" + " - Arrays sort");
        
        System.out.println(Arrays.equals(array, array3));
        System.out.println(Arrays.equals(array2, array3));
        
    }

}
