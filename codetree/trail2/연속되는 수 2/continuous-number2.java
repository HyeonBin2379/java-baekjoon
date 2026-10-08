import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int count = 0;
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] == arr[i-1]) {
                ++count;
                maxLen = Math.max(count, maxLen);
            } else {
                count = 1;
            }
        }
        System.out.println(maxLen);
    }
}