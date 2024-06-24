package bakjoon.bakjoon27XXX;

import java.io.*;
import java.util.*;

public class Exercise27736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] vote = new int[len];
        int zero = 0;
        for (int i = 0; i < len; i++) {
            vote[i] = Integer.parseInt(st.nextToken());
            zero += (vote[i] == 0) ? 1 : 0;
        }

        if (zero >= Math.ceil((double)len/2)) {
            System.out.println("INVALID");
            return;
        }
        int sum = Arrays.stream(vote).sum();
        System.out.println(sum > 0 ? "APPROVED" : "REJECTED");
    }
}
