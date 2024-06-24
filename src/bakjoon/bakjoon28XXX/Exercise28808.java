package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = 0; i < size[0]; i++) {
            String input = br.readLine();
            count += (input.contains("+")) ? 1 : 0;
        }
        System.out.println(count);
    }
}
