package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Exercise10432 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String[] token = br.readLine().split(" ");
            int testNum = Integer.parseInt(token[0]);
            int[] num = IntStream.rangeClosed(1, 12).map(index -> Integer.parseInt(token[index])).toArray();

            int count = 0;
            for (int i = 1; i <= 10; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = i; j <= 10; j++) {
                    min = Math.min(num[j], min);
                    if (num[i-1] < min && num[j+1] < min) {
                        count++;
                    }
                }
            }
            System.out.println(testNum + " " + count);
        }
    }
}
