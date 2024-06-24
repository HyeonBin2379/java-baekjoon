package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise6588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] primeNum = sieve();
        while (true) {
            int num = Integer.parseInt(br.readLine().trim());
            if (num == 0) {
                break;
            }

            int count = 0;
            for (int i = 2; i <= num/2; i++) {
                if (primeNum[i] && primeNum[num-i]) {
                    sb.append(num).append(" = ").append(i).append(" + ").append(num - i).append("\n");
                    count++;
                    break;
                }
            }
            if (count == 0) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }
        System.out.print(sb);
    }

    public static boolean[] sieve() {
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < 1000001; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }
}
