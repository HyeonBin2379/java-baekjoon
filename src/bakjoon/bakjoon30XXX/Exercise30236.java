package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise30236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] temp = IntStream.rangeClosed(1, n).toArray();
            for (int j = 0; j < n; j++) {
                if (temp[j] == arr[j]) {
                    temp[j]++;
                }
                for (int k = j+1; k < n; k++) {
                    if (temp[k-1] >= temp[k]) {
                        temp[k] += (temp[k-1]-temp[k]) + 1;
                    }
                }
            }
            System.out.println(temp[n-1]);
        }
    }
}
