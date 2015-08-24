package com.example.marco.jogou;

/**
 * Created by kpit on 20/07/2015.
 */

import java.util.Random;
//Number - Numeros disponiveis
//Quantity - sorteados
public class Jogou{
    private Random rand = new Random();
    private boolean exists = false;
    private int vet[];
    private int quantity;
    private int number;

    public Jogou(){
        number=0;
        quantity=5;
    }

    public String[] generate()    {
        vet= new int[quantity];
        vet[0] = getSortN();
        for(int i=1; i<quantity; i++)        {
            vet[i] = getSortN();
            int j = 0;
            while(j<i)            {
                do{
                    if(vet[i] == vet[j]){
                        exists = true;
                        vet[i] = getSortN();
                        j=0;
                    }else{
                        exists = false;
                        j++;
                    }
                }
                while(exists);
            }
        }
        insertionSort(vet);
        return geraString(vet);
    }

    //InsertionSort
    public void insertionSort(int v[]) {
        for(int i=1;i<v.length;i++){
            int j=i-1;
            int aux= v[i];
            while(j>=0 && v[j]>aux){
                v[j+1]=v[j];
                j--;
            }
            v[j+1]=aux;
        }
    }

    public String[] geraString(int v[]){
        String vetor[] = new String[v.length];
        for(int i=0;i<v.length;i++){
            if(v[i] < 10){
                vetor[i] = "0"+v[i];
            }else{
                vetor[i] = v[i]+"";
            }
        }
        return vetor;
    }

    public void setNumber(int numb){
        number = numb;
    }
    public void setQuantity(int quant){
        quantity = quant;
    }
    public int getNumber(){
        return number;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getSortN(){
        return rand.nextInt(getNumber()) + 1;
    }
}