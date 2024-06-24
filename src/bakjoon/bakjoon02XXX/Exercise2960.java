package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        br.close();
        sieve(number, count);
    }

    public static void sieve(int number, int count) {
        int[] primeNum = new int[number+1];
        for (int i = 2; i <= number; i++) {
            if (primeNum[i] != 0) {
                continue;
            }

            for (int j = i; j <= number; j += i) {
                if (primeNum[j] == 0) {
                    primeNum[j] = j;
                    count--;
                    if (count == 0) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}
