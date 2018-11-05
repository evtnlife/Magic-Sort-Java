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
public class DirectSelectionSort {
    private int arraySize;
    private int[] myArray;
    private Random random;
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

    public DirectSelectionSort(int quantity) {
        this.arraySize = quantity;
        this.myArray = new int[this.arraySize];
        Random random = new Random();
        for (int i = 0; i < this.arraySize; i++) {
            this.myArray[i] = random.nextInt(99);
        }
        myArraySort = myArray.clone();
        printArray(myArray, "Unordered Array => ");
        this.tempoInicial = System.currentTimeMillis();
        selectionSort(this.myArraySort);
        this.tempoFinal = System.currentTimeMillis();
        printArray(this.myArray, "Ordered Array => ");
        
        this.tempo = tempoFinal - tempoInicial;
        System.out.println("Executado em = " + (this.tempoFinal - this.tempoInicial) + " ms");
    }
                  
    private void printArray(int[] array, String value){
        System.out.print(value);
        System.out.println(Arrays.toString(array));
    }
    
    private void selectionSort(int[] array) {
        for (int fixo = 0; fixo < array.length - 1; fixo++) {
            int menor = fixo;

            for (int i = menor + 1; i < array.length; i++) {
                if (array[i] < array[menor]) {
                   menor = i;
                }
            }
            if (menor != fixo) {
               int t = array[fixo];
               array[fixo] = array[menor];
               array[menor] = t;
            }
        }
    }
}
