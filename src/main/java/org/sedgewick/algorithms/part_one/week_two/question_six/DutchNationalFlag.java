package org.sedgewick.algorithms.part_one.week_two.question_six;

public class DutchNationalFlag {

    /**
     * @param array contains only 3 colors : 0, 1 or 2 values
     * @return sorted array
     */
    public void sortColors(int[] array) {
        int leftBorder = 0;
        int rightBorder = array.length - 1;

        int i = 0;
        while (i <= rightBorder) {
            if (array[i] == 0) {
                swap(array, i, leftBorder);
                leftBorder++;
                i++;
            } else if (array[i] == 2) {
                swap(array, i, rightBorder);
                rightBorder--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
