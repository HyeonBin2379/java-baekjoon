package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise30527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfEars = Integer.parseInt(st.nextToken());
        int KWF = Integer.parseInt(st.nextToken());

        int average = IntStream.iterate(0, i -> i < 10, i -> i+2)
                .map(i -> data[i]*data[i+1])
                .reduce(0, Integer::sum) / 5;
        System.out.println(average * numberOfEars / KWF);
    }
}
