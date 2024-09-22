package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise14686 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] swift = new int[n+1];
        int[] semaphore = new int[n+1];
        IntStream.rangeClosed(1, n).forEach(i -> {
            swift[i] = swift[i-1] + arr1[i-1];
            semaphore[i] = semaphore[i-1] + arr2[i-1];
        });
        for (int i = n; i >= 1; i--) {
            if (swift[i] == semaphore[i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
