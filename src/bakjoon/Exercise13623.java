package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        int idxOne = 0, idxZero = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 1) {
                idxOne += (i+1);
            } else {
                idxZero += (i+1);
            }
        }
        if (idxOne == 6 || idxZero == 6) {
            System.out.println("*");
            return;
        }
        switch ((idxOne <= 3) ? idxOne : idxZero) {
            case 1 -> System.out.println("A");
            case 2 -> System.out.println("B");
            case 3 -> System.out.println("C");
        }
    }
}
