package Lesson5;

public class InsertionSort implements SortingAlgorithm {

    /**
     * sort() - for InsertionSort class
     *
     * @param a the array of integers that will be sorted through
     */
    @Override
    public void sort(int[] a) {

        int len = a.length;  // Value for the length of the array
        for(int i=1; i<len; i++){

            int temp_num = a[i];  // Temporary variable for the number in use in loop
            int count = i-1; // Count variable used to take 1 from the i count from for loop
            while(count >= 0 && (a[count] > temp_num)){
                a[count+1] = a[count];  // Update the count+1 element in a to be the previous element value
                --count;  // Decrement from the count variable
            }
            a[count+1] = temp_num;  // Make the count+1 element the temp variable number value
        }
    }
}
