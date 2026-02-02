import java.util.Scanner;

public class Array_reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        // Input
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        
        // Reverse (simple swap)
        for(int i=0; i<n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }
        
        // Output
        for(int i=0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
