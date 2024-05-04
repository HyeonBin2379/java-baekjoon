package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise30503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] grid = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken())-1;
            int r = Integer.parseInt(st.nextToken())-1;
            switch (type) {
                case 1 -> {
                    int k = Integer.parseInt(st.nextToken());
                    System.out.println(IntStream.rangeClosed(l, r)
                            .filter(index -> grid[index] == k)
                            .count());
                }
                case 2 -> {
                    for (int j = l; j <= r; j++) {
                        grid[j] = 0;
                    }
                }
            }
        }
    }
}
