package bakjoon.bakjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise7239 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = (i % 2 == 0) ? arr[i/2] : arr[n-1-(i/2)];
        }
        System.out.println(Arrays.stream(result).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}
