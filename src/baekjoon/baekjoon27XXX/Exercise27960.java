package baekjoon.baekjoon27XXX;

import java.io.*;
import java.util.*;

public class Exercise27960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] binary1 = getBinaryString(Integer.parseInt(st.nextToken()));
        int[] binary2 = getBinaryString(Integer.parseInt(st.nextToken()));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append((binary1[i] != binary2[i]) ? 1 : 0);
        }
        System.out.println(Integer.parseInt(sb.toString(), 2));
    }

    public static int[] getBinaryString(int num) {
        String temp = Integer.toBinaryString(num);
        String binary = String.format("%010d", Integer.parseInt(temp));
        return Arrays.stream(binary.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
