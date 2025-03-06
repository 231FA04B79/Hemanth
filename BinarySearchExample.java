import java.util.Scanner;

public class BinarySearchExample {
    // Method to perform binary search
    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at mid
            if (sortedArray[mid] == target) {
                return mid; // Target found
            }

            // If target is greater, ignore left half
            if (sortedArray[mid] < target) {
                left = mid + 1;
            } 
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        // Sample sorted list
        int[] sortedArray = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        // Input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the element to search: ");
        int target = scanner.nextInt();

        // Perform binary search
        int result = binarySearch(sortedArray, target);

        // Display result
        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result + ".");
        } else {
            System.out.println("Element " + target + " not found in the list.");
        }
    }
}
