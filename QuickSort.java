package Lesson5;

public class QuickSort implements SortingAlgorithm{

    /**
     * sort() - function from SortingAlgorithm interface
     * Takes the length and the index 0 and will be of use for recursion
     *
     * @param a the array to be sorted
     */
    @Override
    public void sort(int[] a){

        int left = 0;
        int right = a.length;
        quicksort(a, left, right-1);

    }

    /**
     * quicksort() - function used with a pivot index and comparing between right and left indices
     *
     * @param arr the array to be sorted
     * @param left the index of the leftmost array element
     * @param right the indext of the rightmost array element
     */
    public void quicksort(int[] arr, int left, int right){

        int pivot = arr[left+(right-left)/2];
        int x = left, y = right;
        while(x<=y){

            while(arr[x] < pivot)
                x++;  // Incrementing the x-index value to get closer to the pivot index
            while(arr[y] > pivot)
                y--;  // Decrementing the y-index value to get closer to the pivot index
            if(x<=y){
                int temp_num = arr[x];
                arr[x] = arr[y];
                arr[y] = temp_num;
                x++;
                y--;
            }
        }
        if(left < y)
            quicksort(arr, left, y); // Recursive calling for left part of the array
        if(x<right)
            quicksort(arr, x, right); // Recursive calling for the right part of the array
    }
}
