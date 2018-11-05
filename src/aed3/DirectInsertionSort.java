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
public class DirectInsertionSort {
    private int arraySize;
    private Random randon;
    private int[] myArray;
    private long tempoInicial;
    private long tempoFinal;
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

    public DirectInsertionSort(int quantity) {
        this.arraySize = quantity;
        this.myArray = new int[this.arraySize];
        Random random = new Random();
        for (int i = 0; i < this.arraySize; i++) {
            this.myArray[i] = random.nextInt(99);
        }
        myArraySort = myArray.clone();
        printArray(myArray, "Unordered Array => ");
        this.tempoInicial = System.currentTimeMillis();
        insertionSort(this.myArraySort);
        this.tempoFinal = System.currentTimeMillis();
        this.tempo = tempoFinal - tempoInicial;
        printArray(myArraySort, "Ordered Array => ");
        System.out.println("Executado em => " + (tempoFinal - tempoInicial) + " ms");
    }
    
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
                arr[j] = arr[j - 1];
		j--;
            }
            arr[j] = valueToSort;
        }
    }

    private void printArray(int[] array, String value){
            System.out.print(value);
            System.out.println(Arrays.toString(array));
	}
}
