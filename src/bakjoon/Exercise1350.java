package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1350 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] fileSize = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long cluster = Integer.parseInt(br.readLine());

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += Math.ceil((double)fileSize[i]/cluster);
        }
        System.out.println(cluster*count);
    }
}
