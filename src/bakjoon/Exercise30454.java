package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise30454 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        int[] zebra = new int[count];
        for (int i = 0; i < count; i++) {
            String[] stripe = Arrays.stream(br.readLine().split("0")).filter(s -> !s.isEmpty()).toArray(String[]::new);
            zebra[i] = stripe.length;
        }
        Arrays.sort(zebra);
        System.out.println(zebra[count-1] + " " + Arrays.stream(zebra).filter(value -> value == zebra[count-1]).count());
    }
}
