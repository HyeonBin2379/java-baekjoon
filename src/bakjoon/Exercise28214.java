package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise28214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String bread = String.join("", br.readLine().split(" "));
        int saleCount = 0;
        for (int i = 0; i < n*k; i += k) {
            int count = (int) bread.substring(i, i+k).chars()
                    .filter(value -> value == '0')
                    .count();
            saleCount += (count < p) ? 1 : 0;
        }
        System.out.println(saleCount);
    }
}
