package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    private int partition(int arr[],int begin,int end){
        int pivot = arr[end];
        int i=begin-1;  //i is always 1 less than j
        for(int j=begin;j<=end-1;j++){
            if(arr[j]<pivot){
                i++;
                if(i!=j){
                    swap(arr,i,j);
                }
            }
        }
        if(i+1!=end){
            swap(arr,i+1,end);
        }
        return i+1;
    }

    private void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quicksort(int arr[],int begin,int end){
        if(begin<end){
            int partitionIndex = partition(arr,begin,end);
            quicksort(arr,begin,partitionIndex-1);
            quicksort(arr,partitionIndex+1,end);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int arr[] = {3,4,2,7,9};
        quickSort.quicksort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
