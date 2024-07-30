package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise2659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] digit = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = 10000;
        for (int i = 0; i < 4; i++) {
            int num = 0;
            for (int j = 0; j < 4; j++) {
                num += (int)Math.pow(10, 3-j)*digit[(i+j) % 4];
            }
            min = Math.min(num, min);
        }
        System.out.println(IntStream.rangeClosed(1111, min)
                .parallel()
                .filter(i -> getCircleNum(i) == i)
                .count());
    }

    private static int getCircleNum(int num) {
        int temp = num;
        for (int i = 0; i < 3; i++) {
            num = (num % 1000)*10 + (num/1000);
            temp = Math.min(num, temp);
        }
        return temp;
    }
}
