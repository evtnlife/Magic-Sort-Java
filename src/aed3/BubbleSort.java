/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aed3;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Everton
 */
public class BubbleSort extends JPanel{
    private int arraySize;
    private final int[] myArray;
    private int[] myArraySort;
    private Random random;
    private long tempoInicial;
    private long tempoFinal;
    private long tempo;
    
    public BubbleSort(int quantity) {
        this.arraySize = quantity;
        this.myArray = new int[this.arraySize];
        this.random = new Random();
        for (int i = 0; i < this.arraySize; i++) {
            this.myArray[i] = random.nextInt(99);
        }
        myArraySort = myArray.clone();
        printArray(myArray, "Unordered Array => ");
        this.tempoInicial = System.currentTimeMillis();
        bubbleSort(this.myArraySort);
        this.tempoFinal = System.currentTimeMillis();
        printArray(myArraySort, "Ordered Array => ");
        this.tempo = tempoFinal - tempoInicial;
        System.out.println("Executado em => " + (tempoFinal - tempoInicial) + " ms");
    }
    
    public long getTime(){
        return this.tempo;
    }

    private void printArray(int[] array, String message){
        System.out.print(message);
        System.out.println(Arrays.toString(array));
    }
    
    public int[] getArray(){
        return this.myArray;
    }
    public int[] getArraySorted(){
        return this.myArraySort;
    }
    
    private void bubbleSort(int vetor[]){
        boolean troca = true;
        int aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
    } 
}
