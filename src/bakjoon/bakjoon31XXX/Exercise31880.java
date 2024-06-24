package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise31880 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] a = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).filter(value -> value != 0).sorted().toArray();
        long[] b = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).filter(value -> value != 0).sorted().toArray();
        System.out.println(Arrays.stream(a).sum() * Arrays.stream(b).reduce(1, (i1, i2) -> i1*i2));
    }
}
