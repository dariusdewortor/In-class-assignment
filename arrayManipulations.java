
import java.util.Arrays;
import java.util.Scanner;

public class arrayManipulations {
    /*
     * This code is to practice string manipulations using methods like sort, length
     * and many more. It incldues new concepts such as binary searching
     * 
     * @author Darius Dewortor
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Task one
        int num;
        int indexOfNum = 0;
        int[] array = { 2, 5, 8, 3, 4, 6, 10, 15, 20, 1, 11 };
        System.out.println("Enter a number from the array: ");
        num = input.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                indexOfNum = i;
            }
        }
        System.err.println("The index of the number you entered is " + indexOfNum);

        // Task 2
        int value1;
        int value2;
        System.out.println("Enter two index: ");
        value1 = input.nextInt();
        value2 = input.nextInt();
        int orignal1 = array[value1];
        array[value1] = array[value2];
        array[value2] = orignal1;
        System.out.println("Numbers swapped: " + Arrays.toString(array));

        // Task 3
        // ascending
        int[] orderedArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < orderedArray.length - 1; i++) {
            for (int k = 0; k < orderedArray.length - 1 - i; k++) {
                if (orderedArray[k] > orderedArray[k + 1]) {
                    int sub = orderedArray[k];
                    orderedArray[k] = orderedArray[k + 1];
                    orderedArray[k + 1] = sub;
                }
            }
        }

        System.out.println("Numbers in ascending order: " + Arrays.toString(orderedArray));
        // Descending order
        int[] descendingArray = Arrays.copyOf(orderedArray, orderedArray.length);
        for (int i = 0; i < descendingArray.length / 2; i++) {
            int k = descendingArray[i];
            descendingArray[i] = descendingArray[descendingArray.length - 1 - i];
            descendingArray[descendingArray.length - 1 - i] = k;

        }
        System.out.println("Numbers in descending order " + Arrays.toString(descendingArray));

        // Task 4: Linear search
        System.out.println("Enter a number from the array: ");
        int key = input.nextInt();

        int foundAt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                foundAt = i;
                break;
            }
        }
        System.out.println("Value entered is at " + foundAt);
        // Task 5: Binary Search
        System.out.print("Enter a number to search: ");
        int key1 = input.nextInt();

        int left = 0;
        int right = orderedArray.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (orderedArray[mid] == key1) {
                System.out.println("Number " + key1 + " found at index " + mid);
                found = true;
                break;
            } else if (orderedArray[mid] < key1) {
                left = mid + 1; // ✅ only move left
            } else {
                right = mid - 1; // ✅ only move right
            }
        }

        if (!found) {
            System.out.println("Number " + key1 + " not found in the array.");
        }
    }
}
