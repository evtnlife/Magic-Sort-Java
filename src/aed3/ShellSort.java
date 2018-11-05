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
public class ShellSort {

    private final int arraySize;
    private final int[] myArray;
    private final Random random;
    private final long tempoFinal;
    private final long tempoInicial;
    private final int[] myArraySort;
    private long tempo;
   
    public int[] getArray(){
        return this.myArray;
    }
    public int[] getArraySorted(){
        return this.myArraySort;
    }
    
    public ShellSort(int quantity){
        this.arraySize = quantity;
        this.myArray = new int[this.arraySize];
        this.random = new Random();
        for (int i = 0; i < this.arraySize; i++) {
            this.myArray[i] = random.nextInt(99);
        }
        this.myArraySort = myArray.clone();
        printArray(myArray, "Unordered Array => ");
        this.tempoInicial = System.currentTimeMillis();
        sort(this.myArraySort);
        this.tempoFinal = System.currentTimeMillis();
        printArray(this.myArray, "Ordered Array => ");
        this.tempo = tempoFinal - tempoInicial;
        System.out.println("Executado em = " + (this.tempoFinal - this.tempoInicial) + " ms");
    }
    
    public long getTime(){
        return this.tempo;
    }

    /* function to sort arr using shellSort */
    int sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Start with a big gap, then reduce the gap 
        for (int gap = n/2; gap > 0; gap /= 2) 
        { 
            // Do a gapped insertion sort for this gap size. 
            // The first gap elements a[0..gap-1] are already 
            // in gapped order keep adding one more element 
            // until the entire array is gap sorted 
            for (int i = gap; i < n; i += 1) 
            { 
                // add a[i] to the elements that have been gap 
                // sorted save a[i] in temp and make a hole at 
                // position i 
                int temp = arr[i]; 
  
                // shift earlier gap-sorted elements up until 
                // the correct location for a[i] is found 
                int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                    arr[j] = arr[j - gap]; 
  
                // put temp (the original a[i]) in its correct 
                // location 
                arr[j] = temp; 
            } 
        } 
        return 0; 
    } 

     // A utility function to print an array 
    public void printArray(int[] myArray, String value) 
    { 
        System.out.print(value);
        System.out.println(Arrays.toString(myArray));
    } 
}
