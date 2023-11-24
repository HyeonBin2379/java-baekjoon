import java.util.Scanner;

public class Exercise2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prefixSum = new int[n+1];
        for (int i = 1; i < prefixSum.length; i++) {
            int value = sc.nextInt();
            prefixSum[i] = prefixSum[i-1] + value;
        }

        int answer = -10000001;
        for (int i = k; i < prefixSum.length; i++) {
            int rangeSum = prefixSum[i] - prefixSum[i-k];
            if (answer < rangeSum) {
                answer = rangeSum;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}