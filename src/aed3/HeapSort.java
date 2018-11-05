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
public class HeapSort {

    private final int arraySize;
    private final int[] myArray;
    private final Random random;
    private final long tempoInicial;
    private final long tempoFinal;
    private final int[] myArraySort;
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

    public HeapSort(int quantity){
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
        
        this.tempo = tempoFinal - tempoInicial;
        printArray(this.myArray, "Ordered Array => ");
        System.out.println("Executado em = " + (this.tempoFinal - this.tempoInicial) + " ms");
    }
     // A utility function to print an array 
    public void printArray(int[] myArray, String value) 
    { 
        System.out.print(value);
        System.out.println(Arrays.toString(myArray));
    } 
    
    public void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
     // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
}
