package javaapplication9;

import java.util.*;

class DuplicateNum {

    Scanner sc = new Scanner(System.in);
    int n;

    void check() {
        boolean flag=false;
        System.out.println("Enter the size of an array ");
        n = sc.nextInt();
        int[] sa = new int[n];
        System.out.println("enter the number for storing in array");
        for (int i = 0; i < sa.length; i++) {
            sa[i] = sc.nextInt();
        }
        for (int i = 0; i < sa.length; i++) {
            for (int j = i + 1; j < sa.length; j++) {
                if (sa[i] == sa[j]) {
                    System.out.println("the duplicate value are" + sa[j]);
                    flag=true;
                }
            }
        }
        if(flag==false)
            System.out.println("their is no duplication");
    }
}

class QuickSort {

    static int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }

    void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    void meth(int data[]) {
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));
    }
}

class MergeSort {

    int[] mergeTwoSortedArrays(int[] one, int[] two) {

        int[] sorted = new int[one.length + two.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < one.length && j < two.length) {

            if (one[i] < two[j]) {
                sorted[k] = one[i];
                k++;
                i++;
            } else {
                sorted[k] = two[j];
                k++;
                j++;
            }
        }

        if (i == one.length) {

            while (j < two.length) {
                sorted[k] = two[j];
                k++;
                j++;
            }
        }

        if (j == two.length) {

            while (i < one.length) {
                sorted[k] = one[i];
                k++;
                i++;
            }
        }

        return sorted;

    }

    int[] mergeSort(int[] arr, int lo, int hi) {

        if (lo == hi) {
            int[] br = new int[1];
            br[0] = arr[lo];

            return br;
        }

        int mid = (lo + hi) / 2;

        int[] fh = mergeSort(arr, lo, mid);
        int[] sh = mergeSort(arr, mid + 1, hi);

        int[] merged = mergeTwoSortedArrays(fh, sh);

        return merged;
    }

    void meth2(int merg[]) {
        System.out.println("Sorting Using MergeSort :");
        for (int i : merg) {
            System.out.print(i + "  ");
        }
        System.out.println("");
    }
}

class BubbleSort {

    void bubbleSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        System.out.println("Sorting using bubble sort");
        for (int io : a) {
            System.out.print(io + "   ");
        }
        System.out.println("");
    }

}

class SelectionSort {

    void sort() {
        int[] a = {9, 7, 2, 3, 5, 4};
        int temp;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("Sorting using selection sort");
        for (int ij : a) {
            System.out.print(ij + "     ");
        }
        System.out.println("");
    }

}

class Subset {

void set() {
     int k=0;
        int[] ar={3,2,4};
        int[] ss={7,8,3,2,4};
        for(int i=0;i<ar.length;i++)
        {
            for(int j=0;j<ss.length;j++)
            {
                if(ar[i]==ss[j])
                {
                  k++;
                }
            }
        }
        if(k==ar.length)
        System.out.println("Array is a subset of Parents Array");
        else
            System.out.println("Not a subset of Parents Array");

    }
}

public class JavaApplication9 {

    public static void main(String[] args) {
        DuplicateNum work = new DuplicateNum();
        work.check();

        //creating object of Quicksort
        QuickSort so = new QuickSort();
        int[] data = {8, 7, 2, 1, 0, 9, 6};
        so.meth(data);
        int size = data.length;
        so.quickSort(data, 0, size - 1);
        System.out.println("Sorting using Quick Sort");
        System.out.println(Arrays.toString(data));

        // creting object of merge sort 
        MergeSort ms = new MergeSort();

        int[] merged = ms.mergeSort(data, 0, data.length - 1);
        ms.meth2(merged);

        //creating object of selection sort
        SelectionSort SS = new SelectionSort();
        SS.sort();
        //creating object of bubble sort
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(data);
        
        //subeset of set
        Subset ss=new Subset();
        ss.set();

    }
}
