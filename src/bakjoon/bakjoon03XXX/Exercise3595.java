package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3595 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int volume = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        int[] len = new int[3];
        for (int i = 1; i <= volume; i++) {
            for (int j = 1; i*j <= volume; j++) {
                for (int k = 1; i*j*k <= volume; k++) {
                    if (i*j*k == volume) {
                        int area = 2*i*j + 2*(i+j)*k;
                        if (min > area) {
                            min = area;
                            len = new int[] {i, j, k};
                            break;
                        }
                    }
                }
            }
        }
        Arrays.stream(len).forEach(value -> System.out.print(value + " "));
    }
}
