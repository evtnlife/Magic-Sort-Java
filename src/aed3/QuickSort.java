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
public class QuickSort {

    private final int arraySize;
    private final int[] myArray;
    private final Random random;
    private final long tempoInicial;
    private final long tempoFinal;
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

    public QuickSort(int quantity){
        this.arraySize = quantity;
        this.myArray = new int[this.arraySize];
        this.random = new Random();
        for (int i = 0; i < this.arraySize; i++) {
            this.myArray[i] = random.nextInt(99);
        }
        this.myArraySort = myArray.clone();
        printArray(myArray, "Unordered Array => ");
        this.tempoInicial = System.currentTimeMillis();
        sort(this.myArraySort,0,this.arraySize-1);
        this.tempoFinal = System.currentTimeMillis();
        printArray(this.myArray, "Ordered Array => ");
        this.tempo = tempoFinal - tempoInicial;
        System.out.println("Executado em = " + (this.tempoFinal - this.tempoInicial) + " ms");
    }
    
     // A utility function to print an array 
    public void printArray(int[] myArray, String value) 
    { 
        System.out.print(value);
        System.out.println(Arrays.toString(myArray));
    } 
    
    /* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right 
    of pivot 
    */
    int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
}
