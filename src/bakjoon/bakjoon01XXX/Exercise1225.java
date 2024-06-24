package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] a = Arrays.stream(st.nextToken().split("")).mapToLong(Long::parseLong).toArray();
        long[] b = Arrays.stream(st.nextToken().split("")).mapToLong(Long::parseLong).toArray();

        long sum = 0;
        for (long l : a) {
            for (long value : b) {
                sum += l * value;
            }
        }
        System.out.println(sum);
    }
}
