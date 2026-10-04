import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        
        // Please write your code here.
        int[] array = new int[101];
        for (int i = 0; i < n; i++) {
            for (int j = start[i]; j <= end[i]; j++) {
                array[j]++;
            }
        }

        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            answer = Math.max(array[i], answer);
        }
        System.out.println(answer);
    }
}