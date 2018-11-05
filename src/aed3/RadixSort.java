/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aed3;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Everton
 */
public final class RadixSort {
    private int[] myArray;
    private int arraySize;
    private final long tempoInicial;
    private final long tempoFinal;
    private Random random;
    private int[] myArraySort;
    private long tempo;

    public int[] getArray(){
        return this.myArray;
    }
    public int[] getArraySorted(){
        return this.myArraySort;
    }
   
    public long getTime(){
        return this.tempo;
    }

    public RadixSort(int quantity){
        this.arraySize = quantity;
        this.myArray = new int[this.arraySize];
        this.random = new Random();
        for (int i = 0; i < this.arraySize; i++) {
            this.myArray[i] = random.nextInt(99);
        }
        this.myArraySort = myArray.clone();
        printArray(myArray, "Unordered Array => ");
        this.tempoInicial = System.currentTimeMillis();
        radixsort(this.myArraySort, this.arraySize);
        this.tempoFinal = System.currentTimeMillis();
        printArray(this.myArray, "Ordered Array => ");
        this.tempo = tempoFinal - tempoInicial;
        System.out.println("Executado em = " + (this.tempoFinal - this.tempoInicial) + " ms");
    }
    // A utility function to get maximum value in arr[] 
    private int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    private void countSort(int[] myArray, int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) {
            int digit = getDigit(myArray[i], exp);
            count[digit]++; 
        }
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (myArray[i]/exp)%10 ] - 1] = myArray[i]; 
            count[ (myArray[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            myArray[i] = output[i]; 
    } 
    private static int getDigit(int value, int digitPlace){
        return ((value/digitPlace ) % 10);
    }
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    public void radixsort(int arr[], int n) 
    { 
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
  
    // A utility function to print an array 
    public void printArray(int[] myArray, String value) 
    { 
            System.out.print(value);
            System.out.println(Arrays.toString(myArray));
    } 
}
