package ds.arrays;

import org.apache.commons.lang3.ArrayUtils;

/**
 * An element is called a peak element if its value is not smaller
 * than the value of its adjacent elements(if they exists).
 * Given an array arr[] of size N, find the index of any one of its peak elements.
 * Note: The generated output will always be 1 if the index that you return is correct.
 * Otherwise output will be 0.
 *
 * Time complexity = O(n)
 */
public class PeakElement {

    private int findPeakElement(int arr[],int size){
        int index = 0;
        int peakElement = 0;
        for (int i = 0; i < arr.length; i=i+2) {
            if(i==0){
                //compare values at 0 and 1 position
                peakElement = compare(arr[i],arr[i+1]);

            }else if(i==arr.length-1){
                //compare values at last and second-last position
                peakElement = compare(arr[i-1],arr[i]);
            }else{
                //compare all positions.
                peakElement = compare(arr[i-1],arr[i],arr[i+1]);
            }
        }
        System.out.println(peakElement);
        return ArrayUtils.indexOf(arr,peakElement);
    }

    private int compare(int a,int b){
       return Math.max(a,b);
    }

    private int compare(int a,int b,int c){
        if(b>a && b>c){
            return b;
        }else if(a>b){
            return a;
        }else{
            return c;
        }
    }

    public static void main(String[] args) {
        PeakElement peakElement = new PeakElement();
        int arr[] = {11,2,3,4,0};
        System.out.println(peakElement.findPeakElement(arr,5));
    }
}
