import java.util.Random;
import java.util.Scanner;

public class SafeInput {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Example usage: Declare an array and fill it with random values
        int[] dataPoints = new int[100];
        fillArrayWithRandom(dataPoints, 1, 100);

        // Display the array values
        for (int val : dataPoints) {
            System.out.print(val + " ");
        }

        System.out.println(); // Just to add a new line after printing array

        // Second loop to display values in the requested format
        for (int i = 0; i < dataPoints.length; i++) {
            if (i != dataPoints.length - 1) {
                System.out.printf("%d | ", dataPoints[i]);
            } else {
                System.out.printf("%d", dataPoints[i]); // Avoid trailing " | " at the end
            }
        }

        System.out.println(); // New line after formatted display

        // Calculate the sum and average of the dataPoints array
        int sum = 0;
        for (int val : dataPoints) {
            sum += val;
        }
        double average = (double) sum / dataPoints.length;

        // Display the sum and the average with descriptions
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average);

        // Display the average using the getAverage method
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

        // Prompt user for an int value between 1 and 100
        int userVal = getRangedInt(in, "Enter a value", 1, 100);
        System.out.println("You entered: " + userVal);

        // Count the occurrences of the user's value
        int count = 0;
        for (int val : dataPoints) {
            if (val == userVal) {
                count++;
            }
        }

        // Provide feedback on the count
        if (count > 0) {
            System.out.println("The value " + userVal + " was found " + count + " times in the array.");
        } else {
            System.out.println("The value " + userVal + " was not found in the array.");
        }

        // Prompt the user for another int value between 1 and 100
        int searchVal = getRangedInt(in, "Enter another value to search for", 1, 100);
        System.out.println("You entered: " + searchVal);

        // Loop to check if the value exists in the array and break when found
        boolean found = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchVal) {
                System.out.println("The value " + searchVal + " was found at array index " + i);
                found = true;
                break;
            }
        }

        // If the value was not found, print a message indicating so
        if (!found) {
            System.out.println("The value " + searchVal + " was not found in the array.");
        }

        // Initialize min and max with the first element of the array
        int min = dataPoints[0];
        int max = dataPoints[0];

        // Loop through the array to find min and max
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        // Display the min and max values
        System.out.println("The minimum value in the dataPoints array is: " + min);
        System.out.println("The maximum value in the dataPoints array is: " + max);
    }

    // Method to get the average of an array of integers
    public static double getAverage(int values[]) {
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return (double) sum / values.length;
    }

    // Method to fill an array with random values within a given range
    public static void fillArrayWithRandom(int[] array, int min, int max) {
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt((max - min) + 1) + min;
        }
    }

    // Method to safely get an integer input within a specified range
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int result = low; // Initialize result to a valid value
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                if (result >= low && result <= high) {
                    valid = true;
                } else {
                    System.out.println("Error: input is out of range.");
                }
            } else {
                System.out.println("Error: input is not an integer.");
                pipe.next(); // clear invalid input
            }
        } while (!valid);

        return result;
    }
}
