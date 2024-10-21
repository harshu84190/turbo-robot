/*
Overview:
The Merge Sort algorithm sorts an array by dividing it into two halves, sorting each half, 
and then merging the sorted halves back together.

Input:
First line: Size of the array (n)
Second line: n space-separated integers (array elements)

Output:
Sorted array in ascending order.

Example:
Input:
5
3 1 4 1 5

Output:
[1, 1, 3, 4, 5]

Time Complexity:
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n log n)

Space Complexity:
- O(n) for the temporary array used during the merge process.

Arguably the best sorting technique in most cases.
Merge Sort is highly efficient for larger datasets and provides consistent performance across different input types,
making it one of the most reliable sorting techniques in many real-world scenarios.
*/
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        if (n == 0) {
            System.out.println("[]");
            sc.close();
            return;
        }

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        mergeSort(arr, 0, n - 1);
        
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    public static void mergeSort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }
        
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        sort(arr, left, mid, right);
    }

    public static void sort(int arr[], int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        
        int i = left;      
        int j = mid + 1;   
        int k = 0;         

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }
}

