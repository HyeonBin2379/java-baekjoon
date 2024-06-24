package bakjoon.bakjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise8676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] shapes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n-2; i++) {
            if (shapes[i] != shapes[i+1]
                    && shapes[i+1] != shapes[i+2]
                    && shapes[i+2] != shapes[i]) {
                System.out.println("TAK");
                return;
            }
        }
        System.out.println("NIE");
    }
}
