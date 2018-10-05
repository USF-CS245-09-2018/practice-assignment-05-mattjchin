package Lesson5;

public class MergeSort implements SortingAlgorithm {

    /**
     * sort() - overridden function from SortingAlgorithm interface
     *
     * @param a the array in use to be sorted
     */
    @Override
    public void sort(int[] a) {

        int left_target = 0, right_target = a.length-1;
        mergesort(a, left_target, right_target);
    }

    /**
     * mergesort() - the function in use to sort out each element
     * Recursive functions used for every iteration
     *
     * @param arr the array in use
     * @param left_index the least value index - lowest index in array
     * @param right_index the highest value index - highest index in array
     */
    public void mergesort(int[] arr, int left_index, int right_index) {

        if(left_index >= right_index)
            return;
        int t_arr = (right_index+left_index)/2;
        int len_arr = arr.length;

        int[] arr1 = new int[(len_arr+1)/2];
        int[] arr2 = new int[len_arr-arr1.length];
        for(int i=0; i<len_arr; i++){

            if(i<arr1.length)
                arr1[i] = arr[i];
            else
                arr2[i-arr1.length] = arr[i];

        }
        mergesort(arr1, left_index, t_arr);
        mergesort(arr2, t_arr+1, right_index);
        merge(arr1, arr2, arr);
    }

    /**
     * merge() - function for incrementing indices of arrays after sorting
     *
     * @param arr_left one half of the array
     * @param arr_right the other half of the array
     * @param arr the overall array that is being sorted recursively
     */
    public void merge(int[] arr_left, int[] arr_right, int[] arr){

        int li=0, ri=0, target=0;
        while(li<arr_left.length && ri<arr_right.length){

            if(arr_left[li] < arr_right[ri]){
                arr[target] = arr_left[li];
                ++li;
            }
            else{
                arr[target] = arr_right[ri];
                ++ri;
            }
            ++target;
        }
        while(li<arr_left.length)
            arr[target++] = arr_left[li++];
        while(ri<arr_right.length)
            arr[target++] = arr_right[ri++];
    }
}
